public class Circle extends AbstractShape implements CollisionDetector{
    
    private Point center;
    private float radius;
    private static int numberOfInstances;

    public Circle() {
        this.center = new Point(0.0f, 0.0f);
        this.radius = 0.0f;
        numberOfInstances++;
    }

    public Circle(Point c, float r) {
        this.center = c;
        this.radius = r;
        numberOfInstances++;
    }

    public Point getCenter() {
        return center;
    }

    public float getRadius() {
        return radius;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    public boolean intersect(Point s) {
        float centerX = center.getX();
        float centerY = center.getY();

        float distance = (float) Math.sqrt(Math.pow(s.getX() - centerX, 2.0) + Math.pow(s.getY() - centerY, 2.0));

        return distance <= radius;
    }

    public boolean intersect(LineSeg s) {
        Point A = s.getBegin();
        Point B = s.getEnd();
        Point circleCenter = this.center;

        float segmentDX = B.getX() - A.getX();
        float segmentDY = B.getY() - A.getY();

        float circleToStartDX = circleCenter.getX() - A.getX();
        float circleToStartDY = circleCenter.getY() - A.getY();

        float t = (circleToStartDX * segmentDX + circleToStartDY * segmentDY) / (segmentDX * segmentDX + segmentDY * segmentDY);

        if (t < 0.0f) {
            t = 0.0f;
        } else if (t > 1.0f) {
            t = 1.0f;
        }

        float closestX = A.getX() + t * segmentDX;
        float closestY = A.getY() + t * segmentDY;

        float distanceSquared = (closestX - circleCenter.getX()) * (closestX - circleCenter.getX()) + (closestY - circleCenter.getY()) * (closestY - circleCenter.getY());

        return distanceSquared <= this.radius * this.radius;
    }
    
    public boolean intersect(Rectangle s) {
        if (s.getLeft() <= center.getX() && center.getX() <= s.getRight() &&
            s.getBottom() <= center.getY() && center.getY() <= s.getTop()) {
            return true;
        }


        if (center.getX() >= s.getLeft() && center.getX() <= s.getRight()) {
            if (Math.abs(center.getY() - s.getTop()) <= radius || Math.abs(center.getY() - s.getBottom()) <= radius) {
                return true;
            }
        }

        if (center.getY() >= s.getBottom() && center.getY() <= s.getTop()) {
            if (Math.abs(center.getX() - s.getLeft()) <= radius || Math.abs(center.getX() - s.getRight()) <= radius) {
                return true;
            }
        }

        float[] cornersX = { s.getLeft(), s.getRight(), s.getLeft(), s.getRight() };
        float[] cornersY = { s.getBottom(), s.getBottom(), s.getTop(), s.getTop() };

        for (int i = 0; i < 4; i++) {
            float dx = cornersX[i] - center.getX();
            float dy = cornersY[i] - center.getY();
            if (dx * dx + dy * dy <= radius * radius) {
                return true;
            }
        }
        return false;
    }

    public boolean intersect(Circle s) {
        float distance = center.distanceTo(s.getCenter());
        float sumOfRadii = radius + s.getRadius();

        return distance < sumOfRadii;
    }
}

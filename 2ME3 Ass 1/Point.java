public class Point extends AbstractShape implements CollisionDetector{
    private float x;
    private float y;
    private static int numberOfInstances;

    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
        numberOfInstances++;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        numberOfInstances ++;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    public boolean intersect(Point s) {
        return this.x == s.x && this.y == s.y;
    }

    public boolean intersect(LineSeg s) {
        float x1 = s.getBegin().getX();
        float y1 = s.getBegin().getY();
        float x2 = s.getEnd().getX();
        float y2 = s.getEnd().getY();

        return (x >= Math.min(x1, x2) && x <= Math.max(x1, x2) &&
                y >= Math.min(y1, y2) && y <= Math.max(y1, y2) &&
                (Math.abs((x - x1) * (y2 - y1) - (y - y1) * (x2 - x1)) < 0.0001));
    }

    public boolean intersect(Rectangle s) {
        return x >= s.getLeft() && x <= s.getRight() && y <= s.getTop() && y >= s.getBottom();
    }

    public boolean intersect(Circle s) {
        float centerX = s.getCenter().getX();
        float centerY = s.getCenter().getY();

        float distance = (float) Math.sqrt(Math.pow(x - centerX, 2.0) + Math.pow(y - centerY, 2.0));

        return distance <= s.getRadius();
    }

    public float distanceTo(Point s) {
        float dx = x - s.getX();
        float dy = y - s.getY();

        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}

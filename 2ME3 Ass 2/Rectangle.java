public class Rectangle extends AbstractShape implements CollisionDetector{
    private float left;
    private float right;
    private float top;
    private float bottom;
    private static int numberOfInstances;

    public Rectangle() {
        this.left = 0.0f;
        this.right = 0.0f;
        this.top = 0.0f;
        this.bottom = 0.0f;
        numberOfInstances++;
    }

    public Rectangle(float l, float r, float t, float b) {
        try {
            if (l >= r || b >= t) {
                throw new ShapeArgumentException("Rectangle with left >= right or bottom >= top");
            }
        this.left = l;
        this.right = r;
        this.top = t;
        this.bottom = b;
        numberOfInstances++;
        } catch (ShapeArgumentException z) {
            System.out.println("ShapeArgumentException in constructing Rectangle");
        }
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    public float getTop() {
        return top;
    }

    public float getBottom() {
        return bottom;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    public boolean intersect(Point s) {
        return s.intersect(this);
    }

    public boolean intersect(LineSeg s) {
        LineSeg topSide = new LineSeg(new Point(left, top), new Point(right, top));
        LineSeg bottomSide = new LineSeg(new Point(left, bottom), new Point(right, bottom));
        LineSeg leftSide = new LineSeg(new Point(left, top), new Point(left, bottom));
        LineSeg rightSide = new LineSeg(new Point(right, top), new Point(right, bottom));

        return s.intersect(topSide) || s.intersect(bottomSide) || s.intersect(leftSide) || s.intersect(rightSide) || this.intersect(s.getBegin()) || this.intersect(s.getEnd());
    }

    public boolean intersect(Rectangle s) {
        return (left <= s.right && right >= s.left && top >= s.bottom && bottom <= s.top);
    }

    public boolean intersect(Circle s) {
        return s.intersect(this);
    }
}

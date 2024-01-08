public class LineSeg extends AbstractShape implements CollisionDetector{
    
    private Point begin;
    private Point end;
    private static int numberOfInstances;

    public LineSeg() {
        this.begin = new Point(0.0f, 0.0f);
        this.end = new Point(0.0f, 0.0f);
        numberOfInstances++;
    }

    public LineSeg(Point b, Point e) {
        this.begin = b;
        this.end = e;
        numberOfInstances++;
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }   

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    public boolean intersect(Point s) {
        return s.intersect(this);
    }


    private int orientation(Point p, Point q, Point r) {
        float val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (Math.abs(val) < 0.0001) {
            return 0;
        } else {
            return (val > 0) ? 1 : 2;
        }
    }

    private boolean onSegment(Point p, Point q, Point r) {
        return (q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX()) &&
        q.getY() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY()));
    }

    public boolean ccw(Point A, Point B, Point C){
        return ((C.getY() - A.getY()) * (B.getX() - A.getX())) > ((B.getY() - A.getY()) * (C.getX() - A.getX()));
    }

    public boolean intersect(LineSeg s) {
        int o1 = orientation(begin, end, s.begin);
        int o2 = orientation(begin, end, s.end);
        int o3 = orientation(s.begin, s.end, begin);
        int o4 = orientation(s.begin, s.end, end);
    
        if (o1 != o2 && o3 != o4) return true;
    
        return (o1 == 0 && onSegment(begin, s.begin, end)) || 
                (o2 == 0 && onSegment(begin, s.end, end)) ||
                (o3 == 0 && onSegment(s.begin, begin, s.end)) ||
                (o4 == 0 && onSegment(s.begin, end, s.end));
        }

    public boolean intersect(Rectangle s) {
        return s.intersect(this);
    }

    public boolean intersect(Circle s) {
        return s.intersect(this);
    }

    public boolean intersect(CompShape s) {
        return s.intersect(this);
    }
}

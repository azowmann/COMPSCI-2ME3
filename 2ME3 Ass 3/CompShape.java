import java.util.ArrayList;


public class CompShape extends AbstractShape implements CollisionDetector {
    
    private ArrayList<AbstractShape> components;

    public CompShape() {
        this.components = new ArrayList<>();
    }

    public CompShapeIterator iterator() {
        return new CompShapeIterator(this);
    }

    public ArrayList<AbstractShape> getComponents() {
        return components;
    }

    public void addShape(AbstractShape s) {
        components.add(s);
    }

    public void removeShape(AbstractShape s) {
        components.remove(s);
    }

    public boolean intersect(Point s) {
        for (int i = 0; i < components.size(); i++) {
            if (((CollisionDetector)components.get(i)).intersect(s)){
                return true;
            }
        }   
        return false;
    }

    public boolean intersect(LineSeg s) {
        for (int i = 0; i < components.size(); i++) {
            if (((CollisionDetector)components.get(i)).intersect(s)){
                return true;
            }
        }   
        return false;
    }

    public boolean intersect(Rectangle s) {
        for (int i = 0; i < components.size(); i++) {
            if (((CollisionDetector)components.get(i)).intersect(s)){
                return true;
            }
        }   
        return false;
    }

    public boolean intersect(Circle s) {
        for (int i = 0; i < components.size(); i++) {
            if (((CollisionDetector)components.get(i)).intersect(s)){
                return true;
            }
        }   
        return false;
    }

    public boolean intersect(CompShape s) {
        for (int i = 0; i < components.size(); i++) {
            if (((CollisionDetector)components.get(i)).intersect(s)){
                return true;
            }
        }   
        return false;
    }
}

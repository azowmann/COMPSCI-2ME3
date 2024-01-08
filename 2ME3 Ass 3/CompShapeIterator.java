import java.util.Iterator;
import java.util.ArrayList;

public class CompShapeIterator {
    
    private CompShape shape;
    private int currentIndex;

    public CompShapeIterator(CompShape shape) {
        this.shape = shape;
        this.currentIndex = 0;
    }

    public void first() {
        currentIndex = 0;
    }

    public void next() {
        currentIndex++;
    }

    public boolean isDone() {
        return currentIndex >= shape.getComponents().size();
    }

    public AbstractShape getCurrentShape() {
        if (!isDone()) {
            return shape.getComponents().get(currentIndex);
        } else {
            throw new IndexOutOfBoundsException("No more elements in the iterator");
        }
    }
}

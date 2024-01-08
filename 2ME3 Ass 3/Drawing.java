public class Drawing {
    
    private static Drawing drawing;
    private AbstractShape shape;

    private Drawing() {
    }

    public static Drawing getInstance() {
        if (drawing == null) {
            drawing = new Drawing();
        }
        return drawing;
    }

    public AbstractShape getShape() {
        return shape;
    }

    public void setShape(AbstractShape s) {
        this.shape = s;
    }
}

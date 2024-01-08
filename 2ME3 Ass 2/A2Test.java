import org.junit.Test;
import static org.junit.Assert.*;

public class A2Test {

    @Test
    public void testPointintersectPoint() {
        assertTrue(new Point(0.0f, 0.0f).intersect(new Point(0.0f, 0.0f)));
        assertFalse(new Point(0.0f, 0.0f).intersect(new Point(0.0f, 1.0f)));
    }
    
    @Test
    public void testPointintersectLineSeg() {
        assertTrue(new Point(0.0f, 0.0f).intersect(new LineSeg(new Point (-1.0f, 0.0f), new Point (1.0f, 0.0f))));
        assertFalse(new Point(0.0f, 0.0f).intersect(new LineSeg(new Point (-1.0f, 1.0f), new Point (1.0f, 1.0f))));
    }

    @Test
    public void testPointintersectRectangle() {
        assertTrue(new Point(0.0f, 0.0f).intersect(new Rectangle(0.0f, 3.0f, 0.0f, -2.0f)));
        assertTrue(new Point(0.0f, 0.0f).intersect(new Rectangle(-1.0f, 1.0f, 2.0f, -2.0f)));
        assertFalse(new Point(0.0f, 0.0f).intersect(new Rectangle(1.0f, 3.0f, 3.0f, -1.0f)));
    }

    @Test
    public void testPointintersectCircle() {
        assertTrue(new Point(1.0f, 0.0f).intersect(new Circle(new Point(0.0f, 0.0f), 1.0f)));
        assertTrue(new Point(0.0f, 0.0f).intersect(new Circle(new Point(0.0f, 0.0f), 1.0f)));
        assertFalse(new Point(1.0f, 1.0f).intersect(new Circle(new Point(0.0f, 0.0f), 1.0f)));
    }

    @Test
    public void testLineSegintersectPoint() {
        assertTrue(new LineSeg(new Point (-1.0f, 0.0f), new Point (1.0f, 0.0f)).intersect(new Point(0.0f, 0.0f)));
        assertFalse(new LineSeg(new Point (-1.0f, 1.0f), new Point (1.0f, 1.0f)).intersect(new Point(0.0f, 0.0f)));
    }

    @Test
    public void testLineSegintersectLineSeg() {
        assertTrue(new LineSeg(new Point(0.0f, 0.0f), new Point(2.0f, 0.0f)).intersect(new LineSeg(new Point(1.0f, 1.0f), new Point(1.0f, -1.0f))));
        assertTrue(new LineSeg(new Point(0.0f, 0.0f), new Point(2.0f, 2.0f)).intersect(new LineSeg(new Point(2.0f, 2.0f), new Point(3.5f, 3.5f))));
        assertTrue(new LineSeg(new Point(0.0f, 0.0f), new Point(3.0f, 0.0f)).intersect(new LineSeg(new Point(2.0f, 0.0f), new Point(5.0f, 0.0f))));
        assertFalse(new LineSeg(new Point(0.0f, 0.0f), new Point(2.0f, 0.0f)).intersect(new LineSeg(new Point(0.0f, 3.5f), new Point(0.0f, 1.0f))));
    }

    @Test
    public void testLineSegintersectRectangle() {
        assertTrue(new LineSeg(new Point(0.0f, 0.0f), new Point(0.0f, 2.0f)).intersect(new Rectangle(-2.0f, 2.0f, 1.0f, -1.0f)));
        assertTrue(new LineSeg(new Point(-1.0f, 0.0f), new Point(1.0f, 0.0f)).intersect(new Rectangle(-2.0f, 2.0f, 1.0f, -1.0f)));
        assertTrue(new LineSeg(new Point(-2.0f, -3.0f), new Point(-2.0f, 3.0f)).intersect(new Rectangle(-2.0f, 2.0f, 1.0f, -1.0f)));
        assertFalse(new LineSeg(new Point(0.0f, 3.0f), new Point(2.0f, 3.0f)).intersect(new Rectangle(-2.0f, 2.0f, 1.0f, -1.0f)));
    }

    @Test
    public void testLineSegintersectCircle() {
        assertTrue(new LineSeg(new Point(-3.5f, 0.0f), new Point(3.5f, 0.0f)).intersect(new Circle(new Point(0.0f, 0.0f), 1.5f)));
        assertTrue(new LineSeg(new Point(-1.0f, 1.5f), new Point(1.0f, 1.5f)).intersect(new Circle(new Point(0.0f, 0.0f), 1.5f)));
        assertTrue(new LineSeg(new Point(0.0f, -1.0f), new Point(0.0f, 1.0f)).intersect(new Circle(new Point(0.0f, 0.0f), 2.5f)));
        assertFalse(new LineSeg(new Point(-2.0f, -3.0f), new Point(-2.0f, 3.0f)).intersect(new Circle(new Point(0.0f, 0.0f), 1.0f)));
    }

    @Test
    public void testRectangleintersectPoint() {
        assertTrue(new Rectangle(0.0f, 3.0f, 0.0f, -2.0f).intersect(new Point(0.0f, 0.0f)));
        assertTrue(new Rectangle(-1.0f, 1.0f, 2.0f, -2.0f).intersect(new Point(0.0f, 0.0f)));
        assertFalse(new Rectangle(1.0f, 3.0f, 3.0f, -1.0f).intersect(new Point(0.0f, 0.0f)));
    }

    @Test
    public void testRectangleintersectLineSeg() {
        assertTrue(new Rectangle(-2.0f, 2.0f, 1.0f, -1.0f).intersect(new LineSeg(new Point(0.0f, 0.0f), new Point(0.0f, 2.0f))));
        assertTrue(new Rectangle(-2.0f, 2.0f, 1.0f, -1.0f).intersect(new LineSeg(new Point(-1.0f, 0.0f), new Point(1.0f, 0.0f))));
        assertTrue(new Rectangle(-2.0f, 2.0f, 1.0f, -1.0f).intersect(new LineSeg(new Point(-2.0f, -3.0f), new Point(-2.0f, 3.0f))));
        assertFalse(new Rectangle(-2.0f, 2.0f, 1.0f, -1.0f).intersect(new LineSeg(new Point(0.0f, 3.0f), new Point(2.0f, 3.0f))));
    }

    @Test
    public void testRectangleintersectRectangle() {
        assertTrue(new Rectangle(-3.0f, 0.0f, 0.0f, -2.0f).intersect(new Rectangle(0.0f, 3.0f, 2.0f, 0.0f)));
        assertTrue(new Rectangle(-3.0f, 0.0f, 0.0f, -2.0f).intersect(new Rectangle(0.0f, 3.0f, 1.0f, -1.0f)));
        assertTrue(new Rectangle(-3.0f, 0.0f, 0.0f, -2.0f).intersect(new Rectangle(-1.0f, 2.0f, 1.0f, -1.0f)));
        assertTrue(new Rectangle(-4.0f, 0.0f, 0.0f, -3.0f).intersect(new Rectangle(-3.0f, -1.0f, -1.0f, -2.0f)));
        assertTrue(new Rectangle(-3.0f, 0.0f, 0.0f, -2.0f).intersect(new Rectangle(-3.0f, 0.0f, 3.0f, -2.0f)));
        assertFalse(new Rectangle(-3.0f, 0.0f, 0.0f, -2.0f).intersect(new Rectangle(1.0f, 3.0f, 3.0f, 1.0f)));
    }

    @Test
    public void testRectangleintersectCircle() {
        assertTrue(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f).intersect(new Circle(new Point(1.5f,2.0f), 1.0f)));
        assertTrue(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f).intersect(new Circle(new Point(1.5f,1.5f), 1.0f)));
        assertTrue(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f).intersect(new Circle(new Point(1.5f,0.5f), 1.0f)));
        assertTrue(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f).intersect(new Circle(new Point(1.5f,0.5f), 0.5f)));
        assertTrue(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f).intersect(new Circle(new Point(1.5f,0.5f), 0.35f)));
        assertTrue(new Rectangle(0.0f, 2.0f, 1.0f, 0.0f).intersect(new Circle(new Point(1.0f,0.5f), 2.0f)));
        assertFalse(new Rectangle(0.0f, 2.0f, 1.0f, 0.0f).intersect(new Circle(new Point(3.0f,0.5f), 0.35f)));
    }

    @Test
    public void testCircleintersectPoint() {
        assertTrue(new Circle(new Point(0.0f, 0.0f), 1.0f).intersect(new Point(1.0f, 0.0f)));
        assertTrue(new Circle(new Point(0.0f, 0.0f), 1.0f).intersect(new Point(0.0f, 0.0f)));
        assertFalse(new Circle(new Point(0.0f, 0.0f), 1.0f).intersect(new Point(1.0f, 1.0f)));
    }

    @Test
    public void testCircleintersectLineSeg() {
        assertTrue(new Circle(new Point(0.0f, 0.0f), 1.5f).intersect(new LineSeg(new Point(-3.5f, 0.0f), new Point(3.5f, 0.0f))));
        assertTrue(new Circle(new Point(0.0f, 0.0f), 1.5f).intersect(new LineSeg(new Point(-1.0f, 1.5f), new Point(1.0f, 1.5f))));
        assertTrue(new Circle(new Point(0.0f, 0.0f), 2.5f).intersect(new LineSeg(new Point(0.0f, -1.0f), new Point(0.0f, 1.0f))));
        assertFalse(new Circle(new Point(0.0f, 0.0f), 1.0f).intersect(new LineSeg(new Point(-2.0f, -3.0f), new Point(-2.0f, 3.0f))));
    }

    @Test
    public void testCircleintersectRectangle() {
        assertTrue(new Circle(new Point(1.5f,2.0f), 1.0f).intersect(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f)));
        assertTrue(new Circle(new Point(1.5f,1.5f), 1.0f).intersect(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f)));
        assertTrue(new Circle(new Point(1.5f,0.5f), 1.0f).intersect(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f)));
        assertTrue(new Circle(new Point(1.5f,0.5f), 0.5f).intersect(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f)));
        assertTrue(new Circle(new Point(1.5f,0.5f), 0.35f).intersect(new Rectangle(0.0f, 3.0f, 1.0f, 0.0f)));
        assertTrue(new Circle(new Point(1.0f,0.5f), 2.0f).intersect(new Rectangle(0.0f, 2.0f, 1.0f, 0.0f)));
        assertFalse(new Circle(new Point(3.0f,0.5f), 0.35f).intersect(new Rectangle(0.0f, 2.0f, 1.0f, 0.0f)));
    }

    @Test
    public void testCircleintersectCircle() {
        assertTrue(new Circle(new Point(-1.0f, 0.0f), 1.0f).intersect(new Circle(new Point(1.0f, 0.0f), 1.0f)));
        assertTrue(new Circle(new Point(-1.0f, 0.0f), 1.0f).intersect(new Circle(new Point(0.0f, 1.0f), 1.0f)));
        assertTrue(new Circle(new Point(0.0f, 0.0f), 3.0f).intersect(new Circle(new Point(0.0f, 0.0f), 1.0f)));
        assertTrue(new Circle(new Point(0.0f, 0.0f), 1.0f).intersect(new Circle(new Point(4.0f, 0.0f), 1.0f)));
    }
}


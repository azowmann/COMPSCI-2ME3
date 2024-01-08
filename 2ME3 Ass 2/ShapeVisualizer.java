/*
 * ======= SHAPE VISUALIZER | 2ME3 Assignment #1 =======
 * 
 * Description: This GUI tool was developed by Kaami to help visualize the shapes created in
 * 				in Assignment #1 for COMPSCI 2ME3. It can display multiple points, line segments,
 * 				rectangles, and circles on a grid. This can help help simplify the debugging process
 * 				for the various intersection methods.
 * 
 * NOTE #1: This tool requires that all your shape classes be correctly implemented
 * 		 	as per the UML diagram provided with the assignment. Incomplete classes
 * 		 	may cause errors or not work correctly with this tool.
 * 
 * NOTE #2: While all your class methods have to be correctly defined and working,
 * 			the tool does not call any intersection methods, so incorrect implementations
 * 			of those methods should not cause any issues.
 * 
 * NOTE #3: This tool was developed and tested on a MacOS system. While it should ideally also
 * 			work on Windows and Linux devices, there is no guarantee since I have not tested
 * 			it there.
 * 
 * How to use:
 * 		- Place this ShapeVisualizer.java file in your 'src' folder
 * 		  alongside all your shape classes.
 * 
 * 		- In your Main.java file, or main method in any other file, you
 * 		  can then call ShapeVisualizer.visualize(shape1, shape2, shape3...);
 * 		
 * 		- You can visualize as many shapes as you want at a time	
 * 
 * 		- To prevent unexpected issues, do not add or modify any code in this file unless
 * 		  you know what you are doing.
 * 
 * 		- If you do face unexpected issues or bugs. Feel free to contact me on Discord.
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ShapeVisualizer extends JFrame {
    
	private AbstractShape[] shapes;
	
	private static final Color[] colors = {
			new Color(153, 0, 0), // Red
			new Color(0, 0, 153), // Blue
			new Color(0, 102, 0), // Green
			new Color(255, 102, 0), // Orange
			new Color(102, 0, 153), // Purple
			new Color(102, 51, 0) // Brown	
	};
	
	public ShapeVisualizer(AbstractShape[] shapes) {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setTitle("Shape Visualizer");
        this.shapes = shapes;
    }

    private int cX(float x) {
    	return (int) (x * 20 + this.getSize().getWidth() / 2);
    }
    
    private int cY(float y) {
    	return (int) (y * 20 + this.getSize().getHeight() / 2);
    }
    
    private int m(float x) {
    	return (int) (x * 20);
    }
    
    private void drawRectangleClass(Graphics g, Rectangle s, Color c) {
    	g.setColor(c);
    	g.drawRect(cX(s.getLeft()),
    			cY(-s.getTop()),
    			m(s.getRight()-s.getLeft()),
    			m(s.getTop()-s.getBottom()));
    	g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 20));
    	g.fillRect(cX(s.getLeft()),
    			cY(-s.getTop()),
    			m(s.getRight()-s.getLeft()),
    			m(s.getTop()-s.getBottom()));
    }
    
    private void drawCircleClass(Graphics g, Circle s, Color c) {
    	g.setColor(c);
    	g.drawOval(cX(s.getCenter().getX()-s.getRadius()),
    			cY(-s.getCenter().getY()-s.getRadius()),
    			m(s.getRadius() * 2),
    			m(s.getRadius() * 2));
    	g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 20));
    	g.fillOval(cX(s.getCenter().getX()-s.getRadius()),
    			cY(-s.getCenter().getY()-s.getRadius()),
    			m(s.getRadius() * 2),
    			m(s.getRadius() * 2));
    }
    
    private void drawLineSegClass(Graphics g, LineSeg s, Color c) {
    	g.setColor(c);
    	g.drawLine(cX(s.getBegin().getX()),
    			cY(-s.getBegin().getY()),
    			cX(s.getEnd().getX()),
    			cY(-s.getEnd().getY()));
    }
    
    private void drawPointClass(Graphics g, Point s, Color c) {
    	g.setColor(c);
    	g.fillOval(cX(s.getX()-0.25f),
    			cY(-s.getY()-0.25f),
    			m(0.5f),
    			m(0.5f));
    }
    
    private void drawShape(Graphics g, AbstractShape s, Color c) {
    	if(s instanceof Point) {
    		drawPointClass(g, (Point) s, c);
    	}
    	else if(s instanceof LineSeg) {
    		drawLineSegClass(g, (LineSeg) s, c);
    	}
    	else if(s instanceof Rectangle) {
    		drawRectangleClass(g, (Rectangle) s, c);
    	}
    	else if(s instanceof Circle) {
    		drawCircleClass(g, (Circle) s, c);
    	}
    }
    
    @Override
    public void paint(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
        super.paint(g);
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0, (int) this.getSize().getWidth(), (int) this.getSize().getHeight());
        g2.setColor(Color.lightGray);
        for(int i = 0; i < this.getSize().getWidth(); i += 20) {
        	g2.drawLine(i, 0, i, (int) this.getSize().getHeight());
        }
        for(int i = 0; i < this.getSize().getHeight(); i += 20) {
        	g2.drawLine(0, i, (int) this.getSize().getWidth(), i);
        }
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        g2.drawLine(0, cY(0), (int) this.getSize().getWidth(), cY(0));
        g2.drawLine(cX(0), 0, cX(0), (int) this.getSize().getHeight());
        
        int colorCounter = 0;
        for(AbstractShape shape : this.shapes) {
        	drawShape(g2, shape, colors[colorCounter]);
        	colorCounter++;
        	if(colorCounter >= colors.length) {
        		colorCounter = 0;
        	}
        }
    }

    public static void visualize(AbstractShape... shapes) {
    	ShapeVisualizer f = new ShapeVisualizer(shapes);
        f.setVisible(true);
    }
}


import java.applet.*;
import java.awt.*;

public class SierpinskiTriangle extends Applet {

	public void paint(Graphics g) {
		int a = 50;
		
		g.drawLine(0+a, 500+a, 250+a, 0+a);
		g.drawLine(500+a, 500+a, 250+a, 0+a);
		g.drawLine(0+a, 500+a, 500+a, 500+a);
		
		Point p1 = new Point(250+a,500+a);
		Point p2 = new Point(125+a,250+a);
		Point p3 = new Point(375+a,250+a);
			
		int distance = 500;
		int depth = 6;
	
		drawTriangles(p1, distance, depth, g);
		
	}
	
	
	private void drawTriangles(Point p1, int startDistance, int depth, Graphics g) {
		
		if(depth ==0) {
			
		} else {
		
			int newDistance = startDistance/2;
			
			g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p1.getX()- newDistance/2, (int)(p1.getY()-Math.pow(3, 1/2)*(newDistance)));
			g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p1.getX()+ newDistance/2, (int)(p1.getY()-Math.pow(3, 1/2)*(newDistance)));
			g.drawLine((int)p1.getX()- newDistance/2, (int)(p1.getY()-Math.pow(3, 1/2)*(newDistance)), (int)p1.getX()+ newDistance/2, (int)(p1.getY()-Math.pow(3, 1/2)*(newDistance)));
			
			//up
			Point newP1 = new Point((int)p1.getX(), (int)(p1.getY()-Math.pow(3, 1/2)*(newDistance)));
			
			Point newP2 = new Point((int)p1.getX() + newDistance/4, ((int)p1.getY() + (int)(p1.getY()-Math.pow(3, 1/2)*(newDistance)))/2);
			Point newP3 = new Point((int)p1.getX() - newDistance/4, ((int)p1.getY() + (int)(p1.getY()-Math.pow(3, 1/2)*(newDistance)))/2);
			
			drawTriangles(newP1, newDistance, depth-1, g);
			drawTrianglesRight(newP2, newDistance, depth-1, g);
			drawTrianglesLeft(newP3, newDistance, depth-1,g);
			
			
			
		}
		
	}
	
	private void drawTrianglesRight(Point p2, int startDistance, int depth, Graphics g) {
		
		if(depth ==0) {

			
		} else {
			
			int newDistance = startDistance/2;
			g.drawLine((int)p2.getX(), (int)p2.getY(), (int)p2.getX()+newDistance, (int)p2.getY());
			g.drawLine((int)p2.getX(), (int)p2.getY(), (int)p2.getX()+newDistance/2, (int)(p2.getY() + Math.pow(3, 1/2)*newDistance));
			g.drawLine((int)p2.getX()+newDistance, (int)p2.getY(), (int)p2.getX()+newDistance/2,(int)(p2.getY() + Math.pow(3, 1/2)*newDistance));
			
			//right
			Point newP2 = new Point(((int)p2.getX()+newDistance+(int)p2.getX()+newDistance/2)/2, ((int)p2.getY()+ (int)(p2.getY() + Math.pow(3, 1/2)*newDistance))/2);
			
			Point newP1 = new Point((int)p2.getX()+ newDistance/2, (int)p2.getY());
			Point newP3 = new Point((int)p2.getX() +newDistance/4,((int)p2.getY()+ (int)(p2.getY() + Math.pow(3, 1/2)*newDistance))/2);
			
			drawTriangles(newP1, newDistance, depth-1, g);
			drawTrianglesRight(newP2, newDistance, depth-1, g);
			drawTrianglesLeft(newP3, newDistance, depth-1,g);
		}
	}
	
	private void drawTrianglesLeft(Point p3, int startDistance, int depth, Graphics g) {
		
		if(depth ==0) {
			
		} else {
		
			int newDistance = startDistance/2;
			
			g.drawLine((int)p3.getX(), (int)p3.getY(), (int)p3.getX()-newDistance, (int)p3.getY());
			g.drawLine((int)p3.getX(), (int)p3.getY(), (int)p3.getX()-newDistance/2, (int)(p3.getY() + Math.pow(3, 1/2)*newDistance));
			g.drawLine((int)p3.getX()-newDistance, (int)p3.getY(), (int)p3.getX()-newDistance/2, (int)(p3.getY() + Math.pow(3, 1/2)*newDistance));
			
			//left
			Point newP3 = new Point(((int)p3.getX()-newDistance+(int)p3.getX()-newDistance/2)/2,((int)p3.getY() +(int)(p3.getY() + Math.pow(3, 1/2)*newDistance))/2);
			
			Point newP1 = new Point((int)p3.getX()-newDistance/2,(int)p3.getY());
			Point newP2 = new Point((int)p3.getX()-newDistance/4,((int)p3.getY() +(int)(p3.getY() + Math.pow(3, 1/2)*newDistance))/2);
			
			drawTriangles(newP1, newDistance, depth-1, g);
			drawTrianglesRight(newP2, newDistance, depth-1, g);
			drawTrianglesLeft(newP3, newDistance, depth-1,g);
			
			
		}
	}
}
	
	
	
	
	
	
	
	


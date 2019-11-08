
import java.awt.*;
import java.applet.*;

public class FractalsLab extends Applet{
	
	public void paint(Graphics g) {
		
		this.setSize(800,600);
		
		g.fillRect(0,0,800,600);		//set background to black
		
		g.setColor(Color.WHITE);
		rings(g, 200, 210, 0);			//easy
		
		g.setColor(Color.PINK);
		circles(g, 100, 100, 100);		//medium
		
		g.setColor(Color.CYAN);
		disc(g, 100, 200, 400, 360);	//medium
		
		g.setColor(Color.GREEN);
		shell(g, 80, 530, 130, 360);	//hard
		
		g.setColor(Color.WHITE);
		binaryTree(g, 90, 500, 500, 45);
		
	}
	
	public void rings(Graphics g, int radius, int x, int y) {
		
		//base case
		if(radius <= 0) {
			return;
		}else {
			//draw
			g.drawOval(x, y, radius, radius);
			
			//figure out new y and y position
			radius -= 20;
			x += 10;
			y += 10;
			
			//call self
			rings(g,radius, x, y);
		}
	}
	
	public void circles(Graphics g, int radius, int x, int y) {	
		
		//base case
		if(radius <= 0) {
			return;
		}
		else {
			//draw
			g.drawOval(x, y, radius, radius); 					//draws the bottom right circles
			g.drawOval(x-radius, y-radius, radius, radius);		//draws the top left circles
			g.drawOval(x-radius, y, radius, radius);			//draws the bottom left circles
			g.drawOval(x, y-radius, radius, radius);			//draws the top right circles

			//decreasing radius to make circles smaller
			radius -= 5;
			
			//call self
			circles(g, radius, x, y);
		}
	}
	
	public void disc(Graphics g, int radius, int centerX, int centerY, int angle) {
		
		int x,y;	//variables that will be updated as the x and y coordinates of every circle drawn
		//base case
		if(angle <= 0) {
			return;
		}
		else {
			
			//updating variables
			x = (int) ( ( Math.cos(Math.toRadians(angle)) )*radius );
			y = (int) ( ( Math.sin(Math.toRadians(angle)) )*radius );
			
			//draw updated circle
			g.drawOval((x-radius)+centerX , (y-radius)+ centerY,2*radius,2*radius);
			
			//call self
			disc(g, radius, centerX, centerY, angle-6);
		}
		
	}
	
	public void shell(Graphics g, int radius, int centerX, int centerY, int angle) {

		int x,y;	//variables that will be updated as the x and y coordinates of every circle drawn
		
		//base case
		if(angle <= 0) {
			return;
		}
		else {
			
			//updating variables
			x = (int) ( ( Math.cos(Math.toRadians(angle)) )*radius );
			y = (int) ( ( Math.sin(Math.toRadians(angle)) )*radius );
			
			//draw updated circle
			g.drawOval((x-radius)+centerX , (y-radius)+ centerY,2*radius,2*radius);
			
			//call self
			shell(g, radius-1, centerX, centerY, angle-6);
		}
		

	}
	
	
	public void binaryTree(Graphics g, int length, int x, int y, int angle) {
		
		int x2,y2;
		
		//base case
		if(length<=0) {
			return;
		}
		else {
			
			x2 = x + (int) ( ( Math.cos(Math.toRadians(angle)) )*length );
			y2 = y + (int) ( ( Math.sin(Math.toRadians(angle)) )*length );
			g.drawLine(x, y, x2, y2);
			binaryTree(g, length-10, x2, y2, angle-45);

		}
		
	}
	
	
	//each call to square draws its own part
	public void square(Graphics g, int length, int x , int y) {
		
		//first thing - handle what this method needs to do then call the next method
		if(length>0) {
			g.drawRect(x,y,length,length);
			square(g,length/2,length/2+x, y+length/2);
		}else {
			//done - base don't draw
		}
	}
	
	/*
	 * 			x2 = x + (int) ( ( Math.cos(Math.toRadians(angle)) )*length );
			y2 = y + (int) ( ( Math.sin(Math.toRadians(angle)) )*length );
			g.drawLine(x, y, x2, y2);
			binaryTree(g, length-10, x2, y2, angle-45);
	 */

}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Ball extends JComponent
{
	private Ellipse2D.Double ship = new Ellipse2D.Double(0,0,20,20);
	private int dx;
	private int dy;
	
	public Ball(int x, int y)
	{
		this.setSize(new Dimension(20,20));
		this.setLocation(x,y);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.RED);
		g2.fill(ship);
	}
	
	public void setDx(int num)
	{
		dx=num;
	}
	
	public void update()
	{
		this.setLocation(this.getX()+dx,this.getY()+dy);
	}

	public int getDx() 
	{
		return dx;
	}
}
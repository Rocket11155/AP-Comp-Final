import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Ship extends JComponent
{
	
	private Rectangle2D.Double ship = new Rectangle2D.Double(0,0,50,50);
	private int dx,dy;
	
	public Ship(int x, int y)
	{
		this.setSize(new Dimension(20,20));
		this.setLocation(x,y);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLUE);
		g2.fill(ship);
	}
	
//	public void setDy(int num)
//	{
//		dy=num;
//	}
	
	public void setDx(int num)
	{
		dx=num;
	}
	
	public void update()
	{
		this.setLocation(this.getX()+dx,this.getY()+dy);
	}
	
}

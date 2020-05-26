import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class lazer extends JComponent
{
	private Rectangle2D.Double lazer = new Rectangle2D.Double(0,0,50,50);
	private int dy = -2;
	
	public lazer(int x, int y)
	{
		this.setSize(new Dimension(5,20));
		this.setLocation(x,y);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.GREEN);
		g2.fill(lazer);
	}
	
	public void setDy(int num)
	{
		dy=num;
	}	
	public void update()
	{
		this.setLocation(this.getX(),this.getY()+dy);
	}
	
	
	
}
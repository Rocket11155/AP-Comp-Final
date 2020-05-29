import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class APCompFinal extends JFrame implements ActionListener
{
	private ArrayList<Ship> list;
	private ArrayList<Ball> list2;
	private ArrayList<lazer> list3;
	private int score1 = 0;
	private int score2 = 0;
	private JLabel topScore;
	private JLabel btmScore;
	private JLabel topWinner;
	private JLabel btmWinner;
	private JLabel instructions1;
	private JLabel instructions2;
	private int bulletCount = 0;
	private boolean fired = false;
	private boolean scored = false;
	
	public APCompFinal()
	{
		list = new ArrayList<Ship>();
		list2  = new ArrayList<Ball>();
		list3  = new ArrayList<lazer>();
		this.setTitle("APCompFinal");
		this.setBounds(500,100,400,700);
		setResizable(false);
		setLayout(null);
		
		instructions1 = new JLabel("W key - Bottom Ship ");
		instructions1.setSize(new Dimension(200,10));
		instructions1.setLocation(150,25);
		instructions1.setForeground(Color.white);
		instructions1.setFont(new Font("Serif", Font.PLAIN, 15));
		add(instructions1);
		
		instructions2 = new JLabel("^ Arrow key - Top Ship");
		instructions2.setSize(new Dimension(200,10));
		instructions2.setLocation(150,10);
		instructions2.setForeground(Color.white);
		instructions2.setFont(new Font("Serif", Font.PLAIN, 15));
		add(instructions2);
		
		topScore = new JLabel("0");
		topScore.setSize(new Dimension(100,100));
		topScore.setLocation(340,100);
		topScore.setForeground(Color.white);
		topScore.setFont(new Font("Serif", Font.PLAIN, 50));
		add(topScore);
		
		btmScore = new JLabel("0");
		btmScore.setSize(new Dimension(100,100));
		btmScore.setLocation(340,550);
		btmScore.setForeground(Color.white);
		btmScore.setFont(new Font("Serif", Font.PLAIN, 50));
		add(btmScore);
		
		topWinner = new JLabel("Top Ship Wins!");
		topWinner.setSize(new Dimension(200,100));
		topWinner.setLocation(100,250);
		topWinner.setForeground(Color.orange);
		topWinner.setFont(new Font("Serif", Font.PLAIN, 30));
		topWinner.setVisible(false);
		add(topWinner);
		
		btmWinner = new JLabel("Bottom Ship Wins!");
		btmWinner.setSize(new Dimension(250,100));
		btmWinner.setLocation(100,250);
		btmWinner.setForeground(Color.orange);
		btmWinner.setFont(new Font("Serif", Font.PLAIN, 30));
		btmWinner.setVisible(false);
		add(btmWinner);
		
		Ship ship1 = new Ship(190,600);
		add(ship1);
		list.add(ship1);
		
		Ship ship2 = new Ship(190,50);
		add(ship2);
		list.add(ship2);
		
		Ball a1 = new Ball(180,300);
		add(a1);
		list2.add(a1);
		a1.setDx(-1);
		
		Ball a2 = new Ball(130,300);
		add(a2);
		list2.add(a2);
		a2.setDx(-1);
		
		Ball a3 = new Ball(80,300);
		add(a3);
		list2.add(a3);
		a3.setDx(-1);
		
		Ball a4 = new Ball(230,300);
		add(a4);
		list2.add(a4);
		a4.setDx(1);
		
		Ball a5 = new Ball(280,300);
		add(a5);
		list2.add(a5);
		a5.setDx(1);
		
		this.addKeyListener(new KeyListener()
		{


			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_A)
					list.get(0).setDx(-1);
				if(e.getKeyCode() == e.VK_D)
					list.get(0).setDx(1);
				if(e.getKeyCode() == e.VK_W && !fired)
				{
					lazer bullet = new lazer(list.get(0).getX()+8,580,"s1");
					bullet.setDy(-1);
					add(bullet);
					list3.add(bullet);
					fired = true;
				}
				
				if(e.getKeyCode() == e.VK_LEFT)
					list.get(1).setDx(-1);
				if(e.getKeyCode() == e.VK_RIGHT)
					list.get(1).setDx(1);
				if(e.getKeyCode() == e.VK_UP && !fired)
				{
					lazer bullet2 = new lazer(list.get(1).getX()+8,70,"s2");
					bullet2.setDy(1);
					add(bullet2);
					list3.add(bullet2);
					fired = true;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == e.VK_A)
					list.get(0).setDx(0);
				if(e.getKeyCode() == e.VK_D)
					list.get(0).setDx(0);
				
				if(e.getKeyCode() == e.VK_LEFT)
					list.get(1).setDx(0);
				if(e.getKeyCode() == e.VK_RIGHT)
					list.get(1).setDx(0);
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Timer t1 = new Timer(2,this);
		t1.start();
		
		setPreferredSize(new Dimension(400,700));
		pack();
		
		this.getContentPane().setBackground(Color.BLACK);
		
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

	public static void main(String[] args) 
	{
		new APCompFinal();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		for(lazer i : list3)
		{
			for(int j = list2.size()-1; j>= 0; j--)
			{
				
				if(i.getBounds().intersects(list2.get(j).getBounds()) && i.getName().equals("s1"))
				{
					
					score1++;
					list2.get(j).setVisible(false);
					list2.remove(j);
					i.setVisible(false);
					i.setLocation(0,0);
					btmScore.setText("" + score1);
					
					if(score1 + score2 == 5 && score1 > score2)
					{
						btmWinner.setVisible(true);
					}
					if(score1 + score2 == 5 && score1 < score2)
					{
						topWinner.setVisible(true);
					}
					
				}
				
				else if(i.getBounds().intersects(list2.get(j).getBounds()) && i.getName().equals("s2"))
				{
					score2++;
					list2.get(j).setVisible(false);
					list2.remove(j);
					i.setVisible(false);
					i.setLocation(400,700);	
					topScore.setText("" + score2);
					if(score1 + score2 == 5 && score1 > score2)
					{
						btmWinner.setVisible(true);
					}
					if(score1 + score2 == 5 && score1 < score2)
					{
						topWinner.setVisible(true);
					}
				}
				
				
				
			}
			
						
		}
		
		for(Ship i:list)
		{
			i.update();
			
			if(i.getX()<0)
				i.setLocation(i.getX()+1, i.getY());
			if(i.getX()>365)
				i.setLocation(i.getX()-1, i.getY());
		}
		for(int i = 0; i < list3.size(); i++)
		{
			list3.get(i).update();
		}
		for(Ball i:list2)
		{	
			i.update();
			if(i.getX()<0)
				i.setDx(i.getDx()*-1);
			if(i.getX()>365)
				i.setDx(i.getDx()*-1);
		}
		if(fired)
		{
			bulletCount++;
			if(bulletCount == 120)
			{
				fired = false;
				bulletCount = 0;
			}
		}
		
		repaint();
	}

}
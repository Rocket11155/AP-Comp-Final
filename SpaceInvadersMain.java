import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class SpaceInvadersMain extends JFrame implements ActionListener
{
	private ArrayList<Ship> list;
	private ArrayList<Alien> list2;
	private ArrayList<lazer> list3;
	private int score;
	private JLabel lblScore;
	private int bulletCount = 0;
	private boolean fired = false;
	private boolean scored = false;
	
	public SpaceInvadersMain()
	{
		list = new ArrayList<Ship>();
		list2  = new ArrayList<Alien>();
		list3  = new ArrayList<lazer>();
		this.setTitle("Space Invaders");
		this.setBounds(500,100,400,700);
		setResizable(false);
		setLayout(null);
		
		JLabel lblScore = new JLabel(score+"");
		lblScore.setSize(50, 50);
		lblScore.setLocation(320,20);
		lblScore.setFont(new Font("Font",Font.PLAIN,40));
		lblScore.setForeground(Color.WHITE);
		add(lblScore);
		
		Ship ship = new Ship(190,600);
		add(ship);
		list.add(ship);
		
		Alien a1 = new Alien(180,50);
		add(a1);
		list2.add(a1);
		
		Alien a2 = new Alien(130,50);
		add(a2);
		list2.add(a2);
		
		Alien a3 = new Alien(80,50);
		add(a3);
		list2.add(a3);
		
		Alien a4 = new Alien(230,50);
		add(a4);
		list2.add(a4);
		
		Alien a5 = new Alien(280,50);
		add(a5);
		list2.add(a5);
		
		this.addKeyListener(new KeyListener()
		{


			@Override
			public void keyPressed(KeyEvent e) 
			{
//				if(e.getKeyCode() == e.VK_W)
//					list.get(0).setDy(-1);
//				if(e.getKeyCode() == e.VK_S)
//					list.get(0).setDy(1);
				if(e.getKeyCode() == e.VK_A)
					list.get(0).setDx(-1);
				if(e.getKeyCode() == e.VK_D)
					list.get(0).setDx(1);
				if(e.getKeyCode() == e.VK_SPACE && !fired)
				{
					lazer bullet = new lazer(list.get(0).getX()+8,580);
					add(bullet);
					list3.add(bullet);
					fired = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
//				if(e.getKeyCode() == e.VK_W)
//					list.get(0).setDy(0);
//				if(e.getKeyCode() == e.VK_S)
//					list.get(0).setDy(0);
				if(e.getKeyCode() == e.VK_A)
					list.get(0).setDx(0);
				if(e.getKeyCode() == e.VK_D)
					list.get(0).setDx(0);
				
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
		new SpaceInvadersMain();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		for(Alien i:list2)
			for(lazer j:list3)
			{
				if(i.getBounds().intersects(j.getBounds()) && i.isVisible())
				{
					score++;
					System.out.println(score);
//					lblScore.setText(score+"");
					j.setVisible(false);
					i.setVisible(false);
				}
			}
		
		for(Ship i:list)
		{
			i.update();
//			if(i.getY()>730)
//			{
//				i.setLocation(i.getX(), i.getY()-1);
//			}
//			if(i.getY()+i.getHeight()<380)
//			{
//				i.setLocation(i.getX(), i.getY()+1);
//			}
			if(i.getX()<0)
				i.setLocation(i.getX()+1, i.getY());
			if(i.getX()>365)
				i.setLocation(i.getX()-1, i.getY());
		}
		for(lazer i:list3)
		{
			i.update();
			if(i.getY()<0)
			{
				i.setVisible(false);
			}
		}
		for(Alien i:list2)
		{	
			i.update();
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

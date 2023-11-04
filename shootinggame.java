
 // LOGIC and Main method
package gunmain;


import java.awt.*;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.io.*;
import java.awt.event.*;

class demo extends JFrame implements MouseListener, ActionListener{
	
	private static final Color Color = null;
	ImageIcon image , bullet, bullet2 , exitIcon , smile , smilehear , smilehapp , smilepart , smilestar , smileWow;
	Image alien1 ;
	JLabel label , BulLabel , BulLabel2 , AlienLabel , Result , Score1 , Score2 , reaction;
	JButton  Exit ;
	int x = 50,y=10,mouse = 0;
    int x1 = 50 , y1 =50;
	Timer timer;
	int xVelocity = 1;
	int yVelocity = 1;
	final int PANEL_WIDTH = 800;
	final int PANEL_HEIGHT = 800;
	
	public demo() {
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		this.setLayout(null);
	    this.getContentPane().setBackground(Color.black);

		
	    image = new ImageIcon("aircraft (4).png");
		label = new JLabel();
		label.setIcon(image);
		label.setBounds(x,550,70,60);
		/*this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent k) {
				switch(k.getKeyCode()) {
				case 39:
					if(label.getX()  <= 770) {
					label.setLocation(label.getX()+20,label.getY());}
					 break;
				case 37:
					if(label.getX()  >= 50) {
					label.setLocation(label.getX()-20 , label.getY());}
					break;
				 }
				
			   
			}
			public void keyTyped(KeyEvent k) {
				
			}
			public void keyReleased(KeyEvent k) {
				
			}
		});*/
		
		bullet = new ImageIcon("eclipbul.png");
		BulLabel = new JLabel();
		BulLabel.setIcon(bullet);
		
		
		bullet2 = new ImageIcon("eclipbul.png");
		BulLabel2 = new JLabel();
		BulLabel2.setIcon(bullet2);
		
		this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent k) {
				switch(k.getKeyCode()) {
				case 39:
					if(label.getX()  <= 770) {
					label.setLocation(label.getX()+20,label.getY());
					}
					BulLabel.setVisible(false);
					BulLabel2.setVisible(false);
					 break;
				case 37:
					if(label.getX()  >= 50) {
					label.setLocation(label.getX()-20 , label.getY());}
					BulLabel.setVisible(false);
					BulLabel2.setVisible(false);
					break;
				 }
				
			   
			}
			public void keyTyped(KeyEvent k) {
				
			}
			public void keyReleased(KeyEvent k) {
				
			}
		});
		
		
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent bul) {
				BulLabel.setVisible(false);
				BulLabel2.setVisible(false);
			}
			public void mousePressed(MouseEvent m) {
				// TODO Auto-generated method stub
				
				
				/*try {
					Thread.sleep(10);
					BulLabel.setLocation(BulLabel.getX(),BulLabel.getY()-50);
					BulLabel2.setLocation(BulLabel2.getX(),BulLabel2.getY()-50);
					}catch(Exception x) {}*/
			}

			@Override
			public void mouseReleased(MouseEvent m) {
				// TODO Auto-generated method stub
			      
				BulLabel.setVisible(true);
				BulLabel2.setVisible(true);
				}
			

			@Override
			public void mouseEntered(MouseEvent m) {
				// TODO Auto-generated method stub
         
			}
			@Override
			public void mouseExited(MouseEvent m) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		alien1 = new ImageIcon("alien (1).png").getImage();
		timer = new Timer(10,this);
		timer.start();
		
		/*AlienLabel  = new JLabel();
		AlienLabel.setIcon(alien1);
		//AlienLabel.setBounds(100,50,100,100);
		 
		*/
		
		smile = new ImageIcon("smileconfused.png");
		
		Result = new JLabel("  ");
		
		Result.setFont(new Font("MV BOLI",Font.BOLD,30));
		Result.setIcon(smile);
		Result.setForeground(Color.white);
		Result.setBounds(350,200,200,80);
		
		this.addMouseListener(this);
		this.add(label);
		
		exitIcon = new ImageIcon("logout (1).png");
		
		Exit = new JButton();
		Exit.setBounds(890,300,70,70);
		Exit.setIcon(exitIcon);
		Exit.setFocusable(false);
	   
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		Score1 = new JLabel(" Score ");
		Score1.setBounds(880,190,100,50);
		Score1.setFont(new Font("MV BOLI",Font.BOLD,25));
		Score1.setForeground(Color.white);
		
		Score2 = new JLabel("0 ");
		Score2.setBounds(900,150,90,50);
		Score2.setFont(new Font("MV BOLI",Font.BOLD,25));
		Score2.setForeground(Color.white);
		
		
	    // smilehear , smilehappy , smilepart , smilestar , smilewow
		smilehear = new ImageIcon("smileheart.png");
		smilehapp = new ImageIcon("smilehappy.png");
		smilepart = new ImageIcon("smilestar.png");
		smileWow = new ImageIcon("smilewow.png"); 
		
		reaction = new JLabel();
		reaction.setBounds(400,230,200,80);
		reaction.setFont(new Font("MV BOLI",Font.BOLD,25));
		
		this.add(Score2);
		this.add(Score1);
		this.add(Exit);
		this.add(BulLabel);
		this.add(BulLabel2);
		this.add(reaction);
		
		this.setVisible(true);
	
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(alien1,x1,y1,null);
		
		//g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.green);
		
		g2d.drawLine(50, 700, 860, 700);
		g2d.setColor(Color.red);
		g2d.drawLine(890, 100, 890 , 700);
		g2d.setColor(Color.yellow);
		g2d.drawLine(30, 70, 30, 700);
		
	}
	
	int shot , i = 0;
	public void actionPerformed(ActionEvent a) {

	if(x1 > 750) {
		x1 = 100;
	}
	if(y1 <= 550 && x1 <= 750) {
		
		Random s = new Random();
		shot = s.nextInt(10)+5;
		if(mouse == shot)
		{	y1 = 0;
		    i++;
		    
		 if(i == 10) {
			   reaction.setIcon(smilehear);
			   reaction.setText(" Good...");
			   reaction.setBounds(400,230,200,80);
			   reaction.setForeground(Color.red);
			 //  this.add(reaction);
			   
		   }
		 else if(i == 25) {
			  reaction.setIcon(smilehapp);
			  reaction.setText(" OOh...!");
			  reaction.setBounds(400,230,200,80);
			   reaction.setForeground(Color.green);
			 // this.add(reaction);
		   }
		else if(i == 40) {
			   reaction.setIcon(smileWow);
			   reaction.setText(" Wow...*");
			   reaction.setBounds(400,230,200,80);
			   reaction.setForeground(Color.blue);
			  // this.add(reaction);
		   }
		 else if(i == 60) {
			  reaction.setIcon(smilepart);
			  reaction.setText(" Splendid....!!");
			  reaction.setBounds(400,230,200,80);
			   reaction.setForeground(Color.magenta);
			  //this.add(reaction);
		   }
		 else if(i == 100) {
			  reaction.setIcon(smilestar);
			  reaction.setText(" Star....");
			  reaction.setBounds(400,230,200,80);
			   reaction.setForeground(Color.yellow);
			 // this.add(reaction);
		   }
		   else {
			  reaction.setBounds(0,0,0,0);
			  reaction.setText("        ");
			   reaction.setForeground(Color.red);
			 // this.add(reaction);
		   }
		
		Score2.setText(" "+String.valueOf(i)+" ");
		  
		Random r = new Random();
		x1 = x1 + r.nextInt(750)+1;
		   mouse = 0;
		   
		  if(x1 >= 50  && x1 <= 300) {
			  alien1 = new ImageIcon("monster (1).png").getImage();
		  }
		  else if(x1 > 300 && x1 <= 600 ) {
			  alien1 = new ImageIcon("alien (3).png").getImage();
		  }
		  else if(x1 > 600 && x1 <= 700) {
			  alien1 = new ImageIcon("monster (2).png").getImage();
		  }
		  else if(x1 > 700 && x1 <= 900) {
			  alien1 = new ImageIcon("alien (1).png").getImage();
		  }
		}
		else
		  y1 = y1 + 1;
		
	}
	
		else if(y1 > 550){
		Result.setText("Ga-ver....!");
		this.add(Result);
	}  

		repaint();
	}
	
	

	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub
		try {
			sound s = new sound();
		//if(label.getX() <= alien1.getLocation() && alien1.getWidth(null) <= label.getY())
		   if(label.getX() >= x1 && alien1.getWidth(null)+x1 >= label.getX())
			mouse++;
			
			BulLabel.setBounds(label.getX()-20,460,300,100);
			BulLabel2.setBounds(label.getX()+70,460,300,100);
			
		}
		catch(Exception e) {}
		
		BulLabel.setVisible(true);
		BulLabel2.setVisible(true);
		
		
	}
	
	
	
	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
		BulLabel.setVisible(false);
		BulLabel2.setVisible(false);
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub
		BulLabel.setVisible(false);
		BulLabel2.setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent m) {
		// TODO Auto-generated method stub
		
		
		// TODO Auto-generated method stub
		BulLabel.setVisible(true);
		BulLabel2.setVisible(true);
	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub
		BulLabel.setVisible(false);
		BulLabel2.setVisible(false);
	}
	
	
}

class gungame extends JFrame{
	
	public static void main(String args[]) {
	
	Thread t = new Thread();
	t.start();
	
	Bar b = new Bar();	
	//demo d = new demo();
	Intro i1 = new Intro();
		
	}
}


// Sound effect of game


package gunmain;

import java.util.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;


class music extends Thread {
	public void run() {
		try {
		Scanner scan = new Scanner(System.in);
		 File file = new File("music1.wav");
	       
	       AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	       
	       Clip clip = AudioSystem.getClip();
	       
	       clip.open(audioStream);
	       
	       clip.start();

	       String response = scan.next();}catch(Exception x) {}
	 }

}

class Bar extends JFrame{
	JProgressBar bar = new JProgressBar();
	Image Background;
	int count = 0;
	public Bar() {
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(1000,1000);
		 this.setVisible(true);
		 this.setLayout(null);
		 
		 bar.setBounds(300,300,450,40);
		 bar.setBackground(Color.black);
		 bar.setStringPainted(true);
		 bar.setFont(new Font("MV BOLI",Font.BOLD,30));
		 bar.setForeground(Color.green);
	
		 
		 Background = new ImageIcon("spaceosam.jpg").getImage();
		 
		 this.add(bar);
		 
		 repaint();
		 fill();
		 
		
	}
	
	public void fill() {
	
		 int counter = 0 ;
		
		 while(counter <= 100) {
			 bar.setString("Loading ...");
				
			 bar.setValue(counter);
			 //bar.setText(s);
			 try {
			 Thread.sleep(50);}catch(Exception e) {}
			 //counter+=10;
			 counter++;
			 
		  }
			bar.setString("Done :)");
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Background,0,0,null);
	
	  
	}
	
}



class Intro extends JFrame{
	 JButton button1 , button2;
	 Image Background1;
	 ImageIcon power,logout;
	 public Intro() {
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(1000,1000);
		 this.setLayout(null);
		 this.getContentPane().setBackground(Color.black);
		 
		 Background1 = new ImageIcon("spaceosam.jpg").getImage();
		 power = new ImageIcon("power.png");
		 logout = new ImageIcon("logout.png");
		 
		 button1 = new JButton(" Play");
		 button2 = new JButton(" Exit");
		 
		 button1.setBounds(280,300,150,50);
		 button1.setIcon(power);
		 button1.setBackground(Color.green);
		 button1.setFocusable(false);
		 button1.setFont(new Font("MV BOLI",Font.BOLD,30));
		 button1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent i) {
				 demo d = new demo();
			 }
		 });
		 
		 
		 button2.setBounds(480,300,150,50);
		 button2.setBackground(Color.green);
		 button2.setIcon(logout);
		 button2.setFocusable(false);
		 button2.setFont(new Font("MV BOLI",Font.BOLD,30));
		 button2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent i) {
				 System.exit(0);
			 }
		 });
		
		 
		// repaint();
		 this.add(button1);
		 this.add(button2);
		 
		 this.setVisible(true);
		
	 }
	 
/*	 public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(Background1,0,0,null);
		
			
		}*/
	 
}



public class sound {
   
	public sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
	
	     File file = new File("gun.wav");
	     AudioInputStream audio = AudioSystem.getAudioInputStream(file);
	     Clip clip = AudioSystem.getClip();
	     clip.open(audio);
	     for(int i = 1 ; i <= 5 ; i++) {
	    	if(i == 2) {
	    	  clip.stop(); 
	    	  }
	     clip.start();
	    	 
	       }
	 }
 
}
/*
File file = new File("gun.wav");

AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

Clip clip = AudioSystem.getClip();

clip.open(audioStream);
for(int i = 0 ; i < 5 ; i++) {
	  if(i == 2)
		  clip.stop();
clip.start();

} */
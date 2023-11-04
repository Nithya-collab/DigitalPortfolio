
package Bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;



public class BankingSystem extends JFrame implements ActionListener{

	 JButton b1;
	 JButton b2;
	 
	 
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost:3306/myproject?characterEncoding=utf8";
		
	 static final String USER = "username";
	 static final String PASS ="password";
		
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement p = null;
		ResultSet rs = null;
		String str1=" ",str2="0",qry="";
		
	
	public BankingSystem() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		//this.setResizable(false);
    
		this.setLayout(null);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("my.png"));
		
		JLabel l1 = new JLabel(icon);
        l1.setBounds(550,150,500,500);
		
		JLabel l2 = new JLabel("A T M");
		l2.setFont(new Font("arial",Font.BOLD,30));
		l2.setForeground(Color.black);
        l2.setBounds(400,20,150,60);		
        
        b1 = new JButton();
	    b1.setText("Login");
	    b1.setBounds(200,300,200,50);
	    b1.setFocusable(false);
	    b1.setFont(new Font("Arial",Font.BOLD,20));
	    b1.addActionListener(this);
	    
	    
	    b2 = new JButton();
	    b2.setText("Sing Up");
	    b2.setBounds(200,450,200,50);
	    b2.setFocusable(false);
	    b2.setFont(new Font("Arial",Font.BOLD,20));
	    b2.addActionListener(this);
	    
	    
		
		this.add(l2);
		this.add(l1);
		this.add(b1);
		this.add(b2);
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource() == b1) {
			 
			 
			 ImageIcon icon = new ImageIcon(getClass().getResource("my.png"));
			 JLabel label = new JLabel(icon);
		     label.setBounds(550,150,500,500);
				
			 JLabel l2 = new JLabel("A T M");
			 l2.setFont(new Font("arial",Font.BOLD,30));
			 l2.setForeground(Color.black);
		     l2.setBounds(400,20,150,60);	
			
			 JFrame frame = new JFrame("Login Page... :)");
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.setSize(1000,1000);
			 frame.setVisible(true);
			 frame.setLayout(null);
			 
			 
             JButton DebButton = new JButton(" Credit ");
             JButton CreButton = new JButton(" Debit ");
             JButton balButton = new JButton(" Balance");
			 
			 DebButton.setBounds(270,250,180,50);
			 DebButton.setFocusable(false);
			 DebButton.setFont(new Font("arial",Font.BOLD,20));
			 DebButton.setBackground(Color.LIGHT_GRAY);

			 
			 DebButton.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent obj) {
					 
					 JFrame debframe = new JFrame("Credit Page.....");
					 debframe.setSize(600,500);
					 debframe.setVisible(true);
					 debframe.setLayout(null);
					 
					 Font debfont = new Font("ARial",Font.BOLD,25);
					 Font debfont1 = new Font("ARial",Font.BOLD,20);
					 
					 JTextField debText1 = new JTextField();
					 JTextField debText2 = new JTextField();
					 JTextField debText3 = new JTextField();
					 
					 JButton debbutton = new JButton("Credit");
					 debbutton.setBounds(250,400,150,40);
					 debbutton.setFont( debfont);
					 debbutton.setFocusable(false);
					 
					 
					 debText1.setBounds(250,100,200,40);
					 debText2.setBounds(250,200,200,40);
					 debText3.setBounds(250,300,200,40);
					 
					 debText2.setFont(debfont1);
					 debText3.setFont(debfont1);
					 debText1.setFont(debfont1);
					 
					 
					 debText1.setForeground(Color.LIGHT_GRAY);
					 debText2.setForeground(Color.LIGHT_GRAY);
					 debText3.setForeground(Color.LIGHT_GRAY);
					 
					 
					 JLabel deblabel1 = new JLabel("Date            :");
					 JLabel deblabel2 = new JLabel("Ac.no          :");
					 JLabel deblabel3 = new JLabel("Ammount    :");
					 JLabel deblabel4 = new JLabel("Balance :");
					 JLabel deblabel5 = new JLabel("          ");
					 
					 deblabel1.setBounds(30,100,150,50);
					 deblabel2.setBounds(30,200,150,50);
					 deblabel3.setBounds(30,300,150,50);
					 
					 
					 deblabel1.setFont(debfont);
					 deblabel2.setFont(debfont);
					 deblabel3.setFont(debfont);
					 deblabel4.setFont(debfont);
					 deblabel5.setFont(debfont);
					 deblabel4.setForeground(Color.LIGHT_GRAY);
					 deblabel5.setForeground(Color.LIGHT_GRAY);
					 
					 
					 debbutton.addActionListener(new ActionListener() {
					
						 public void actionPerformed(ActionEvent event) {
							  String date = debText1.getText();
							  String Aco = debText2.getText();
							  String balance = debText3.getText();
							
							  
							  if(date.isEmpty() || Aco.isEmpty() || balance.isBlank()) {
							     JOptionPane.showMessageDialog(null,"Please give all details","Message",JOptionPane.WARNING_MESSAGE);
							  return;
							  }
							  
							  int b = Integer.parseInt(balance);
							  int a = Integer.parseInt(Aco);
							  
							  int result=0;
							  int ac_no=0;
							  String value=null;
							  if(event.getSource() == debbutton) {
								 
				
								  try {
					
									  
										Class.forName("com.mysql.cj.jdbc.Driver");
										
										con = DriverManager.getConnection(DB_URL,USER,PASS);
										
								
									 qry ="SELECT balance,ac_no from customer WHERE ac_no="+a;
									 stmt = con.createStatement();
									 rs = stmt.executeQuery(qry);
								 if(rs.next()) {
										result = rs.getInt("balance");
									    ac_no = rs.getInt("ac_no");
								  }
									
								if(a == ac_no) {
									  qry="UPDATE customer SET balance=?,date=? WHERE ac_no=?";
									  p=con.prepareStatement(qry);
									  p.setInt(1,b+result);
									  p.setString(2,date);
									  p.setInt(3,a);
									  
									  p.executeUpdate();
									  
									  value = String.valueOf(b+result);
									  
								}
								else {
									value = "Incorret Account Number !!";
									 deblabel5.setBounds(130,10,350,50);
									 deblabel5.setForeground(Color.red);
									 deblabel5.setText(value);
									 
									    
								     debText2.setText(" ");
									 debText3.setText(" ");
									 debText1.setText(" ");
									 debText1.requestFocus();
									 
									 return ;
								}
										 
								  }catch(Exception excep) {
									  System.out.println(excep);
								  }
								  
								     deblabel4.setBounds(30,10,150,50);
								   	 deblabel5.setBounds(150,10,150,50);
								     deblabel5.setText(value);
								    
								    
								     debText2.setText(" ");
									 debText3.setText(" ");
									 debText1.setText(" ");
									 debbutton.setEnabled(false);
									 debbutton.setText("Credited..");
									 
									 debText1.requestFocus();
									 
								    
							  }
						 }
					 });
					 
					 
					 
	
					 debframe.add(deblabel1);
					 debframe.add(deblabel2);
					 debframe.add(deblabel3);
					 debframe.add(deblabel4);
					 debframe.add(deblabel5);
					 
					 

					 debframe.add(debText1);
					 debframe.add(debText2);
					 debframe.add(debText3);
					 debframe.add(debbutton);
					
					 
					 
					 
				 }
			 });
			 
			 CreButton.setBounds(270,380,180,50);
			 CreButton.setFocusable(false);
			 CreButton.setFont(new Font("arial",Font.BOLD,20));
			 CreButton.setBackground(Color.LIGHT_GRAY);
			 CreButton.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent obj) {
					 
					 // Credit 
					 
					 
					 
					 JFrame creframe = new JFrame("Debit Page.....");
					 creframe.setSize(600,500);
					 creframe.setVisible(true);
					 creframe.setLayout(null);
					 
					 Font crefont = new Font("ARial",Font.BOLD,25);
					 Font crefont1 = new Font("ARial",Font.BOLD,20);
					 
					 JTextField creText1 = new JTextField();
					 JTextField creText2 = new JTextField();
					 JTextField creText3 = new JTextField();
					 
					 JButton crebutton = new JButton("Debit");
					 crebutton.setBounds(250,400,150,40);
					 crebutton.setFont( crefont);
					 crebutton.setFocusable(false);
					/* crebutton.addMouseListener(new MouseAdapter() {
						 public void mouseClicked(MouseEvent m) {
							 crebutton.setBackground(Color.green);
						 }
						 public void mousePressed(MouseEvent m) {
							 
						 }
						 public void mouseEntered(MouseEvent m){
							 
						 }
						 public void mouseRealesed(MouseEvent m) {
							 
						 }
						 public void mouseExited(MouseEvent m) {
							 
						 }
					 });*/
					 
					 
					 creText1.setBounds(250,100,200,40);
					 creText2.setBounds(250,200,200,40);
					 creText3.setBounds(250,300,200,40);
					 
					 creText2.setFont(crefont1);
					 creText3.setFont(crefont1);
					 creText1.setFont(crefont1);
					 
					 
					 creText1.setForeground(Color.LIGHT_GRAY);
					 creText2.setForeground(Color.LIGHT_GRAY);
					 creText3.setForeground(Color.LIGHT_GRAY);
					 
					 
					 JLabel crelabel1 = new JLabel("Date            :");
					 JLabel crelabel2 = new JLabel("Ac.no          :");
					 JLabel crelabel3 = new JLabel("Ammount    :");
					 JLabel crelabel4 = new JLabel("Balance :");
					 JLabel crelabel5 = new JLabel("          ");
					 
					 crelabel1.setBounds(30,100,150,50);
					 crelabel2.setBounds(30,200,150,50);
					 crelabel3.setBounds(30,300,150,50);
					 
					 
					 crelabel1.setFont(crefont);
					 crelabel2.setFont(crefont);
					 crelabel3.setFont(crefont);
					 crelabel4.setFont(crefont);
					 crelabel5.setFont(crefont);
					 crelabel4.setForeground(Color.LIGHT_GRAY);
					 crelabel5.setForeground(Color.LIGHT_GRAY);
					 
					 
					 
					 crebutton.addActionListener(new ActionListener() {
						 public void actionPerformed(ActionEvent event2) {
							 
							 String balance = creText3.getText();
							  String Aco = creText2.getText();
							  String date = creText1.getText();
							  
							  if(balance.isEmpty() || Aco.isEmpty() || date.isEmpty()) {
								  JOptionPane.showMessageDialog(null,"Please give all details","Message",JOptionPane.WARNING_MESSAGE);
							   return;
							  }
							  int b = Integer.parseInt(balance);
							  int a = Integer.parseInt(Aco);
							  int result=0;
							  String value=null;
							  int ac_no = 0;
							  
							  if(event2.getSource() == crebutton) {
								  
									 
								  try {
									  
									 
									  
										Class.forName("com.mysql.cj.jdbc.Driver");
										
										con = DriverManager.getConnection(DB_URL,USER,PASS);
										
									  
									 qry ="SELECT balance,ac_no from customer WHERE ac_no="+a;
									 stmt = con.createStatement();
									 rs = stmt.executeQuery(qry);
								 if(rs.next()) {
										result = rs.getInt("balance");
									    ac_no = rs.getInt("ac_no");
								  }
									
								if(a == ac_no) {	
									if(result >= b) {
									  qry="UPDATE customer SET balance=? WHERE ac_no=?";
									  p=con.prepareStatement(qry);
									  p.setInt(1,Math.abs(result)-Math.abs(b));
									  p.setInt(2,a);
									  
									  p.executeUpdate();
									  
									  value = String.valueOf(Math.abs(result)-Math.abs(b));
									}
									else {
										value = "Over Draft";
										crelabel5.setBounds(130,10,350,50);
										crelabel5.setForeground(Color.red);
										crelabel5.setText(value);
										
										 creText2.setText(" ");
										 creText3.setText(" ");
										 creText1.setText(" ");
										 creText1.requestFocus();
									    return ;
									}
								}
								else {
									value = "Incorrect Account Number !!";
									crelabel5.setBounds(130,10,350,50);
									crelabel5.setForeground(Color.red);
								    crelabel5.setText(value);
								    
								    
								    
								     creText2.setText(" ");
									 creText3.setText(" ");
									 creText1.setText(" ");
									 creText1.requestFocus();
								    return ;
									
								}
										 
								  }catch(Exception excep) {
									  System.out.println(excep);
								  }
								  
								     crelabel4.setBounds(30,10,150,50);
								   	 crelabel5.setBounds(150,10,150,50);
								     crelabel5.setText(value);
								    
								    
								     creText2.setText(" ");
									 creText3.setText(" ");
									 creText1.setText(" ");
									 crebutton.setEnabled(false);
									 crebutton.setText("Debited..");
									 
									 creText1.requestFocus();
									 
								    
							  }
							 
						 }
					 });
					 
					 
					 
					 
					 
					 
					 creframe.add(crelabel1);
					 creframe.add(crelabel2);
					 creframe.add(crelabel3);
					 creframe.add(crelabel4);
					 creframe.add(crelabel5);
					 
					 

					 creframe.add(creText1);
					 creframe.add(creText2);
					 creframe.add(creText3);
					 creframe.add(crebutton);
					 
					
					 
					 
					 
					 
					 
				 }
			 });
			 
			 balButton.setBounds(270,500,180,50);
			 balButton.setFocusable(false);
			 balButton.setFont(new Font("arial",Font.BOLD,20));
			 balButton.setBackground(Color.LIGHT_GRAY);
			 balButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent b) {
				  JFrame balFrame = new JFrame("Balance Checking .....");
				  balFrame.setSize(600,500);
				  balFrame.setVisible(true);
				  balFrame.setLayout(null);
				  
				  JLabel balLabel = new JLabel("Account No :");
				  balLabel.setBounds(30,100,180,50);
				  balLabel.setFont(new Font("ARIAL",Font.BOLD,25));
				  
				  
				  JLabel balLabel2 = new JLabel();
			
				  
				  JLabel balLabel3 = new JLabel("Balance :");
				  
				
				 
				  JTextField balText = new JTextField();
				  balText.setBounds(230,100,220,40);
				  balText.setBackground(Color.LIGHT_GRAY);
				  balText.setFont(new Font("ARIAL",Font.BOLD,23));
				  balText.setForeground(Color.gray);
				  
				  JButton BalButton = new JButton("check");
				  BalButton.setBounds(300,200,140,30);
				  BalButton.setFocusable(false);
				  
				  JLabel balLabel4 = new JLabel("Name   :");
				  JLabel balLabel5 = new JLabel("Branch :");
				  
				  JLabel balLabel6 = new JLabel();
				  JLabel balLabel7 = new JLabel();
				  
				  
				  BalButton.addActionListener(new ActionListener() {
					  
					  public void actionPerformed(ActionEvent bal) {
						  
						  
						  int result=0;
						  int ac_no = 0;
						  String name="";
						  String branch="";
						  String ac = balText.getText();
						  
						  if(ac.isEmpty()) {
							  JOptionPane.showMessageDialog(null,"Please Enter your Account No","Error",JOptionPane.PLAIN_MESSAGE,null);
							
						  }
						  
						  
						  int a1 = Integer.parseInt(ac);
						  
						  
						try {  
						  Class.forName("com.mysql.cj.jdbc.Driver");
							
							con = DriverManager.getConnection(DB_URL,USER,PASS);
							
						  
						 qry ="SELECT balance,ac_no,name,city from customer WHERE ac_no="+ac;
						 stmt = con.createStatement();
						 rs = stmt.executeQuery(qry);
					   if(rs.next()) {
							result = rs.getInt("balance");
						    ac_no = rs.getInt("ac_no");
						    name = rs.getString("name");
						    branch=rs.getString("city");
					  }
					   if(ac_no == a1) {
						   
						   balLabel2.setText(String.valueOf(result));
						   
						   balLabel2.setBounds(230,300,150,50);
						   balLabel2.setForeground(Color.red);
							 // balLabel2.setBackground(Color.red);
							  balLabel2.setFont(new Font("ARIAL",Font.BOLD,25));
							  
							//balance
							  balLabel3.setBounds(30,300,150,50);
							  balLabel3.setForeground(Color.green);
							  balLabel3.setFont(new Font("ARIAL",Font.BOLD,25));
							  
							  
							  
							//  balLabel4 = new JLabel("Name  :");
							  balLabel4.setBounds(30,350,150,40);
							  balLabel4.setForeground(Color.black);
							  balLabel4.setFont(new Font("Arial",Font.BOLD,20));
							  
							 //name label
                              balLabel6.setBounds(230,350,260,40);
							  balLabel6.setForeground(Color.blue);
							  balLabel6.setFont(new Font("arial",Font.ITALIC,20));
							  balLabel6.setText(name);
							  
							  //branch label
							  balLabel7.setBounds(230,400,260,40);
							  balLabel7.setForeground(Color.blue);
							  balLabel7.setFont(new Font("arial",Font.ITALIC,20));
							  balLabel7.setText(branch);
							  
							 // balLabel5 = new JLabel("Branch");
							  balLabel5.setBounds(30,400,150,40);
							  balLabel5.setFont(new Font("Arial",Font.BOLD,20));
							  balLabel5.setForeground(Color.black);
							  
							  balText.setText(" ");
					   }
					   else {
						   balLabel2.setText("Wrong Account Number ");
						   balLabel2.setBounds(150,300,370,50);
						    balLabel2.setForeground(Color.red);
							
						  balLabel2.setFont(new Font("ARIAL",Font.BOLD,25));
							  
					   }
					  
						
					  }catch(Exception p) {}
					 }	
				  });
				  
				  
				  balFrame.add(balLabel);
				  balFrame.add(balText);
				  balFrame.add(BalButton);
				  
				  balFrame.add(balLabel3);
				  balFrame.add(balLabel2);
				  balFrame.add(balLabel4);
				  balFrame.add(balLabel5);
				  balFrame.add(balLabel6);
				  balFrame.add(balLabel7);
				  
			  }
			 });
			 
			 frame.add(DebButton);
			 frame.add(CreButton);
			 frame.add(balButton);
			 
			 frame.add(label);
			 frame.add(l2);
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
		 }
		 else if(e.getSource() == b2) {
			/* JOptionPane.showMessageDialog(null,"Sing Up Successfully!!","Message",JOptionPane.PLAIN_MESSAGE);
		     System.out.println("Sing Up....");
			 b2.setEnabled(false);*/
			 
			 JFrame singupWindow = new JFrame("Sing UP Page...");
			// singupWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 singupWindow.setSize(1000,900);
			 singupWindow.setLayout(null);
			 singupWindow.setVisible(true);
			 
			ImageIcon icon = new ImageIcon(getClass().getResource("my.png"));
				
				JLabel l1 = new JLabel(icon);
		        l1.setBounds(550,150,500,500); 
				
			 
			 JLabel singLabel1 = new JLabel();
			 singLabel1.setBounds(150,150,150,50);
			 singLabel1.setFont(new Font("arial",Font.BOLD,27));
			 singLabel1.setText("Name   :   ");
			 
			 JLabel singLabel2 = new JLabel(); 
			 singLabel2.setBounds(150,250,160,50);
			 singLabel2.setText("Branch :   ");
			 singLabel2.setFont(new Font("arial",Font.BOLD,27));
		
			 JTextField singText1 = new JTextField();
			 singText1.setBounds(300,150,250,40);
			 singText1.setFont(new Font("arial",Font.BOLD,25));
			 singText1.setForeground(Color.GRAY);
			 
			 JTextField singText2 = new JTextField();
			 singText2.setBounds(300,250,250,40);
			 singText2.setFont(new Font("arial",Font.BOLD,25));
			 singText2.setForeground(Color.GRAY);
			 
		   
       		 JComboBox singText2 = new JComboBox(city);
			 singText2.setBounds(300,250,250,40);
			 singText2.setFont(new Font("arial",Font.BOLD,25));
			 singText2.setForeground(Color.GRAY);
			 singText2.addActionListener(this);*/ //-----------COmbo Box
			
			
			 JLabel l2 = new JLabel("Account No :");
			 JLabel l3 = new JLabel("          ");
			 
			 JButton submit = new JButton("Submit");
			 submit.setBounds(300,350,150,50);
			 submit.setFocusable(false);
			 submit.setFont(new Font("arial",Font.BOLD,20));
			 submit.addActionListener(new ActionListener() {
				   
				 public void actionPerformed(ActionEvent i) {
					 
					 String s2 , s1;
					
					  if(i.getSource() == submit) {
					
						  s1 = singText1.getText();
						  s2 = singText2.getText();
							
							
						  
						  
						  if(s1.isEmpty())
						  {
							  JOptionPane.showMessageDialog(null,"Please Enter your Name..");
						  }
						 else if(s2.isEmpty()) {
							  JOptionPane.showMessageDialog(null,"Please Enter your City..");
						  }
						  else {
							  
								 l2.setBounds(140,50,200,50);
								 l2.setFont(new Font("arial",Font.BOLD,27));
								 l2.setForeground(Color.gray);
								 
								Random ran = new Random();
								int k = ran.nextInt(100000)+700;
							 l3.setBounds(370,50,150,50);
							 l3.setFont(new Font("arial",Font.BOLD,27));
						     l3.setText(String.valueOf(k));
							
						     str1 = l3.getText();
						     
						     int aco = Integer.parseInt(str1);
						     int bal = Integer.parseInt(str2);
								
								try {
									
							
									Class.forName("com.mysql.cj.jdbc.Driver");
									
									con = DriverManager.getConnection(DB_URL,USER,PASS);
									//stmt = con.createStatement();
									
									qry="INSERT INTO customer "+"VALUES (?,?,?,?,?)";
									p = con.prepareStatement(qry);
									
									p.setInt(1,aco);
									p.setString(2,s1);
									p.setString(3,s2);
									p.setInt(4,bal);
									p.setInt(5,0);
									
									p.executeUpdate();
							
									 con.close();
								}catch(Exception s) {System.out.println(s);
								
								}
								

							     singText1.setText(" ");
								  singText2.setText(" ");
							     
								  submit.setEnabled(false);
								  submit.setText("Submited...");
							      singText1.requestFocus();
							 
						  }
					  }
				 }

			 });
			 
			/* JButton ero = new JButton("<-");
			 ero.setBounds(100,50,60,30);
			 ero.setFocusable(false);
			 ero.setFont(new Font("arial",Font.BOLD,25));
			 ero.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent i) {
					 
				 }
			});*/
			 
			 singupWindow.add(l1);
			 singupWindow.add(l2);
			 singupWindow.add(l3);
			 
			 singupWindow.add(singLabel1);
			 singupWindow.add(singLabel2);
			 
			 singupWindow.add(singText1);
			 singupWindow.add(singText2);
			 
			 singupWindow.add(submit);
	
			 
			 
		 }
	}
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   
		BankingSystem bs = new BankingSystem();
	}

}
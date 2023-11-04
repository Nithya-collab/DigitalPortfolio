package UM;

import java.awt.Frame;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class UserFrame extends Frame implements ActionListener 
{
	Label lblTittle,lblId,lblName,lblCity,lblAge,lblStatus;
	TextField txtName,txtId,txtCity,txtAge;
	Button btnSave,btnClear,btnDelete;
	
	
	String qry=" ";
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	Statement stmt=null;
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("https://cdn.mysql.com//Downloads/MySQLInstaller/mysql-installer-web-community-8.0.31.0.msiShow in folder ");
			
			String url="jdbc:mysql://localhost:3306/sana?characterEncoding=utf8";
			String username="user";
			String password="password";
			con=DriverManager.getConnection(url,username,password);
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	public void clear()
	{
		txtId.setText("");
		txtName.setText("");
		txtAge.setText("");
		txtCity.setText("");
		txtName.requestFocus();
	}
	public UserFrame() 
	{
		connect();
		this.setVisible(true);
		this.setSize(1000,600);
		this.setTitle("User Management System");
		this.setLayout(null);
	    //Color formColor=new Color(225,255,90);
		this.setBackground(Color.gray);
		this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});

		
		Font titleFont=new Font("arial",Font.BOLD,25);
		Font labelFont=new Font("arial",Font.PLAIN,18);
		Font textFont=new Font("arial",Font.PLAIN,18);


		lblTittle=new Label("User Management System");
		lblTittle.setBounds(250,40,400,50);
		lblTittle.setFont(titleFont);
		lblTittle.setForeground(Color.YELLOW);
		add(lblTittle);


		lblId=new Label("ID");
		lblId.setBounds(250,100,150,30);
		lblId.setFont(labelFont);
		lblId.setForeground(Color.WHITE);
		add(lblId);

		txtId=new TextField();
		txtId.setBounds(400,100,400,30);
		txtId.setFont(labelFont);
		txtId.addActionListener(this);
		add(txtId);
 
		lblName=new Label("Name");
		lblName.setBounds(250,150,150,30);
		lblName.setFont(labelFont);
		lblName.setForeground(Color.WHITE);
		add(lblName);

		txtName=new TextField();
		txtName.setBounds(400,150,400,30);
		txtName.setFont(textFont);
		add(txtName);

		lblAge=new Label("Age");
		lblAge.setBounds(250,200,150,30);
		lblAge.setFont(labelFont);
		lblAge.setForeground(Color.WHITE);
		add(lblAge);

		txtAge=new TextField();
		txtAge.setBounds(400,200,400,30);
		txtAge.setFont(textFont);
		add(txtAge);

		lblCity=new Label("City");
		lblCity.setBounds(250,250,150,30);
		lblCity.setFont(labelFont);
		lblCity.setForeground(Color.WHITE);
		add(lblCity);

		txtCity=new TextField();
		txtCity.setBounds(400,250,400,30);
		txtCity.setFont(textFont);
	    add(txtCity);

		btnSave=new Button("Save");
		btnSave.setBounds(400,300,100,30);
		btnSave.setBackground(Color.yellow);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(labelFont);
		btnSave.addActionListener(this);
		add(btnSave);

		btnClear=new Button("Clear");
		btnClear.setBounds(520,300,100,30);
		btnClear.setBackground(Color.green);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(labelFont);
		btnClear.addActionListener(this);
		add(btnClear);

		btnDelete=new Button("Delete");
		btnDelete.setBounds(640,300,100,30);
		btnDelete.setBackground(Color.red);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(labelFont);
		btnDelete.addActionListener(this);
		add(btnDelete);

		lblStatus=new Label("                              ");
		lblStatus.setFont(labelFont);
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setBounds(400,350,300,30);
		add(lblStatus);

	}
	
	public void actionPerformed(ActionEvent e)
	  {
      try
		{
    	  String id=txtId.getText();
    	  String name=txtName.getText();
    	  String age=txtAge.getText();
    	  String city=txtCity.getText();
    	
    	  if(e.getSource().equals(txtId)) {
    		  qry="SELECT ID,NAME,AGE,CITY from users where ID="+txtId.getText();
    		  stmt=con.createStatement();
    		  rs=stmt.executeQuery(qry);
    		 if(rs.next())
    		  {
    			  txtId.setText(rs.getString("ID"));
    			  txtName.setText(rs.getString("Name"));
    			  txtAge.setText(rs.getString("Age"));
    			  txtCity.setText(rs.getString("City"));
    		  }
    		  else {
    			  clear();
    		    lblStatus.setText("Invalid Id");
    	          }
    	  }
    		 
    	    if(e.getSource().equals(btnClear))
				{
				  lblStatus.setText("Data Clear");
					clear();
				}	
			else if(e.getSource().equals(btnSave))
			   {
				  if(id.isEmpty()||id.equals(""))
				  {
					  qry="insert into users (NAME,AGE,CITY) values(?,?,?)";
					  st=con.prepareStatement(qry);
					  st.setString(1, name);
					  st.setString(2, age);
					  st.setString(3, city);
					  st.executeUpdate();
					  clear();
				   lblStatus.setText("Data Insert Success");
				   }
				  else
				   {
					  qry="update users set NAME=?,AGE=?,CITY=? where ID=?";
					  st=con.prepareStatement(qry);
					  st.setString(1, name);
					  st.setString(2, age);
					  st.setString(3, city);
					  st.setString(4, id);
					  st.executeUpdate();
					  clear();
					  
					   lblStatus.setText("Data Update Success");
				   }
			   }
			else if(e.getSource().equals(btnDelete))
				{
				    if(!id.isEmpty()||!id.equals("")) 
				    {
				    	qry="delete from users where ID=?";
				    	st=con.prepareStatement(qry);
				    	st.setString(1, id);
				    	st.executeUpdate();
				    	clear();
				    	lblStatus.setText("Data Deleted Success");
				    }
				    else
				    {
				    	lblStatus.setText("Please Enter The Correct Id..");
				    }
					
				}
		 
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	  }

}

public class UserManagement {

	public static void main(String[] args) {
		
    UserFrame frm=new UserFrame();
	}
}

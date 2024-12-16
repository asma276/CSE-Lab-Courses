package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, cancel, signup;
    JTextField namefield,passfield;
    Choice loginin;
    
    Login(){
        
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);      
        setLayout(null);
        
        //Labels
        
        JLabel username = new JLabel ("Username :");
        username.setBounds(300, 40, 100, 25);
        add(username);
        
        JLabel password = new JLabel ("Password :");
        password.setBounds(300, 80, 100, 25);
        add(password);
        
        //Empty fields
        
        namefield = new JTextField();
        namefield.setBounds(400, 40, 200, 25);
        add(namefield);        
        
        passfield = new JTextField();
        passfield.setBounds(400, 80, 200, 25);
        add(passfield); 
        
        //buttons
        
        cancel = new JButton("Cancel");
        cancel.setBounds(340, 150, 100, 25);
        cancel.addActionListener(this);
        add(cancel);
        
        login = new JButton("Login");
        login.setBounds(460, 150, 100, 25);
        login.addActionListener(this);
        add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(400, 190, 100, 25);
        signup.addActionListener(this);
        add(signup);

        // Image
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image scaledImage = i2.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image = new JLabel(scaledIcon);
        image.setBounds(20, 0, 250, 250);
        add(image);
        
        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            String susername = namefield.getText();
            String spassword = passfield.getText();
            //String user = loginin.getSelectedItem();
            try{
                Conn c = new Conn();
                String query = "select * from login1 where username = '"+susername+"' and password = '"+spassword+"'";  
            
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    namefield.setText("");
                    passfield.setText("");
                }
                
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == cancel){setVisible (false);}
        else if (ae.getSource() == signup){setVisible (false);
        new Signup();
        }
    }
    
    public static void main(String[]args){
        new Login();
    }
}

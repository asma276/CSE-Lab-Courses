package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, cancel;
    Choice accountType;
    JTextField id, user, nm, pass;
    
    Signup() {
        setSize(700, 400);
        setLocation(450, 250);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(
                new LineBorder(new Color(100, 216, 230), 3), 
                "Create Account", 
                TitledBorder.LEADING, 
                TitledBorder.TOP, 
                null, 
                new Color(100, 216, 230)
        ));
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);

        // Labels

        JLabel meterNo = new JLabel("ID Number :");
        meterNo.setBounds(130, 50, 140, 25);
        meterNo.setForeground(Color.BLACK);
        meterNo.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(meterNo);

        JLabel username = new JLabel("Username :");
        username.setBounds(130, 90, 140, 25);
        username.setForeground(Color.BLACK);
        username.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(username);

        JLabel name = new JLabel("Name :");
        name.setBounds(130, 135, 140, 25);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        JLabel password = new JLabel("Password :");
        password.setBounds(130, 180, 140, 25);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(password);

        // Text Fields
        id = new JTextField();
        id.setBounds(330, 50, 200, 23);
        panel.add(id);

        user = new JTextField();
        user.setBounds(330, 90, 200, 23);
        panel.add(user);

        nm = new JTextField();
        nm.setBounds(330, 135, 200, 23);
        panel.add(nm);

        pass = new JTextField();
        pass.setBounds(330, 180, 200, 23);
        panel.add(pass);

        // Buttons
        create = new JButton("Create");
        create.setBackground(new Color(100, 216, 230));
        create.setForeground(Color.BLACK);
        create.setBounds(200, 240, 100, 25);
        create.addActionListener(this);
        panel.add(create);

        cancel = new JButton("Cancel");
        cancel.setBackground(new Color(100, 216, 230));
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(370, 240, 100, 25);
        cancel.addActionListener(this);
        panel.add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String suser = user.getText();
            String snm = nm.getText();
            String spass = pass.getText();
            String sid_no = id.getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into login1 values('"+sid_no+"', '"+suser+"', '"+snm+"', '"+spass+"')";
            
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            
            } catch (Exception e){
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
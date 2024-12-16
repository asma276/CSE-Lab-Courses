package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;
    Splash(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elec.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        
        setSize(1066, 600);
        setLocation(200, 100);
        setVisible(true);
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run(){
        try{
            Thread.sleep(3000);
            setVisible(false);
            
            //login frame
            new Login();
            
    } catch (Exception e){
        e.printStackTrace();
    }
    }
    
    public static void main(String[]args){
        new Splash();
    }
}

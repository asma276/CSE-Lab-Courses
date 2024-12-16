package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    // Declare instance variables for menu items that need action listeners
    JMenuItem calculatebill, newcustomer, customerdetails, depositdetails, updateinfo, viewinfo, paybill, billdetails, generatebill, notepad, calculator, exit;

    Project() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        // First Menu
        JMenu master = new JMenu("     Master     ");
        master.setForeground(Color.RED);
        mb.add(master);

        // First Menu Dropdowns
        newcustomer = createMenuItem(" New Customer", "icon/icon1.png", 'N', KeyEvent.VK_N, master);
        customerdetails = createMenuItem(" Customer Details", "icon/icon2.png", 'D', KeyEvent.VK_D, master);
        depositdetails = createMenuItem(" Deposit Details", "icon/icon3.png", 'M', KeyEvent.VK_M, master);
        calculatebill = createMenuItem(" Calculate Bill", "icon/icon4.png", 'B', KeyEvent.VK_B, master);

        // Second Menu
        JMenu info = new JMenu("     Information     ");
        info.setForeground(Color.RED);
        mb.add(info);

        // Second Menu Dropdowns
        updateinfo = createMenuItem(" Update Information", "icon/icon5.png", 'U', KeyEvent.VK_U, info);
        viewinfo = createMenuItem(" View Information", "icon/icon6.png", 'V', KeyEvent.VK_V, info);

        // Third Menu
        JMenu user = new JMenu("     User     ");
        user.setForeground(Color.RED);
        mb.add(user);

        // Third Menu Dropdowns
        paybill = createMenuItem(" Pay Bill", "icon/icon7.png", 'P', KeyEvent.VK_P, user);
        billdetails = createMenuItem(" Bill Details", "icon/icon8.png", 'T', KeyEvent.VK_T, user);

        // Fourth Menu
        JMenu report = new JMenu("     Report     ");
        report.setForeground(Color.RED);
        mb.add(report);

        // Fourth Menu Dropdowns
        generatebill = createMenuItem(" Generate Bill", "icon/icon9.png", 'G', KeyEvent.VK_G, report);

        // Fifth Menu
        JMenu utility = new JMenu("     Utility     ");
        utility.setForeground(Color.RED);
        mb.add(utility);

        // Fifth Menu Dropdowns
        notepad = createMenuItem(" Notepad", "icon/icon12.png", 'P', KeyEvent.VK_P, utility);
        calculator = createMenuItem(" Calculator", "icon/icon9.png", 'C', KeyEvent.VK_C, utility);

        // Sixth Menu
        JMenu mexit = new JMenu("       Exit     ");
        mexit.setForeground(Color.RED);
        mb.add(mexit);

        // Sixth Menu Dropdowns
        exit = createMenuItem(" Exit", "icon/icon11.png", 'E', KeyEvent.VK_E, mexit);

        // Add action listeners
        calculatebill.addActionListener(this);
        generatebill.addActionListener(this);
        exit.addActionListener(this);

        setVisible(true);
    }

    private JMenuItem createMenuItem(String text, String iconPath, char mnemonic, int acceleratorKey, JMenu menu) {
        JMenuItem item = new JMenuItem(text);
        item.setFont(new Font("monospaced", Font.BOLD, 12));
        item.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(iconPath));
        Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        item.setIcon(new ImageIcon(image));
        item.setMnemonic(mnemonic);
        item.setAccelerator(KeyStroke.getKeyStroke(acceleratorKey, ActionEvent.CTRL_MASK));
        menu.add(item);
        return item;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == calculatebill) {
            // Example call to another class
            new CalculateBill();
        }else if (ae.getSource() == generatebill) { 
            new GenerateBill();
        }else if (ae.getSource() == exit) {
            setVisible(false);
            dispose(); // Properly close the application
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}

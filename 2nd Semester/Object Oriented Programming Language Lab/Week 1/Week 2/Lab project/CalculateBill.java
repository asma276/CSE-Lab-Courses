package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculateBill extends JFrame implements ActionListener {

    JTextField tfmeterno, tfunits, tfdueunits;
    JButton submit, cancel;
    JLabel lblmetertype, lblmeterno, lblunits, lbldueunits;
    Choice metertype;

    public CalculateBill() {
        setSize(500, 340);
        setLocation(500, 300);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(235, 235, 235));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100, 20, 300, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        p.add(heading);

        // Meter Type
        
        lblmetertype = new JLabel("Meter Type:");
        lblmetertype.setBounds(50, 70, 150, 25);
        lblmetertype.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(lblmetertype);

        metertype = new Choice();
        metertype.setBounds(290, 70, 150, 25);
        metertype.add("Regular");
        metertype.add("Industrial");
        p.add(metertype);

        // Meter Number
        
        lblmeterno = new JLabel("Meter Number:");
        lblmeterno.setBounds(50, 110, 150, 25);
        lblmeterno.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(lblmeterno);

        tfmeterno = new JTextField();
        tfmeterno.setBounds(290, 110, 150, 25);
        p.add(tfmeterno);

        // Units Consumed
        
        lblunits = new JLabel("Units Consumed:");
        lblunits.setBounds(50, 150, 150, 25);
        lblunits.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(lblunits);

        tfunits = new JTextField();
        tfunits.setBounds(290, 150, 150, 25);
        p.add(tfunits);

        // Due Units
        
        lbldueunits = new JLabel("Due Units:");
        lbldueunits.setBounds(50, 190, 150, 25);
        lbldueunits.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(lbldueunits);

        tfdueunits = new JTextField();
        tfdueunits.setBounds(290, 190, 150, 25);
        p.add(tfdueunits);

        // Submit Button
        
        submit = new JButton("Submit");
        submit.setBounds(100, 250, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);

        // Cancel Button
        
        cancel = new JButton("Cancel");
        cancel.setBounds(290, 250, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                float units = Float.parseFloat(tfunits.getText());
                float dueUnits = Float.parseFloat(tfdueunits.getText());

                float currentBill = calculateBill(units);
                float dueBill = calculateBill(dueUnits);
                float totalPayable = currentBill + dueBill;

                showResult(currentBill, dueBill, totalPayable);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for units.");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            dispose();
        }
    }

    private float calculateBill(float units) {
        if (units >= 0 && units <= 50) {
            return units * 4.63f;
        } else if (units > 50 && units <= 75) {
            return units * 5.26f;
        } else if (units > 75 && units <= 200) {
            return units * 7.20f;
        } else if (units > 200 && units <= 300) {
            return units * 7.59f;
        } else if (units > 300 && units <= 400) {
            return units * 8.02f;
        } else if (units > 400 && units <= 600) {
            return units * 12.67f;
        } else {
            return units * 14.61f;
        }
    }

    private void showResult(float currentBill, float dueBill, float totalPayable) {
        JFrame resultFrame = new JFrame("Bill Summary");
        resultFrame.setSize(400, 300);
        resultFrame.setLocation(560, 320);
        resultFrame.getContentPane().setBackground(new Color(235, 235, 235));
        resultFrame.setLayout(null);

        JLabel heading = new JLabel("Bill Summary");
        heading.setBounds(130, 20, 200, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        resultFrame.add(heading);

        JLabel currentLabel = new JLabel("Current Bill: Taka " + String.format("%.2f", currentBill));
        currentLabel.setBounds(100, 70, 300, 25);
        currentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        resultFrame.add(currentLabel);

        JLabel dueLabel = new JLabel("Due Bill: Taka " + String.format("%.2f", dueBill));
        dueLabel.setBounds(110, 110, 300, 25);
        dueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        resultFrame.add(dueLabel);

        JLabel totalLabel = new JLabel("Total Payable (Without VAT): Taka " + String.format("%.2f", totalPayable));
        totalLabel.setBounds(40, 150, 350, 25);
        totalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        resultFrame.add(totalLabel);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(130, 200, 100, 30);
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(e -> resultFrame.dispose());
        resultFrame.add(closeButton);

        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculateBill();
    }
}

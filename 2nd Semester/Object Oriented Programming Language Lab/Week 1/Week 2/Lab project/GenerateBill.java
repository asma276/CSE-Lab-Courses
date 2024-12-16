package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.*;

public class GenerateBill extends JFrame implements ActionListener {

    JTextField tfcname, tfunits, tfdueunits, tfmeterno, tfcaddress, tfcemail, tfcnumber;
    JButton gbill, cancel;
    JLabel cmetertype, cmonth;
    Choice metertype, month;

    public GenerateBill() {
        setSize(500, 700);
        setLocation(500, 75);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(235, 235, 235));
        add(p);

        JLabel heading = new JLabel("Dhaka Power Distribution Company");
        heading.setBounds(25, 20, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        p.add(heading);

        JLabel dpdc = new JLabel("(DPDC)");
        dpdc.setBounds(190, 70, 150, 25);
        dpdc.setFont(new Font("Tahoma", Font.BOLD, 24));
        p.add(dpdc);

        JLabel ministry = new JLabel("Ministry of Power, Energy & Mineral Resources");
        ministry.setBounds(50, 105, 500, 25);
        ministry.setFont(new Font("Tahoma", Font.BOLD, 16));
        p.add(ministry);

        JLabel dash = new JLabel("__________________________________________");
        dash.setBounds(25, 135, 500, 25);
        dash.setFont(new Font("Tahoma", Font.BOLD, 16));
        p.add(dash);

        // Customer Details
        addLabelAndField(p, "Customer Name:", 190, tfcname = new JTextField());
        addLabelAndField(p, "Customer Address:", 230, tfcaddress = new JTextField());
        addLabelAndField(p, "Customer Email:", 270, tfcemail = new JTextField());
        addLabelAndField(p, "Contact Number:", 310, tfcnumber = new JTextField());
        addLabelAndField(p, "Meter Number:", 350, tfmeterno = new JTextField());

        // Meter Type
        cmetertype = new JLabel("Meter Type:");
        cmetertype.setBounds(35, 390, 150, 25);
        cmetertype.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(cmetertype);

        metertype = new Choice();
        metertype.setBounds(220, 390, 230, 25);
        metertype.add("Regular");
        metertype.add("Industrial");
        p.add(metertype);

        // Current Month
        cmonth = new JLabel("Current Month:");
        cmonth.setBounds(35, 430, 150, 25);
        cmonth.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(cmonth);

        month = new Choice();
        month.setBounds(220, 430, 230, 25);
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        p.add(month);

        // Units and Due Units
        addLabelAndField(p, "Units Consumed:", 470, tfunits = new JTextField());
        addLabelAndField(p, "Due Units:", 510, tfdueunits = new JTextField());

        // Generate Bill Button
        gbill = new JButton("Generate Bill");
        gbill.setBounds(65, 585, 150, 25);
        gbill.setBackground(Color.BLACK);
        gbill.setForeground(Color.WHITE);
        gbill.addActionListener(this);
        p.add(gbill);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(270, 585, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setVisible(true);
    }

    private void addLabelAndField(JPanel p, String label, int y, JTextField field) {
        JLabel l = new JLabel(label);
        l.setBounds(35, y, 150, 25);
        l.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(l);

        field.setBounds(220, y, 230, 25);
        p.add(field);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == gbill) {
            try {
                float units = Float.parseFloat(tfunits.getText());
                float costPerUnit = getCostPerUnit(units);
                float currentBill = units * costPerUnit;
                float vat = currentBill * 0.05f;
                float meterCharge = 150f;
                float totalPayable = currentBill + vat + meterCharge;

                showResult(currentBill, vat, meterCharge, totalPayable);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for units.");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            dispose();
        }
    }

    private float getCostPerUnit(float units) {
        if (units > 0 && units <= 50) return 4.63f;
        else if (units > 50 && units <= 75) return 5.26f;
        else if (units > 75 && units <= 200) return 7.20f;
        else if (units > 200 && units <= 300) return 7.59f;
        else if (units > 300 && units <= 400) return 8.02f;
        else if (units > 400 && units <= 600) return 12.67f;
        else return 14.61f;
    }

private void showResult(float currentBill, float vat, float meterCharge, float totalPayable) {
    float dueUnits = Float.parseFloat(tfdueunits.getText());
    float dueAmount = dueUnits * getCostPerUnit(dueUnits);

    JFrame display = new JFrame("Bill Summary");
    display.setSize(305, 450);
    display.setLocation(620, 210);
    display.setLayout(new BorderLayout());

    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
    displayPanel.add(new JLabel(" ____________________________________________"));
    displayPanel.add(new JLabel(" "));
    displayPanel.add(new JLabel(" Dhaka Power Distribution Company (DPDC)"));
    displayPanel.add(new JLabel(" Ministry of Power, Energy & Mineral Resources"));
    displayPanel.add(new JLabel(" Electricity Department"));
    displayPanel.add(new JLabel(" Payment Invoice"));
    displayPanel.add(new JLabel(" ____________________________________________"));
    displayPanel.add(new JLabel(" "));
    displayPanel.add(new JLabel(" 01. Customer Name: " + tfcname.getText()));
    displayPanel.add(new JLabel(" 02. Customer Address: " + tfcaddress.getText()));
    displayPanel.add(new JLabel(" 03. Customer Division: Dhaka"));
    displayPanel.add(new JLabel(" 04. Customer Phone Number: " + tfcnumber.getText()));
    displayPanel.add(new JLabel(" 05. Customer Email: " + tfcemail.getText()));
    displayPanel.add(new JLabel(" 06. Customer Meter Number: " + tfmeterno.getText()));
    displayPanel.add(new JLabel(" 07. Customer Meter Type: " + metertype.getSelectedItem()));
    displayPanel.add(new JLabel(" 08. Current Month: " + month.getSelectedItem()));
    displayPanel.add(new JLabel(" 09. Cost per unit: Taka " + getCostPerUnit(Float.parseFloat(tfunits.getText()))));
    displayPanel.add(new JLabel(" 10. Meter charge: Taka " + String.format("%.2f", meterCharge)));
    displayPanel.add(new JLabel(" 11. VAT: Taka " + String.format("%.2f", vat)));
    displayPanel.add(new JLabel(" 12. Unit consumed: " + tfunits.getText()));
    displayPanel.add(new JLabel(" 13. Total charge: Taka " + String.format("%.2f", currentBill)));
    displayPanel.add(new JLabel(" 14. Previous Due Amount: Taka " + String.format("%.2f", dueAmount)));
    displayPanel.add(new JLabel(" 15. Total payable: Taka " + String.format("%.2f", totalPayable)));

    JButton printButton = new JButton("Print");
    printButton.addActionListener(e -> {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Electricity Bill");

        // Define what to print
        printerJob.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            // Print the content of the display frame
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            displayPanel.paint(g2d);
            return Printable.PAGE_EXISTS;
        });

        // Display print dialog
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(display, "Print error: " + ex.getMessage());
            }
        }
    });

    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(e -> display.dispose());

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(printButton);
    buttonPanel.add(closeButton);

    display.add(displayPanel, BorderLayout.CENTER);
    display.add(buttonPanel, BorderLayout.SOUTH);

    display.setVisible(true);
}


    public static void main(String[] args) {
        new GenerateBill();
    }
}

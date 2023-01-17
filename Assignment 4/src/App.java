import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.util.ArrayList;

public class App {
    static MyFrame frame;
    static MainPanel panel;
    static MyBill myBill;
    static AsCustomer asCustomer;
    static AsOwner asOwner;
    static MenuForOwner menuForOwner;
    static DisCustomerPanel customerPanel;
    static ExitPanel exitPanel;

    public static void displayMenuForOwner(MainPanel prevPanel) {
        asOwner.setVisible(false);
        menuForOwner = new MenuForOwner(prevPanel);
        menuForOwner.setVisible(true);
        App.frame.add(menuForOwner);
    }
//    
    public static void displayExitPanel(MainPanel prevPanel) {
        myBill.setVisible(false);
        exitPanel = new ExitPanel(prevPanel);
        exitPanel.setVisible(true);
        App.frame.add(exitPanel);
    }
    public static void displayMyBill(ArrayList<FoodOrder> foodOrders,MainPanel prevPanel) {
        asCustomer.setVisible(false);
        myBill = new MyBill(foodOrders,prevPanel);
        myBill.setVisible(true);
        App.frame.add(myBill);
    }
   
    public static void main(String[] args) throws Exception {
        frame = new MyFrame();
        JLabel heading = new JLabel();
        heading.setText("Star Restaurant");
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setFont(new Font("MV Boli", Font.BOLD, 40));
        heading.setForeground(Color.yellow);
        heading.setBorder(BorderFactory.createLineBorder(new Color(200, 78, 123), 5));
        heading.setBounds(50, 10, 1000, 75);
        frame.add(heading);

        panel = new MainPanel(null);
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);

        JLabel loginLabel = new JLabel("Log in as:");
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 36));
        loginLabel.setForeground(Color.orange);
        loginLabel.setBounds(0, 10, 1100, 60);
        loginLabel.setVisible(true);
        panel.add(loginLabel);

        MyButton button1 = new MyButton("Customer");
        button1.setBounds(500, 100, 250, 60);
        panel.add(button1);

        MyButton button2 = new MyButton("Owner");
        button2.setBounds(500, 200, 250, 60);
        panel.add(button2);
        
        asCustomer = new AsCustomer(panel);
        frame.add(asCustomer);
        asCustomer.setVisible(false);

        asOwner = new AsOwner(panel);
        frame.add(asOwner);
        asOwner.setVisible(false);
        

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                asCustomer.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                asOwner.setVisible(true);
            }
        });
        
        frame.setVisible(true);
    }
}

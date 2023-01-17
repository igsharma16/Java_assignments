import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.*;

public class AsOwner extends MainPanel {
    JButton backButton = new JButton("Back");
    MyButton seeMenuButton = new MyButton("Menu");
    MyButton seeCustomers = new MyButton("Customers");
    
    public AsOwner(MainPanel prevPanel) {
        super(prevPanel);
        this.setBackground(Color.white);
        backButton.setBounds(0, 0, 250, 60);
        backButton.setForeground(Color.black);
        backButton.setFont(new Font("Arial", Font.PLAIN, 28));
        this.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });

        this.seeMenuButton.setBounds(200,200,250,60);
        this.add(seeMenuButton);
        this.seeMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.displayMenuForOwner(AsOwner.this);
            }
        }) ;

        this.seeCustomers.setBounds(200,300,250,60);
        this.add(seeCustomers);
        this.seeCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCustomers();
            }
        });
    }

    public void displayCustomers() {
        DisCustomerPanel disCustomerPanel = new DisCustomerPanel(this);
        App.frame.add(disCustomerPanel);
        this.setVisible(false);
    }
}

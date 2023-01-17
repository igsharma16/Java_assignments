import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

class BillJPanel extends JPanel {
    JPanel temPanel = new JPanel(new GridLayout(18,1,0,15));
    JScrollPane jsp ;
    ArrayList<OrderPanel> aOrderPanels = new ArrayList<OrderPanel>();
        
    public BillJPanel(ArrayList<FoodOrder> foodOrders) {
        this.setBounds(0, 110,1085, 400);
        this.setBackground(Color.orange);
        this.setLayout(new BorderLayout());
        temPanel.setBackground(Color.white);

        temPanel.add(new BoldRowPanel("Bill"));
        for (FoodOrder fOrder : foodOrders) {
            temPanel.add(new OrderPanel(fOrder));
        }
        String totAmount = String.valueOf(FoodOrder.generateBill(foodOrders));
        temPanel.add(new BoldRowPanel("Total : "+totAmount));
        jsp = new JScrollPane(temPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(jsp,BorderLayout.CENTER);
    }

}

class MyBill extends MainPanel {
    JButton backButton = new JButton("Bac");
    BillJPanel billJPanel ;
    ColumnHeader ch = new ColumnHeader();
    JButton payButton = new JButton("Pay");

    public MyBill(ArrayList<FoodOrder> foodOrders,MainPanel prevPanel) {
        super(prevPanel);
        this.setBackground(Color.BLACK);
        this.billJPanel = new BillJPanel(foodOrders);
        this.add(billJPanel);
        backButton.setBounds(0, 0, 250, 60);
        backButton.setForeground(Color.black);
        backButton.setFont(new Font("Arial", Font.PLAIN, 28));
        this.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        ch.setBounds(0, 60, 1100, 50);
        this.add(ch);

        payButton.setBounds(400, 510, 250, 60);
        payButton.setForeground(Color.black);
        payButton.setFont(new Font("Arial", Font.PLAIN, 28));
        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String[] options = {"Yes","No"};
               int x = JOptionPane.showOptionDialog(
                MyBill.this,
               "Proceed with payment of "+String.valueOf(FoodOrder.generateBill(foodOrders)),
               "Pay Bill",
               JOptionPane.OK_CANCEL_OPTION ,
               JOptionPane.PLAIN_MESSAGE,
               null,
               options,
                0
               );
               System.out.println(x);
               if (x == 0) {
                App.displayExitPanel(MyBill.this);
               }
            }
        });
        this.add(payButton);
    }
}
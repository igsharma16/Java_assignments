import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

import java.awt.event.*;

/*
public class ItemPanel extends JPanel {
    // JLabel sNumber ;
    JLabel name ;
    JLabel price ;
    JCheckBox includeItem ;
    JTextField quantityTextField;

    ItemPanel( String name,int price) {
        this.setBackground(Color.white);
        

        // sNumber = new JLabel(String.valueOf(sid));
        // sNumber.setBackground(Color.white);
        // sNumber.setOpaque(true);
        // sNumber.setFont(new Font("Arial",Font.PLAIN,24));

        this.name = new JLabel(name);
        this.name.setBackground(Color.white);
        this.name.setOpaque(true);
        this.name.setFont(new Font("Arial",Font.PLAIN,24));

        this.price = new JLabel("$"+String.valueOf(price));
        this.price.setBackground(Color.white);
        this.price.setOpaque(true);
        this.price.setFont(new Font("Arial",Font.PLAIN,24));

        this.includeItem = new JCheckBox();
        includeItem.setIcon (new MetalCheckBoxIcon() {
            protected int getControlSize() { return 20; }
        });

        this.quantityTextField = new JTextField(3);
        this.quantityTextField.setFont(new FontUIResource("Arial",Font.PLAIN,60));
        quantityTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if (!Character.isDigit(ch)){
                    e.consume();
                }
            }
        });
       

        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setHorizontalGroup(
            groupLayout.createSequentialGroup()
                .addContainerGap(20, 30)
                .addComponent(this.name)
                .addGap(10, 20, 30)
                .addComponent(this.price)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(this.includeItem)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                30, 30)
                .addComponent(this.quantityTextField,0,20,40)
        );

        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.name)
            .addComponent(this.price)
            .addComponent(this.includeItem)
            .addComponent(this.quantityTextField,0,20,20)
        );
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        // groupLayout.linkSize(this.name,this.price,this.includeItem,this.quantityTextField);
        this.setLayout(groupLayout);
    }
}
*/

public class ItemPanel extends JPanel {
    Food food;
    JLabel name ;
    JLabel price ;
    JCheckBox includeItem ;
    JTextField quantityTextField;
    Border border = BorderFactory.createLineBorder(Color.black,5);

    ItemPanel(Food f) {
        this.food = f;
        this.setBackground(Color.white);

        this.name = new JLabel(f.fname);
        this.name.setFont(new Font("Arial",Font.PLAIN,24));

        this.price = new JLabel("$"+String.valueOf(f.price));
        this.price.setFont(new Font("Arial",Font.PLAIN,24));

        this.includeItem = new JCheckBox();
        includeItem.setIcon (new MetalCheckBoxIcon() {
            protected int getControlSize() { return 20; }
        });
        includeItem.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    ItemPanel.this.quantityTextField.setEnabled(true);
                    ItemPanel.this.quantityTextField.setText("1");
                } else {
                    ItemPanel.this.quantityTextField.setEnabled(false);
                }
                
            }
        });
        this.quantityTextField = new JTextField(3);
        this.quantityTextField.setFont(new FontUIResource("Arial",Font.PLAIN,24));
        this.quantityTextField.setEnabled(false);
        quantityTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if (!Character.isDigit(ch)){
                    e.consume();
                }
            }
        });
        this.setLayout(null);
        this.name.setBounds(100, 5, 300, 35);
        this.price.setBounds(450,5,100,35);
        this.includeItem.setBounds(660,5,50,35);
        this.quantityTextField.setBounds(810,5,50,35);

        this.add(this.name);
        this.add(this.price);
        this.add(this.includeItem);
        this.add(this.quantityTextField);
    }
    public int getQuantity() {
        String s =  this.quantityTextField.getText();
        return Integer.parseInt(s);
    }
    public boolean getCheckState() {
        return this.includeItem.isSelected();
    }
}
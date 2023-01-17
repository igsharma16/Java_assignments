import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel{
    FoodOrder foodOrder;
    JLabel nameLabel ;
    JLabel priceLable ;
    JLabel quantityLabel;
    JLabel itemTotLabel;

    public OrderPanel(FoodOrder fOrder) {
        this.foodOrder = fOrder;
        this.setBackground(Color.white);
        Font font = new Font("Arial",Font.PLAIN,20);
        
        this.nameLabel = new JLabel(fOrder.fname);
        this.nameLabel.setFont(font);

        this.priceLable = new JLabel(String.valueOf(fOrder.price));
        this.priceLable.setFont(font);

        this.quantityLabel = new JLabel(String.valueOf(fOrder.quantiy));
        this.quantityLabel.setFont(font);

        this.itemTotLabel = new JLabel(String.valueOf(fOrder.price*fOrder.quantiy));
        this.itemTotLabel.setFont(font);

        
        this.setLayout(null);
        this.nameLabel.setBounds(100,5,300,35);
        this.priceLable.setBounds(450,5,100,35);
        this.quantityLabel.setBounds(650,5,100,35);   
        this.itemTotLabel.setBounds(810,5,100,35);
        
        this.add(this.nameLabel);
        this.add(this.priceLable);
        this.add(this.quantityLabel);
        this.add(this.itemTotLabel);

    }

}
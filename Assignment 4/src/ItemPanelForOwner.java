import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ItemPanelForOwner extends JPanel {
    Food food;
    JLabel name;
    JLabel price;
    JButton changeButton;

    Border border = BorderFactory.createLineBorder(Color.black, 5);

    ItemPanelForOwner(Food f) {
        this.food = f;
        this.setBackground(Color.white);

        this.name = new JLabel(f.fname);
        this.name.setFont(new Font("Arial", Font.PLAIN, 24));

        this.price = new JLabel("$" + String.valueOf(f.price));
        this.price.setFont(new Font("Arial", Font.PLAIN, 24));

        this.changeButton = new JButton("Change Details");

        this.setLayout(null);
        this.name.setBounds(100, 5, 300, 35);
        this.price.setBounds(500, 5, 100, 35);
        this.changeButton.setBounds(680,5,200,35);

        this.add(name);
        this.add(this.price);
        this.add(this.changeButton);

    }
}

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.ThemeColor;

class BoldRowPanel extends JPanel {
    JLabel label ;
    BoldRowPanel(String text) {
        label = new JLabel();
        label.setText(text);
        label.setVisible(true);
        label.setForeground(ThemeColor.color);
        label.setFont(new Font("Arial",Font.BOLD,32));
        label.setHorizontalTextPosition(JLabel.LEFT);
        this.add(label);
    }
}
class MyButton extends JButton {
    MyButton(String text) {
        this.setText(text);
        this.setForeground(Color.black);
        this.setFont(new Font("Arial", Font.PLAIN, 28));
    }
}
class MyFrame extends JFrame{
    MyFrame() {
        this.setTitle("Restaurant Management");
        this.setSize(1100, 700);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(40,40,78));
        this.setVisible(true);
    }
}
class MainPanel extends JPanel {
    MainPanel backMainPanel ;
    public void back() {
        this.setVisible(false);
        this.backMainPanel.setVisible(true);
    }
    // MainPanel() {
    //     this.setLayout(null);
    //     this.setBounds(0,100,1100,600);
    // }
    MainPanel(MainPanel prevPanel) {
        this.backMainPanel = prevPanel;
        this.setLayout(null);
        this.setBounds(0,100,1100,600);
    }
}

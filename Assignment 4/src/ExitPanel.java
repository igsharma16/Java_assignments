public class ExitPanel extends MainPanel{

    public ExitPanel(MainPanel prevPanel) {
        super(prevPanel);
        BoldRowPanel thank = new BoldRowPanel("Thank You");        
        thank.setBounds(100,100,500,50);
        this.add(thank);
    }
    
}


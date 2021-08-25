package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.*;

public class OutputPanel extends JPanel implements ActionListener {
  
    MainView view;
    
    public OutputPanel(MainView view) {
        JLabel filler = new JLabel("Output");
        filler.setHorizontalAlignment(JLabel.CENTER);
        setLayout(new GridLayout(1, 1));
        add(filler);

        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}

package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.*;

public class TeamPanel extends JPanel implements ActionListener {

    MainView view;
    
    public TeamPanel(MainView view) {
        JLabel filler = new JLabel("Team");
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

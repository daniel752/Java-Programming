package program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportDialog  extends JDialog implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel p1,p2;
    private JButton ok;
    private PostSystemPanel rs;


    public ReportDialog(Main parent, PostSystemPanel pan, String text) {
        super((Main)parent,"ReportDialog",true);
        rs = pan;

        setSize(600,700);

        setBackground(new Color(100,230,255));
        p1 = new JPanel();
        p2 = new JPanel();

        p1.setLayout(new GridLayout(1,1,10,5));
        p1.add(new JTextArea(text));

        p2.setLayout(new GridLayout(1,1,5,5));
        ok=new JButton("OK");
        ok.addActionListener(this);
        ok.setBackground(Color.lightGray);
        p2.add(ok);

        setLayout(new BorderLayout());
        add("North" , p1);
        add("South" , p2);
    }
  


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ok){
            rs.resume();
            setVisible(false);
        }
    }
}

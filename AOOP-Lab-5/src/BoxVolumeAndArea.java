import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoxVolumeAndArea
{

    public static void main(String[] args)
    {
        final double[] result = new double[2];
        JPanel panel = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        JButton button = new JButton("Calculate");
        JFrame frame = new JFrame("Box volume & area");
        final JLabel label_w = new JLabel("Width");
        final JLabel label_h = new JLabel("Height");
        final JLabel label_l = new JLabel("Length");
        final JLabel label_volume = new JLabel("Volume:");
        final JLabel label_area = new JLabel("Area:");
        JTextField user_width = new JTextField();
        JTextField user_height = new JTextField();
        JTextField user_length = new JTextField();
        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setHgap(20);
        flowLayout.setVgap(40);

        panel.add(label_w);
        panel.add(user_width).setPreferredSize(new Dimension(80,20));
        panel.add(label_h);
        panel.add(user_height).setPreferredSize(new Dimension(80,20));
        panel.add(label_l);
        panel.add(user_length).setPreferredSize(new Dimension(80,20));
        panel.add(button);
        panel.add(label_volume).setPreferredSize(new Dimension(90,20));
        panel.add(label_area).setPreferredSize(new Dimension(90,20));
        panel.setLayout(flowLayout);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                result[0] = Double.parseDouble(user_width.getText())*Double.parseDouble(user_height.getText())*Double.parseDouble(user_length.getText());
                label_volume.setText("Volume:" + result[0]);

                result[1] = Double.parseDouble(user_length.getText())*Double.parseDouble(user_height.getText())+
                2*(Double.parseDouble(user_length.getText())*Double.parseDouble(user_width.getText()))+
                4*(Double.parseDouble(user_width.getText())*Double.parseDouble(user_height.getText()));
                label_area.setText("Area:" + result[1]);
            }
        });
    }

}

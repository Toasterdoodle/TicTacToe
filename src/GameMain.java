import javax.swing.*;
import java.awt.*;

/**
 * Created by michael_hopps on 11/14/17.
 */
public class GameMain extends JPanel{

    public static void main(String[] args) {

        //===========Jframe==========
        JFrame frame = new JFrame("M4K3 4RT");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 700;
        int height = 700;
        frame.setPreferredSize(new Dimension(width, height + 22));

        //============JPanel===========
        JPanel panel = new GamePanel(width, height);
        panel.setFocusable(true);
        panel.grabFocus();

        //============JFrame============
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }//end psvm

}//end class
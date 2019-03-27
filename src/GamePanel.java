import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by student on 11/16/17.
 */

public class GamePanel extends JPanel{

    //=====instance field=====

    public static int width, height;

    private static boolean xTurn;

    private Game TicTacToe = new Game(3);
    private int win;

    public GamePanel(int w, int h){

        setSize(w, h);

        width = w;
        height = h;

        xTurn = true;

        //======Mouse Listener=====

        win = 0;

//        while(win == 0){

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }//end mouseClicked

            @Override
            public void mousePressed(MouseEvent e) {

                System.out.println(e.getX() + ", " + e.getY());

                if(win == 0) {
                    if (xTurn == true) {

                        if (TicTacToe.emptySquare(e.getX(), e.getY()) == true) {
                            //checks if the clicked square is empty

                            TicTacToe.setX(e.getX(), e.getY());

                            xTurn = false;

                        }//end if

                    }//end if
                    else {

                        if (TicTacToe.emptySquare(e.getX(), e.getY()) == true) {
                            //checks if the clicked square is empty

                            TicTacToe.setO(e.getX(), e.getY());

                            xTurn = true;

                        }//end if

                    }//end else

                    win = TicTacToe.didWin();

                    if(win == 1){

                        System.out.println("Red Wins!");

                    }//end if

                    if(win == 2){

                        System.out.println("Blue Wins!");

                    }//end if

                }//end if

                repaint();

            }//end mousePressed

            @Override
            public void mouseReleased(MouseEvent e) {

            }//end mouseReleased

            @Override
            public void mouseEntered(MouseEvent e) {

            }//end mouseEntered

            @Override
            public void mouseExited(MouseEvent e) {

            }//end mouseExited
        });



        //===========================

    }//end GamePanel

    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g;

        TicTacToe.draw(g2);

        if(TicTacToe.didWin() == 1){

            g2.setFont(new Font("Arial", 0, 50));

            g2.setColor(new Color(251, 93, 255));

            g2.setStroke(new BasicStroke(10));

            g2.drawString("Red Wins!", 235, 355);

        }//end if

        if(TicTacToe.didWin() == 2){

            g2.setFont(new Font("Arial", 0, 50));

            g2.setColor(new Color(251, 93, 255));

            g2.setStroke(new BasicStroke(10));

            g2.drawString("Blue Wins!", 235, 355);

        }//end if

    }//end paintComponent

}//end class

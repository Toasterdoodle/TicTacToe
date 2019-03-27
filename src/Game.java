import java.awt.*;

/**
 * Created by student on 11/16/17.
 */
public class Game {

    //0 is an empty square
    //1 is an x
    //2 is a y

    private int[][] gr;

    private int n;
    //controls how many squares are wanted in the JPanel

    public Game(int n){

        this.n = n;

        gr = new int[n][n];//makes the array that will control whether the squares are black or white

        for (int r = 0; r < gr.length; r++) {

            for (int c = 0; c < gr[0].length; c++) {

                gr[r][c] = 0;

            }//end for

        }//end for

    }//end Game

    //------------------------------------------

    public boolean emptySquare(int MouseX, int MouseY){
        //checks if the clicked square is an empty square

        int x = MouseX;
        //sets x to the x coord of the mouse
        int y = MouseY;
        //sets y to the y coord of the mouse

        int w = GamePanel.width / n;
        int h = GamePanel.height / n;
        //these guys give us the size of the squares

        int r = y / h;
        int c = x / w;
        //this code tells us which square our cursor is currently inside

        boolean emptySquare;

        if(gr[r][c] == 0){

            emptySquare = true;

        }//end if
        else{

            emptySquare = false;

        }//end else

        return emptySquare;

    }//end emptySquare

    //------------------------------------------

    public void setX(int MouseX, int MouseY){

        int x = MouseX;
        //sets x to the x coord of the mouse
        int y = MouseY;
        //sets y to the y coord of the mouse

        int w = GamePanel.width / n;
        int h = GamePanel.height / n;
        //these guys give us the size of the squares

        int r = y / h;
        int c = x / w;
        //this code tells us which square our cursor is currently inside

        gr[r][c] = 1;

    }//end getX

    //------------------------------------------

    public void setO(int MouseX, int MouseY){

        int x = MouseX;
        //sets x to the x coord of the mouse
        int y = MouseY;
        //sets y to the y coord of the mouse

        int w = GamePanel.width / n;
        int h = GamePanel.height / n;
        //these guys give us the size of the squares

        int r = y / h;
        int c = x / w;
        //this code tells us which square our cursor is currently inside

        gr[r][c] = 2;

    }//end getO

    //------------------------------------------

    public void draw(Graphics2D g2){

        int space = 20;

        int w = GamePanel.width / n;
        //controls size of the squares

        int h = GamePanel.height / n;
        //also controls size of squares

        for (int r = 0; r < gr.length; r++){
            //actually makes the squares

            for (int c = 0; c < gr[0].length; c++) {

                if(gr[r][c] == 0){

                    g2.setStroke(new BasicStroke(1));
                    g2.setColor(new Color(0, 0, 0));
                    g2.drawRect(c * w, r * h, w, h);

                }//end if

                if(gr[r][c] == 1){

                    g2.setColor(new Color(255, 65, 51));
                    g2.fillRect(c * w, r * h, w, h);
                    g2.setColor(new Color(255, 255, 255));
                    g2.setStroke(new BasicStroke(10));
                    g2.drawLine(c * w + space, r * h + space, c * w + w - space, r * h + h - space);
                    g2.drawLine(c * w + w - space, r * h + space, c * w + space, r * h + h - space);

                }//end if

                if(gr[r][c] == 2){

                    g2.setColor(new Color(67, 96, 239));
                    g2.fillRect(c * w, r * h, w, h);
                    g2.setColor(new Color(255, 255, 255));
                    g2.setStroke(new BasicStroke(10));
                    g2.fillOval(c * w + space, r * h + space, w - 2 * space, h - 2 * space);

                }//end if

            }//end for

        }//end for

    }//end draw

    //------------------------------------------

    public int didWin(){

        int didWin = 0;

        for (int i = 0; i < n; i++) {

            if(gr[i][0] == gr[i][1] && gr[i][1] == gr[i][2]){

                if(gr[i][0] == 1){

                    didWin = 1;

                }//end if

                if(gr[i][0] == 2){

                    didWin = 2;

                }//end if

            }//end if

        }//end for

        for (int i = 0; i < n; i++) {

            if(gr[0][i] == gr[1][i] && gr[0][i] == gr[2][i]){

                if(gr[0][i] == 1){

                    didWin = 1;

                }//end if

                if(gr[0][i] == 2){

                    didWin = 2;

                }//end if

            }//end if

        }//end for

        if(gr[0][0] == gr[1][1] && gr[1][1] == gr[2][2]){

                if(gr[0][0] == 1){

                    didWin = 1;

                }//end if

            if(gr[0][0] == 2){

                didWin = 2;

            }//end if

        }//end if

        if(gr[0][2] == gr[1][1] && gr[1][1] == gr[2][0]){

            if(gr[0][0] == 1){

                didWin = 1;

            }//end if

            if(gr[0][0] == 2){

                didWin = 2;

            }//end if

        }//end if

        return didWin;

    }//end didWin

}//end class

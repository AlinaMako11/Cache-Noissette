
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents a frame in which there is a button,
 * by clicking on which the user can select again the level.
 */

public class GameWin implements ActionListener {
    // creates a new frame
    private JFrame gamewin = new JFrame("You win!Click on the button.");
    // creates a button with a defined picture
    private Picture gameover = new Picture("icons/gameover.jpg", 0);
    private JButton win = new JButton(gameover);

    public GameWin() {
        // sets size and colour of the frame
        gamewin.setSize(300, 300);
        gamewin.setBackground(Color.darkGray);
        gamewin.setResizable(false);
        // adds a button to frame
        gamewin.add(win);
        // links a win button with ActionListener
        win.addActionListener(this);
        // defines a frame visible on monitor
        gamewin.setVisible(true);

    }

    
    /**
     * Method that will handle all events
     */
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == win) {
       Menu gomenu = new Menu();
        }
    }

}

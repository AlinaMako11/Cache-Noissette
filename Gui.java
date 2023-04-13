import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents a Frame . When combined with the Squirrel class,
 * instances of the Gui class can be displayed on the screen.
 * 
 * @author Alina Macovei
 * @version 1.0
 *
 */

public class Gui implements ActionListener

{
    // creates a new frame
    private JFrame frame1 = new JFrame();
    // creates a new panel
    private JPanel panel = new JPanel();
    // creates a panel that will have our soil buttons and squirrels
    private JPanel soilpanel = new JPanel();
    // creates buttons with picture of arrows in a defined rotation
    private Picture p = new Picture("icons/BigArrow.png", 0);
    private JButton arrowup = new JButton(p);

    Picture p1 = new Picture("icons/BigArrow.png", 180);
    JButton arrow1 = new JButton(p1);

    Picture p2 = new Picture("icons/BigArrow.png", 90);
    JButton right = new JButton(p2);

    Picture p3 = new Picture("icons/BigArrow.png", 270);
    JButton left = new JButton(p3);
    // creates an array of pictures that will be used in buttons
    private Picture[] mySoil = new Picture[16];
    // creates an array of soil buttons
    private JButton[] mySoilButtons = new JButton[16];
    // creates an array of squirrels
    private Squirrel[] squirrelm = new Squirrel[4];
    private boolean squirrelClicked = false;
    private int squirrelMove = 0;
    private boolean[] holeState = new boolean[16];
    private int gamelevel = 0;

    public Gui(int level) {
        // sets title,size and colour of the frame
        frame1.setTitle("Nut Store" + level);
        frame1.setSize(615, 635);
        frame1.setBackground(Color.darkGray);
        frame1.setResizable(false);
        // sets layout to frame
        panel.setLayout(new BorderLayout());
        // sets layout to soilpanel
        soilpanel.setLayout(new GridLayout(4, 4));
        soilpanel.setBorder(null);
        soilpanel.setBackground(Color.BLACK);
        // adds a panel to the frame
        frame1.getContentPane().add(panel);
        // adds a soilpanel to the panel
        panel.add(soilpanel, BorderLayout.CENTER);
        gamelevel = level;
        soilPanel();
        // defines a frame visible on monitor
        frame1.setVisible(true);
    }

    private void soilPanel() {

        arrowup.setBorder(null);
        arrow1.setBorder(null);
        right.setBorder(null);
        left.setBorder(null);
        // links arrow buttons with ActionListener
        arrowup.addActionListener(this);
        arrow1.addActionListener(this);
        right.addActionListener(this);
        left.addActionListener(this);
        // adds arrow buttons to the panel
        panel.add(arrowup, BorderLayout.PAGE_START);
        panel.add(arrow1, BorderLayout.PAGE_END);
        panel.add(right, BorderLayout.LINE_END);
        panel.add(left, BorderLayout.LINE_START);
        // creates soil buttons that will show the picture of hole or empty according to
        // its position
        for (int i = 0; i < 16; i++) {
            if (i == 15 || i == 9 || i == 4 || i == 2) {
                mySoil[i] = new Picture("icons/Hole.png", 0);
            } else {
                mySoil[i] = new Picture("icons/Empty.png", 0);

            }
            mySoilButtons[i] = new JButton(mySoil[i]);
            mySoilButtons[i].setBorder(null);
            // links soil buttons with ActionListener
            mySoilButtons[i].addActionListener(this);
            // adds soil buttons to the soilpanel
            soilpanel.add(mySoilButtons[i]);

        }
        // if the level of the game is 1 creates 2 squirrels and 1 flower
        if (gamelevel == 1) {

            squirrelm[0] = new Squirrel("RedSquirrel", 270, this, 5, 6, 0, false);
            squirrelm[1] = new Squirrel("GreySquirrel", 0, this, 10, 14, 0, false);
            mySoil[9] = new Picture("icons/Flower.png", 0);
            mySoilButtons[9].setIcon(mySoil[9]);
        }
        // if the level of the game is 2 creates 2 squirrels and 1 flower
        else if (gamelevel == 2) {

            squirrelm[0] = new Squirrel("GreySquirrel", 0, this, 1, 5, 0, false);
            squirrelm[1] = new Squirrel("BrownSquirrel", 270, this, 10, 11, 6, true);
            mySoil[4] = new Picture("icons/Flower.png", 0);
            mySoilButtons[4].setIcon(mySoil[4]);

        }
        // if the level of the game is 3 creates 2 squirrels and 1 flower
        else if (gamelevel == 3) {

            squirrelm[0] = new Squirrel("BrownSquirrel", 0, this, 8, 12, 9, true);
            squirrelm[1] = new Squirrel("BlackSquirrel", 180, this, 11, 7, 6, true);
            mySoil[15] = new Picture("icons/Flower.png", 0);
            mySoilButtons[15].setIcon(mySoil[15]);
        }
        // if the level of the game is 4 creates 2 squirrels and 1 flower
        else if (gamelevel == 4) {
            squirrelm[0] = new Squirrel("BlackSquirrel", 180, this, 6, 2, 1, true);
            squirrelm[1] = new Squirrel("BrownSquirrel", 180, this, 11, 7, 10, true);
            mySoil[4] = new Picture("icons/Flower.png", 0);
            mySoilButtons[4].setIcon(mySoil[4]);
        }
        // if the level of the game is 5 creates 4 squirrels
        else if (gamelevel == 5) {
            squirrelm[0] = new Squirrel("BlackSquirrel", 180, this, 6, 2, 1, true);
            squirrelm[1] = new Squirrel("GreySquirrel", 180, this, 11, 7, 0, false);
            squirrelm[2] = new Squirrel("BrownSquirrel", 180, this, 14, 10, 0, false);
            squirrelm[3] = new Squirrel("RedSquirrel", 270, this, 8, 9, 13, true);
        }

    }

    private void gameOver() {
        int x = 0;
        for (int i = 0; i < 16; i++) {
            if (holeState(i) == true) {
                x = x + 1;
            }
        }
        // If gamelevel=1 and the number of squirrels is 2,when all nuts are in holes,
        // opens a gameOver frame
        if (gamelevel == 1 && x == 2) {
            GameWin winners = new GameWin();
        }
        // If gamelevel=2 and the number of squirrels is 2,when all nuts are in holes,
        // opens a GameWin frame
        else if (gamelevel == 2 && x == 2) {
            GameWin winners = new GameWin();
        }
        // If gamelevel=3 and the number of squirrels is 2,when all nuts are in holes,
        // opens a GameWin frame
        else if (gamelevel == 3 && x == 2) {
            GameWin winners = new GameWin();
        }
        // If gamelevel=4 and the number of squirrels is 2,when all nuts are in holes,
        // opens a GameWin frame
        else if (gamelevel == 4 && x == 2) {
            GameWin winners = new GameWin();
        }
        // If gamelevel=5 and the number of squirrels is 4,when all nuts are in holes,
        // opens a GameWin frame
        else if (gamelevel == 5 && x == 4) {
            GameWin winners = new GameWin();
        }
    }
    
/**
 * Method that will handle all events
 */
    public void actionPerformed(ActionEvent e) {
        if (gamelevel == 1) {
            if (e.getSource() == mySoilButtons[squirrelm[0].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 0;
            }

            else if (e.getSource() == mySoilButtons[squirrelm[1].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 1;
            }
        } else if (gamelevel == 2) {
            if (e.getSource() == mySoilButtons[squirrelm[0].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 0;
            }

            else if (e.getSource() == mySoilButtons[squirrelm[1].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 1;
            }

        } else if (gamelevel == 3) {
            if (e.getSource() == mySoilButtons[squirrelm[0].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 0;
            }

            else if (e.getSource() == mySoilButtons[squirrelm[1].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 1;
            }

        } else if (gamelevel == 4) {
            if (e.getSource() == mySoilButtons[squirrelm[0].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 0;
            }

            else if (e.getSource() == mySoilButtons[squirrelm[1].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 1;
            }
        } else if (gamelevel == 5) {
            if (e.getSource() == mySoilButtons[squirrelm[0].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 0;
            }

            else if (e.getSource() == mySoilButtons[squirrelm[1].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 1;
            } else if (e.getSource() == mySoilButtons[squirrelm[2].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 2;
            }

            else if (e.getSource() == mySoilButtons[squirrelm[3].getHeadLocationSquirrel()]) {
                squirrelClicked = true;
                squirrelMove = 3;
            }
        }

        if (e.getSource() == arrowup && squirrelClicked == true) {
            squirrelm[squirrelMove].move(this, 0);
            squirrelClicked = false;
        } else if (e.getSource() == arrow1 && squirrelClicked == true) {
            squirrelm[squirrelMove].move(this, 180);
            squirrelClicked = false;
        } else if (e.getSource() == left && squirrelClicked == true) {
            squirrelm[squirrelMove].move(this, 270);
            squirrelClicked = false;
        } else if (e.getSource() == right && squirrelClicked == true) {
            squirrelm[squirrelMove].move(this, 90);
            squirrelClicked = false;
        }

        gameOver();

    }

    /**
     * Changes the image from the button
     * 
     * @param pictureToChange The picture to change
     * @param location        The location of the picture wanted to change
     * @param rotation        The rotation of the picture wanted to change
     * 
     */
    public void changeIcon(String pictureToChange, int location, int rotation) {
        mySoil[location] = new Picture(pictureToChange, rotation);
        mySoilButtons[location].setIcon(mySoil[location]);
    }

    /**
     * Sets hole to filled or not.
     */
    public boolean holeState(int holeCheck) {
        return holeState[holeCheck];
    }

    /**
     * @return if hole is filled or not.
     */
    public void setHoleState(int holeSet) {
        holeState[holeSet] = true;
    }

}

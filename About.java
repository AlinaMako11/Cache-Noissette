
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class allows the user to know about the game and its creator
 */

public class About {
  //creates a new frame
   private JFrame about1=new JFrame("About the game.");
   //creates a new panel
   private JPanel about=new JPanel();
   //creates a new Text Area
   private JTextArea aboutgame=new JTextArea(
   "This game was created by Alina Macovei"+ " "+
   "as coursework for the Scc110 subject."+ 
   "At the beginning of the game, you are presented with a menu where"+" "+
   " you can select the difficulty of the level in the Cache-Noisette game."+
   "The essence of the game is for the squirrels to deliver their nuts to the holes."+" "+
   " To move the squirrels,you need to select the squirrel by clicking on its head"+" "+
   "and then on the arrows around the gamepad, and repeat this until the nut is in the hole."+
   "When all the nuts are in the holes, you will have a window where you can click on the button and select any level again.");
 

 public About(){
//sets panel and frame size
about.setPreferredSize(new Dimension(380, 250));
about1.setSize(420,310);
about1.setResizable(false);
    

//sets frame colour
 about1.getContentPane().setBackground(Color.darkGray);
//sets layout to frame
 about1.setLayout(new FlowLayout());
//sets layout to panel
 about.setLayout(new BorderLayout());

 aboutgame.setFont(new Font("Serif", Font.ITALIC, 16));
 aboutgame.setLineWrap(true);
 aboutgame.setWrapStyleWord(true);
 aboutgame.setOpaque(false);
 aboutgame.setEditable(false);

//adds panel to frame
about1.getContentPane().add(about, BorderLayout.CENTER);
//adds text area to panel
about.add(aboutgame);
//defines a panel visible on monitor
about.setVisible(true);
//defines a frame visible on monitor
about1.setVisible(true);

 }

}
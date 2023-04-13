import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents a menu where by clicking on the buttons the menu
 * user can select a level or learn about the game.
 */

public class Menu implements ActionListener {
    //creates a new frame
    private JFrame frame1 = new JFrame();
    //creates a new panel
    private JPanel panel = new JPanel();
    //creates a new panel
    private JPanel numericalpanel = new JPanel();
    //creates level buttons 
    private JButton level1 = new JButton();
    private JButton level2 = new JButton();
    private JButton level3 = new JButton();
    private JButton level4 = new JButton();
    private JButton level5 = new JButton();
    //creates an about button
    private JButton about = new JButton();

    public Menu() {
        //sets title,size and colour of the frame
        frame1.setTitle("Game Menu!Choose your level!");
        frame1.setSize(270, 450);
        frame1.setResizable(false);
        frame1.getContentPane().setBackground(Color.darkGray);
        //sets layout to frame
        frame1.setLayout(new FlowLayout());
        //sets layout to border
        panel.setLayout(new BorderLayout());
        //adds numericalpanel to panel
        panel.add("South", numericalpanel);
        //sets layout to numericalpanel
        numericalpanel.setLayout(new GridLayout(6,1));
        numericalpanel.setBorder(null);


        //sets text,colour and size of the buttons
        level1.setText("Level 1");
        level1.setBackground(Color.GREEN);
        level1.setPreferredSize(new Dimension(150,60));

        level2.setText("Level 2");
        level2.setBackground(Color.YELLOW);
        level2.setPreferredSize(new Dimension(150,60));

        level3.setText("Level 3");
        level3.setBackground(Color.ORANGE);
        level3.setPreferredSize(new Dimension(150,60));

        level4.setText("Level 4");
        level4.setBackground(Color.ORANGE);
        level4.setPreferredSize(new Dimension(150,60));


        level5.setText("Level 5");
        level5.setBackground(Color.RED);
        level5.setPreferredSize(new Dimension(150,60));


        about.setText("About");
        about.setBackground(Color.GRAY);
        about.setPreferredSize(new Dimension(150,60));
    
        //links the buttons with ActionListener
        level1.addActionListener(this);
        level2.addActionListener(this);
        level3.addActionListener(this);
        level4.addActionListener(this);
        level5.addActionListener(this);
        about.addActionListener(this);

        //adds the buttons to numericalpanel
        numericalpanel.add(level1);
        numericalpanel.add(level2);
        numericalpanel.add(level3);
        numericalpanel.add(level4);
        numericalpanel.add(level5);
        numericalpanel.add(about);
        //adds panel to the frame
        frame1.getContentPane().add(panel, BorderLayout.CENTER);
        //adds numericalpanel to panel
        panel.add(numericalpanel, BorderLayout.CENTER);
        //defines a panel visible on monitor
        panel.setVisible(true);
        //defines a frame visible on monitor
        frame1.setVisible(true);
        

    } 
    /**
     * Method that will handle all events
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == level1) {
       Gui Nutstore = new Gui(1);
        }

        if (e.getSource() == level2) {
       Gui Nutstore1 = new Gui(2);
        }

        if(e.getSource() == level3) {
       Gui Nutstore2 = new Gui(3);
        }

       if(e.getSource() == level4){
       Gui Nutstore3 = new Gui(4);
       } 

       if (e.getSource() ==level5){
       Gui Nutstore4 = new Gui(5);
       }

       if(e.getSource() ==about){
       About about = new About();
       }
    }
}
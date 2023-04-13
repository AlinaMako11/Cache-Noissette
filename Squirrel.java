
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * This class represents squirrels . When combined with the Gui class,
 * instances of the Squirrel class can be displayed on the screen.
 */

public class Squirrel {

     
    private int HeadLocationSquirrel = 0; //The position of Squirrel s head.
    private int BodyLocationSquirrel = 0;//The position of Squirrel s body.
    private int FlowerLocation = 0; //The position of flower.
    private String SquirrelFile;     //The filename of the image.
    private int SquirrelRotation = 0; //The rotation of the image.
    private boolean SquirrelFlower;  //Value which allows the flower appear or not.
    private boolean SquirrelHasNut = true;  //Value which determines if Squirrel has nut.

    /**
     * Constructor. Creates a Squirrel with the given parameters
     * 
     * @param filename The filename of an image to load.
     * @param rotation The rotation to supply to the image on loading, measure in
     *                 degrees.
     * @param soilpanel My Gui object
     *  @param head The location of the Squirrel s head.
     * @param body The location of the Squirrel s body.
     * @param flower The location of the Squirrel s flower.
     * @param appearFlower Make flower appear or not acording to the value.
     */
    public Squirrel(String filename, int rotation, Gui soilpanel, int head, int body, int flower,
            boolean appearFlower) {

        HeadLocationSquirrel = head;
        BodyLocationSquirrel = body;
        FlowerLocation = flower;
        SquirrelFile = filename;
        SquirrelRotation = rotation;
        SquirrelFlower = appearFlower;

        soilpanel.changeIcon("icons/" + filename + "1Nut.png", head, rotation);
        soilpanel.changeIcon("icons/" + filename + "2.png", body, rotation);

        if (appearFlower == true) {
            soilpanel.changeIcon("icons/SquirrelFlower.png", flower, 0);
        }

    }

    /**
     *Method that allows to move the squirrels to the given position
     *and draw it on the screen 
     * @param soilpanel My Gui object
     * @param direction The direction of the picture wanted to change
     * 
     */
    public void move(Gui soilpanel, int direction) {
        if (HeadLocationSquirrel == 15 || HeadLocationSquirrel == 9 || HeadLocationSquirrel == 4 || HeadLocationSquirrel == 2) {
            if (soilpanel.holeState(HeadLocationSquirrel) == false && SquirrelHasNut == true) {
                soilpanel.setHoleState(HeadLocationSquirrel);
                soilpanel.changeIcon("icons/HoleNut.png", HeadLocationSquirrel, SquirrelRotation);
                soilpanel.changeIcon("icons/Empty.png", BodyLocationSquirrel, SquirrelRotation);
                SquirrelHasNut = false;
            } else if (soilpanel.holeState(HeadLocationSquirrel) == true && SquirrelHasNut == true) {
                soilpanel.changeIcon("icons/HoleNut.png", HeadLocationSquirrel, SquirrelRotation);
                soilpanel.changeIcon("icons/Empty.png", BodyLocationSquirrel, SquirrelRotation);
            } else if (soilpanel.holeState(HeadLocationSquirrel) == true && SquirrelHasNut == false) {
                soilpanel.changeIcon("icons/HoleNut.png", HeadLocationSquirrel, SquirrelRotation);
                soilpanel.changeIcon("icons/Empty.png", BodyLocationSquirrel, SquirrelRotation);
            } else if (soilpanel.holeState(HeadLocationSquirrel) == false && SquirrelHasNut == false) {
                soilpanel.changeIcon("icons/Hole.png", HeadLocationSquirrel, SquirrelRotation);
                soilpanel.changeIcon("icons/Empty.png", BodyLocationSquirrel, SquirrelRotation);
            }

        } else if (BodyLocationSquirrel == 15 || BodyLocationSquirrel == 9 || BodyLocationSquirrel == 4
                || BodyLocationSquirrel == 2) {
            if (soilpanel.holeState(BodyLocationSquirrel) == false) {
                soilpanel.changeIcon("icons/Hole.png", BodyLocationSquirrel, SquirrelRotation);
                soilpanel.changeIcon("icons/Empty.png", HeadLocationSquirrel, SquirrelRotation);
            } else if (soilpanel.holeState(BodyLocationSquirrel) == true) {
                soilpanel.changeIcon("icons/HoleNut.png", BodyLocationSquirrel, SquirrelRotation);
                soilpanel.changeIcon("icons/Empty.png", HeadLocationSquirrel, SquirrelRotation);
            }
        } else {
            soilpanel.changeIcon("icons/Empty.png", HeadLocationSquirrel, SquirrelRotation);
            soilpanel.changeIcon("icons/Empty.png", BodyLocationSquirrel, SquirrelRotation);
        }

        if (direction == 0) {
           int hd=HeadLocationSquirrel - 4;
           int bd= BodyLocationSquirrel - 4;
           int flw=FlowerLocation - 4;

             if(hd >= 0 && bd >= 0 && hd < 16 && bd < 16)
            {
                HeadLocationSquirrel -= 4;
                BodyLocationSquirrel -= 4;
                if(SquirrelFlower == true && flw >= 0 && flw < 16)
                {
                    FlowerLocation -= 4;
                }

            }

        }else if (direction == 180) {
            int hd=HeadLocationSquirrel + 4;
            int bd=BodyLocationSquirrel + 4;
            int flw= FlowerLocation + 4;

             if (hd >= 0 && bd >= 0 && hd < 16 && bd < 16) {
               HeadLocationSquirrel += 4;
               BodyLocationSquirrel += 4;
               if (SquirrelFlower == true && flw >= 0 && flw < 16) {
                   FlowerLocation += 4;
               }

           }

        }else if (direction == 270) {
            int hd=HeadLocationSquirrel - 1;
            int bd=BodyLocationSquirrel - 1;
            int flw=FlowerLocation - 1;

             if (hd >= 0 && bd >= 0 && hd < 16 && bd < 16) {
                HeadLocationSquirrel -= 1;
                BodyLocationSquirrel -= 1;
                if (SquirrelFlower == true && flw >= 0 && flw < 16) {
                    FlowerLocation -= 1;
                }

            }


        } else if (direction == 90) {
            int hd=HeadLocationSquirrel + 1;
            int bd=BodyLocationSquirrel + 1;
            int flw= FlowerLocation + 1;

             if (hd >= 0 && bd >= 0 && hd < 16 && bd < 16) {
                HeadLocationSquirrel += 1;
                BodyLocationSquirrel += 1;
                if (SquirrelFlower == true && flw >= 0 && flw < 16) {
                    FlowerLocation += 1;
                }

            }

        }
    

  
        if (HeadLocationSquirrel == 15 || HeadLocationSquirrel == 9 || HeadLocationSquirrel == 4
                || HeadLocationSquirrel == 2) {
            soilpanel.changeIcon("icons/" + SquirrelFile + "1.png", HeadLocationSquirrel, SquirrelRotation);
            soilpanel.changeIcon("icons/" + SquirrelFile + "2.png", BodyLocationSquirrel, SquirrelRotation);
            if (soilpanel.holeState(HeadLocationSquirrel) == false && SquirrelHasNut == true) {
                soilpanel.setHoleState(HeadLocationSquirrel);
                SquirrelHasNut = false;
            }
        }

        else if (HeadLocationSquirrel != 15 || HeadLocationSquirrel != 9 || HeadLocationSquirrel != 4
                || HeadLocationSquirrel != 2) {
            if (SquirrelHasNut == false) {
                soilpanel.changeIcon("icons/" + SquirrelFile + "1.png", HeadLocationSquirrel, SquirrelRotation);
                soilpanel.changeIcon("icons/" + SquirrelFile + "2.png", BodyLocationSquirrel, SquirrelRotation);
            } else if (SquirrelHasNut == true) {
                soilpanel.changeIcon("icons/" + SquirrelFile + "1Nut.png", HeadLocationSquirrel, SquirrelRotation);
                soilpanel.changeIcon("icons/" + SquirrelFile + "2.png", BodyLocationSquirrel, SquirrelRotation);
            }
        }

        if (SquirrelFlower == true) {
            soilpanel.changeIcon("icons/SquirrelFlower.png", FlowerLocation, 0);
        }
} 
    

    /**
     * Obtains the head location of the Squirrel.
     * 
     * @return the head position of the Squirrel,as an int value.
     */
    public int getHeadLocationSquirrel() {
        return HeadLocationSquirrel;
    }

    /**
     * Obtains the tail location of the Squirrel.
     * 
     * @return the head tail of the Squirrel,as an int value.
     */
    public int getBodyLocationSquirrel() {

        return BodyLocationSquirrel;

    }
}
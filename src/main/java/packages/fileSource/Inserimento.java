/**
 * @author Zoppellaro Filippo            @data 2024_05_13
 * Class that implements the insert interface
 *
 */

package packages.fileSource;

import javax.swing.*;
import java.awt.*;

public class Inserimento extends JFrame  {

    // #########################
    //         ATTRIBUTES
    // #########################
    //attributes declaration
    private InsertPanel insertPanel;

    // #########################
    //       CONSTRUCTORS
    // #########################

    /**
     * Constructor that permit to create insertFrame
     */
    Inserimento () {
        this.setSize(new Dimension(800,500));

        this.insertPanel = new InsertPanel();

        this.add(this.insertPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // #########################
    //          METHODS
    // #########################

    //*****************
    //     PRIVATE
    //*****************

}

/**
 * @author Zoppellaro Filippo            @data 2024_05_13
 * Class that implemets the showFrame
 */

package packages.fileSource;

import javax.swing.*;

public class Mostra extends JFrame {

    // #########################
    //         ATTRIBUTES
    // #########################

    private JPanel showPanel;

    // #########################
    //       CONSTRUCTORS
    // #########################

    /**
     * Constructor that permit to create the frame
     */
    Mostra () {
        this.setSize(800,500);

        this.showPanel = new ShowPanel();

        this.add(this.showPanel);
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

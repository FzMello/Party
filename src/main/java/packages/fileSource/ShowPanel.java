/**
 * @author Zoppellaro Filippo            @data 2024_05_13
 * Class that implements the show panel.
 */
package packages.fileSource;

import javax.swing.*;
import java.awt.*;

public class ShowPanel extends JPanel {

    // #########################
    //         ATTRIBUTES
    // #########################

    private JTextArea area;

    // #########################
    //       CONSTRUCTORS
    // #########################

    /**
     * Constructor that permit to create the showPanel
     */
    ShowPanel() {
        this.setLayout(new BorderLayout());

        //Initialization of the testArea and setting
        this.area = new JTextArea();
        this.area.setEditable(false);

        //Add a vertica scroll bar to the textArea
        JScrollPane scrollPane = new JScrollPane(this.area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(800, 500));

        this.add(scrollPane, BorderLayout.CENTER);

        this.updateText();
    }

    // #########################
    //          METHODS
    // #########################

    //*****************
    //     PRIVATE
    //*****************
    /**
     * Method that permit to update the data
     */
    private void updateText() {
        this.area.setText("\n" + Data.toPrint());
    }
}

/**
 * @author Zoppellaro Filippo            @data 2024_05_13
 * Classe che implementa l'interfaccia principale.
 * Viene scelta l'azione da fare e viene aperto un nuovo JFrame.
 */

package packages.fileSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principale extends JFrame implements ActionListener {

    // #########################
    //         ATTRIBUTES
    // #########################
    //static final attributes declaration
    private static final String INSERT = "Inserisci nuovo partecipante";
    private static final String SHOW = "Mostra partecipanti";

    //attributes declaration
    private JPanel principalPanel;
    private JPanel centerPanel;
    private JButton insertButton;
    private JButton showButton;

    // #########################
    //       CONSTRUCTORS
    // #########################

    /**
     * Constructor that permit to set all the attributes and to create the principal interface.
     */
    public Principale() {
        //frame settings
        this.setSize(800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            caricaDaFile("file.txt");
        }catch (IOException e) {}

        //principalPanel initialization
        this.principalPanel = new JPanel(new BorderLayout());
        //add some panels for a better interface
        setArea(this.principalPanel);

        //centerPanel initialization
        this.centerPanel = new JPanel(new GridLayout(0, 1, 0, 10));

        //initialization and button setting
        this.insertButton = new JButton(INSERT);
        this.insertButton.setPreferredSize(new Dimension(200,50));
        this.insertButton.setBackground(Color.orange);
        this.insertButton.addActionListener(this);

        this.showButton = new JButton(SHOW);
        this.showButton.setPreferredSize(new Dimension(200,50));
        this.showButton.setBackground(Color.orange);
        this.showButton.addActionListener(this);

        //add button to the centralPanel
        this.centerPanel.add(this.insertButton);
        this.centerPanel.add(this.showButton);

        //add centralPanel to principalPanel in the NORTH
        this.principalPanel.add(centerPanel, BorderLayout.CENTER);

        //add principalPanel to the frame and some frame settings
        this.add(this.principalPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // #########################
    //          METHODS
    // #########################

    /**
     * Implement of ActionListener interface.
     * if in the button is written what is written in INSERT, create a new object Inserimento,
     * else create a new object Mostra.
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        JButton butt = (JButton) e.getSource();
        if (butt.getText().equals(INSERT)) new Inserimento();
        else new Mostra();
    }

        //*****************
        //     PRIVATE
        //*****************

    /**
     * private method that permit to add some panels to the panel that is passed as param.
     * @param panel
     */
    private void setArea (JPanel panel) {
        panel.add(new JPanel(), BorderLayout.NORTH);
        panel.add(new JPanel(), BorderLayout.SOUTH);
        panel.add(new JPanel(), BorderLayout.WEST);
        panel.add(new JPanel(), BorderLayout.EAST);
    }

    /**
     * Private method that permit to add to Data.persons data from file
     * @param pathName
     * @throws IOException
     */
    private void caricaDaFile (String pathName) throws IOException {
        String s;
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))){
            while ((s = br.readLine()) != null ) {
                if (!Data.persons.contains(s)) Data.persons.add(s + "\n");
            }
        }
    }
}

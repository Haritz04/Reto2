package gui;

import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private ArrayList<JPanel> mainMenus = null;

    private final int rootWidth  = 450;
    private final int rootHeight = 300;


    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, rootWidth, rootHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        mainMenus = new ArrayList<JPanel>();

        genMenues();
    }

    public void genMenues() {

        JPanel p = null;

        ///////////
        // LOGIN //
        ///////////

        p = new JPanel();

        p.setBounds(0, 0, rootWidth, rootHeight);

        mainMenus.add(p);

        ////////////
        // SIGNUP //
        ////////////

        p = new JPanel();

        p.setBounds(0, 0, rootWidth, rootHeight);

        mainMenus.add(p);

        //////////
        // MENU //
        //////////

        p = new JPanel();

        p.setBounds(0, 0, rootWidth, rootHeight);

        mainMenus.add(p);

        for (JPanel panel: mainMenus) {
            this.add(panel);
        }
    }
}

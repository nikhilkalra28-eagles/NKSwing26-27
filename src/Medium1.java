import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Medium1 implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public Medium1() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Medium1 swingControlDemo = new Medium1();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());// makes boxes in the lid that are the same dimensions

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top

        ta = new JTextArea(); // ta = area can be typed in. j button. At a button = j button
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        //mainFrame.add(mb);  //add menu bar
        // mainFrame.add(ta);//add typing area
        // mainFrame.setJMenuBar(mb); //set menu bar

        statusLabel = new JLabel("", JLabel.CENTER); //
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel(); // being used for
        controlPanel.setLayout(new GridLayout()); //set the layout of the pannel
        // three types of layouts: grid, boarder layout
        // mainFrame.add(controlPanel);
        // mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // make sure its true
    }

    private void showEventDemo() {

        JButton Button1 = new JButton("Button 1");
        JButton Button2 = new JButton("Button 2");
        JButton Button3 = new JButton("Button 3");
        JButton Button4 = new JButton("Button 4");
        JButton Button5 = new JButton("Button 5");

       // Button1.setActionCommand("Button 1");
       // Button2.setActionCommand("Button 2");
       // Button3.setActionCommand("Button 3");
       // Button4.setActionCommand("Button 4");
      //  Button5.setActionCommand("Button 5");

        Button1.addActionListener(new ButtonClickListener());
        Button2.addActionListener(new ButtonClickListener());
        Button3.addActionListener(new ButtonClickListener());
        Button4.addActionListener(new ButtonClickListener());
        Button5.addActionListener(new ButtonClickListener());

        mainFrame.add(Button1, BorderLayout.NORTH);
        mainFrame.add(Button2, BorderLayout.WEST);
        mainFrame.add(Button3, BorderLayout.SOUTH);
        mainFrame.add(Button4, BorderLayout.EAST);
        mainFrame.add(Button5, BorderLayout.CENTER);






        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}



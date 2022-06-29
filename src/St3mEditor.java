// Java Program to create a text editor using java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;

class St3mEditor extends JFrame implements ActionListener {

    JTextArea t;
    JTextArea t2;
    JFrame f;
    static St3mLexer lexer;
    St3mParser parser;

    // Constructor
    St3mEditor()
    {
        // Create a frame
        f = new JFrame("editor");

        try {
            // Set metal look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }
        catch (Exception e) {
        }

        // Text component
        t = new JTextArea();
        t2= new JTextArea();

        t2.setBackground(Color.darkGray);
        t2.setCaretColor(Color.red);
        t2.setForeground(Color.red);
        t.setBackground(Color.black);
        t.setCaretColor(Color.green);
        t.setForeground(Color.GREEN);

        t.setFont(new Font("consolas", Font.PLAIN, 28));
        t2.setFont(new Font("consolas", Font.PLAIN, 28));


        // Create a menubar
        JMenuBar mb = new JMenuBar();

        // Create a menu for menu
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem run = new JMenuItem("Run");
        JMenuItem mc = new JMenuItem("Close");
        JMenuItem add = new JMenuItem("+");
        JMenuItem min = new JMenuItem("-");

        run.setOpaque(true);
        run.setBackground(Color.green);
        mc.setBackground(Color.RED);


        mc.addActionListener(this);
        run.addActionListener(this);
        add.addActionListener(this);
        min.addActionListener(this);
        mi1.addActionListener(this);

        mb.add(mi1);
        mb.add(add);
        mb.add(min);
        mb.add(mc);
        mb.add(run);


        f.setJMenuBar(mb);
        f.add(t);
      //  f.add(t2,BorderLayout.SOUTH);
        f.setSize(600, 800);

        f.show();
    }

    // If a button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        if (s.equals("New")) {
            t.setText("");
        }
        else if (s.equals("Run")){
         run();
        }
        else if (s.equals("+")){
            Font font = t.getFont();
            float size = font.getSize() + 1.0f;
            t.setFont( font.deriveFont(size) );
        }
        else if (s.equals("-")){
            Font font = t.getFont();
            float size = font.getSize() - 1.0f;
            t.setFont( font.deriveFont(size) );
        }
        else {
            f.setVisible(false);
            System.out.print("St3m> IDE closed");

        }

    }

    StringBuffer getSourceCode(){
        StringBuffer buffer = new StringBuffer(t.getText().trim());
        return buffer;
    }

    void run()
    {
        St3mLexer lexer = new St3mLexer();
        lexer.init_lexer(getSourceCode().toString());
        parser.setClassifications(lexer.returnClass());

    }

    // Main class
    void initEditor()
    {
        parser = new St3mParser();
        System.out.println("St3m> IDE started...");

    }
}

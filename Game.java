import java.awt.*;
import javax.swing.*;

public class Game extends JFrame{
    JPanel panel;
    
    public Game() throws Exception{
        setTitle("Dino by KASSI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(true);
        setLocation(250,200);
        setSize(750,250);
        panel=new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        Dino dino=new Dino();
        dino.addKeyListener(new Listener(dino));
        panel.add(dino);
        add(panel,BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
}

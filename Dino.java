import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;

public class Dino extends JPanel implements ActionListener {
    Timer dinoTimer;
    Timer cactusTimer;
    Boolean gameOver = false;

    int score = 0;
    int bestScore=0;
    Score sc = new Score();
    Image ground = new ImageIcon("Images/track.png").getImage();
    Image dinoRun = new ImageIcon("Images/dino-run.gif").getImage();
    Image dinoJump = new ImageIcon("Images/dino-jump.png").getImage();
    Image dinoDead = new ImageIcon("Images/dino-dead.png").getImage();
    Image GO = new ImageIcon("Images/game-over.png").getImage();
    Image reset = new ImageIcon("Images/reset.png").getImage();

    Image c1 = new ImageIcon("Images/cactus1.png").getImage();
    Image c2 = new ImageIcon("Images/cactus2.png").getImage();
    Image c3 = new ImageIcon("Images/cactus3.png").getImage();

    Vector<Block> cactusList = new Vector<>();

    Block dino = new Block(50, 157, 60, 70, dinoRun);
    Block cactus1;
    Block cactus2;
    Block cactus3;

    int cactusX = 700;
    int velocityX = 0; // cactus
    int velocityY = 0; // dino
    int gravity = 0;

    public Dino() {
        bestScore=sc.getBestScore();
        setPreferredSize(new Dimension(750, 250));
        setBackground(Color.lightGray);
        setFocusable(true);
        dinoTimer = new Timer(1000 / 60, this);
        dinoTimer.start();
        cactusTimer = new Timer(1200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCactus();
            }
        });
        cactusTimer.start();
    }

    public void draw(Graphics g) {
        g.drawImage(ground, 0, 220, 750, 20, null);
        g.drawImage(dino.image, dino.x, dino.y, dino.width, dino.height, null);
        if (cactusList.size() > 0) {
            for (int i = 0; i < cactusList.size(); i++) {
                Block cactus = cactusList.get(i);
                g.drawImage(cactus.image, cactus.x, cactus.y, cactus.width, cactus.height, null);
            }
        }
        g.setColor(Color.black);
        if(score/5>sc.getBestScore())
        {
           bestScore=score/5;
        }
        g.drawString("Score:" + score / 5, 5, 15);
        g.drawString("Best core:" + bestScore, 5, 30);

    }

    public void drawGO(Graphics g) {
        g.drawImage(GO, 100, 40, 550, 50, null);
        g.drawImage(reset, 350, 90, 30, 30, null);
        g.drawString("PRESS TAB TO TRY AGAIN", 290, 140);
    }

    public void generateCactus() {
        Random random = new Random();
        int guess = random.nextInt(10);
        if (guess > 9) {
            cactus3 = new Block(cactusX, 177, 80, 50, c3);
            cactusList.add(cactus3);
        } else if (guess > 7) {
            cactus2 = new Block(cactusX, 177, 60, 50, c2);
            cactusList.add(cactus2);
        } else if (guess > 4) {
            cactus1 = new Block(cactusX, 177, 34, 50, c1);
            cactusList.add(cactus1);
        }
        if (cactusList.size() > 10) {
            cactusList.remove(0);
        }
    }

    public boolean collusion(Block a, Block b) {
        return a.x + 10 < b.x + b.width &&
                a.x + a.width > b.x + 20 &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y + 5;
    }

    public void moved(Graphics g) {
        for (int i = 0; i < cactusList.size(); i++) {
            Block cactus = cactusList.get(i);
            cactus.x -= 8;
        }
        dino.y += velocityY;
        velocityY += gravity;
        if (dino.y == 157) {
            velocityY = 0;
        }
        dino.image = dinoRun;
        for (int index = 0; index < cactusList.size(); index++) {
            Block cactus = cactusList.get(index);
            if (collusion(dino, cactus)) {
                gameOver = true;
                drawGO(g);
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
        score++;
        moved(g);
        if (gameOver) {
            if (score / 5 > sc.getBestScore()) {
                sc.writeScore(score / 5);
            }
            dinoTimer.stop();
            cactusTimer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
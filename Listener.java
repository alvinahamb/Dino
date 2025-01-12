import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    Dino dino;

    public Listener(Dino d) {
        dino = d;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(dino.dino.y==157){
                dino.velocityY = -12;
                dino.gravity = 1;
                dino.dino.image=dino.dinoJump;
            }
            if(dino.gameOver)
            {
                dino.gameOver=false;
                dino.score=0;
                dino.dino = new Block(50, 157, 60, 70,dino.dinoRun);
                dino.dino.image=dino.dinoRun;
                dino.velocityX = 0; // cactus
                dino.velocityY = 0; // dino
                dino.gravity = 0;
                dino.cactusList.clear();
                dino.cactusTimer.start();
                dino.dinoTimer.start();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

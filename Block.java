import javax.swing.*;
import java.awt.*;

public class Block {
    int x;
    int y;
    int width;
    int height;
    Image image;

    public Block(int x,int y,int w,int h,Image i)
    {
        this.x=x;
        this.y=y;
        this.width=w;
        this.height=h;
        this.image=i;
    }
}

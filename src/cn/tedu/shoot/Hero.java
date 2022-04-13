package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
    private int life;
    private int fire;

    public Hero(){
        super(97, 139, 140, 400);
        life = 3;
        fire = 0;
    }
    private int index = 0;
    public BufferedImage getImage() {
        return Images.heros[(index++) % Images.heros.length];
    }

    public Bullet[] shoot(){
        int xStep = this.width / 4;
        int yStep = 20;
        if (fire > 0){
            Bullet[] bs = new Bullet[2];
            bs[0] = new Bullet(this.x + (1 * xStep), this.y - yStep);
            bs[1] = new Bullet(this.x + (3 * xStep), this.y - yStep);
            fire -= 2;
            return bs;
        }else{
            Bullet[] bs = new Bullet[1];
            bs[0] = new Bullet(this.x + (2 * xStep), this.y - yStep);
            return bs;
        }
    }
}

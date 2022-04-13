package cn.tedu.shoot;

import jdk.jfr.FlightRecorder;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.Random;

public abstract class FlyingObject {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    public static final int REMOVE = 2;
    protected int state = LIVE;

    protected int width;
    protected int height;
    protected int x;
    protected int y;
    public FlyingObject(int width ,int height){
        this.width = width;
        this.height = height;
        Random random = new Random();
        x = random.nextInt(World.WIDTH - width);
        y = -height;
    }
    public FlyingObject(int width, int height, int x, int y ){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public abstract BufferedImage getImage();

    public boolean isLive(){
        return state == LIVE;
    }

    public boolean isDead(){
        return state == DEAD;
    }

    public boolean isRemove(){
        return state == REMOVE;
    }
}


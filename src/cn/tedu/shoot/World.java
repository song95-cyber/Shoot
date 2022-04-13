package cn.tedu.shoot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class World extends JPanel {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;

    private Sky sky = new Sky();
    private Hero hero = new Hero();
    private FlyingObject[] enemies = {};
    private Bullet[] bullets = {};

    public FlyingObject nextOne(){
        Random random = new Random();
        int type = random.nextInt(20);
        if(type < 5){
            return new Bee();
        }else if(type < 13){
            return new Airplane();
        }else{
            return new BigAirplane();
        }
    }

    private int enterIndex = 0;
    public void enterAction(){
        enterIndex ++;
        if(enterIndex % 40 == 0){
            FlyingObject obj = nextOne();
            enemies = Arrays.copyOf(enemies, enemies.length + 1);
            enemies[enemies.length - 1] = obj;
        }
    }
    Bullet[] bs = hero.shoot();
    private int shootIndex = 0;
    private int size = bs.length;
    public void shootAction(){
        shootIndex++;
        if(shootIndex % 30 == 0){
                for(int i = 0; i < size; i++){
                    bullets = Arrays.copyOf(bullets, 1);
                    bullets[bullets.length - 1] = bs[i];
                }

        }
    }

    public void action(){
        Timer timer = new Timer();
        int intervel = 10;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                enterAction();
                shootAction();
                repaint();
            }
        }, intervel, intervel);
    }
    public void paint(Graphics g){
        g.drawImage(sky.getImage(), sky.x, sky.y, null);
        g.drawImage(sky.getImage(), sky.x, sky.getY1(), null);
        g.drawImage(hero.getImage(), hero.x, hero.y, null);
        for(int i = 0; i < enemies.length; i++){
            FlyingObject f = enemies[i];
            g.drawImage(f.getImage(), f.x, f.y, null);
        }
        for(int i = 0; i < bullets.length; i++){
            Bullet b = bullets[i];
            g.drawImage(b.getImage(), b.x, b.y, null);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        world.action();
    }
}

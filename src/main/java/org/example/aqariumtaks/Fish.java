package org.example.aqariumtaks;

import java.util.Random;

public class Fish implements Runnable {

    private static final Random random = new Random();
    private int fishId;
    private int lifespan;

    private int x, y;
    private Gender gender;
    private Aquarium aquarium;

    private boolean live = true;

    public Fish(int fishId, int lifespan, int x, int y, Gender gender, Aquarium aquarium) {
        this.fishId = fishId;
        this.lifespan = lifespan;
        this.x = x;
        this.y = y;
        this.gender = gender;
        this.aquarium = aquarium;
    }

    public int getFishId() {
        return fishId;
    }

    public Gender getGender() {
        return gender;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        for (int i = 0; i < lifespan && live; i++) {
            movement();
            aquarium.checkNewFish(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        die();
    }


    private synchronized void movement() {
        x = random.nextInt(3) - 1;   //   0 1 2 -1 //   -1 0 1
        y = random.nextInt(3) - 1;   //
        x = Math.max(0, Math.min(aquarium.getWidth() - 1, x));
        y = Math.max(0, Math.min(aquarium.getHeight() - 1, y));
        System.out.println("baliq " + fishId + " harakatlandi: (" + x + "," + y + ")");
    }


    private synchronized void die() {
        live = false;
        aquarium.removeFish(this);

    }


}

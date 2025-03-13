package org.example.aqariumtaks;

import java.util.Random;

public class Fish implements Runnable {

    private static final Random random = new Random();

    private int fishId;
    private Gender gender;
    private final Integer lifespan;
    private int x, y;
    private boolean live = true;
    private Aquarium aquarium;


    public Fish(int fishId, Gender gender, Integer lifespan, int x, int y, Aquarium aquarium) {
        this.fishId = fishId;
        this.gender = gender;
        this.lifespan = lifespan;
        this.x = x;
        this.y = y;
        this.aquarium = aquarium;
    }


    @Override
    public void run() {
        for (int i = 0; i < lifespan && live; i++) {
            movement();
            aquarium.checkForInteraction(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        die();

    }

    private synchronized void die() {
        live = false;
        aquarium.removeFish(this);
        //System.out.println("Baliq oldi "+fishId);
    }

    private synchronized void movement() {

        x += random.nextInt(3) - 1;
        y += random.nextInt(3) - 1;
        x = Math.max(0, Math.min(aquarium.getWidth() - 1, x));
        y = Math.max(0, Math.min(aquarium.getHeight() - 1, y));
        System.out.println("Baliq " + fishId + " harakatlandi: (" + x + "," + y + ")");

    }


    public int getFishId() {
        return fishId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

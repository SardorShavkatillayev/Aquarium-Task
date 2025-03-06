package org.example.aqariumtaks;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class Aquarium {

    private static final Random random = new Random();

    private Set<Fish> fishList = new CopyOnWriteArraySet<>();

    private int width, height, capacity;
    private ExecutorService executors = Executors.newCachedThreadPool();
    private static final AtomicInteger fishIdCounter = new AtomicInteger(1);


    public Aquarium(int width, int height, int capacity) {
        this.width = width;
        this.height = height;
        this.capacity = capacity;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCapacity() {
        return capacity;
    }

    public synchronized void removeFish(Fish fish) {
        fishList.remove(fish);
        System.out.println("☠️ Baliq oldi... R.I.P 🐟 ID = " + fish.getFishId() + " | Gender = " + fish.getGender() + " | Jami baliqlar: " + fishList.size());
        if (fishList.isEmpty()) {
            executors.shutdown();
            System.out.println("❌ Hamma baliqlar oldi, akvarium yopildi!");
        }
    }

    public synchronized void checkNewFish(Fish fish) {

        for (Fish fish1 : fishList) {
            if (fish != fish1 && fish.getX() == fish1.getX() && fish.getY() == fish1.getY()) {
                if (fish.getGender() != fish1.getGender()) {
                    spawnNewFish();
                }
            }
        }

    }

    private synchronized void spawnNewFish() {
        if (capacity > fishList.size()) {
            int id = fishIdCounter.incrementAndGet();
            Gender gender;
            if (random.nextBoolean()) {
                gender = Gender.MALE;
            } else {
                gender = Gender.FEMALE;
            }
            Fish fish = new Fish(id, random.nextInt(10) + 6,
                    random.nextInt(width), random.nextInt(height), gender, this);
            addFish(fish);
            System.out.println("\uD83D\uDFE2 Yangi baliq tugildi! ID: " + fish.getFishId() + " | Gender: " + gender + " | Jami baliqlar: " + fishList.size());

        }

    }

    public synchronized void addFish(Fish fish) {
        if (capacity > fishList.size()) {
            fishList.add(fish);
            executors.submit(fish);
            System.out.println("🎉 Yangi baliq qoshildi! [ID: " + fish.getFishId() + "] 🐠");
        }
    }
}

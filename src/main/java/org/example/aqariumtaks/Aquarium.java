package org.example.aqariumtaks;


import java.util.Random;

import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Aquarium {

    String GREEN = "\u001B[32m";
    String RESET = "\u001B[0m";

    private static final Random random = new Random();
    private final int width, height, capacity;
    private final Set<Fish> fishSet = new CopyOnWriteArraySet<>();


    private final ExecutorService executor = Executors.newCachedThreadPool();
    private static final AtomicInteger fishIdCounter = new AtomicInteger(1);

    public Aquarium(int width, int height, int capasity) {
        this.width = width;
        this.height = height;
        this.capacity = capasity;
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


    public void checkForInteraction(Fish fish) {
        synchronized (this) {
            for (Fish fish1 : fishSet) {
                if (fish != fish1 && fish.getX() == fish1.getX() && fish.getY() == fish1.getY()) {
                    if (fish.getGender() != fish1.getGender()) {
                        spawnNewFish();
                    }
                }
            }
        }
    }

    private synchronized void spawnNewFish() {
        if (fishSet.size() < capacity) {
            int id = fishIdCounter.incrementAndGet();
            Gender gender;
            if (random.nextBoolean()) {
                gender = Gender.MALE;
            } else {
                gender = Gender.FEMALE;
            }

            Fish fish = new Fish(id, gender, random.nextInt(20) + 10,
                    random.nextInt(width), random.nextInt(height), this);

            addFish(fish);

            System.out.println("\uD83D\uDFE2 Yangi baliq tugildi! ID: " + fish.getFishId() +
                               " | Gender: " + gender +
                               " | Jami baliqlar: " + fishSet.size());

        }
    }


    public synchronized void addFish(Fish fish) {

        if (fishSet.size() < capacity) {
            fishSet.add(fish);
            executor.submit(fish);
            System.out.println(GREEN + "🎉 Yangi baliq qoshildi! [ID: " + fish.getFishId() + "] 🐠" + RESET);

        } else {
            System.out.println("🚫🐠 Akvarium tola! Yangi baliq qoshib bolmaydi. ❌");
        }
    }

    public synchronized void removeFish(Fish fish) {

        fishSet.remove(fish);
        System.out.println("☠️ Baliq oldi... R.I.P 🐟 ID = " + fish.getFishId() +
                           " | Gender = " + fish.getGender() +
                           " | Jami baliqlar: " + fishSet.size());
        if (fishSet.isEmpty()) {
            System.out.println("❌ Hamma baliqlar oldi, akvarium yopildi!");
            shutdownAquarium();
        }

    }

    private void shutdownAquarium() {
        executor.shutdown();
    }


}

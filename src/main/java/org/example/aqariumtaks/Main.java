package org.example.aqariumtaks;


import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int width = random.nextInt(12) + 5;
        int height = random.nextInt(12) + 5;

        int minCapacity = random.nextInt(10) + 7;
        int capacity = Math.max(minCapacity, random.nextInt((width * height) / 2) + 1);
        Aquarium aquarium = new Aquarium(width, height, capacity);
        System.out.println("Akvarium sig‘imi: " + capacity);

        int totalFish = random.nextInt(capacity / 2) + 7;

        int malesCount = random.nextInt(totalFish - 1) + 1;
        int femalesCount = totalFish - malesCount;

        for (int i = 0; i < malesCount; i++) {
            aquarium.addFish(new Fish(i + 1, Gender.MALE,
                    random.nextInt(20) + 10,
                    random.nextInt(width), random.nextInt(height), aquarium));
        }

        for (int i = 0; i < femalesCount; i++) {
            aquarium.addFish(new Fish(i + malesCount + 1, Gender.FEMALE,
                    random.nextInt(20) + 10,
                    random.nextInt(width), random.nextInt(height), aquarium));
        }
    }
}


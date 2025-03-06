package org.example.aqariumtaks;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int width = random.nextInt(9) + 6;
        int height = random.nextInt(9) + 6;
        int capacity = random.nextInt((width * height) / 3) + 1;

        Aquarium aquarium = new Aquarium(width, height, capacity);
        int totalFish = random.nextInt(capacity / 2) + 6;

        int maleCount = random.nextInt(totalFish - 1) + 1;
        int femaleCount = totalFish - maleCount;


        System.out.println("akvarium sigimi= " + capacity);

        Gender gender;
        for (int i = 0; i < maleCount + femaleCount; i++) {

            if (random.nextBoolean()) {
                gender = Gender.MALE;
            } else {
                gender = Gender.FEMALE;
            }

            aquarium.addFish(new Fish(i + 1, random.nextInt(15) + 5,
                    random.nextInt(width), random.nextInt(height), gender, aquarium));
        }

    }
}
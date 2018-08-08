package com.aleks.codility.prefixsums;

/**
 * Passing Cars Solution in Java
 * DEMO : https://app.codility.com/demo/results/training7TQKXX-89Z/
 * Task Score : 100%
 * Correctness : 100%
 * Performance : 100%
 */
public class PassingCars {
    public static int solution(int[] A) {
        // Simple counter to keep at any moment how many cars are heading to East
        int counterEast = 0;

        // Simple counter to keep how many cars heading to East passed cars heading to West
        int passingCars = 0;

        // Whenever a car goes to East, increase the counterEast
        // Whenever a car goes to West, it'll pass all the cars already going to East,
        // so increment passingCars by the amount of cars heading to East already encountered (counterEast)
        // If the number of passingCars exceeds 1 000 000 000, return -1
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                counterEast++;
            else if (A[i] == 1)
                passingCars += counterEast;

            if (passingCars > 1000000000)
                return -1;
        }
        return passingCars;
    }

    public static void main(String[] args) {
        int[] test1 = { 0, 1, 0, 1, 1 };
        System.out.println("A = [0,1,0,1,1] Solution : " + solution(test1));
    }
}
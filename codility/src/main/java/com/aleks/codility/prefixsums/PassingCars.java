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
        int counterEast = 0;
        int passingCars = 0;
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
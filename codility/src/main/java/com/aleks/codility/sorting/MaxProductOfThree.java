package com.aleks.codility.sorting;

/**
 * Max Product Of Three Solution in Java
 * DEMO : https://app.codility.com/demo/results/training97U3U9-MZV/
 * Task Score : 100%
 * Correctness : 100%
 * Performance : 100%
 */
public class MaxProductOfThree {

    public static int solution(int[] A) {

        // The multiplication of the 3 max integers gives the max triplet
        int maxPositive1 = Integer.MIN_VALUE+2;
        int maxPositive2 = Integer.MIN_VALUE+1;
        int maxPositive3 = Integer.MIN_VALUE;
        
        // The multiplication of 2 negative numbers give a positive number
        // -6*-5 = 6*5 = 30 > 6 = 3*2 even if 3 and 2 are greater than -6 or -5
        int minNegative1 = Integer.MAX_VALUE-1;
        int minNegative2 = Integer.MAX_VALUE;
        
        // We search for the 3 max positive integers and the 2 min negative integers
        for(int i=0; i<A.length; i++) {
            if(A[i] >= maxPositive1) {
                maxPositive3 = maxPositive2;
                maxPositive2 = maxPositive1;
                maxPositive1 = A[i];
            } else if(A[i] >= maxPositive2) {
                maxPositive3 = maxPositive2;
                maxPositive2 = A[i];
            } else if(A[i] > maxPositive3) {
                maxPositive3 = A[i];
            }
            
            if(A[i] <= minNegative1) {
                minNegative2 = minNegative1;
                minNegative1 = A[i];
            } else if(A[i] < minNegative2) {
                minNegative2 = A[i];
            }
        }
        
        // We keep the multiplication of the 3 max positive integers in a variable maxes
        int threePositiveMaxes = maxPositive1 * maxPositive2 * maxPositive3;

        // We keep the multiplication of the 2 min negative integers and 1 max positive
        // integer in a variable twoMinsOneMax

        // Since the multiplication of 3 negative integers equals to a negative integer
        // we multiply the 2 min negative integers with the max positive integer
        int twoNegativeOnePositive = minNegative1 * minNegative2 * maxPositive1;
        
        // Return the greatest result
        return (threePositiveMaxes > twoNegativeOnePositive) ? threePositiveMaxes : twoNegativeOnePositive;
    }

    public static void main(String[] args) {
        int[] A = {-3,1,2,-2,5,6};
        int[] B = {-6,-5,3,2,6}; // 6*3*2 = 36 BUT -6*-5*6 = 180

        System.out.println("A = [-3,1,2,-2,5,6] Solution = " + solution(A));
        System.out.println("B = [-6,-5,3,2,6] Solution = " + solution(B));
    }
}
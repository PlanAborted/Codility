package com.aleks.codility.maxsliceproblem;

/**
 * MaxProfit Solution in Java
 * DEMO : https://app.codility.com/demo/results/training2BD457-RAU/
 * Task Score : 100%
 * Correctness : 100%
 * Performance : 100%
 */
public class MaxProfit {

    public static int solution(int[] A) {

        /*
            Explanation step-by-step : 
        
            1) Find the minimum value of the array
            2) Find the maximum value that comes AFTER the minimum value
            (Since the maximum value of the entire array can be before the minimum
            value, we initialize it again each time we found another minimum value)
            3) Store maximum-minimum in maxProfit if it's higher than the current profit
        */
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int maxProfit = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] < min) {
                min = A[i];
                max = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }

            int currentProfit = max - min;

            // maxProfit = max(maxProfit,currentProfit)
            maxProfit = (maxProfit < currentProfit ? currentProfit : maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };

        System.out.println("A = {23171,21011,21123,21366,21013,21367} ; Solution : " + solution(A));
    }
}
package com.aleks.codility;

/**
 * Binary Gap Solution in Java
 * DEMO : https://app.codility.com/demo/results/trainingGMMP37-5RK/
 * Task Score : 100%
 * Correctness : 100%
 * Performance : Not assessed
 */

public final class BinaryGap {
    public static int solution(int N) {
        // Transform N to a binary string representation
        String binaryString = Integer.toBinaryString(N);

        // Split the binary string to get a String array of "0"s
        String[] zeroArray = binaryString.split("1");

        // Check if the binary String ends with "1", if not we omit the last value of the String array
        int arrayLength = (binaryString.endsWith("1") ? zeroArray.length : zeroArray.length - 1);

        // Find and return the String with the maximum length - or 0, if no binary gaps
        int maxZerosLength = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (zeroArray[i].length() > maxZerosLength)
                maxZerosLength = zeroArray[i].length();
        }
        return maxZerosLength;
    }

    public static void main(String[] args) {
        System.out.println("N = 1041\tSolution : " + solution(1041));
        System.out.println("N = 529 \tSolution : " + solution(529));
        System.out.println("N = 32  \tSolution : " + solution(32));
        System.out.println("N = 20  \tSolution : " + solution(20));
        System.out.println("N = 15  \tSolution : " + solution(15));
    }
}

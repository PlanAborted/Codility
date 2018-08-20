package com.aleks.codility.stacksqueues;

/**
 * Nesting Solution in Java
 * DEMO : https://app.codility.com/demo/results/training2PSK3T-6PS/
 * Task Score : 100%
 * Correctness : 100%
 * Performance : 100%
 */
public class Nesting {

    public static int solution(String S) {

        // Initialization of a counter that will keep the number of ( and ) in the string S
        long counter = 0;

        for(int i=0; i<S.length(); i++) {

            // ( => counter + 1
            if(S.charAt(i) == '(') {
                counter++;

            }
            // ) => counter - 1
            else if(S.charAt(i) == ')') {
                counter--;
            }
            
            // If the counter goes below 0, it means the string is not nested (e.g. the String )( is not nested)
            if (counter<0) {
                return 0;
            }
        }

        // If the counter equals 0, it means that there is an equal number of ( and )
        return (counter==0?1:0);
    }

    public static void main(String[] args) {
        String s1 = "(()(())())"; // Should return 1
        String s2 = "())"; // Should return 0
        String s3 = ")("; // Should return 0

        System.out.println("String = (()(())()) ; Solution = "+ solution(s1));
        System.out.println("String = ()) ; Solution = "+ solution(s2));
        System.out.println("String = )( ; Solution = "+ solution(s3));
    }
}
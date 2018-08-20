package com.aleks.codility.stacksqueues;

import java.util.Stack;

/**
 * Brackets Solution in Java
 * DEMO : https://app.codility.com/demo/results/trainingUFNG5Q-D3T/
 * Task Score : 100%
 * Correctness : 100%
 * Performance : 100%
 */
public class Brackets {

    public static int solution(String S) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return 0;
            } else {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else
                    return 0;
            }
        }

        return (stack.isEmpty() ? 1 : 0);
    }

    public static void main(String[] args) {
        String s1 = "{[()()]}"; // Should return 1
        String s2 = "())"; // Should return 0
        String s3 = "([)()]"; // Should return 0

        System.out.println("String = {[()()]} ; Solution = " + solution(s1));
        System.out.println("String = ()) ; Solution = " + solution(s2));
        System.out.println("String = ([)()] ; Solution = " + solution(s3));
    }
}
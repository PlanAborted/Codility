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

        /*
            In this case, we use a Stack to keep track of opening and closing brackets.

            Our goal is :   -if we encounter an opening bracket, we put it at the top of the stack.
                            -if we encounter a closing bracket, and if it's the same as the opening
                            bracket at the top of the stack, we pop the stack.
            That means that we will always make sure that for every opening bracket there is a closing
            bracket.
            
            For this :
            We parse the String S and if the char encountered is an opening bracket, we stock it in 
            the stack.
            If the char encountered is not an opening bracket, we check if the stack is empty.
            (If the stack is empty that means that the string S is begining with a closing bracket.)
            If the char encountered is a closing bracket AND if the top of the stack is the same but 
            opening, we pop it.
            If it's not, the string S is not nested properly, so we return 0.

            At the end, there is still a possibility that the String S has only opening brackets,
            so we make sure that all the opening brackets were poped by a closing bracket
            (the stack is empty).
        */
        
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
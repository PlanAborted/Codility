package com.aleks.codility.stacksqueues;

import java.util.Stack;

/**
 * StoneWall Solution in Java
 * DEMO : https://app.codility.com/demo/results/trainingD7S6GK-Y4P/
 * Task Score : 100%
 * Correctness : 100%
 * Performance : 100%
 */
public class StoneWall {

    public static int solution(int[] H) {

        /*
            Goal : 
            Implement a counter that increments each time we construct a block
            You can easily notice that you can use the decreasing height of the int array for this.

            We can have 3 cases when parsing the int array H : 
                - H[i] = H[i-1] : there is no block construction
                - H[i] > H[i-1] : there is no block construction
                - H[i] < H[i-1] : block construction

            For it :
            To keep track of the heights already encoutered, we use a Stack.
            We initialize the stack by pushing the first height (H[0])
            Then we compare each element (height) of the int array H with the top of the Stack (peek)
            3 cases :   - H[i] = top element : we do nothing, the block is not constructed
                        - H[i] > top element : we add the new height to the stack by pushing it on the top
                        - H[i] < top element : we pop the stack as many times as needed and increment the counter
            Example : If the stack is {9,8,7} (as the peek of the stack is 9) and the height is 7
            1) 7 < 9 : pop the stack and increment counter (counter = 1; stack = {8,7})
            2) 7 < 8 : pop the stack and increment counter (counter = 2; stack = {7})
            3) 7 = 7 : we do nothing, as the block with height 7 is still in construction
            
            Result : 2 blocks already constructed and another is waiting for construction
            If there is nothing more to compare, we construct all the blocks in the stack (in our example stack = {7}, so counter = 3)
            So we add the Stack size to the counter and return it.


        */

        int blocksConstructed = 0;

        Stack<Integer> heightToConstruct = new Stack<Integer>();
        heightToConstruct.push(H[0]);

        for (int i = 1; i < H.length; i++) {
            if (H[i] < heightToConstruct.peek()) {
                while (true) {
                    if (!heightToConstruct.isEmpty()) {
                        if (H[i] < heightToConstruct.peek()) {
                            heightToConstruct.pop();
                            blocksConstructed++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                };

                if (!heightToConstruct.isEmpty()) {
                    if (H[i] > heightToConstruct.peek()) {
                        heightToConstruct.push(H[i]);
                    }
                } else {
                    heightToConstruct.push(H[i]);
                }

            } else if (H[i] > heightToConstruct.peek()) {
                heightToConstruct.push(H[i]);
            }
        }

        blocksConstructed += heightToConstruct.size();

        return blocksConstructed;
    }

    public static void main(String[] args) {
        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};

        System.out.println("H = {8, 8, 5, 7, 9, 8, 7, 4, 8} ; Solution : " + solution(H));
    }
}
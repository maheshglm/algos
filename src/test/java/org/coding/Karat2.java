package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/1084353/Wayfair-or-Karat-interview
public class Karat2 {

    /*
    This question was asked by Wayfair, Karat

    You are working on a logic game made up of a series of puzzles.
    The first type of puzzle you settle on is "sub-Sudoku", a game where the player has to position the numbers 1..N on an NxN matrix.

    Your job is to write a function that, given an NxN matrix,
    returns true if every row and column contains the numbers 1..N

    The UI for the game does not do any validation on the numbers the player enters,
    so the matrix can contain any signed integer.
     */

    private boolean solution(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //Map<Integer, Set<Integer>> unique = new HashMap<>();
        /*
        i = 0 -> 1, 2, 3
        i = 1 -> 3, 1, 2
        i = 2 -> 2, 3, 1
         */
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            int j = 0;
            while (j < cols) {
                if (unique.contains(matrix[i][j]) || matrix[i][j] < 0) {
                    return false;
                }
                unique.add(matrix[i][j]);
                j++;
            }
            unique.clear();
        }

        for (int j = 0; j < cols; j++) {
            int i = 0;
            while (i < rows) {
                if (unique.contains(matrix[i][j]) || matrix[i][j] < 0) {
                    return false;
                }
                unique.add(matrix[i][j]);
                i++;
            }
            unique.clear();
        }
        return true;
    }


    @Test
    public void test1() {
        int[][] matrix = {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };
        System.out.println(solution(matrix));
        //true
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 2, 3},
                {3, 1, 2},
                {1, 3, 2}
        };
        System.out.println(solution(matrix));
        //false
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        System.out.println(solution(matrix));
        //false
    }

    @Test
    public void test4() {
        int[][] matrix = {
                {1000, -1000, 6},
                {2, 3, 1},
                {3, 1, 2}
        };
        System.out.println(solution(matrix));
        //false
    }


}

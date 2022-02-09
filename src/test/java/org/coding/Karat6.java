package org.coding;

import org.junit.Test;

//https://leetcode.com/discuss/interview-question/1062462/Indeed-Karat-Questions
public class Karat6 {

    //return start or end index of rectangle or height or length
    private int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    Integer[] measure = {0, 0}; //set to zeros initially
                    dfs(matrix, i, j, measure);
                    //deducting i and j from height and width is because to get
                    //exact height and width of the island
                    //ex: first zero found at 1,2
                    //last zero indices are available in measure[0]-1 and measure[1]-1
                    //in test1, they ll be 3,4, so height will be 3-1 = 2
                    //and width ll be 4-2 = 2
//                    int height = measure[0] - i;
//                    int width = measure[1] - j;
                    System.out.println("star row " + i + " start col " + j);
                    System.out.println("end row " + (measure[0] - 1) + " end col " + (measure[1] - 1));
                    System.out.println("height " + (measure[0] - i) + " width " + (measure[1] - j));
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] matrix, int i, int j, Integer[] measure) {
        int maxRow = Math.max(measure[0], i);
        int maxCol = Math.max(measure[1], j);
        measure[0] = maxRow;
        measure[1] = maxCol;

        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length && matrix[i][j] == 0) {
            matrix[i][j] = 1; //once confirmed as 0 then setting to 1 so that it ll not be scanned again
            dfs(matrix, i + 1, j, measure);
            dfs(matrix, i - 1, j, measure);
            dfs(matrix, i, j + 1, measure);
            dfs(matrix, i, j - 1, measure);
        }
    }

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(solution(matrix));
        /*
            height 2 width 2
            1
        */

    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1}
        };
        System.out.println(solution(matrix)); //1
        //height 2 width 2
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(solution(matrix)); //0
    }

    @Test
    public void test4() {
        int[][] matrix = {
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(solution(matrix)); //1
        //height 1 width 1
    }

    @Test
    public void test5() {
        int[][] matrix = {
                {1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(solution(matrix)); //1
        //height 1 width 2
    }

    @Test //more rectangles
    public void test6() {
        int[][] matrix = {
                {0, 1, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1}
        };
        System.out.println(solution(matrix));//3
        /*
        height 1 width 1
        height 2 width 2
        height 2 width 1
         */
    }


    @Test
    public void test7() {
        int[][] matrix = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        System.out.println(solution(matrix));

        /*
        [
            [[0,0],[0,0]],
            [[2,0],[2,0]],
            [[2,3],[3,5]],
            [[3,1],[5,1]],
            [[5,3],[6,4]],
            [[7,6],[7,6]],
        ]
         */

    }

}

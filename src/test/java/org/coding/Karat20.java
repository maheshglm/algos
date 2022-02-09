package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/discuss/interview-experience/1042873/roblox-karat-interview-ic2-san-mateo-december-2020-passed
public class Karat20 {


    /*
    Write a function that takes a rectangular board with only +'s and 0's, and returns two collections:
    one containing all of the row numbers whose row is completely passable by snakes, and
    the other containing all of the column numbers where the column is completely passable by snakes.
     */

    //+'s represent impassable squares where snakes cannot go,
    //and 0's represent squares through which snakes can move.
    private List<List<Integer>> solution(char[][] grid) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        //loop thru all cols
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    break;
                }
                if (j == grid[0].length - 1) {
                    rows.add(i);
                }
            }
        }

        //loop thru all rows
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] != '0') {
                    break;
                }
                if (j == grid.length - 1) {
                    cols.add(i);
                }
            }
        }

        result.add(rows);
        result.add(cols);

        return result;
    }

    @Test
    public void test1() {
        char[][] grid = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}
        };

        System.out.println(solution(grid));
        //Rows: [1], Columns: [3, 5]
    }

    @Test
    public void test2() {
        char[][] grid = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}
        };

        System.out.println(solution(grid));
        //Rows: [1, 2], Columns: [3, 5]
    }

    @Test
    public void test3() {
        char[][] grid = {
                {'0', '+', '+', '0', '+', '0', '0'},
                {'0', '+', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'0', '+', '+', '0', '0', '0', '+'}
        };

        System.out.println(solution(grid));
        //Rows: [], Columns: [0, 3, 5]
    }

}

package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/discuss/interview-question/992306/indeed-karat-phone-screen-find-embedded-words-i-ii
public class Karat16 {

    /*
        After catching your classroom students cheating before,
        you realize your students are getting craftier and hiding words in 2D grids of letters.
        The word may start anywhere in the grid,
        and consecutive letters can be either immediately below or immediately to the right of the previous letter.

        Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates.
        If there are multiple matches, return any one.
     */


    private List<List<Integer>> solution(char[][] grid, String word) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length + 1][grid[0].length + 1];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    dfs(grid, i, j, new ArrayList<>(), word, visited, 0, result);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j, List<List<Integer>> temp, String word, boolean[][] visited,
                     int index, List<List<Integer>> result) {
        if (i >= grid.length || j >= grid[i].length || visited[i][j]
                || grid[i][j] != word.charAt(index)) {
            return;
        }

        visited[i][j] = true;
        temp.add(Arrays.asList(i, j));

        if (index == word.length() - 1) {
            result.addAll(temp);
            return;
        }

        dfs(grid, i + 1, j, temp, word, visited, index + 1, result);
        dfs(grid, i, j + 1, temp, word, visited, index + 1, result);
        // visited[i][j] = false; still works
    }


    @Test
    public void test1() {
        char[][] grid = {
                {'c', 'c', 'c', 'a', 'r', 's'},
                {'c', 'c', 'i', 't', 'n', 'b'},
                {'a', 'c', 'n', 'n', 't', 'i'},
                {'t', 'c', 'i', 'i', 'p', 't'}
        };

        String word1 = "catnip";
        //[ (0, 2), (0, 3), (1, 3), (2, 3), (3, 3), (3, 4) ]
        System.out.println(solution(grid, word1));


        String word2 = "cccc";
        //[(0, 1), (1, 1), (2, 1), (3, 1)]
        //or [(0, 0), (1, 0), (1, 1), (2, 1)]
        //or [(0, 0), (0, 1), (1, 1), (2, 1)]
        //or [(1, 0), (1, 1), (2, 1), (3, 1)]
        System.out.println(solution(grid, word2));

    }


}

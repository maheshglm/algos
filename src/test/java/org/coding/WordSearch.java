package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/word-search/
//https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2793/
public class WordSearch {

    /*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells,
    where adjacent cells are horizontally or vertically neighboring.
    The same letter cell may not be used more than once
     */
    private boolean solution(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (searchWord1(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchWord(char[][] board, int i, int j, int index, String word) {
        //base condition, when i reaches word length, then function found a word
        //returns true.
        if (index == word.length()) {
            return true;
        }

        //boundary check
        //while in the process of incrementing/decrementing i and j,
        //we should not overshoot the boundaries

        //additional validation to break when char is not the char in the word that we are looking for
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(index)) {
            return false;
        }

        //The same letter cell may not be used more than once.
        char temp = board[i][j];
        board[i][j] = ' ';

        // check down, up, left, right
        if (searchWord(board, i + 1, j, index + 1, word)
                || searchWord(board, i - 1, j, index + 1, word)
                || searchWord(board, i, j + 1, index + 1, word)
                || searchWord(board, i, j - 1, index + 1, word)) {
            board[i][j] = temp;
            return true;
        }
        board[i][j] = temp;
        return false;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean searchWord1(char[][] board, int i, int j, int index, String word) {
        //base condition
        if (index == word.length()) {
            return true;
        }

        //boundary condition
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        for (int[] dir : dirs) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (searchWord1(board, ii, jj, index + 1, word)) {
                board[i][j] = temp;
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }

    @Test
    public void test1() {
        char[][] grid =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'},
                };

        System.out.println(solution(grid, "ABCCED")); //true
        System.out.println(solution(grid, "SEE")); //true
        System.out.println(solution(grid, "ABCB")); //false
    }
}

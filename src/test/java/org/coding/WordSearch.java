package org.coding;

import org.junit.Test;

public class WordSearch {

    private static boolean solution(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (searchWord(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchWord(char[][] board, int i, int j, int index, String word) {

        if (index == word.length()) {
            return true;
        }

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

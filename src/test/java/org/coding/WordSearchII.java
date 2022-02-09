package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-search-ii/
public class WordSearchII {

    public List<String> solution(char[][] board, String[] words) {
        List<String> wordsFound = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                wordsFound.add(word);
            }
        }
        return wordsFound;
    }

    private boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length())
            return true;

        // off the grid
        if (i < 0 || i == board.length || j < 0 || j == board[0].length ||
                board[i][j] != word.charAt(pos)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '0';

        // check down, up, left, right
        if (search(board, i + 1, j, word, pos + 1)
                || search(board, i - 1, j, word, pos + 1)
                || search(board, i, j + 1, word, pos + 1)
                || search(board, i, j - 1, word, pos + 1)) {
            board[i][j] = temp;
            return true;
        }

        board[i][j] = temp;
        return false;
    }


    @Test
    public void test1() {
        char[][] board =
                {
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                };

        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(solution(board, words));
        //output oath and eat
    }

    @Test
    public void test2() {
        char[][] board =
                {
                        {'a', 'b'},
                        {'c', 'd'}
                };

        String[] words = {"abcb"};

        System.out.println(solution(board, words));
        //output []
    }

    @Test
    public void test3() {
        char[][] board =
                {
                        {'a', 'a'},
                };

        String[] words = {"a"};

        System.out.println(solution(board, words));
        //output [a]

    }
}

package org.coding;

//https://leetcode.com/problems/rotating-the-box/
public class RotateTheBox {

    //You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
    //
    //A stone '#'
    //A stationary obstacle '*'
    //Empty '.'
    //The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
    //
    //It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
    //
    //Return an n x m matrix representing the box after the rotation described above.

    public char[][] solution(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    int empty = j + 1;
                    while (empty < cols && box[i][empty] == '.') {
                        empty++;
                    }
                    //still inside boundary
                    if (empty < cols && box[i][empty] == '.') {
                        box[i][empty] = '#';
                        box[i][j] = '.';
                    } else if (empty - 1 < cols && box[i][empty - 1] == '.') {
                        box[i][empty - 1] = '#';
                        box[i][j] = '.';
                    }
                }
            }
        }

        char[][] result = new char[cols][rows];
        int k = cols - 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][k] = box[i][j];
            }
            k--;
        }
        return result;
    }

}

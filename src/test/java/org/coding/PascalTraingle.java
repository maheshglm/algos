package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://algorithms.tutorialhorizon.com/pascal-triangle-get-specific-row-k/
public class PascalTraingle {

    private List<List<Integer>> solution(int rows) {

        List<List<Integer>> traingle = new ArrayList<>();

        if (rows == 0) return traingle;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        traingle.add(firstRow);

        for (int i = 1; i < rows; i++) {
            List<Integer> previousRow = traingle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            currentRow.add(1);
            traingle.add(currentRow);
        }
        return traingle;
    }

    @Test
    public void test1() {
        List<List<Integer>> traingle = solution(5);
        for (List<Integer> list : traingle) {
            System.out.println(list);
        }
    }

}

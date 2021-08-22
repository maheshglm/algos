package org.coding;


import org.junit.Test;

//https://www.youtube.com/watch?v=XYi2-LPrwm4&t=42s
//https://leetcode.com/problems/edit-distance/
public class EditDistance {

    /*
        Given two strings word1 and word2,
        return the minimum number of operations required to convert word1 to word2.
     */

    //https://leetcode.com/problems/edit-distance/solution/
    //
    //Edit distance between word1[1 : i] and word2[1 : j]
    //if last char is same from last :
    //D[i][j] = 1 + min( D[i−1][j], D[i][j−1], D[i−1][j−1]−1)
    //else
    //D[i][j] = 1 + min( D[i−1][j], D[i][j−1], D[i−1][j−1])

    //base case to consider
    //what if both are empty "", "" - minimum number = 0
    //what if both are same "abc", "abc" = 0
    //what if word 2 is empty, "abc", "" = len(word1)
    //what if word 1 is empty, "", "abc" = len(word2)

    //by using above base cases, we can fill bottom row and last column and then
    //we can build bottom up 2D array
    //O(M*N)
    //2 cases to consider (iterating from bottom up)
    //if word1[i] == word2[j] -> dp[i][j] = dp[i+1][j+1]
    //if word1[i] != word2[j] -> dp[i][j] = 1 + Min of 3 directions such as dp[i+1][j+1], dp[i][j+1], dp[i+1][j]
    //dp[0][0] will have the result

    //convert word1 -> word2
    private int solution(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        //fill the bottom row
        for (int i = 0; i <= l2; i++) {
            dp[l1][i] = l2 - i;
            //5 4 3 2 1 0
        }

        //fill the last column
        for (int i = 0; i <= l1; i++) {
            dp[i][l2] = l1 - i;
            //3
            //2
            //1
            //0
        }

        //fill all the columns
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i][j + 1], dp[i + 1][j]));
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void test1() {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(solution(word1, word2));
        //Output: 3
        //Explanation:
        //horse -> rorse (replace 'h' with 'r')
        //rorse -> rose (remove 'r')
        //rose -> ros (remove 'e')
    }

    @Test
    public void test2() {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(solution(word1, word2));
        //Output: 5
        //Explanation:
        //intention -> inention (remove 't')
        //inention -> enention (replace 'i' with 'e')
        //enention -> exention (replace 'n' with 'x')
        //exention -> exection (replace 'n' with 'c')
        //exection -> execution (insert 'u')
    }
}

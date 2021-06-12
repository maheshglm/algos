package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=2328s
public class GridTraveller {

    //it is slow (O(2^(n+m)) and O(n+m) space
    public int solution(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        int down = solution(m - 1, n);
        int right = solution(m, n - 1);
        return down + right;
    }

    //O(n*m) time, O(n+m) space
    public long solution1(int m, int n, Map<String, Long> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        memo.put(key, solution1(m - 1, n, memo) + solution1(m, n - 1, memo));
        return memo.get(key);
    }

    @Test
    public void test1() {
        System.out.println(solution(1, 1)); //1
        System.out.println(solution1(1, 1, new HashMap<>())); //1
    }

    @Test
    public void test2() {
        System.out.println(solution(1, 0)); //0
        System.out.println(solution(0, 1)); //0
        System.out.println(solution1(0, 1, new HashMap<>())); //0
    }

    @Test
    public void test3() {
        System.out.println(solution(3, 3)); //6
        System.out.println(solution1(3, 3, new HashMap<>())); //6
    }

    @Test
    public void test4() {
        System.out.println(solution(2, 3)); //3
        System.out.println(solution1(2, 3, new HashMap<>())); //6
    }

    @Test
    public void test5() {
        System.out.println(solution1(18, 18, new HashMap<>())); //2333606220
    }
}

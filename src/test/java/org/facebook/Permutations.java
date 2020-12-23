package org.facebook;

import com.google.common.base.Strings;
import org.junit.Test;

public class Permutations {

    static String swap(String s, int i, int j) {
        //System.out.println("swap(" + i + "," + j + ")");
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }

    //little confusing on the flow
    static void calculate(String s, int left) {
        if (left == s.length() - 1) {
            System.out.println(s);
        } else {
            for (int i = left; i <= s.length() - 1; i++) {
                s = swap(s, left, i);
                calculate(s, left + 1);
            }
        }
    }

    //better understandable especially the flow of recursion
    public static void permute(String full) {
        if (Strings.isNullOrEmpty(full)) {
            System.out.println("You need to provide string having length > 0.");
            return;
        }
        permute("", full);
    }

    public static void permute(String prefix, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
        }

        for (int i = 0; i < remaining.length(); i++) {
            String p = prefix + remaining.charAt(i);
            String r = remaining.substring(0, i) + remaining.substring(i + 1);
            permute(p, r);
        }
    }


    @Test
    public void test1() {
        String s = "ABC";
        permute(s);
    }

    @Test
    public void test2() {
        String s = "ABCD";
        permute(s);
    }
}

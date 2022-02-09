package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/859968/bettercom-phone-karat-interview
public class Karat19 {

    /*
    Suppose we have an unsorted log file of accesses to web resources.
    Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
    The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

    Follow-up:
    Write a function that takes the logs and returns the resource with the highest number of
    accesses in any 5 minute window, together with how many accesses it saw.
    Example:
    ('resource_3', 3)
     */

    public Map<String, List<Integer>> solution(String[][] logs) {
        Map<String, List<Integer>> result = new HashMap<>();
        for (String[] log : logs) {
            String user = log[1];
            Integer timeStamp = Integer.valueOf(log[0]);
            if (!result.containsKey(user)) {
                result.put(user, Arrays.asList(timeStamp, timeStamp));
            } else {
                Integer newMin = Math.min(timeStamp, result.get(user).get(0));
                Integer newMax = Math.max(timeStamp, result.get(user).get(1));
                result.replace(user, Arrays.asList(newMin, newMax));
            }
        }
        return result;
    }


    public String solution1(String[][] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            Integer ts1 = Integer.valueOf(o1[0]);
            Integer ts2 = Integer.valueOf(o2[0]);
            return ts1.compareTo(ts2);
        });

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> store = new HashMap<>();

        for (String[] log : logs) {
            String resource = log[2];
            Integer timestamp = Integer.valueOf(log[0]);

            if (!map.containsKey(resource)) {
                map.put(resource, timestamp);
            } else {
                Integer previousValue = map.get(resource);
                if (timestamp - previousValue <= 360) {
                    if (!store.containsKey(resource)) {
                        store.put(resource, 1);
                    } else {
                        store.replace(resource, store.get(resource) + 1);
                    }
                } else {
                    map.replace(resource, timestamp);
                }
            }
        }

        String maxResource = "";
        Integer maxFrequency = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : store.entrySet()) {
            if (maxFrequency < entry.getValue()) {
                maxFrequency = entry.getValue();
                maxResource = entry.getKey();
            }
        }
        return maxResource + ", " + maxFrequency;
    }


    @Test
    public void test1() {
        String[][] logs = {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_4", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_2"},
                {"54359", "user_1", "resource_3"},
        };

        //System.out.println(solution(logs));

        System.out.println(solution1(logs));

        //user_3:[53760,53760]
        //user_2:[54060,62314]
        //user_1:[54001,58523]
        //user_7:[400,400]
        //user_6:[2,215]
        //user_5:[53651,53651]
        //user_4:[58522,58522]
        //user_8:[100,100]

    }


    @Test
    public void test2() {
        String[][] logs = {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_4", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_2"},
                {"54359", "user_1", "resource_3"},
                {"200", "user_1", "resource_2"},
                {"250", "user_1", "resource_2"},
                {"260", "user_1", "resource_2"},
        };

        System.out.println(solution1(logs));
        //resource_2, 4


    }


}

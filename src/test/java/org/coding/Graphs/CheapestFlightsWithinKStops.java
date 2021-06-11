package org.coding.Graphs;

import org.junit.Test;

import java.util.*;

//https://www.youtube.com/watch?v=WA0Gp8hwXbg
public class CheapestFlightsWithinKStops {

    class TripInfo {
        int dest;
        int cost;
        int stops;

        public TripInfo(int dest, int cost, int stops) {
            this.dest = dest;
            this.cost = cost;
            this.stops = stops;
        }

    }

    Map<Integer, List<TripInfo>> tripMap;

    private void populateTripMap(int[][] flights, int stops) {
        tripMap = new HashMap<>();
        for (int[] flight : flights) {
            List<TripInfo> trips = tripMap.getOrDefault(flight[0], new ArrayList<>());
            trips.add(new TripInfo(flight[1], flight[2], stops));
            tripMap.put(flight[0], trips);
        }
    }

    //n cities connected by m flights
    //Each flight starts from city u and arrives at v with a price w
    //k max no. of stops
    private int solution(int n, int[][] flights, int src, int dest, int k) {
        populateTripMap(flights, k);

        //heap
        Queue<TripInfo> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        //setup BFS
        heap.addAll(tripMap.getOrDefault(src, Collections.EMPTY_LIST));

        //BFS
        while (!heap.isEmpty()) {
            TripInfo lowest = heap.poll();
            if (lowest.dest == dest) {
                return lowest.cost;
            }


        }

        return -1;
    }


    @Test
    public void test1() {
        int n = 3;
        int[][] edges = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };

        int src = 0;
        int dest = 2;
        int k = 1;

        System.out.println(solution(n, edges, src, dest, k));
        //output - 200
    }
}

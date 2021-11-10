package dynamicProgramming;

import javafx.util.Pair;

import java.util.*;

public class MinusTarget {
    public static void main(String[] args) {
        int[] intArray = new int[]{2, 3, 5, 2, 8, 6};
        int target = 3;
        List<Pair<Integer, Integer>> result = minusTarget2(intArray, 3);
        if (result == null) {
            System.out.println("no result found");
        }

        result.forEach(it -> {
            System.out.println("" + it.getKey() + it.getValue());
        });
    }

    private static List<Pair<Integer, Integer>> minusTarget(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Arrays.sort(arr);
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            j = Math.max(i + 1, j);
            while (j < arr.length && arr[j] - arr[i] < target) {
                j++;
            }

            if (j == arr.length) {
                break;
            }

            if (arr[j] - arr[i] == target) {
                result.add(new Pair<>(arr[j], arr[i]));
            }
        }

        return result;
    }

    private static List<Pair<Integer, Integer>> minusTarget2(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        List<Pair<Integer, Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target + arr[i])) {
                result.add(new Pair<>(arr[i], target + arr[i]));
            }

            if(map.containsKey(arr[i] - target)){
                result.add(new Pair<>(arr[i], arr[i] - target));
            }
            map.put(arr[i], i);
            map.put(-arr[i], i);
        }

        return result;
    }
}

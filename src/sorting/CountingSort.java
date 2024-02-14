package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CountingSort {
    public static int[] sort(int[] arr, int k) {
        return countSort(arr, k);
    }

    private static int[] countSort(int[] arr, int k){
        //create empty array for count and result
        int[] count = new int[k + 1]; //account for zero as minimum number
        int[] result = new int[arr.length];

        //initialize it to 0
        for (int i = 0; i < k + 1; i++) {
            count[i] = 0;
        }

        //add count of distinct values from arr to count
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        //add correct sum to count
        for (int i = 1; i < k + 1; i++) {
            count[i] += count [i-1];
        }

        //populate result array
        for (int i = arr.length - 1; i >= 0 ; i--) {
            result[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        generateList(list);
        int[] arr = countSort(list.stream().mapToInt(i -> i).toArray(), list.size());

        System.out.println(Arrays.toString(arr));
    }

    private static void generateList(ArrayList<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            Integer anInt = random.nextInt(0, 10);
            list.add(anInt);
        }
    }
}

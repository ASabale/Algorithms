package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        generateList(list);
        System.out.println(list);
        int[] arr = sort(list.stream().mapToInt(i -> i).toArray());
        System.out.println(Arrays.toString(arr));
    }

    private static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int key = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[key] > arr[j]){
                    key=j;
                }
            }
            swap(arr, key, i);
        }

        return arr;
    }

    private static void swap(int[] arr, int key, int i) {
        int temp = arr[key];
        arr[key] = arr[i];
        arr[i] = temp;
    }

    private static void generateList(ArrayList<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(0, 50));
        }
    }
}

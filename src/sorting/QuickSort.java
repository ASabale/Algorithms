package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        generateList(list, 100);
        System.out.println(list);
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr, int p, int r){
        if(p<r){
            int q = partition(arr, p, r);
            sort(arr,p, q-1);
            sort(arr,q+1, r);
        }

    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p-1;
        for (int j = p; j < r; j++) {
            if(arr[j]<=pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void generateList(ArrayList<Integer> list, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(0, n));
        }
    }
}

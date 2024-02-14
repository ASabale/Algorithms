package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        generateList(list);

        int[] list1 = sort(list.stream().mapToInt(i -> i).toArray());
        System.out.println(Arrays.toString(list1));
    }

    private static void generateList(ArrayList<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(0, 9999));
        }
    }

    private static int[] sort(int[] array) {
        int max = getMax(array);
        for (int exp = 1;max/exp > 0; exp *= 10) {
            countSort(array, array.length, exp);
        }
        return array;
    }

    private static int getMax(int[] array) { 
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i]>max){
                max = array[i];
            }
        }
        return max;
    }

    private static void countSort(int[] array, int length, int exp) {
        int[] count = new int[10];
        int[] result = new int[length];

        Arrays.fill(count, 0);

        for (int i = 0; i < length; i++) {
            count[(array[i]/exp)%10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        for (int i = length - 1; i >= 0 ; i--) {
            result[count[(array[i] / exp) % 10] -1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < length; i++) {
            array[i] = result[i];
        }
    }
}

package searching;

import sorting.CountingSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Select {
    public static void main(String[] args) {

        //create empty arraylist of integers
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        //populate arraylist randomly
        for (int i = 0; i < 104; i++) {
            Integer anInt = random.nextInt(0, 50);
            list.add(anInt);
        }

        System.out.println(list);

        // rank is the ith smallest element we want to find
        int rank = 50;

        //get the output
        int number = selectRank(list.stream().mapToInt(i -> i).toArray(),0, list.size()-1, rank);
        System.out.println(number);

        //verify output
        Collections.sort(list);
        System.out.println(list);
    }

    private static int selectRank(int[] list, int p, int r, int i) {
        //if only 1 number in list then return that number
        if(p>=r){
            return list[p];
        }

        //while list is not multiple of 5, move the smallest element to the left side and check if rank is one of them.
        while (((r - p + 1) % 5) != 0) {
            for (int j = p + 1; j <= r; j++) {
                if(list[j] < list[p]){
                    swap(list, p, j);
                }
            }
            if(i==1){
                return list[p];
            }
            p=p+1;
            i=i-1;
            }

        //find number of groups of 5
        int g = (r - p + 1) / 5;

        //sort all groups of 5
        for (int k = p; k < p + g; k++) {
            sortSublist(list, k, g);
        }

        //x is the median of median around which we need to partition the array
        int x = selectRank(list, p+(2*g), p+(3*g)-1, g/2);

        //q returns index of x after partition and moving smallest elements to the left side of pivot
        int q = partition(list, p, r, x);

        //total number of elements in new array
        int k = q - p + 1;

        // if rank is pivot then return pivot
        if(i==k){
            return list[q];
        }
        //if rank is in the lower half of array
        else if (i < k) {
            return selectRank(list, p, q - 1,i);
        }
        //if rank is in the upper half of array
        else return selectRank(list, q + 1, r, i - k);
        }

    private static void sortSublist(int[] list, int k, int g) {
        int[] arr = {list[k], list[k + g], list[k +(2* g)], list[k +(3* g)], list[k +(4* g)]};
        arr = CountingSort.sort(arr, 100);
        list[k] = arr[0];
        list[k + g] = arr[1];
        list[k +(2* g)] = arr[2];
        list[k +(3* g)] = arr[3];
        list[k +(4* g)] = arr[4];
    }

    private static int partition(int[] list, int p, int r, int x) {
        //find the pivot in array and move it to the end
        for (int i = p; i < r; i++) {
            if(list[i]==x){
                swap(list, r, i);
                break;
            }
        }

        //partition and move pivot to correct position
        int i = p-1;
        for (int j = p; j < r; j++) {
            if(list[j]<=x){
                i++;
                swap(list, i, j);
            }
        }
        i++;
        swap(list, i, r);
        return i; //return index of pivot
    }

    private static void swap(int[] list, int r, int i) {
        int temp = list[r];
        list[r] = list[i];
        list[i] = temp;
    }

}

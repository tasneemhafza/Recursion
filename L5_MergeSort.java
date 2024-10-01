package Recursion;

import java.util.Arrays;

public class L5_MergeSort {
    public static void main(String[] args) {
        int[] arr= {5,2,9,6,1,3};
        // arr = mergeSort(arr);
        // System.out.println(Arrays.toString(arr));

        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
        
    }

    static int[] mergeSort(int[] arr) {
        if(arr.length==1) {
            return arr;
        }
        int mid = arr.length/2;
        int[] left= mergeSort(Arrays.copyOfRange(arr, 0, mid)); //mid exclusive
        int[] right= mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int[] all= new int[first.length + second.length];

        int i=0, j=0, k=0;
        while(i<first.length && j<second.length) {
            if(first[i] < second[j]) {
                all[k] = first[i];
                i++;
            } else {
                all[k] = second[j];
                j++;
            }
            k++;
        }
        //when one array is completed while the other isn't
        while(i< first.length) {
            all[k] = first[i];
            i++; k++;
        }
        while(j< second.length) {
            all[k] = second[j];
            j++; k++;
        }
        return all;
    }

    static void mergeSortInPlace(int[] arr, int s, int e) {
        if(e-s==1) return;
        int mid= (s+e)/2;
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);
        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];
        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left half
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements from the right half
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // Copy the sorted elements back into the original array
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
}

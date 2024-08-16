package Recursion;

import java.util.Arrays;

public class L4_pattern {
    public static void main(String[] args) {
        triangle(4, 0);
        triangle2(5, 0);

        int[] arr= {3, 5, 6, 1 ,2};
        bubble(arr, arr.length-1, 0);
        System.out.println("\n"+Arrays.toString(arr));

        Selection(arr, arr.length-1, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void triangle(int r, int c) {
        if(r==0) return;
        if(c < r) {
            System.out.print("*");
            triangle(r, c+1);
        } else {
            System.out.println();
            triangle(r-1, 0);
        }
    }

    static void triangle2(int r, int c) {
        if(r==0) return;
        if(c < r) {
            triangle2(r, c+1);
            System.out.print("*");
        } else {
            triangle2(r-1, 0);
            System.out.println();
        }
    }

    static void bubble(int[] arr, int r, int c) {
        if(r==0) return;
        if(c < r) {
            if(arr[c] > arr[c+1]) {
                int temp= arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubble(arr, r, c+1);
        } else {
            bubble(arr, r-1, 0);
        }
    }

    static void Selection(int[] arr, int r, int c, int max) {
        if(r==0) return;
        if(c < r) {
            if(arr[c] > arr[max]) {
                Selection(arr, r, c+1, c);
            } else {
                Selection(arr, r, c+1, max);
            }
        } else {
            int temp= arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            Selection(arr, r-1, 0, 0);
        }
    }
}

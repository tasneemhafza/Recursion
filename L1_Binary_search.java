package Recursion;

public class L1_Binary_search {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 55, 66, 78};
        int target = 4;
        System.out.println(binary_search(arr, target, 0, arr.length - 1));
    }
    static int binary_search(int[] arr, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid= (start+end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return binary_search(arr, target, start, mid - 1);
        }
        return binary_search(arr, target, mid + 1, end);
    }
}

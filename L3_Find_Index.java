package Recursion;

import java.util.ArrayList;

public class L3_Find_Index {
    static boolean sorted(int[] arr, int index){
        if(index == arr.length-1){
            return true; //came to last element without false condition so its actually sorted
        }
        return arr[index] < arr[index+1] && sorted(arr, index+1);
    }

    static int findIndex(int[] arr, int target, int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return findIndex(arr, target, index+1);
    }

    static int findLastIndex(int[] arr, int target, int index){
        if(index == -1){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return findLastIndex(arr, target, index-1);
    }

    static ArrayList<Integer> l1= new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return;
        }
        if(arr[index] == target){
            l1.add(index);
        }
        findAllIndex(arr, target, index+1);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAllIndex2(arr, target, index+1, list);
    }

    static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex3(arr, target, index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }


    public static void main(String[] args) {
        int[] arr= {1,3,3,5,5,7,9};
        System.out.println(sorted(arr, 0));
        System.out.println(findIndex(arr, 5, 0));
        System.out.println(findLastIndex(arr, 7, arr.length-1));
        // findAllIndex(arr, 3, 0);
        // System.out.println(l1);

        // System.out.println(findAllIndex2(arr, 5, 0, new ArrayList<>()));
        // OR
        ArrayList<Integer> ans= findAllIndex2(arr, 5, 0, new ArrayList<>()); 
        System.out.println(ans);

        System.out.println(findAllIndex3(arr, 3, 0));
    }

    
}

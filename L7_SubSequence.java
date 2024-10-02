package Recursion;

import java.util.*;

public class L7_SubSequence {
    public static void main(String[] args) {
        System.out.println("Subsequence:-"); subSeq("", "abc");
        System.out.println("Subsequence with return: " + subSeqReturn("", "abc"));
        System.out.println("Subsequence with ascii value:-"); subSeqAscii("", "abc");
        System.out.println("Subsequence with Ascii Return: " + subSeqAsciiReturn("", "abc"));

        int[] arr= {1, 2, 3};
        List<List<Integer>> ans= subsetIterative(arr);
        for(List<Integer> list: ans) {
            System.err.println(list);
        }
        System.out.println();
        int[] arr2= {1, 2, 2};
        List<List<Integer>> ans2= subsetDuplicate(arr2);
        for(List<Integer> list: ans2) {
            System.err.println(list);
        }
    }

    static void subSeq(String processed, String unprocessed) {
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return; 
        }
        char ch= unprocessed.charAt(0);

        subSeq(processed + ch, unprocessed.substring(1)); //considering the character
        subSeq(processed, unprocessed.substring(1)); //not considering the character
    }

    static ArrayList<String> subSeqReturn(String processed, String unprocessed) {
        if(unprocessed.isEmpty()){
            ArrayList<String> list= new ArrayList<>();
            list.add(processed);
            return list; 
        }
        char ch= unprocessed.charAt(0);

        ArrayList<String> left= subSeqReturn(processed + ch, unprocessed.substring(1)); //considering the character
        ArrayList<String> right= subSeqReturn(processed, unprocessed.substring(1)); //not considering the character
        left.addAll(right);
        
        return left;
    }

    static void subSeqAscii(String processed, String unprocessed) {
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return; 
        }
        char ch= unprocessed.charAt(0);

        subSeqAscii(processed + ch, unprocessed.substring(1)); //considering the character
        subSeqAscii(processed, unprocessed.substring(1)); //not considering the character
        subSeqAscii(processed + (ch+0), unprocessed.substring(1)); //ch+0 returns ascii value
    }

    static ArrayList<String> subSeqAsciiReturn(String processed, String unprocessed) {
        if(unprocessed.isEmpty()){
            ArrayList<String> list= new ArrayList<>();
            list.add(processed);
            return list; 
        }
        char ch= unprocessed.charAt(0);

        ArrayList<String> first= subSeqAsciiReturn(processed + ch, unprocessed.substring(1)); //considering the character
        ArrayList<String> second= subSeqAsciiReturn(processed, unprocessed.substring(1)); //not considering the character
        ArrayList<String> third= subSeqAsciiReturn(processed + (ch+0), unprocessed.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }

    static List<List<Integer>> subsetIterative(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr) {
            int n= outer.size();
            for(int i=0; i<n; i++) {
                List<Integer> internal= new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0, end=0; 
        for(int i=0; i<arr.length; i++) {
            start=0;
            if(i>0 && arr[i]==arr[i-1]) {
                start= end+1;
            }
            end= outer.size()-1;
            int n= outer.size();
            for(int j=start; j<n; j++) {
                List<Integer> internal= new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}

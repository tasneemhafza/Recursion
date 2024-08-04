package Recursion;

public class L2_factorial {
    public static void main(String[] args) {
        int ans= fact(5);
        int ans2= sum(4);
        System.out.println(ans);
        System.out.println(ans2);
    }

    static int fact(int n){
        if(n<=1){
            return 1;
        }
        return n * fact(n-1);
    }

    static int sum(int n){
        if(n<=1){
            return 1;
        }
        return n + fact(n-1);
    }
}

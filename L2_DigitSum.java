package Recursion;

public class L2_DigitSum {
    public static void main(String[] args) {
        int ans= sum(1234); //10
        System.out.println(ans);
        int ans2= product(255); //50
        System.out.println(ans2);
    }

    static int sum(int n){
        if(n==0){
            return 0;
        }
        return (n%10) + sum(n/10);
    }

    static int product(int n){
        if(n%10==n){ //only one digit
            return n;
        }
        return (n%10) * product(n/10);
    }
}

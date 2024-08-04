package Recursion;

public class L2_Reverse {

    //1st method
    static int sum=0;
    static void rev(int n){
        if (n==0){
            return;
        }
        int rem= n%10;
        sum = sum*10 + rem;
        rev(n/10);
    }

    //2nd method
    static int rev2(int n){
        int digits= (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }
    static int helper(int n, int digit){
        if(n%10 == 0){
            return n;
        }
        int rem2= n%10;
        return rem2*(int)Math.pow(10, digit-1) + helper(n/10, --digit); //digit-1==--digit
    }

    static boolean isPalin(int n){
        return n==rev2(n);
    }

    public static void main(String[] args) {
        rev(2468);
        System.out.println(sum);
        System.out.println(rev2(5432));
        System.out.println(isPalin(3553));
    }
}

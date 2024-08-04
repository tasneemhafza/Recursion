package Recursion;

public class L2_Nto1 {
    public static void main(String[] args) {
        // fun(5);
        // funRev(5);
        // both(5);
        concept(5);
    }
    static void funRev(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        funRev(n-1);
    }

    static void fun(int n){
        if(n==0){
            return;
        }
        fun(n-1);
        System.out.println(n);
    }

    static void both(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        both(n-1);
        System.out.println(n);
    }

    //concept-->similar to funrev()
    static void concept(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        // concept(n--);  //-->this will alway give eg.5 first... base condition will never be met therefore infinite time calls
        concept(--n);  //-->first -- so eg. 5-1=4 ...base condition will 
    }
}

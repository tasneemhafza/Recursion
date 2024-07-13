package Recursion;

public class L1_Recursion_Basics {
    public static void main(String[] args) {
        // print1(1);
        print(1);
        print_rev(10);
    }
    static void print(int n){
        if(n==10){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n+1);
    }
    static void print_rev(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print_rev(n-1);
    }

    // static void print1(int n){
    //     System.out.println(n);
    //     print2(2);
    // }
    // static void print2(int n){
    //     System.out.println(n);
    //     print3(3);
    // }
    // static void print3(int n){
    //     System.out.println(n);
    //     print4(4);
    // }
    // static void print4(int n){
    //     System.out.println(n);
    //     print5(5);
    // }
    // static void print5(int n){
    //     System.out.println(n);
    // }
}

package Recursion;

public class L7_Skipping {
    public static void main(String[] args) {
        skip1("", "banana");
        System.out.println(skip2("apple"));
        System.out.println(skip3("baappleappcat"));
        System.out.println(skip4("baapplappcat"));
    }

    static void skip1(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch= up.charAt(0);
        if(ch=='a') {
            skip1(p, up.substring(1));
        }
        else {
            skip1(p+ch, up.substring(1));
        }
    }
// without updating or passing p string
    static String skip2(String up) {
        if(up.isEmpty()) {
            return "";
        }
        char ch= up.charAt(0);
        if(ch=='a') {
            return skip2(up.substring(1));
        }
        else {
            return ch + skip2(up.substring(1));
        }
    } 

// skip apple 
    static String skip3(String up) {
        if(up.isEmpty()) {
            return "";
        }
        if(up.startsWith("apple")) {
            return skip3(up.substring(5));
        }
        else {
            return up.charAt(0) + skip3(up.substring(1));
        }
    } 

// skip app if its not apple
    static String skip4(String up) {
        if(up.isEmpty()) {
            return "";
        }
        if(up.startsWith("app") && !up.startsWith("apple")) {
            return skip4(up.substring(3));
        }
        else {
            return up.charAt(0) + skip4(up.substring(1));
        }
    } 


}

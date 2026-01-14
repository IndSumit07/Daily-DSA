package Monu_Bhaiya.Recursion;

public class Fabonacci {
    public static void main(String[] args) {
        System.out.println(fab(6));
    }
    public static int fab(int n){
        if(n<=1) return n;
        return fab(n-1)+fab(n-2);
    }
}

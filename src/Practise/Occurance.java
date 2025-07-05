package Practise;

public class Occurance {
    public static void main(String[] args) {
        System.out.println(returnNumber());
    }
    public static int returnNumber(){
        int a,b;
        int l = 2;
        int m = 4;
        if (l>m){
            b=l;
            a = m;
        }else{
            a=l;
            b=m;
        }
        int n = 10;
        int count = 0;
        if (a+b>10){
            return 0;
        }
        int sum = a;
        while (sum<=n){
            count++;
            sum +=b;
        }
        return count;

    }
}

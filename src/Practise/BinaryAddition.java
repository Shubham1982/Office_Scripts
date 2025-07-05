package Practise;

public class BinaryAddition {
    static int carry = 0;
    public static void main(String[] args) {
        String s1 = "1010";
        String s2 = "1011";
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int count1 = 0;
        int count2 = 0;
        int res = 0;
        int res1= 0;
        while(a > 0){
            if(a%10==1){
                res = (int)Math.pow(2, count1) + res;
            }
            a /= 10;
            count1++;
        }
        while(b > 0){
            if(b%10==1){
                res1 = (int)Math.pow(2, count2) + res1;
            }
            b /= 10;
            count2++;
        }
        int result = res + res1;
        System.out.println(result);
        String returnValue = "";
        if(result == 0){
            returnValue = "0";
        }
        while(result>0){
            returnValue = (result % 2) + returnValue;
            result /=2;
        }
        System.out.println(returnValue);

    }
}

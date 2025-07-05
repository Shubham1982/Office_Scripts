import java.util.ArrayList;

public class MostlyRecurringNumber {

    public static int findNum;

    public static void main(String[] args){

        int []arr = {1,3,3,3,3,2,2,2,4,4};

        int max = maxReturn(arr);

        int min = max;
        min=  minReturn(arr,min);
        System.out.println("minimum: "+min);

        int []arr2 = new int[max + 1];

        for(int i=0;i<arr.length;i++){
            arr2[arr[i]] += 1;
        }

        maxReturn(arr2);
        System.out.println("Mostly Recurring Number is: " + findNum);
    }
    public static int maxReturn(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                findNum = i;
            }
        }
        return max;
    }
    public static int minReturn(int[] arr, int min){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}

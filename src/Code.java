public class Code {
    public static void main(String[] args) {

        int num[] = {1,1,0,0,1,0};
        int temp []= new int[num.length];
        int count = 0;
        int count1 = 0;

        for(int i = 0; i< num.length; i++){
            if (num[i]==0){
                temp[count]=0;
                count++;
            }
            else{
                temp[num.length-count1-1]= 1;
                count1++;
            }

        }
        for (int i = 0; i< num.length; i++){
            System.out.println(temp[i]);
        }
    }
}

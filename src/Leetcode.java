import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Leetcode {
    public static void main(String [] args) {

        int[] ints = {13,11,10,9,12};
        List<Integer> list = Arrays.stream(ints).boxed().sorted().collect(Collectors.toList());
        Integer first = list.get(0);
        Integer last = list.get(list.size()-1);
        Integer size= list.size();
        int count = 1;
        for(int i = 1; i<=size; i++){
            Integer binary = list.get(i-1);
            if ((first&binary)==binary){
                first++;
                count++;
                continue;
            }
            else {
                System.out.println("result ="+first);
            }

        }
//        System.out.println(count);

    }
}
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Valids {
    public static void main(String[] args) {
        String toBeChecked = "Chlorpyriphos 20% EC";
        String[] toBeCheckedValues = toBeChecked.split(",");
        List<String> toBeCheckedList = Arrays.asList(toBeCheckedValues);
        Set<String> validationValuesSet = new HashSet<>();

        validationValuesSet.add("Chlorpyriphos 20% EC");
        boolean value = validationValuesSet.containsAll(toBeCheckedList);
        System.out.println(value);

//        System.out.println(System.currentTimeMillis());
//
//        String id = "134345";
//
//        String appOrderId = Long.toString(System.currentTimeMillis());
//        if (id != null) {
//            appOrderId = id + "-" + appOrderId;
//        }
//
//        if (appOrderId.length() >= 16) {
//            appOrderId = appOrderId.substring(0, 16);
//        }
//        System.out.println(appOrderId);;

    }

}

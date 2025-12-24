package Practise;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RearrangeStringCompare {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Map<Character, Long> sCharMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
        Map<Character, Long> tCharMap = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
        boolean isEqual = true;
        for (Map.Entry<Character, Long> entry : sCharMap.entrySet()) {
            if (!entry.getValue().equals(tCharMap.get(entry.getKey()))) {
                isEqual = false;
                break;
            }
        }
        System.out.println(sCharMap);
        System.out.println(tCharMap);
        System.out.println(isEqual);
    }
}

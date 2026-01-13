package Practice_OOPS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class javaCollections {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.remove(Integer.valueOf(1));
        Collections.sort(numbers);
        System.out.println(numbers.get(0));
        System.out.println("Hello, World!");
        System.out.println("Hello, World!");
    }
}
//consoling the applcation is the very immportant thing is the ver
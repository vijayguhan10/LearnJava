import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaCollectionsDemo {

    public static void main(String[] args) {

        // ===============================
        // 1️⃣ ARRAYLIST
        // ===============================
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);

        System.out.println("ArrayList element at index 1: " + list.get(1));

        list.set(2, 40);
        list.remove(0);

        System.out.println("List contains 20: " + list.contains(20));
        System.out.println("ArrayList: " + list);

        System.out.print("Iterating ArrayList: ");
        for (int it : list) {
            System.out.print(it + " ");
        }
        System.out.println();


        // ===============================
        // 2️⃣ HASHSET
        // ===============================
        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);

        System.out.println("HashSet contains 30: " + set.contains(30));

        set.remove(10);
        System.out.println("HashSet: " + set);


        // ===============================
        // 3️⃣ HASHMAP
        // ===============================
        Map<String, Integer> map = new HashMap<>();

        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Orange", 2);
        map.put("Apple", 10);

        System.out.println("Apple count: " + map.get("Apple"));
        System.out.println("Mango count: " + map.getOrDefault("Mango", 0));

        System.out.println("Iterating using entrySet:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Iterating using keySet:");
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.println("Iterating using values:");
        for (int value : map.values()) {
            System.out.println(value);
        }


        // ===============================
        // 4️⃣ COLLECTIONS ALGORITHMS
        // ===============================
        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        Collections.reverse(list);
        System.out.println("Reversed List: " + list);

        Collections.shuffle(list);
        System.out.println("Shuffled List: " + list);

        System.out.println("Min element: " + Collections.min(list));
        System.out.println("Max element: " + Collections.max(list));
        System.out.println("Frequency of 20: " + Collections.frequency(list, 20));


        // ===============================
        // 5️⃣ ITERATOR (SAFE REMOVAL)
        // ===============================
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value == 20) {
                iterator.remove();
            }
        }

        System.out.println("List after iterator removal: " + list);


        // ===============================
        // 6️⃣ ARRAYS INBUILTS & ALGORITHMS
        // ===============================
        int[] arr = {5, 2, 9, 1, 5, 6};

        // print array
        System.out.println("Original Array: " + Arrays.toString(arr));

        // sort array
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // binary search (array MUST be sorted)
        int index = Arrays.binarySearch(arr, 5);
        System.out.println("Index of 5: " + index);

        // copy array
        int[] copiedArr = Arrays.copyOf(arr, arr.length);
        System.out.println("Copied Array: " + Arrays.toString(copiedArr));

        // compare arrays
        System.out.println("Arrays equal: " + Arrays.equals(arr, copiedArr));

        // fill array
        int[] filledArr = new int[5];
        Arrays.fill(filledArr, 7);
        System.out.println("Filled Array: " + Arrays.toString(filledArr));

        // array to list (fixed-size list)
        List<Integer> arrayToList = Arrays.asList(1, 2, 3, 4);
        System.out.println("Array to List: " + arrayToList);
    }
}

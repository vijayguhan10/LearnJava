import java.util.*;
import java.util.stream.*;

public class JavaAlgorithmsMustUse {

    public static void main(String[] args) {

        /* =========================
           1️⃣ ARRAY ALGORITHMS
           ========================= */
        int[] arr = {5, 2, 9, 1, 5, 6};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));  
        // [1, 2, 5, 5, 6, 9]

        System.out.println(Arrays.binarySearch(arr, 5));  
        // 2 (index of searched element)

        Arrays.fill(arr, 0);
        System.out.println(Arrays.toString(arr));  
        // [0, 0, 0, 0, 0, 0]

        int[] copiedArr = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(copiedArr));  
        // [0, 0, 0]


        /* =========================
           2️⃣ COLLECTION ALGORITHMS
           ========================= */
        List<Integer> list = new ArrayList<>(List.of(5, 1, 3, 2, 4));

        Collections.sort(list);
        System.out.println(list);  
        // [1, 2, 3, 4, 5]

        Collections.reverse(list);
        System.out.println(list);  
        // [5, 4, 3, 2, 1]

        System.out.println(Collections.max(list));  
        // 5

        System.out.println(Collections.min(list));  
        // 1

        System.out.println(Collections.frequency(list, 2));  
        // 1

        Collections.shuffle(list);
        System.out.println(list);  
        // random order


        /* =========================
           3️⃣ STREAMS API (MOST USED)
           ========================= */
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> evenNums =
                nums.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
        System.out.println(evenNums);  
        // [2, 4, 6]

        List<Integer> squared =
                nums.stream()
                    .map(n -> n * n)
                    .collect(Collectors.toList());
        System.out.println(squared);  
        // [1, 4, 9, 16, 25, 36]

        int sum =
                nums.stream()
                    .reduce(0, Integer::sum);
        System.out.println(sum);  
        // 21

        int max =
                nums.stream()
                    .max(Integer::compare)
                    .get();
        System.out.println(max);  
        // 6

        boolean hasEven =
                nums.stream()
                    .anyMatch(n -> n % 2 == 0);
        System.out.println(hasEven);  
        // true

        List<Integer> sortedDesc =
                nums.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        System.out.println(sortedDesc);  
        // [6, 5, 4, 3, 2, 1]
    }
}

import java.util.*;

public class JavaCollectionsDemo {

    public static void main(String[] args) {

        /* =======================
           1️⃣ ARRAYLIST
           ======================= */
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);           // [10, 20, 30]

        list.add(1, 15);
        System.out.println(list);           // [10, 15, 20, 30]

        System.out.println(list.get(2));    // 20

        list.set(2, 25);
        System.out.println(list);           // [10, 15, 25, 30]

        list.remove(1);
        System.out.println(list);           // [10, 25, 30]

        System.out.println(list.contains(25)); // true
        System.out.println(list.size());       // 3


        /* =======================
           2️⃣ HASHSET
           ======================= */
        HashSet<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(10);                         // duplicate ignored
        System.out.println(set);             // [10, 20] (order not guaranteed)

        System.out.println(set.contains(20)); // true

        set.remove(10);
        System.out.println(set);             // [20]

        System.out.println(set.size());      // 1


        /* =======================
           3️⃣ HASHMAP
           ======================= */
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println(map);             // {1=One, 2=Two, 3=Three}

        map.put(2, "TWO");                   // overwrite value
        System.out.println(map);             // {1=One, 2=TWO, 3=Three}

        System.out.println(map.get(1));      // One
        System.out.println(map.containsKey(3)); // true
        System.out.println(map.containsValue("Two")); // false

        map.remove(3);
        System.out.println(map);             // {1=One, 2=TWO}

        System.out.println(map.keySet());    // [1, 2]
        System.out.println(map.values());    // [One, TWO]
        System.out.println(map.size());      // 2


        /* =======================
           4️⃣ QUEUE (FIFO)
           ======================= */
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue);           // [10, 20, 30]

        System.out.println(queue.peek());    // 10

        System.out.println(queue.poll());    // 10
        System.out.println(queue);           // [20, 30]

        System.out.println(queue.isEmpty()); // false


        /* =======================
           5️⃣ STACK (LIFO)
           ======================= */
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);            // [10, 20, 30]

        System.out.println(stack.peek());     // 30

        System.out.println(stack.pop());      // 30
        System.out.println(stack);            // [10, 20]

        System.out.println(stack.isEmpty());  // false
        System.out.println(stack.search(10)); // 2 (position from top)
    }
}

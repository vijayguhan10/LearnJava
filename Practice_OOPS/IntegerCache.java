package Practice_OOPS;

import java.lang.reflect.Field;

public class IntegerCache {

    public static void main(String[] args) throws Exception {

        // Load the private inner class Integer$IntegerCache
        Class<?> cacheClass =
                Class.forName("java.lang.Integer$IntegerCache");

        // Access the private static field "cache"
        Field cacheField = cacheClass.getDeclaredField("cache");
        cacheField.setAccessible(true);

        // Get the cache array (static field → null instance)
        Integer[] cache = (Integer[]) cacheField.get(null);

        System.out.println("Total cached Integer objects: " + cache.length);
        System.out.println("Cached values:\n");

        for (Integer i : cache) {
            System.out.println(
                    "Value = " + i +
                            ", identityHashCode = " + System.identityHashCode(i));
        }
    }
}

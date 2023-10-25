package Task1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        int[] valuesTest = {0, 1, 2, 3, 4, 5};
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("Empty: " + list.isEmpty());
        System.out.println("Add values: " + valuesTest[1] + ", " + valuesTest[2] + ", " + valuesTest[1]);
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println("Empty: " + list.isEmpty());
        System.out.println("Array: " + Arrays.toString(list.toArray()));
        System.out.println("Size: " + list.size());
        System.out.println("Get value index " + valuesTest[0] + ": " + list.get(valuesTest[0]));
        list.set(valuesTest[2], valuesTest[3]);
        System.out.println("Array after set value " + valuesTest[3] + " in index " + valuesTest[2] + ": " + Arrays.toString(list.toArray()));
        list.add(valuesTest[2], valuesTest[5]);
        System.out.println("Array after add value " + valuesTest[5] + " in index " + valuesTest[2] + ": " + Arrays.toString(list.toArray()));
        System.out.println("Array remove in index " + valuesTest[2] + " and return value it: " + list.remove(valuesTest[2]));
        System.out.println("Last index of value " + valuesTest[1] + ": " + list.lastIndexOf(valuesTest[1]));
        System.out.println("Contain value " + valuesTest[0] + ": " + list.lastIndexOf(valuesTest[0]));
        list.sort(Comparator.comparingInt(o -> o));
        System.out.println("Sort: " + Arrays.toString(list.toArray()));
        list.clear();

    }
}

package JavaConcepts.Collections;

import java.util.*;

public class CollectionClass {
    public static void main(String args[]) {
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        ArrayList<Integer> l1 = new ArrayList<>(l);
        ArrayList<String> l2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        LinkedList ll = new LinkedList<>(Arrays.asList("l", "i", "n", "c", "k"));
        System.out.println("List: " + l);
        System.out.println("ArrayList: " + l1);
        System.out.println("ArrayList of Strings: " + l2);
        System.out.println("LinkedList: " + ll);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(3, "Three");
        map.put(2, "Two");
        map.put(4,"four");

        Map<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(1, "One1");
        map1.put(3, "Three3");
        map1.put(2, "Two2");
        map1.put(4, "four");


        Map<Integer, String> map2 = new TreeMap<>();
        map2.put(1,"Tone");
        map2.put(3,"TThree");
        map2.put(2,"TTwo");
        System.out.println("HashMap: " + map);
        System.out.println("LinkedHashMap: " + map1);
        System.out.println("TreeMap: " + map2);

        Set<Integer> s = new HashSet<>(Arrays.asList(1,3,4,5,2));
        Set<Integer> s1 = new LinkedHashSet<>(Arrays.asList(1,3,4,5,2));
        Set<Integer> s2 = new TreeSet<>(Arrays.asList(1,3,4,5,2));
        System.out.println("HashSet: " + s);
        System.out.println("LinkedHashSet: " + s1);
        System.out.println("TreeSet: " + s2);

        // looping of collections

        //1.loop list using for loop
        for (Integer i : l1) {
            System.out.print(i + " ");
        }

        //2.loop list using for each
        l1.forEach(i-> System.out.println(i*i));

        //3.loop list using iterator
        Iterator<Integer> itr = l1.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        // looping over set
        for (Integer set: s1) {
            System.out.print(set + " ");
        }

        s1.forEach(x->System.out.println(x*x));

        Iterator<Integer> itr1 = s1.iterator();
        while(itr1.hasNext()) {
            System.out.print(itr1.next() + " ");

        }

        // looping over map

        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.print("[Key:" + entry.getKey() + ", Value:" + entry.getValue() + "] ");
        }

        map.forEach((key,value)-> System.out.println("key " + key + " value: " + value));

        Iterator<Map.Entry<Integer, String>> itr2 = map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Integer, String> entry = itr2.next();
            System.out.print("[Key:" + entry.getKey() + ", Value:" + entry.getValue() + "] ");
        }
    }

}

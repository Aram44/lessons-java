package collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Examples {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        List arrayList2 = List.copyOf(arrayList);
        List arrayList3 = List.of(arrayList1);
        List arrayList4 = List.of(1, 2, 3);

        List linkedList = new LinkedList();

        Set set = new HashSet();
        Set linkedHashSet = new LinkedHashSet();
        Set treeSet = new TreeSet();

        Map map = new HashMap();
        Map linkedHashMap = new LinkedHashMap();
        Map treeMap = new LinkedHashMap();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(list);
        copyOnWriteArrayList.get(0);
        Set copyOnWriteArraySet = new CopyOnWriteArraySet();
        List syncList = Collections.synchronizedList(list);
        Set syncSet = Collections.synchronizedSet(set);
        Map syncMap = Collections.synchronizedMap(map);
        Map cuncurrentHashMap = new ConcurrentHashMap();
    }
}

package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparableExample implements Comparable<ComparableExample> {
    private String name;

    public ComparableExample(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ComparableExample o) {
        return name.length() - o.name.length();
    }

    public static void main(String[] args) {
        ComparableExample o1 = new ComparableExample("Bro");
        ComparableExample o2 = new ComparableExample("Araaa");
        List<ComparableExample> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        Collections.sort(list);
        System.out.println(list);
    }

    public String getName() {
        return name;
    }
}

package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample implements Comparator<Examples> {
    @Override
    public int compare(Examples o1, Examples o2) {
        return o1.hashCode() - o2.hashCode();
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        Examples examples = new Examples();
        Examples examples1 = new Examples();
        list.add(examples);
        list.add(examples1);

        Collections.sort(list, new ComparatorExample());
    }
}

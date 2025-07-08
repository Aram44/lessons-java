package collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapAndTreads extends Thread {

//    static Map<Integer, String> map = new HashMap<>(); // will receive ConcurrentModificationException
//    map.put(null, null); accepted
//    static Map<Integer, String> map = new ConcurrentHashMap<>();
    static Hashtable map = new Hashtable<>();

    public void run(){
        try{
            Thread.sleep(1000);
            map.put(5, "1");
//            map.put(null, null); // Null pointer exception
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        map.put(1, "2");
        map.put(2, "3");
        map.put(4, "5");
        HashMapAndTreads mapAndTreads = new HashMapAndTreads();
        mapAndTreads.start();

        for (Object o : map.entrySet()) {
            System.out.println(o);
            Thread.sleep(1000);
        }
        System.out.println(map);
    }
}

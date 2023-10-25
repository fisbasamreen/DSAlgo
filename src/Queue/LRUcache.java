package src.Queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/*
This LRUCache class uses a doubly linked list to maintain the order of accessed items, and a hash map to efficiently retrieve items by key.
The get and put operations are both designed to run in O(1) time complexity.
 */
public class LRUcache {
    Deque<Integer> doublyQueue = new LinkedList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    private final int CACHE_SIZE;

    public LRUcache(int capacity) {
        CACHE_SIZE = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (doublyQueue.size() == CACHE_SIZE) {
                int last = doublyQueue.removeLast();
                map.remove(last);
            }
        }
        else {/* The found page may not be always the last element, even if it's an
               intermediate element that needs to be removed and added to the start
               of the Queue */
            doublyQueue.remove(key);
        }
        doublyQueue.push(key);
        map.put(key, value);
    }

    public void display() {
        Iterator<Integer> itr = doublyQueue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args) {
        LRUcache cache = new LRUcache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));

        System.out.println(" ");
        cache.display();

        cache.put(2,8);
        System.out.println(" ");
        cache.display();

        System.out.println(" ");

        cache.put(4,4);
        cache.display();

    }
}

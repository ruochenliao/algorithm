package data.structure;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, ListNode<Integer>> map;
    private int size;
    private int capacity;
    private ListNode<Integer> header;
    private ListNode<Integer> tailer;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        header = new ListNode<>();
        tailer = new ListNode<>();
        header.next = tailer;
        tailer.prev = header;
        map = new HashMap<>();
    }

    int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode<Integer> target = map.get(key);
        removeNode(target);
        attachToHeader(target);
        return map.get(key).value;
    }


    void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode<Integer> target = map.get(key);
            target.value = value;
            removeNode(target);
            attachToHeader(target);
            return;
        }

        ListNode<Integer> target = new ListNode<>();
        target.key = key;
        target.value = value;
        map.put(key, target);
        attachToHeader(target);
        size++;
        if (size > capacity) {
            map.remove(tailer.prev.key);
            removeNode(tailer.prev);
            size--;
        }
    }

    private void attachToHeader(ListNode<Integer> target) {
        target.prev = header;
        target.next = header.next;
        header.next.prev = target;
        header.next = target;
    }

    private void removeNode(ListNode<Integer> target) {
        target.prev.next = target.next;
        target.next.prev = target.prev;
        target.prev = null;
        target.next = null;
    }

    class ListNode<T> {
        T key;
        T value;
        ListNode<T> prev;
        ListNode<T> next;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        //test case 1
        lruCache.put(1,1);
        lruCache.put(2,2);
        int result1 = lruCache.get(1);
        lruCache.put(3,3);
        int result2 = lruCache.get(2);
        lruCache.put(4,4);
        int result3 = lruCache.get(3);
        int result4 = lruCache.get(4);
        System.out.println("result1 " + result1);
        System.out.println("result2 " + result2);
        System.out.println("result3 " + result3);
        System.out.println("result4 " + result4);
        System.out.println();
        //test case 2
        LRUCache lruCache1 = new LRUCache(2);
        lruCache1.put(2,1);
        lruCache1.put(1,1);
        lruCache1.put(2,3);
        lruCache1.put(4,1);
        System.out.println(lruCache1.get(1));
        System.out.println(lruCache1.get(2));
    }
}

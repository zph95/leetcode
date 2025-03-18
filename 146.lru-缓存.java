/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final LinkedHashSet<Integer> order;
    private int cacheMisses;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new LinkedHashSet<>();
        this.cacheMisses = 0;
        
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            cacheMisses++;
            return -1;
        }
        // Update order
        order.remove(key);
        order.add(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            order.remove(key);
        } else {
            if (cache.size() == capacity) {
                // Evict the least recently used item
                int lru = order.iterator().next();
                order.remove(lru);
                cache.remove(lru);
            }
            cacheMisses++;
        }
        cache.put(key, value);
        order.add(key);
    }


    public int getCacheMisses() {
        return cacheMisses;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end



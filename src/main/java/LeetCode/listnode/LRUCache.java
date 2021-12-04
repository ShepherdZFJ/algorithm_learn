package LeetCode.listnode;

import java.util.LinkedHashMap;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2021/11/24 15:17
 */

/**
 * 实现LRU缓存淘汰策略： LRU（Least Recently Used）：也就是说我们认为最近使用过的数据应该是是「有用的」，
 * 很久都没用过的数据应该是无用的，内存满了就优先删那些很久没用过的数据
 */
public class LRUCache {

    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
        return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
        // 修改 key 的值
        cache.put(key, val);
        // 将 key 变为最近使用
        makeRecently(key);
        return;
        }
        if (cache.size() >= this.cap) {
        // 链表头部就是最久未使用的 key
        int oldestKey = cache.keySet().iterator().next();
        cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}


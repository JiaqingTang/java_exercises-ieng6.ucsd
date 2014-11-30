package lru;

import java.util.HashMap;

public class LRUCache {
	class DListNode{
        DListNode(int k, int v){
            key = k;
            val = v;
        }
        private int key;
        private int val;
        private DListNode pre;
        private DListNode next;
    }
    
    class DList{
        private DListNode head;
        private DListNode tail;
        private int size;
        DList(){
            head = new DListNode(0,0);
            tail = new DListNode(0,0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }
        public void insertFront(DListNode node){
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }
        public void removeNode(DListNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        public void removeTail(){
            tail.pre = tail.pre.pre;
            tail.pre.next = tail; 
        }
        public int getSize(){
            return size;
        }
        
    }
    private int cap;
    private HashMap<Integer, DListNode> map;
    private DList list;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, DListNode>();
        list = new DList();
    }
    
    public int get(int key) {
        int val = -1;
        if(map.containsKey(key)){
            DListNode node = map.get(key);
            val = node.val;
            list.removeNode(node);
            list.insertFront(node);
        }
        return val;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DListNode node = map.get(key);
            node.val = value;
            list.removeNode(node);
            list.insertFront(node);
        }
        else{
            DListNode node = new DListNode(key, value);
            map.put(key, node);
            int size = list.getSize();
            if(size >= cap){
                list.removeTail();
            }
            list.insertFront(node);
            size++;
        }
    }
    
    public static void main(String[] args){
    	LRUCache l = new LRUCache(1);
    	l.set(2, 1);
    	l.set(3,2);
    }
}
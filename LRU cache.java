//main idea is use a double linked list to store the frequency of the usage
//And use a another hashmap to store whether it has been store or delete
public class LRUCache{
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    //Two node used to construct a double linkedlist
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity){
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key){
        if(!hs.containsKey(key)){
            return -1;
        }
        //if hs has this key, then remove this key from hs and name it current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        //Move current to tail  the tail has been attached many recently used nodes
        move_to_tail(current);

        return hs.get(key).value;

    }

    public void set(int key, int value){
        if(get(key) != -1){
            hs.get(key).value = value;
            return;
        }
        //if the hash table have fulled
        if(hs.size() == capacity){
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current){
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }



}
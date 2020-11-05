package Week_10_assignment;

import java.util.Scanner;

public class orderedBinaryST<Key extends Comparable<Key>, Value> {
	//BST의 root
	private Node root;
	
	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		//노드의 서브트리 수
		private int size;			
	
	public Node(Key key, Value val, int size) {
		this.key = key;
		this.val = val;
		this.size = size;
		}
	}
	
	//1. rank
	public int rank(Key key) {
        return rank(key, root);
    } 
	
    // 키보다 작은 서브트리 내의 노드 수
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    }
    
    //2. get
    public Value get(Key key) {
        return get(root, key);
    }
    
    //get : compareTo 이용하여 구현
    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    
    //3. delete
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 
    
    //3-1. 최소 값 찾기
    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    
    //3-2. 최소 값 삭제
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    //4. put
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    
	//root Node의 size return
	public int size() {
        return size(root);
    }

    // Node X의 size return
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
    
    //5. floor
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 
    
    //6. ceiling
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    }
    
    //중위 순회 출력
    public void printInorder(Node node) {
    	if(node == null) return;
    	
    	printInorder(node.left);
    	System.out.print(node.key + " ");
    	printInorder(node.right);
    }
    
    public static void  main(String[] args) {
    	orderedBinaryST<String, Integer> st = new orderedBinaryST<String,Integer>();
    	Scanner scan= new Scanner(System.in);
    	int value = 1;
    	
    	while(true) {
    		String key = scan.next();
    		if(key.equals("exit")) break;
    		st.put(key, value);
    		value ++;
    	}
    	
    	st.printInorder(st.root);
    }
}

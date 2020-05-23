package Utils;


public class ListNode<T> {
    public T key;
    public T val;
    public ListNode(){}
    public ListNode(T val){
        this.val = val;
    }
    public ListNode<T> prev;
    public ListNode<T> next;
}

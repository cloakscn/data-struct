//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
//
// Related Topics 设计 链表 👍 597 👎 0


package cn;

import java.util.ArrayList;

/**
 * @author cloaks
 * @questionId 707
 * @title 设计链表
 * @titleSlug design-linked-list
 * @date 2022-09-23 11:25:43
 */
public class Code707DesignLinkedList {
    public static void main(String[] args) {
        System.out.println("hello world!");
        MyLinkedList solution = new Code707DesignLinkedList().new MyLinkedList();
        solution.addAtHead(7);
        solution.addAtTail(0);
        solution.deleteAtIndex(1);
        solution.addAtTail(5);
        solution.addAtIndex(1,1);
        solution.addAtIndex(2,6);
        solution.deleteAtIndex(2);
        solution.deleteAtIndex(1);
        solution.addAtTail(7);
        solution.addAtIndex(1,7);
        solution.addAtTail(6);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {

        private int size;

        private Node head;

        private Node tail;

        public MyLinkedList() {
            this.head = new Node(-1);
            this.tail = new Node(-1);
        }

        private class Node {

            public Node(int val) {
                this.val = val;
            }

            private int val;

            private Node next;

            private Node pre;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return getIndex(index).val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (size == 0) {
                node.pre = head;
                node.next = tail;
                head.next = node;
                tail.pre = node;
            } else {
                node.pre = head;
                node.next = head.next;
                node.next.pre = node;
                head.next = node;
            }
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (size == 0) {
                node.pre = head;
                node.next = tail;
                head.next = node;
                tail.pre = node;
            } else {
                headAdd(tail, node);
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) {
                addAtHead(val);
                return;
            }
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }

            Node node = new Node(val);
            Node cur = getIndex(index);
            headAdd(cur, node);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            Node cur = getIndex(index);

            cur.pre.next = cur.next;
            cur.pre.next.pre = cur.pre;
            size--;
        }

        private void headAdd(Node cur, Node node) {
            node.next = cur;
            node.pre = cur.pre;
            node.pre.next = node;
            cur.pre = node;
        }

        private Node getIndex(int index) {
            Node node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

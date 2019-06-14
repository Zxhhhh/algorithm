package com.zxh.algorithm.linkList;

/**
 * 模拟链表
 * 
 * 链表访问数据的时间复杂度：O(n)
 * 链表插入、删除数据的时间复杂度：O(1)
 * 
 * @author zhuxianhao
 *
 */
public class MyLinkedList {
	
	//头结点引用
	private Node head;
	
	//尾节点引用
	private Node last;
	
	//链表实际长度
	private int size;
	
	/**
	 * 链表在指定位置插入元素
	 * @param data
	 * @param index
	 * @throws Exception
	 */
	public void insert(int data,int index) throws Exception{
		if(index<0 || index>size)
			throw new Exception("超出链表节点范围");
		
		Node insertedNode = new Node(data);
		if(size ==0) {
			//第一个元素
			head = insertedNode;
			last = insertedNode;
		}else if(index == size-1) {
			//在尾部插入
			last.next = insertedNode;//把原尾节点的next指向新节点
			last = insertedNode;//新节点成为尾节点
		}else {
			//在中间插入
			Node prevNode = get(index-1); //找到指定位置的上一个节点
			Node nextNode = prevNode.next; //找到指定位置的下一个节点
			prevNode.next = insertedNode; //使上一个节点的next指到新节点
			insertedNode.next = nextNode;//使新节点的next指向下一个节点
		}
	}
	
	/**
	 * 链表删除指定位置的元素
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public Node remove(int index) throws Exception{
		if(index<0 || index>size)
			throw new Exception("超出链表节点范围");
		Node removedNode = null;
		if(index ==0) {
			//删除头节点
			removedNode = head;
			head = head.next;
		}else if(index == size-1) {
			//删除尾节点
			Node prevNode = get(index-1); //找到被删除节点的上一个节点
			removedNode = prevNode.next; //找到被删除节点,等于上一个节点的next
			prevNode.next = null; //使上一个节点的next指向空，成为尾节点
			last = prevNode;
		}else {
			//删除中间
			Node prevNode = get(index-1); //找到被删除节点的上一个节点
			Node nextNode = prevNode.next.next; //找到被删除节点的下一个节点
			removedNode = prevNode.next; //找到被删除节点
			prevNode.next = nextNode; //上一个节点的next直接指向下一节点，以去掉被删除节点
		}
		size--;
		return removedNode;
	}
	
	/**
	 * 链表查找指定位置元素
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public Node get(int index) throws Exception{
		if(index<0 ||index>size)
			throw new Exception("超出链表节点范围");
		
		//从头节点开始遍历
		Node temp = head;
		for(int i=0;i<index;i++) {
			//向下一节点遍历，直到index
			temp = temp.next;
		}
		size--;
		return temp;
	}
	
	public void output() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.insert(3,0);
		myLinkedList.insert(7,1);
		myLinkedList.insert(9,2);
		myLinkedList.insert(5,3);
		myLinkedList.insert(6,1);
		myLinkedList.output();
	}

}

package com.zxh.algorithm.array;


/**
 * 模拟数组
 * 
 * 数据访问，数据更新的时间复杂度：O(1)
 * 数据插入，数据删除的时间复杂度：O(n)
 * 
 * @author zhuxianhao
 *
 */
public class MyArray {
	
	//数组引用
	private int[] array;
	
	//实际大小
	private int size;
	
	/**
	 * 初始化数组和大小
	 * @param capacity
	 */
	public MyArray(int capacity) {
		this.array = new int[capacity];
		size = 0;
	}
	
	/**
	 * 在指定位置插入元素
	 * @param element
	 * @param index
	 * @throws Exception
	 */
	public void insert(int element,int index) throws Exception{
		if(index<0 || index>size)
			throw new Exception("超出数组实际元素范围");
		
		//实际元素数量达到容量上限，对数组扩容
		if(size>=array.length) {
			resize();
		}
		
		//从插入位置右边的元素从右到左循环，向右挪位
		for(int i=size-1;i>=index;i--) {
			array[i+1] = array[i];
		}
		
		//腾出的位置放入新元素
		array[index] = element;
		size++;
	}
	
	/**
	 * 数组元素删除
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public int delete(int index) throws Exception{
		if(index<0 || index>size)
			throw new Exception("超出数组实际元素范围");
		
		int deletedElement = array[index];
		
		//从删除卫视右边的元素从左到右循环，向左挪位
		for(int i=index;i<size-1;i++) {
			array[i] = array[i+1];
		}
		size--;
		return deletedElement;
	}
	
	/**
	 * 数组扩容
	 */
	public void resize() {
		int[] arrayNew = new int[array.length*2];
		//把旧的数组复制到新数组
		System.arraycopy(array, 0,arrayNew,0,array.length);
		
		//把引用指向新的数组，完成扩容
		array = arrayNew;
	}
	
	public void output() {
		for(int i=0;i<size;i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyArray myArray = new MyArray(5);
		myArray.insert(3,0);
		myArray.insert(7,1);
		myArray.insert(8,2);
		myArray.insert(5,3);
		myArray.insert(6,1);
		myArray.insert(11,4);
		myArray.output();
	}

}

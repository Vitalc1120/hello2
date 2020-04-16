package linear;

public interface A_11_IQueue {
	/**
	 * 入队
	 */
	void enqueue(Object e);
	
	/**
	 * 出队
	 */
	Object dequeue();
	
	/**
	 * 返回队列的大小
	 */
	int size();
	
	/**
	 * 队列是否为空
	 */
	boolean empty();
	
	/**
	 * 取队首元素
	 */
	Object peek();
}

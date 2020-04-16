package linear;

public interface A_08_IStack{
	/**
	 * 元素入栈
	 */
	void push(Object e);
	
	/**
	 * 元素出栈
	 */
	Object pop();
	
	/**
	 * 是否为空栈
	 */
	boolean empty();
	
	/**
	 * 栈的长度
	 */
	int size();
	
	/**
	 * 查看栈顶的元素，不弹出
	 */
	Object peek();
}

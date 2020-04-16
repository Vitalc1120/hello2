package linear;

/**
 * 线性结构
 * 优势：查找元素很快，直接通过下标索引
 * @author Vitalc
 *
 */
public class A_02_MyArrayList implements A_01_IList{

	Object[] elements;
	
	int size = 0;//元素个数
	
	int capacity = 10;//容量

	public A_02_MyArrayList(int capacity) {
		this.capacity = capacity;
		elements = new Object[capacity];
	}
	
	public A_02_MyArrayList() {
		elements = new Object[capacity];
	}
	
	@Override
	public void add(Object element) {
		if (size * 1.0 == capacity * 0.8) {
			capacity *= 2;
			Object[] newArr = new Object[capacity];
			for (int i = 0; i < size; i++) {
				newArr[i] = elements[i];
			}
			elements = newArr;
		}
		elements[size++] = element;
	}

	@Override
	public void delete(Object element) {
		int index = indexOf(element);
		if (index >= 0) {
			delete(index);
		}	
	}

	@Override
	public void delete(int index) {
		if (index < 0 || index >= size) {
			System.out.println("异常处理");
			return;
		}
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		size--;	
	}

	@Override
	public void update(int index, Object element) {
		if (index < 0 || index >= size) {
			System.out.println("异常处理");
			return;
		}
		elements[index] = element;
	}

	@Override
	public boolean contains(Object target) {
		return indexOf(target) >= 0;
	}

	@Override
	public int indexOf(Object element) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Object at(int index) {
		if (index < 0 || index >= size) {
			return "异常处理";
		}
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return elements[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			if (elements[i] != null) {
				sb.append(elements[i] + (i == size - 1 ? "" : ","));
			}
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}

	
}

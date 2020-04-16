package hash;

import java.util.Iterator;

public class A_02_MyHashMap<K, V> implements A_01_IMap<K, V>{

	@SuppressWarnings("unchecked")
	private Node<K, V>[] buckets = new Node[16];
	private int size = 0;
	@Override
	public void clear() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
	}

	@Override
	public boolean containsKey(K key) {
		int index = hash1(key);
		if (buckets[index] == null) {
			return false;
		} else {
			Node<K, V> p = buckets[index];
			while (p != null) {
				K k1 = p.key;
				//所有对象都有自己的hashcode和equals
				if (key == k1 || (k1.hashCode() == key.hashCode() && k1.equals(key))) {
					return true;
				}
				p = p.next;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(V value) {		
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				Node<K, V> p = buckets[i];
				while (p != null) {
					if (p.value.equals(value)) {
						return true;
					}
					p = p.next;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public V get(K key) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				Node<K, V> p = buckets[i];
				K k1 = p.key;
				while (p != null) {
					if (k1.hashCode() == key.hashCode() && k1.equals(key)) {
						return p.value;
					}
					p = p.next;
				}
			} else {
				break;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public A_05_MyHashSet<K> keySet() {
		A_05_MyHashSet<K> set = new A_05_MyHashSet<K>();
		for (int i = 0; i < buckets.length; i++) {
			Node<K, V> p = buckets[i];
			while (p != null) {
				set.add(p.key);
				p = p.next;
			}
		}
		return set;
	}

	@Override
	public V[] values() {
		return null;
	}

	@Override
	public void put(K key, V value) {
		Node<K, V> node = new Node<>(key, value);
		int index = hash1(key);//算出桶的位置
		if (buckets[index] == null) {//桶中没有东西
			buckets[index] = node;
			size++;
		} else {
			Node<K, V> p = buckets[index];//链表的表头
			K k1 = p.key;
			while (p != null) {
				if (key.hashCode() == k1.hashCode() && key.equals(k1)) {
					p.value = value;//更新相同key的value值
					break;
				}
				if (p.next == null) {
					p.next = node;
					size++;
					break;
				}
				p = p.next;
			}
		
		}
	}

	private int hash1(K key) {		
		return key.hashCode() % 16;
	}

	@Override
	public void putAll(A_01_IMap<? extends K, ? extends V> map) {
		
	}

	@Override
	public V remove(K key) {
		int index = hash1(key);
		if (buckets[index] == null) {
			return null;
		} else {
			Node<K, V> p = buckets[index];
			Node<K, V> pre = p;			
			while (p != null) {
				K k1 = p.key;
				if (key.hashCode() == k1.hashCode() && key.equals(k1)) {
					//移除
					if (p == pre) {
						buckets[index] = pre.next;
					} else {
						pre.next = p.next;
					}
					size--;
					return p.value;
				}
				pre = p;
				p = p.next;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				Node<K, V> p = buckets[i];
				while (p != null) {
					if (p.next == null) {
						sb.append("[" + p.key + "," + p.value + "]");
						break;
					}
					sb.append("[" + p.key + "," + p.value + "],");
					p = p.next;
				}
			}
		}
		return sb.toString();
	}
	
	@SuppressWarnings("hiding")
	public class Node<K, V> {
		public K key;
		public V value;
		private Node<K, V> next;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}	
	}

	@SuppressWarnings({"rawtypes" })
	private class MapIterator implements Iterator<Node> {
		int i = 0;
		Node<K, V> p = buckets[0];
		@Override
		public boolean hasNext() {//跳过空的桶,在桶之间移动
			while (i < 16 && p == null) {
				i++;
				if (i == 16) {
					p = null;
				} else {
					p = buckets[i];
				}
			}
			return p != null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Node<K, V> next() {//在链表上移动
			Node res = p;
			p = p.next;
			return res;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Iterator<Node> iterator() {
		return new MapIterator();
	}
}

package hash;

import java.util.Iterator;

public class A_05_MyHashSet<E> implements A_04_IHashSet<E>{

	private A_02_MyHashMap<E, E> map = new A_02_MyHashMap<>();
	@Override
	public void add(E key) {
		map.put(key, null);
	}

	@Override
	public void remove(E key) {
		map.remove(key);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean contains(E key) {
		return map.containsKey(key);
	}

	@Override
	public boolean isEmpty() {
		return map.size() > 0;
	}

	@Override
	public int size() {
		return map.size();
	}
	
	@Override
	public String toString() {
		@SuppressWarnings("rawtypes")
		Iterator<A_02_MyHashMap.Node> iterator = map.iterator();
		StringBuilder sb = new StringBuilder();
		while (iterator.hasNext()) {
			sb.append(iterator.next().key + ",");
		}
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		@SuppressWarnings("rawtypes")
		Iterator<A_02_MyHashMap.Node> iterator = map.iterator();
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				return (E)iterator.next().key;
			}
			
		};
	}
	
}

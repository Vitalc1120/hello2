package hash;

import static org.junit.Assert.*;

import org.junit.Test;

public class A_03_MyHashMapTest {

	@Test
	public final void testClear() {
		fail("��δʵ��");
	}

	@Test
	public final void testContainsKey() {
		fail("��δʵ��");
	}

	@Test
	public final void testContainsValue() {
		fail("��δʵ��");
	}

	@Test
	public final void testGet() {
		fail("��δʵ��");
	}

	@Test
	public final void testIsEmpty() {
		fail("��δʵ��");
	}

	@Test
	public final void testKeySet() {
		fail("��δʵ��");
	}

	@Test
	public final void testValues() {
		fail("��δʵ��");
	}

	@Test
	public final void testPut() {
		A_02_MyHashMap<String, Integer> map = new A_02_MyHashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		System.out.println(map);
	}

	@Test
	public final void testPutAll() {
		fail("��δʵ��");
	}

	@Test
	public final void testRemove() {
		fail("��δʵ��");
	}

	@Test
	public final void testSize() {
		A_02_MyHashMap<String, Integer> map = new A_02_MyHashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		System.out.println(map.size());
	}

}

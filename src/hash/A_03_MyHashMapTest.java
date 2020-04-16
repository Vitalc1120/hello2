package hash;

import static org.junit.Assert.*;

import org.junit.Test;

public class A_03_MyHashMapTest {

	@Test
	public final void testClear() {
		fail("尚未实现");
	}

	@Test
	public final void testContainsKey() {
		fail("尚未实现");
	}

	@Test
	public final void testContainsValue() {
		fail("尚未实现");
	}

	@Test
	public final void testGet() {
		fail("尚未实现");
	}

	@Test
	public final void testIsEmpty() {
		fail("尚未实现");
	}

	@Test
	public final void testKeySet() {
		fail("尚未实现");
	}

	@Test
	public final void testValues() {
		fail("尚未实现");
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
		fail("尚未实现");
	}

	@Test
	public final void testRemove() {
		fail("尚未实现");
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

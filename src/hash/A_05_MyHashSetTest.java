package hash;

import org.junit.Before;
import org.junit.Test;

public class A_05_MyHashSetTest {

	A_05_MyHashSet<String> set = new A_05_MyHashSet<>();
	@Before
	public final void testAdd() {
		set.add("1");
		set.add("2");
		set.add("3");
		System.out.println(set);
	}

	@Test
	public final void testRemove() {
		set.remove("1");
		set.remove("3");
		System.out.println(set);
	}

	@Test
	public final void testClear() {
		set.clear();
		System.out.println(set);
	}

	@Test
	public final void testContains() {
		set.add("1");
		set.add("2");
		set.add("3");
		System.out.println(set.contains("2"));
		System.out.println(set.contains("4"));
	}

	@Test
	public final void testIsEmpty() {
		System.out.println(set.isEmpty());
	}

	@Test
	public final void testSize() {
		System.out.println(set.size());
	}

	@Test
	public final void testToString() {
		set.clear();
		System.out.println(set);
	}

}

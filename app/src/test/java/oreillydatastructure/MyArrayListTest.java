package oreillydatastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author downey AND UPDATE ZELDA31777
 *
 */
class MyArrayListTest {

    protected List<Integer> mylist;
    protected List<Integer> list;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        mylist = new MyArrayList<>();
        mylist.addAll(list);
    }

    /**
     * Test method for {@link MyArrayList#MyArrayList()}.
     */
    @Test
    void testMyList() {
        assertThat(mylist.size(), is(3));
    }

    /**
     * Test method for {@link MyArrayList#add(Object)}.
     */
    @Test
    void testAddT() {
        for (int i = 4; i < 20; i++) {
            mylist.add(i);
        }
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(18), is(19));
    }

    /**
     * Test method for {@link MyArrayList#add(int, Object)}.
     */
    @Test
    void testAddIntT() {
        mylist.add(1, 5);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(1), is(5));
        assertThat(mylist.size(), is(4));

        assertThrows(IndexOutOfBoundsException.class, () -> mylist.set(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> mylist.set(4, 0));

        mylist.add(0, 6);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(0), is(6));

        mylist.add(5, 7);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(5), is(7));
    }

    /**
     * Test method for {@link MyArrayList#addAll(java.util.Collection)}.
     */
    @Test
    void testAddAllCollectionOfQextendsT() {
        mylist.addAll(list);
        mylist.addAll(list);
        mylist.addAll(list);
        assertThat(mylist.size(), is(12));
        assertThat(mylist.get(5), is(3));
    }

    /**
     * Test method for {@link MyArrayList#clear()}.
     */
    @Test
    void testClear() {
        mylist.clear();
        assertThat(mylist.size(), is(0));
    }

    /**
     * Test method for {@link MyArrayList#contains(Object)}.
     */
    @Test
    void testContains() {
        assertThat(mylist.contains(1), equalTo(true));
        assertThat(mylist.contains(4), equalTo(false));
        assertThat(mylist.contains(null), equalTo(false));
        mylist.add(null);
        assertThat(mylist.contains(null), equalTo(true));
    }

    /**
     * Test method for {@link MyArrayList#containsAll(java.util.Collection)}.
     */
    @Test
    void testContainsAll() {
        assertThat(mylist.containsAll(list), equalTo(true));
    }

    /**
     * Test method for {@link MyArrayList#get(int)}.
     */
    @Test
    void testGet() {
        assertThat(mylist.get(1), is(2));
    }

    /**
     * Test method for {@link MyArrayList#indexOf(Object)}.
     */
    @Test
    void testIndexOf() {
        assertThat(mylist.indexOf(1), is(0));
        assertThat(mylist.indexOf(2), is(1));
        assertThat(mylist.indexOf(3), is(2));
        assertThat(mylist.indexOf(4), is(-1));
    }

    /**
     * Test method for {@link MyArrayList#indexOf(Object)}.
     */
    @Test
    void testIndexOfNull() {
        assertThat(mylist.indexOf(null), is(-1));
        mylist.add(null);
        assertThat(mylist.indexOf(null), is(3));
    }

    /**
     * Test method for {@link MyArrayList#isEmpty()}.
     */
    @Test
    void testIsEmpty() {
        assertThat(mylist.isEmpty(), equalTo(false));
        mylist.clear();
        assertThat(mylist.isEmpty(), equalTo(true));
    }

    /**
     * Test method for {@link MyArrayList#iterator()}.
     */
    @Test
    void testIterator() {
        Iterator<Integer> iter = mylist.iterator();
        assertThat(iter.next(), is(1));
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(3));
        assertFalse(iter.hasNext());
    }

    /**
     * Test method for {@link MyArrayList#lastIndexOf(Object)}.
     */
    @Test
    void testLastIndexOf() {
        mylist.add(2);
        assertThat(mylist.lastIndexOf(2), is(3));
    }

    /**
     * Test method for {@link MyArrayList#remove(Object)}.
     */
    @Test
    void testRemoveObject() {
        boolean flag = mylist.remove(Integer.valueOf(2));
        assertThat(flag, equalTo(true));
        assertThat(mylist.size(), is(2));
        assertThat(mylist.get(1), is(3));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(Integer.valueOf(1));
        assertThat(flag, equalTo(true));
        assertThat(mylist.size(), is(1));
        assertThat(mylist.get(0), is(3));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(Integer.valueOf(5));
        assertThat(flag, equalTo(false));
        assertThat(mylist.size(), is(1));
        assertThat(mylist.get(0), is(3));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(Integer.valueOf(3));
        assertThat(flag, equalTo(true));
        assertThat(mylist.size(), is(0));
        //System.out.println(Arrays.toString(mal.toArray()));
    }

    /**
     * Test method for {@link MyArrayList#remove(int)}.
     */
    @Test
    void testRemoveInt() {
        Integer val = mylist.remove(1);
        assertThat(val, is(2));
        assertThat(mylist.size(), is(2));
        assertThat(mylist.get(1), is(3));
    }

    /**
     * Test method for {@link MyArrayList#removeAll(java.util.Collection)}.
     */
    @Test
    void testRemoveAll() {
        mylist.removeAll(list);
        assertThat(mylist.size(), is(0));
    }

    /**
     * Test method for {@link MyArrayList#set(int, Object)}.
     */
    @Test
    void testSet() {
        Integer val = mylist.set(1, 5);
        assertThat(val, is(2));

        val = mylist.set(0, 6);
        assertThat(val, is(1));

        val = mylist.set(2, 7);
        assertThat(val, is(3));

        // return value should be 2
        // list should be [6, 5, 7]
        assertThat(mylist.get(0), is(6));
        assertThat(mylist.get(1), is(5));
        assertThat(mylist.get(2), is(7));
        //System.out.println(Arrays.toString(mal.toArray()));

        assertThrows(IndexOutOfBoundsException.class, () -> mylist.set(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> mylist.set(4, 0));
    }

    /**
     * Test method for {@link MyArrayList#size()}.
     */
    @Test
    void testSize() {
        assertThat(mylist.size(), is(3));
    }

    /**
     * Test method for {@link MyArrayList#subList(int, int)}.
     */
    @Test
    void testSubList() {
        mylist.addAll(list);
        List<Integer> sub = mylist.subList(1, 4);
        assertThat(sub.get(1), is(3));
    }

    /**
     * Test method for {@link MyArrayList#toArray()}.
     */
    @Test
    void testToArray() {
        Object[] array = mylist.toArray();
        assertThat((Integer) array[0], is(1));
    }

}
package com.immutablecollections.list;

import com.immutablecollections.ImmutableCollection;

import java.util.*;

public interface ImmutableList<E> extends ImmutableCollection<E> {

    @SuppressWarnings("rawtypes")
    ImmutableList EMPTY_LIST = new ImmutableArrayList(Collections.EMPTY_LIST);

    static <E> ImmutableList empty() {
        return (ImmutableList<E>) EMPTY_LIST;
    }

    static <E> ImmutableList of(E... e) {
        final int size = e.length;
        List<E> list = new ArrayList<>(size);
        for (E element : e) {
            list.add(element);
        }
        return new ImmutableArrayList<>(list);
    }

    static <E> ImmutableList of(List<E> list) {
        return new ImmutableArrayList<>(list);
    }

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean containsAll(Collection<?> c);

    boolean equals(Object o);

    int hashCode();

    E get(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    ImmutableList<E> subList(int fromIndex, int toIndex);

    List<E> toArrayList();

    List<E> toLinkedList();

}

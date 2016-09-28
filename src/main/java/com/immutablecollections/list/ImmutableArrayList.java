package com.immutablecollections.list;

import java.util.*;

class ImmutableArrayList<E> implements ImmutableList<E>, RandomAccess, Cloneable, java.io.Serializable {

    private final List<E> list;

    ImmutableArrayList(List<E> list) {
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new ImmutableIteratorImpl<>(list);
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ImmutableListIteratorImpl<>(0 , list);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ImmutableListIteratorImpl<>(index, list);
    }

    @Override
    public ImmutableList<E> subList(int fromIndex, int toIndex) {
        return new ImmutableArrayList<>(list.subList(fromIndex, toIndex));
    }

    @Override
    public List<E> toArrayList() {
        return new ArrayList<>(list);
    }

    @Override
    public List<E> toLinkedList() {
        return new LinkedList<>(list);
    }

    private class ImmutableIteratorImpl<E> implements Iterator<E> {

        final Iterator<E> iterator;

        private ImmutableIteratorImpl(List<E> list) {
            this.iterator = list.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            return iterator.next();
        }
    }

    private class ImmutableListIteratorImpl<E> implements ListIterator<E> {

        private ListIterator<E> listIterator;

        private ImmutableListIteratorImpl(int index, List<E> list) {
            listIterator = list.listIterator(index);
        }

        @Override
        public boolean hasNext() {
            return listIterator.hasNext();
        }

        @Override
        public E next() {
            return listIterator.next();
        }

        @Override
        public boolean hasPrevious() {
            return listIterator.hasPrevious();
        }

        @Override
        public E previous() {
            return listIterator.previous();
        }

        @Override
        public int nextIndex() {
            return listIterator.nextIndex();
        }

        @Override
        public int previousIndex() {
            return listIterator.previousIndex();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}

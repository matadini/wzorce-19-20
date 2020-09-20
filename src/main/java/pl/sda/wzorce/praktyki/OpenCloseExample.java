package pl.sda.wzorce.praktyki;

import java.time.LocalDate;
import java.util.*;

public class OpenCloseExample {

    // to jest nietykalne i nei wolno modyfikowac
    String generujFakture() {
        return "faktura";
    }

    // to jest dopuszczalne dodanie nowej metody
    String generujFakture(LocalDate from, LocalDate to) {
        return "faktura" + from.toString() + " x " + to.toString();
    }

}

class MyList<E> implements List<E> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}

class Liscov {
    public static void main(String[] args) {
        List<String> lista = new MyList<>();
        lista.add("janek");
        lista.add("zosia");
        lista.add("olek");
        lista.forEach(System.out::println);
    }
}

// o ta klasa lamie literke I bo interfejs ma za duzo odpowiedzialnosci
interface TouchEvent {
    void tap(); // pojedyncze tapniecie w ekran
    void press(); // przytrzymanie
}

interface TouchEventTap {
    void tap(); // pojedyncze tapniecie w ekran
}

interface TouchEventPress {
    void press(); // przytrzymanie
}
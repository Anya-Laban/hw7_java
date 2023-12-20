import java.util.*;
/*

C2 = Set
C3 = Масив із початковою кількістю елементів 15 та збільшенням кількості
елементів на 30%

Створити клас, що описує типізовану колекцію (типом колекції є узагальнений
клас з лабораторної роботи №6), що реалізує заданий варіантом інтерфейс (п.2)
та має задану внутрішню структуру (п.3). Реалізувати всі методи інтерфейсу, а
також створити не менше ніж 3 конструктори (1 – порожній, 2 – в який
передається 1 об’єкт узагальненого класу, 3 – в який передається стандартна
колекція об’єктів). Всі початкові дані задаються у виконавчому методі. Код
повинен відповідати стандартам JCC та бути детально задокументований.

*/
public class TypedCollection implements Set<MusicComposition> {

    private static final int INITIAL_SIZE = 15;
    private MusicComposition[] compositions = new MusicComposition[INITIAL_SIZE];
    private int size = 0;

    public TypedCollection() {
    }
    public TypedCollection(MusicComposition composition) {
        add(composition);
    }
    public TypedCollection(Collection<MusicComposition> compositions) {
        addAll(compositions);
    }

    public boolean increaseCapacity(double factor) {
        if (factor > 1) {
            MusicComposition[] temp = Arrays.copyOf(compositions, compositions.length);
            compositions = new MusicComposition[(int) (INITIAL_SIZE * factor)];
            addAll(Arrays.asList(temp));
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        if (obj instanceof MusicComposition) {
            for (int i = 0; i < size; i++) {
                if (compositions[i].equals(obj)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) return false;
        }
        return true;
    }

    @Override
    public Iterator<MusicComposition> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public MusicComposition next() {
                return compositions[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return compositions;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public boolean add(MusicComposition composition) {
        if (!this.contains(composition)) {
            if (size >= compositions.length) {
                increaseCapacity(1.3);
            }
            compositions[size++] = composition;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends MusicComposition> c) {
        int sizeBeforeOperation = size;
        c.forEach(this::add);
        return sizeBeforeOperation != size;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof MusicComposition) {
            for (int i = 0; i < size; i++) {
                if (compositions[i].equals(obj)) {
                    compositions[i] = compositions[size - 1];
                    compositions[--size] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int sizeBeforeOperation = size;
        c.forEach(this::remove);
        return sizeBeforeOperation != size;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int sizeBeforeOperation = size;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (Object obj : c) {
                if (compositions[i].equals(obj)) {
                    compositions[counter++] = compositions[i];
                }
            }
        }
        for (int i = counter; i < size; i++) {
            compositions[i] = null;
        }
        size = counter;
        return sizeBeforeOperation != size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            compositions[i]= null;
        }
        size = 0;
    }
}
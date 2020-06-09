package sort;

import java.util.List;
import compare.Comparator;
import lists.Listable;

public interface Sortable<T> {
    public void sort(Listable<T> list, Comparator<T> comparator);
}
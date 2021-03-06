package sort;

import compare.Comparator;
import lists.Listable;


public class SelectionSort<T> extends Swapper<T> implements Sortable<T>  {

    @Override
    public void sort(Listable<T> list, Comparator<T> comparator) {
        int minimun;
        for (int i = 0; i < list.size(); i++) {
            minimun = i;
            for (int e = i + 1; e < list.size(); e++) {
                if (comparator.compare(list.get(e), list.get(minimun)) < 0) {
                    minimun = e;
                }
            }
            swap(list, i, minimun);
        }
    }
}
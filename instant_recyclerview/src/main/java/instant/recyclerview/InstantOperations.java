package instant.recyclerview;

import java.util.List;

interface InstantOperations<T> {


    void setViewDataItems(List<T> items);

    void setViewDataItems(T[] items);

    void setViewNewDataItems(List<T> items);

    void setViewNewDataItem(T item);

    void setViewNewDataItemAt(int position, T item);

    void deleteViewDataItemAt(int position);

    void deleteViewDataItem(T item);
}

package instant.recyclerview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InstantRecyclerView<T> extends RecyclerView implements InstantOperations<T> {


    private InstantBuilder<T> builder;

    public InstantRecyclerView(@NonNull Context context) {
        super(context);
    }

    public InstantRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InstantRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void setInstantBuilder(InstantBuilder<T> builder) {
        this.builder = builder;

    }

   /* public InstantRecyclerView(@NonNull Context context) {
        super(context);
    }

    protected void setInstantBuilder(InstantBuilder<T> builder) {
        this.builder = builder;

    }

 */

    public InstantRecyclerAdapter<T> getRecyclerAdapter() {
        return builder.getRecyclerAdapter();
    }


    @Override
    public void setViewDataItems(List<T> items) {
        builder.getRecyclerAdapter().setViewDataItems(items);
    }

    @Override
    public void setViewDataItems(T[] items) {
        builder.getRecyclerAdapter().setViewDataItems(items);

    }

    @Override
    public void setViewNewDataItems(List<T> items) {
        builder.getRecyclerAdapter().setViewNewDataItems(items);

    }

    @Override
    public void setViewNewDataItem(T item) {
        builder.getRecyclerAdapter().setViewNewDataItem(item);
    }

    @Override
    public void setViewNewDataItemAt(int position, T item) {
        builder.getRecyclerAdapter().setViewNewDataItemAt(position, item);
    }

    @Override
    public void deleteViewDataItemAt(int position) {
        builder.getRecyclerAdapter().deleteViewDataItemAt(position);
    }

    @Override
    public void deleteViewDataItem(T item) {
        builder.getRecyclerAdapter().deleteViewDataItem(item);
    }

    /*public void setBuilder(InstantRecyclerAdapter<T> recyclerAdapter, RecyclerView recyclerView) {
        this.view
    }*/
}

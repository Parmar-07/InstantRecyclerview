package instant.recyclerview;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class InstantBuilder<T> {

    private T instance;
    private Context context;
    private InstantRecyclerView<T> recyclerView;
    private int viewItemRes;
    private List<T> items = null;
    private InstantRecyclerAdapter<T> recyclerAdapter;
    private InstantViewBinder<T> instantViewBinder;
    private InstantViewClicksBinder<T> instantViewClickBinder;

    private InstantBuilder(Class<T> clazz) {
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <T> InstantBuilder<T> newBuilder(Class<T> clazz) {
        return new InstantBuilder<>(clazz);
    }


    public InstantBuilder<T> fromRecyclerView(Activity activity, int recyclerViewId) {
        this.recyclerView = activity.findViewById(recyclerViewId);
        return layoutManager(new LinearLayoutManager(activity));
    }

    public InstantBuilder<T> layoutManager(RecyclerView.LayoutManager manager) {
        this.recyclerView.setLayoutManager(manager);
        return this;
    }

    public InstantBuilder<T> itemVewResource(int viewItemRes) {
        this.viewItemRes = viewItemRes;
        return this;
    }

    public InstantBuilder<T> setViewDataItems(List<T> items) {
        this.items = items;
        return this;
    }


    protected void setAdapterViewDataItems(List<T> items) {
        this.items = items;
    }

    public InstantBuilder<T> setViewDataItems(T[] items) {
        this.items = Arrays.asList(items);
        return this;
    }

    public InstantBuilder<T> setVisibility(int visibility) {
        this.recyclerView.setVisibility(visibility);
        return this;
    }

    public InstantBuilder<T> setInstantViewBinder(InstantViewBinder<T> instantViewBinder) {
        this.instantViewBinder = instantViewBinder;
        return this;
    }

    public InstantBuilder<T> setInstantViewClickBinder(InstantViewClicksBinder<T> instantViewClickBinder) {
        this.instantViewClickBinder = instantViewClickBinder;
        return this;
    }

    public T getInstance() {
        return instance;
    }

    InstantRecyclerAdapter<T> getRecyclerAdapter() {
        return recyclerAdapter;
    }


    int getViewItemRes() {
        return viewItemRes;
    }

    InstantViewBinder<T> getInstantViewBinder() {
        return instantViewBinder;
    }


    List<T> getItems() {
        return items;
    }

    InstantViewClicksBinder<T> getInstantViewClickBinder() {
        return instantViewClickBinder;
    }


    public InstantRecyclerView<T> build() {
        recyclerAdapter = new InstantRecyclerAdapter<>(this);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setInstantBuilder(this);
        return recyclerView;
    }


}

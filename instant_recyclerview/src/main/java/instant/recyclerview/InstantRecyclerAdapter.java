package instant.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class InstantRecyclerAdapter<T> extends RecyclerView.Adapter<InstantViewHolder> implements InstantOperations<T> {


    private InstantBuilder<T> builder;

    InstantRecyclerAdapter(InstantBuilder<T> builder) {
        this.builder = builder;
    }

    @Override
    public void setViewDataItems(List<T> items) {
        builder.setAdapterViewDataItems(items);
    }

    @Override
    public void setViewDataItems(T[] items) {
        builder.setAdapterViewDataItems(Arrays.asList(items));
    }

    @Override
    public void setViewNewDataItems(List<T> items) {
        if (items == null || items.size() == 0)
            return;
        builder.getItems().addAll(items);
        this.notifyDataSetChanged();
    }

    @Override
    public void setViewNewDataItem(T item) {
        if (item == null)
            return;
        builder.getItems().add(item);
        this.notifyDataSetChanged();
    }

    @Override
    public void setViewNewDataItemAt(int position, T item) {
        if (item == null)
            return;
        builder.getItems().add(position, item);
        this.notifyItemChanged(position);
    }


    @Override
    public void deleteViewDataItemAt(int position) {
        builder.getItems().remove(position);
        this.notifyItemRemoved(position);

    }

    @Override
    public void deleteViewDataItem(T item) {
        if (item == null)
            return;
        builder.getItems().remove(item);
        this.notifyDataSetChanged();

    }


    @NonNull
    @Override
    public InstantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(parent.getContext()).inflate(builder.getViewItemRes(), parent, false);

        return new InstantViewHolder(view) {
            @Override
            void bindView(final View itemView) {

                if (builder.getInstantViewClickBinder()!=null)
                {
                    builder.getInstantViewBinder().instantBindViewClick(builder.getInstantViewClickBinder());
                }

                builder.getInstantViewBinder().instantBindView(itemView);

                if (builder.getInstantViewClickBinder() != null) {
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            builder.getInstantViewClickBinder().onItemViewClick(itemView,builder.getItems().get(getAdapterPosition()));
                        }
                    });
                }
            }
        };
    }

    @Override
    public void onBindViewHolder(@NonNull InstantViewHolder holder, int position) {
        builder.getInstantViewBinder().instantBindData(builder.getItems().get(position));

    }


    @Override
    public int getItemCount() {
        return (builder.getItems() == null) ? 0 : builder.getItems().size();
    }


}

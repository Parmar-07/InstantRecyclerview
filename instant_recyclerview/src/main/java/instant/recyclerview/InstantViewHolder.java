package instant.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public abstract class InstantViewHolder extends ViewHolder {

    abstract void bindView(View itemView);

    public InstantViewHolder(@NonNull View itemView) {
        super(itemView);
        bindView(itemView);
    }

}
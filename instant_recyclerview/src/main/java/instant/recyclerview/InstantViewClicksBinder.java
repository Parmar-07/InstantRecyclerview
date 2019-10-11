package instant.recyclerview;

import android.view.View;

public interface InstantViewClicksBinder<T> {

    void onItemViewClick(View view , T data);
}

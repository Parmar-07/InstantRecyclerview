package instant.recyclerview;

import android.view.View;

public interface InstantViewBinder<T> {

    void instantBindView(View iteView);

    void instantBindViewClick(InstantViewClicksBinder<T> clickListener);

    void instantBindData(final T data);

}

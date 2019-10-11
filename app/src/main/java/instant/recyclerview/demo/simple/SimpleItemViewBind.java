package instant.recyclerview.demo.simple;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import instant.recyclerview.InstantViewBinder;
import instant.recyclerview.InstantViewClicksBinder;
import instant.recyclerview.demo.R;

public class SimpleItemViewBind implements InstantViewBinder<String> {

    private TextView textView;

    @SuppressLint("StaticFieldLeak")
    private static SimpleItemViewBind binder = null;

    private SimpleItemViewBind() {
    }

    static SimpleItemViewBind getBinder() {
        if (binder == null)
            binder = new SimpleItemViewBind();

        return binder;
    }


    @Override
    public void instantBindView(View iteView) {
        textView = iteView.findViewById(R.id.simpleText);
    }

    @Override
    public void instantBindViewClick(InstantViewClicksBinder<String> clickListener) {

    }

    @Override
    public void instantBindData(String data) {
        textView.setText(data);
    }
}

package instant.recyclerview.demo.simple;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Toast;

import instant.recyclerview.InstantViewClicksBinder;

public class SimpleItemViewClick implements InstantViewClicksBinder<String> {

    @SuppressLint("StaticFieldLeak")
    private static SimpleItemViewClick clicker =null;

    private SimpleItemViewClick(){}
    static SimpleItemViewClick getClicker(){
        if (clicker ==null)
            clicker =new SimpleItemViewClick();

        return clicker;
    }

    @Override
    public void onItemViewClick(View view, String data) {
        Toast.makeText(view.getContext(), "ItemClick : " + data, Toast.LENGTH_SHORT).show();
    }
}

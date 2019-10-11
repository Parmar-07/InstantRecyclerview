package instant.recyclerview.demo.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import instant.recyclerview.InstantViewClicksBinder;
import instant.recyclerview.demo.CustomModel;

public class CustomItemViewClick implements CustomClicks<CustomModel> {

    @SuppressLint("StaticFieldLeak")
    private static CustomItemViewClick clicker = null;

    private CustomItemViewClick() {
    }

    static CustomItemViewClick getClicker() {
        if (clicker == null)
            clicker = new CustomItemViewClick();

        return clicker;
    }

    @Override
    public void onItemViewClick(View view, CustomModel dataModel) {
        Toast.makeText(view.getContext(), "ItemClick : " + dataModel.getVersionName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onImage1Click(Context context) {
        Toast.makeText(context, "onImageClick : 1", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSubTitleClick(Context context, String subTitle) {
        Toast.makeText(context, "onSubTitleClick : "+subTitle, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onImage2Click(Context context) {
        Toast.makeText(context, "onImageClick : 2", Toast.LENGTH_SHORT).show();

    }
}

interface CustomClicks<T> extends InstantViewClicksBinder<T> {

    void onImage1Click(Context context);

    void onSubTitleClick(Context context,String subTitle);

    void onImage2Click(Context context);
}

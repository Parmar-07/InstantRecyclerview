package instant.recyclerview.demo.custom;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import instant.recyclerview.InstantViewBinder;
import instant.recyclerview.InstantViewClicksBinder;
import instant.recyclerview.demo.CustomModel;
import instant.recyclerview.demo.R;

public class CustomItemViewBind implements InstantViewBinder<CustomModel> {

    private TextView customTitle;
    private TextView customSubTitle;

    @SuppressLint("StaticFieldLeak")
    private static CustomItemViewBind binder = null;
    private CustomItemViewClick click;

    private CustomItemViewBind() {
    }

    static CustomItemViewBind getBinder() {
        if (binder == null)
            binder = new CustomItemViewBind();

        return binder;
    }


    @Override
    public void instantBindView(View iteView) {
        customTitle = iteView.findViewById(R.id.customTitle);
        customSubTitle = iteView.findViewById(R.id.customSubTitle);
        ImageView imageView1 = iteView.findViewById(R.id.imageView1);
        ImageView imageView2 = iteView.findViewById(R.id.imageView2);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onImage1Click(view.getContext());
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onImage2Click(view.getContext());
            }
        });
    }

    @Override
    public void instantBindViewClick(InstantViewClicksBinder<CustomModel> clickListener) {
        click = (CustomItemViewClick) clickListener;
    }

    @Override
    public void instantBindData(final CustomModel dataModel) {
        customTitle.setText(dataModel.getVersionName());
        customSubTitle.setText(dataModel.getVersionDesc());
        customSubTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onSubTitleClick(view.getContext(),dataModel.getVersionDesc());
            }
        });
    }
}

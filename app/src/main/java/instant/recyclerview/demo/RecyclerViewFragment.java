package instant.recyclerview.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import instant.recyclerview.InstantBuilder;
import instant.recyclerview.InstantViewBinder;
import instant.recyclerview.InstantViewClicksBinder;

public class RecyclerViewFragment extends Fragment {

    private int type = -1;

    static RecyclerViewFragment createRecyclerView(int type) {

        RecyclerViewFragment recyclerFrag = new RecyclerViewFragment();

        recyclerFrag.type = type;

        return recyclerFrag;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (type == Constants.SIMPLE) {

            InstantBuilder.newBuilder(String.class)
                    .fromRecyclerView(getActivity(), R.id.recyclerViewId)
                    .itemVewResource(android.R.layout.simple_list_item_1)
                    .setViewDataItems(simpleLoadData())
                    .setInstantViewBinder(new InstantViewBinder<String>() {

                        TextView textView;

                        @Override
                        public void instantBindView(View iteView) {

                            textView = iteView.findViewById(android.R.id.text1);
                        }

                        @Override
                        public void instantBindViewClick(InstantViewClicksBinder<String> clickListener) {

                        }

                        @Override
                        public void instantBindData(String data) {
                            textView.setText(data);
                        }


                    })
                    .setInstantViewClickBinder(new InstantViewClicksBinder<String>() {
                        @Override
                        public void onItemViewClick(View view, String data) {
                            Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();

        } else {

            InstantBuilder.newBuilder(CustomModel.class)
                    .fromRecyclerView(getActivity(), R.id.recyclerViewId)
                    .itemVewResource(android.R.layout.simple_list_item_2)
                    .setViewDataItems(customLoadData())
                    .setInstantViewBinder(new InstantViewBinder<CustomModel>() {

                        TextView textView;
                        TextView textView2;

                        @Override
                        public void instantBindView(View iteView) {

                            textView = iteView.findViewById(android.R.id.text1);
                            textView2 = iteView.findViewById(android.R.id.text2);
                        }

                        @Override
                        public void instantBindViewClick(InstantViewClicksBinder<CustomModel> clickListener) {

                        }

                        @Override
                        public void instantBindData(CustomModel data) {
                            textView.setText(data.getVersionName());
                            textView2.setText(data.getVersionName());
                        }


                    })
                    .setInstantViewClickBinder(new InstantViewClicksBinder<CustomModel>() {
                        @Override
                        public void onItemViewClick(View view, CustomModel data) {
                            Toast.makeText(getActivity(), data.getVersionName(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();


        }


    }


    private String[] simpleLoadData() {

        return new String[]{
                "Apple Pie",
                "Banana Bread",
                "Cupcake",
                "Donut",
                "Eclair",
                "Froyo",
                "Gingerbread",
                "Honeycomb",
                "Ice Cream Sandwich",
                "Jelly Bean",
                "Kitkat",
                "Lollipop",
                "Marshmallow",
                "Nougat",
                "Oreo",
                "Pie",
                "Android 10(Q)",

        };
    }


    private ArrayList<CustomModel> customLoadData() {

        ArrayList<CustomModel> listData = new ArrayList<>();


        listData.add(new CustomModel("Apple Pie", "SDK API level : 1, v : 1.0"));
        listData.add(new CustomModel("Banana Bread", "SDK API level : 2, v : 1.1 "));
        listData.add(new CustomModel("Cupcake", "SDK API level : 3, v : 1.5 "));
        listData.add(new CustomModel("Donut", "SDK API level : 4, v : 1.6 "));
        listData.add(new CustomModel("Eclair", "SDK API level : 5-7, v : 2.0-2.1 "));
        listData.add(new CustomModel("Froyo", "SDK API level : 8, v : 2.2-2.2.3 "));
        listData.add(new CustomModel("Gingerbread", "SDK API level : 9-10, v : 2.3-2.3.7 "));
        listData.add(new CustomModel("Honeycomb", "SDK API level : 11-13 v : 3.0-3.2.6 "));
        listData.add(new CustomModel("Ice Cream Sandwich", "SDK API level : 14-15, v : 4.0-4.0.4 "));
        listData.add(new CustomModel("Jelly Bean", "SDK API level : 16-18, v : 4.1-4.3.1 "));
        listData.add(new CustomModel("Kitkat", "SDK API level : 19-20, v : 4.4-4.4.4 "));
        listData.add(new CustomModel("Lollipop", "SDK API level : 21-22, v : 5.0-5.1.1 "));
        listData.add(new CustomModel("Marshmallow", "SDK API level : 23, v : 6.0-6.0.1 "));
        listData.add(new CustomModel("Nougat", "SDK API level : 24-25, v : 7.0-7.12 "));
        listData.add(new CustomModel("Oreo", "SDK API level : 26-27, v : 8.0-8.1 "));
        listData.add(new CustomModel("Pie", "SDK API level : 28, v : 9.0 "));
        listData.add(new CustomModel("Q - Android 10", "SDK API level : 29, v : 10.0 "));


        return listData;
    }


}

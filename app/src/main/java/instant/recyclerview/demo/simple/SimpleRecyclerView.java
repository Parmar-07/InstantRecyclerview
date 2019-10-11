package instant.recyclerview.demo.simple;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import instant.recyclerview.InstantBuilder;
import instant.recyclerview.InstantRecyclerView;
import instant.recyclerview.demo.R;

public class SimpleRecyclerView extends Fragment {


    private static SimpleRecyclerView recyclerFrag = null;
    private InstantBuilder<String> instantBuilder = InstantBuilder.newBuilder(String.class);
    private String[] listData = new String[]{
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
            "Q - Android 10",

    };

    private SimpleRecyclerView() {


        instantBuilder.itemVewResource(R.layout.simple_view);
        instantBuilder.setInstantViewBinder(SimpleItemViewBind.getBinder());
        instantBuilder.setInstantViewClickBinder(SimpleItemViewClick.getClicker());


    }

    public static SimpleRecyclerView createRecyclerView() {

        if (recyclerFrag == null)
            recyclerFrag = new SimpleRecyclerView();

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

        InstantRecyclerView<String> recyclerView = instantBuilder
                .fromRecyclerView(getActivity(), R.id.recyclerViewId)
                .build();

        recyclerView.setViewDataItems(listData);


    }

}

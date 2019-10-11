# [InstantRecyclerview.apk][0]

InstantRecyclerview helps to write a code immediately of recyclerview stuffs like `Adapters`,`View holders`&`View click listeners`

As we all know <b>RecyclerView</b> is more advanced version of <i>ListView</i> with improved performance and other benefits

Let's overview to create a basic of recyclerview :
* <i>`android.support.v7.widget.RecyclerView`</i> in xml design
* <i>`item_view.xml`</i> for list item of recycler view
* <i>`RecyclerView.ViewHolder`</i> consist of list item objects
* <i>`RecyclerView.Adapter`</i> holds the ViewHolder objects to <b>onCreateViewHolder()</b> and also for <b>onBindViewHolder()</b> from <b>item_view.xml</b>
* And finally <i>`ItemClickListeners`</i> for list item clicks


## Usage


Add <b><i>instant.recyclerview.InstantRecyclerView</i></b> component in `activity_main.xml`
```xml

<instant.recyclerview.InstantRecyclerView
        android:id="@+id/recyclerViewId"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
 ... />

```

# Simple RecyclerView

Create a simple listitem recyclerview with loads String[] array & with single item clicks

* Simple RecyclerView holds the array of String objects, so we building a recyclerview type of <b>String.class</b>.

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          InstantBuilder builder = InstantBuilder.newBuilder(String.class);

       }

   }
```

* Attach the InstantRecyclerView component id with builder from activity
```java
  ...
  builder.fromRecyclerView(MainActivity.this, R.id.recyclerViewId);
```

* Attach the list-item layout xml with builder
```java
  ...
  builder.itemVewResource(android.R.layout.simple_list_item_1);
```
* Attach the list-item data with builder its optinal while building you can attach after build
```java

  String[] listData = new String[]{"Item 1","Item 2"....,"Item n"};

...
  builder.setViewDataItems(listData);
```
* Attach the list-item view-data binder with builder as per the build data type
```java
...
  builder.setInstantViewBinder(new InstantViewBinder<String>() {
                        TextView textView;

                        @Override
                        public void instantBindView(View iteView) {
                            textView = iteView.findViewById(android.R.id.text1);
                        }

                        @Override
                        public void instantBindData(String data) {
                            textView.setText(data);
                        }

                        @Override
                        public void instantBindViewClick(InstantViewClicksBinder<String> clickListener) {}
                    });
```
* Attach the list-item clicks binder with builder as per the build data type
```java
...
  builder.setInstantViewClickBinder(new InstantViewClicksBinder<String>() {
                        @Override
                        public void onItemViewClick(View view, String data) {
                            Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
                        }
                    });
```
* Finally  InstantRecyclerView is ready with InstantBuilder `build()`
```java
...

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          InstantBuilder builder = InstantBuilder.newBuilder(String.class);
          builder.fromRecyclerView(MainActivity.this, R.id.recyclerViewId);
          ...
          ...
          InstantRecyclerView instantRecylerView = builder.build();
       }

   }

```



# Custom RecyclerView

Create a custom listitem recyclerview with loads array CustomDataModel.class & with single item clicks

* Custom RecyclerView holds the array of CustomDataModel objects, so we building a recyclerview type of <b>CustomDataModel.class</b>.

```java

public class CustomDataModel {

    private String versionName;
    private String versionDesc;

    public CustomModel(String versionName, String versionDesc) {
        this.versionName = versionName;
        this.versionDesc = versionDesc;
    }

    public String getVersionName() {
        return versionName;
    }

    public String getVersionDesc() {
        return versionDesc;
    }
}

...

public class MainActivity extends AppCompatActivity {


  private ArrayList<CustomDataModel> listData = new ArrayList();

  private void loadData(){

  listData.add(new CustomModel("Apple Pie", "SDK API level : 1, v : 1.0"));
  listData.add(new CustomModel("Banana Bread", "SDK API level : 2, v : 1.1 "));
  listData.add(new CustomModel("Cupcake", "SDK API level : 3, v : 1.5 "));
  ...
  ...
  listData.add(new CustomModel("Q - Android 10", "SDK API level : 29, v : 10.0 "));

  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          loadData();

          InstantBuilder builder = InstantBuilder.newBuilder(CustomDataModel.class);
          builder.fromRecyclerView(MainActivity.this, R.id.recyclerViewId);
          builder.itemVewResource(android.R.layout.simple_list_item_2);
          builder.setViewDataItems(listData);
       }

   }


```

* For Custom list-item we have custom clicks in list item with default item-view click, to invoke custom clicks we need to extend <b>InstantViewClicksBinder<T></b> for binding custom view with clicks

```java

interface CustomClicks<T> extends InstantViewClicksBinder<T> {

    void onTitleClick(Context context,String title);
    void onSubTitleClick(Context context,String subTitle);

}


...
builder.setInstantViewBinder(new InstantViewBinder<CustomDataModel>() {

                       private TextView textView;
                       private TextView textView2;
                       private CustomClicks clicks;

                        @Override
                        public void instantBindView(View iteView) {

                            textView = iteView.findViewById(android.R.id.text1);
                            textView2 = iteView.findViewById(android.R.id.text2);
                        }

                        @Override
                        public void instantBindViewClick(InstantViewClicksBinder<CustomDataModel> clickListener) {
                          clicks = (CustomClicks) clickListener;
                        }

                        @Override
                        public void instantBindData(final CustomDataModel data) {
                            textView.setText(data.getVersionName());
                            textView2.setText(data.getVersionDesc());

                           textView.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View view) {
                                clicks.onSubTitleClick(view.getContext(),dataModel.getVersionName());
                                 }
                               });

                            textView2.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View view) {
                                clicks.onSubTitleClick(view.getContext(),dataModel.getVersionDesc());
                                 }
                               });

                        }


                    })


```


* Implement the `CustomClicks` with instant builder

```java

  ...
  builder.setInstantViewClickBinder(new CustomClicks<CustomDataModel>() {
                        @Override
                        public void onItemViewClick(View view, CustomDataModel data) {}

                        @Override
                        public void onTitleClick(Context context,String title) {
                           Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSubTitleClick(Context context,String subTitle) {
                           Toast.makeText(context, subTitle, Toast.LENGTH_SHORT).show();
                        }

                    })
InstantRecyclerView instantRecylerView = builder.build();

```

# InstantRecyclerView properties

InstantRecyclerView is extendable from Recyclerview so it able to bring up all the properties for recyclerview. Apart from this we have

* <b>getRecyclerAdapter()</b> to get recyclerview adapter.
* <b>void setViewDataItems(... items) </b> set the list data if it is not set with instant builder
* <b>void setViewNewDataItems(... items)</b> update with new list data
* <b>void setViewNewDataItem(...  item)</b> update with new single data
* <b>void setViewNewDataItemAt(int position, ...  item)</b> update with new single data with positions
* <b>void deleteViewDataItem(... item)</b> delete single data
* <b>void deleteViewDataItemAt(int position)</b> delete single data with positions


# Implementation
Download the [@instant_recyclerview.aar][1] file and copy to the libs folder, libs folder must be added to `project-level.gradle` file

```gradle
allprojects {
    repositories {
        google()
        jcenter()
        flatDir {
            dirs 'libs'
        }
    }
}

```
Add @aar file dependancy in `app-level.gradle` file

```gradle

dependencies {
implementation(name:'instant_recyclerview', ext:'aar')
}

```


 [0]:https://github.com/Parmar-07/InstantRecyclerview/blob/master/app/demo/instant_recyclerview_demo.apk
 [1]:https://github.com/Parmar-07/InstantRecyclerview/blob/master/instant_recyclerview/aar/instant_recyclerview.aar
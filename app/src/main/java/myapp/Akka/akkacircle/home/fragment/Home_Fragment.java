package myapp.Akka.akkacircle.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import myapp.Akka.akkacircle.Util.Api;
import myapp.Akka.akkacircle.home.adapter.Category;
import myapp.Akka.akkacircle.home.model.Pojo;
import myapp.Akka.akkacircle.home.model.Images_list;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.ListManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home_Fragment extends Fragment  implements ListManager.ListManagerInterface {
    private RecyclerView categoryrecycler, recyclerView;
    private ArrayList<Images_list> arrayList;
    private ListManager listManager;
    public Category category;
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,
                container, false);
        imageView=view.findViewById(R.id.grocery);

        recyclerView = view.findViewById(R.id.recyclerimages);
        arrayList = new ArrayList();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        listManager = new ListManager(Home_Fragment.this, arrayList, R.layout.imagerecycler_cusstom, recyclerView, "");


        Images_list images_list=new Images_list();
        images_list.setImag(R.drawable.groceryicon);
        arrayList.add(images_list);

        Images_list images_list1=new Images_list();
        images_list1.setImag(R.drawable.dairy);
        arrayList.add(images_list1);
        Images_list images_list2=new Images_list();
        images_list2.setImag(R.drawable.diet);
        arrayList.add(images_list2);
        Images_list images_list3=new Images_list();
        images_list3.setImag(R.drawable.pharmacy);
        arrayList.add(images_list3);
        Images_list images_list4=new Images_list();
        images_list4.setImag(R.drawable.plantt);
        arrayList.add(images_list4);
        Images_list images_list5=new Images_list();
        images_list5.setImag(R.drawable.meat);
        arrayList.add(images_list5);

        listManager.getAdapter().notifyDataSetChanged();
        categoryrecycler=view.findViewById(R.id.categoryrecycler);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        categoryrecycler.setLayoutManager(mLayoutManager);
        categoryrecycler.setItemAnimator(new DefaultItemAnimator());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api service = retrofit.create(Api.class);

        Call<Pojo> call = service.getCategory();

        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                Category adapter = new Category(response.body().getCategory(), getActivity());
                categoryrecycler.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {

            }
        });

        return view;
    }


    @Override
    public void onBindView(ListManager.BaseViewHolder holder, int position, String for_what) {
        imageView.setImageResource(arrayList.get(position).getImag());

    }

    @Override
    public void ViewHolder(View itemView, String for_what) {
        imageView= (ImageView) itemView.findViewById(R.id.grocery);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

}

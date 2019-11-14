package myapp.Akka.akkacircle.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import myapp.Akka.akkacircle.home.model.Productlist;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.ListManager;

public class Cart_Fragment extends Fragment implements ListManager.ListManagerInterface {
    private RecyclerView  recyclerView;
    private ArrayList<Productlist> arrayList;

    private ListManager listManager;
    private TextView Describation, _dis,_price,_priceless;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment,
                container, false);

        recyclerView = view.findViewById(R.id.recyclercart);
        arrayList = new ArrayList();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        listManager = new ListManager(Cart_Fragment.this, arrayList, R.layout.cartlisting, recyclerView, "");

        for (int i = 0; i < 9; i++) {
            Productlist productlist = new Productlist();
            productlist.setImage(R.drawable.orange);
            productlist.setMaintext("Orange");
            productlist.setDescribcation("Akka Circle Choice Fresh Orange");
            productlist.setDiscount("20%off");
            productlist.setPrice("267");
            productlist.setAddlist("ADD +");
            arrayList.add(productlist);
        }
        listManager.getAdapter().notifyDataSetChanged();


        return view;
    }

    @Override
    public void onBindView(ListManager.BaseViewHolder holder, int position, String for_what) {

    }

    @Override
    public void ViewHolder(View itemView, String for_what) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
}

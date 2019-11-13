package myapp.Akka.akkacircle.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import myapp.Akka.akkacircle.Model.Productlist;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.ListManager;
import myapp.Akka.akkacircle.Util.addItem;

public class Pharmacy_fragment extends Fragment implements ListManager.ListManagerInterface {
    private RecyclerView recyclerView;
    private ArrayList<Productlist> arrayList;
    private addItem AddItem;

    private ListManager listManager;
    private ImageView imageView;
    private TextView _Maintext,Des,dis,price,_pricessless,_wait,_Add;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pharmacy_fragment,
                container, false);
        recyclerView =view.findViewById(R.id.recyclerfruits);

        arrayList = new ArrayList();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        listManager = new ListManager(Pharmacy_fragment.this, arrayList, R.layout.pharmacycustomlist, recyclerView, "",AddItem);
for (int i=0;i<10;i++) {
    Productlist productlist = new Productlist();
    productlist.setImage(R.drawable.pharmcy);
    productlist.setMaintext("Orange");
    productlist.setDescribcation("Akka Circle Choice Fresh Orange");
    productlist.setDiscount("50%off");
    productlist.setPrice("Rs.267");
    productlist.setPricessless("Rs.300");
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

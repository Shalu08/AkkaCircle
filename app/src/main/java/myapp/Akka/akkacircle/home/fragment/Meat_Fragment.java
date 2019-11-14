package myapp.Akka.akkacircle.home.fragment;

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

import myapp.Akka.akkacircle.home.model.Productlist;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.ListManager;
import myapp.Akka.akkacircle.Util.addItem;

public class Meat_Fragment extends Fragment implements ListManager.ListManagerInterface {
    private RecyclerView recyclerView;
    private ArrayList<Productlist> arrayList;
    private addItem additem;
    private ListManager listManager;
    private ImageView imageView;
    private TextView _Maintext,Des,dis,price,_pricessless,_wait;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meat_fragment,
                container, false);
        recyclerView = view.findViewById(R.id.recyclermeat);
        arrayList = new ArrayList();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        listManager = new ListManager(Meat_Fragment.this, arrayList, R.layout.meatcustom, recyclerView, "");



        Productlist productlist = new Productlist();
        productlist.setImage(R.drawable.bone);
        productlist.setMaintext("Bone");
        productlist.setDescribcation("Akka Circle Choice Fresh Bonn");
        productlist.setDiscount("50%off");
        productlist.setPrice("Rs.267");
        productlist.setPricessless("Rs.300");
        productlist.setAddlist("ADD +");

        arrayList.add(productlist);
        Productlist productlist1 = new Productlist();
        productlist1.setImage(R.drawable.chicken);
        productlist1.setMaintext("chicken");
        productlist1.setDescribcation("Akka Circle Choice Fresh chicken");
        productlist1.setDiscount("20%off");
        productlist1.setPrice("Rs.107");
        productlist1.setPricessless("Rs.200");

        productlist1.setAddlist("ADD +");

        arrayList.add(productlist1);
        Productlist productlist2 = new Productlist();
        productlist2.setImage(R.drawable.freshfishindia);
        productlist2.setMaintext("Fish");
        productlist2.setDescribcation("Akka Circle Choice Fresh Fish");
        productlist2.setDiscount("10%off");
        productlist2.setPrice("RS 507");
        productlist2.setPricessless("Rs.800");
        productlist2.setAddlist("ADD +");

        arrayList.add(productlist2);


        listManager.getAdapter().notifyDataSetChanged();
        return view;
    }

    @Override
    public void onBindView(ListManager.BaseViewHolder holder, int position, String for_what) {
        imageView.setImageResource(arrayList.get(position).getImage());
        _Maintext.setText(arrayList.get(position).getMaintext());
        Des.setText(arrayList.get(position).getDescribcation());
        dis.setText(arrayList.get(position).getDiscount());

        _wait.setText(arrayList.get(position).getWait());
        price.setText(arrayList.get(position).getPrice());
        _pricessless.setText(arrayList.get(position).getPricessless());

    }

    @Override
    public void ViewHolder(View itemView, String for_what) {
        imageView= (ImageView) itemView.findViewById(R.id.meatimg);
        _Maintext=(TextView)itemView.findViewById(R.id.meatname);
        Des=(TextView)itemView.findViewById(R.id.freshmeat);
        dis=(TextView)itemView.findViewById(R.id.offpricemeat);
        _wait=itemView.findViewById(R.id.waitmeat);
        price=(TextView)itemView.findViewById(R.id.moneymeat);
        _pricessless=(TextView)itemView.findViewById(R.id.pricelessmeat);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
}

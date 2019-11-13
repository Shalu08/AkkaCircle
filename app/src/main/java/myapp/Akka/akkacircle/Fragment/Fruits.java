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

public class Fruits extends Fragment implements ListManager.ListManagerInterface {

    private RecyclerView recyclerView;
    private ArrayList<Productlist> arrayList;

    private ListManager listManager;
   myapp.Akka.akkacircle.Util.addItem addItem;
    private ImageView imageView;
    private TextView _Maintext,Des,dis,price,_pricessless,_wait;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fruits,
                container, false);
        recyclerView =view.findViewById(R.id.recyclerfruits);

        arrayList = new ArrayList();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        listManager = new ListManager(Fruits.this, arrayList, R.layout.cartlisting, recyclerView, "",addItem);



        Productlist productlist = new Productlist();
        productlist.setImage(R.drawable.orange);
        productlist.setMaintext("Orange");
        productlist.setDescribcation("Akka Circle Choice Fresh Orange");
        productlist.setDiscount("50%off");
        productlist.setPrice("Rs.267");
        productlist.setPricessless("Rs.300");
        productlist.setAddlist("ADD +");

        arrayList.add(productlist);
        Productlist productlist1 = new Productlist();
        productlist1.setImage(R.drawable.onion);
        productlist1.setMaintext("Onion");
        productlist1.setDescribcation("Akka Circle Choice Fresh Onion");
        productlist1.setDiscount("20%off");
        productlist1.setPrice("Rs.60");
        productlist1.setPricessless("Rs.80");

        productlist1.setAddlist("ADD +");

        arrayList.add(productlist1);
        Productlist productlist2 = new Productlist();
        productlist2.setImage(R.drawable.cheery);
        productlist2.setMaintext("Cheery");
        productlist2.setDescribcation("Akka Circle Choice Fresh cherry");
        productlist2.setDiscount("10%off");
        productlist2.setPrice("Rs.507");
        productlist2.setPricessless("Rs.800");
        productlist2.setAddlist("ADD +");

        arrayList.add(productlist2);

        Productlist productlist3 = new Productlist();
        productlist3.setImage(R.drawable.apple);
        productlist3.setMaintext("Apple");
        productlist3.setDescribcation("Akka Circle Choice Fresh Apple");
        productlist3.setDiscount("8%off");
        productlist3.setPrice("Rs.100");
        productlist3.setPricessless("Rs.150");
        productlist3.setAddlist("ADD +");

        arrayList.add(productlist3);
        Productlist productlist4 = new Productlist();
        productlist4.setImage(R.drawable.potato);
        productlist4.setMaintext("Potato");
        productlist4.setDescribcation("Akka Circle Choice Fresh Potatos");
        productlist4.setDiscount("2%off");
        productlist4.setPrice("RS 20");
        productlist4.setPricessless("Rs.35");
        productlist4.setAddlist("ADD +");

        arrayList.add(productlist4);
        Productlist productlist5 = new Productlist();
        productlist5.setImage(R.drawable.tomatoes);
        productlist5.setMaintext("Tomatoes");
        productlist5.setDescribcation("Akka Circle Choice Fresh Tomatoes");
        productlist5.setDiscount("10%off");
        productlist5.setPrice("Rs.40");
        productlist5.setPricessless("Rs.50");
        productlist5.setAddlist("ADD +");

        arrayList.add(productlist5);
        Productlist productlist6 = new Productlist();
        productlist6.setImage(R.drawable.bananas);
        productlist6.setMaintext("Bananas");
        productlist6.setDescribcation("Akka Circle Choice Fresh Bananas");
        productlist6.setDiscount("15%off");
        productlist6.setPrice("Rs.50");
        productlist6.setPricessless("Rs.80");
        productlist6.setAddlist("ADD +");

        arrayList.add(productlist6);
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
        imageView= (ImageView) itemView.findViewById(R.id.img);
        _Maintext=(TextView)itemView.findViewById(R.id.orange);
        Des=(TextView)itemView.findViewById(R.id.freshorange);
        dis=(TextView)itemView.findViewById(R.id.offprice);
        _wait=itemView.findViewById(R.id.wait);
        price=(TextView)itemView.findViewById(R.id.moneyfruits);
        _pricessless=(TextView)itemView.findViewById(R.id.pricelessfruits);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
}

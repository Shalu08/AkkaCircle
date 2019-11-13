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

public class Dairy_Fragment extends Fragment implements ListManager.ListManagerInterface {
    private RecyclerView recyclerView;
    private ArrayList<Productlist> arrayList;
    private addItem AddItem;
    private ListManager listManager;
    private ImageView imageView;
    private TextView _Maintext,Des,dis,price,_pricessless,_wait,_Add,add,sub;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dairy_fragment,
                container, false);
        AddItem=new addItem() {
            @Override
            public void itemadd(String id, String name, String quantity, String discount, String price, String priceless) {

            }

            @Override
            public void remove(String id) {

            }
        };
        recyclerView=view.findViewById(R.id.dairyrecycler);
        arrayList=new ArrayList();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        listManager=new ListManager(Dairy_Fragment.this,arrayList,R.layout.dairycustomlist,recyclerView,"",AddItem);
        Productlist productlist = new Productlist();
        productlist.setImage(R.drawable.fullcream);
        productlist.setMaintext("Milk");
        productlist.setDescribcation("Akka Circle Choice Fresh Milk");
        productlist.setDiscount("10%off");
        productlist.setPrice("Rs.100");
        productlist.setPricessless("Rs.120");
        productlist.setAddlist("ADD +");

        arrayList.add(productlist);
        Productlist productlist1 = new Productlist();
        productlist1.setImage(R.drawable.gahi);
        productlist1.setMaintext("icecream");
        productlist1.setDescribcation("Akka Circle Choice IceCream");
        productlist1.setDiscount("1%off");
        productlist1.setPrice("Rs.60");
        productlist1.setPricessless("Rs.80");

        arrayList.add(productlist1);
        Productlist productlist2 = new Productlist();
        productlist2.setImage(R.drawable.icecream);
        productlist2.setMaintext("icecream");
        productlist2.setDescribcation("Akka Circle Choice IceCream");
        productlist2.setDiscount("1%off");
        productlist2.setPrice("Rs.60");
        productlist2.setPricessless("Rs.80");

        arrayList.add(productlist2);
        Productlist productlist3= new Productlist();
        productlist3.setImage(R.drawable.icecreamdairy);
        productlist3.setMaintext("icecream");
        productlist3.setDescribcation("Akka Circle Choice IceCream");
        productlist3.setDiscount("1%off");
        productlist3.setPrice("Rs.60");
        productlist3.setPricessless("Rs.80");

        arrayList.add(productlist3);
        Productlist productlist4 = new Productlist();
        productlist4.setImage(R.drawable.dahi);
        productlist4.setMaintext("Dahi");
        productlist4.setDescribcation("Akka Circle Choice Dahi");
        productlist4.setDiscount("1%off");
        productlist4.setPrice("Rs.60");
        productlist4.setPricessless("Rs.80");

        arrayList.add(productlist4);
        Productlist productlist5 = new Productlist();
        productlist5.setImage(R.drawable.icecream);
        productlist5.setMaintext("icecream");
        productlist5.setDescribcation("Akka Circle Choice IceCream");
        productlist5.setDiscount("1%off");
        productlist5.setPrice("Rs.60");
        productlist5.setPricessless("Rs.80");

        arrayList.add(productlist5);
        listManager.getAdapter().notifyDataSetChanged();
        return view;
    }

    @Override
    public void onBindView(ListManager.BaseViewHolder holder, final int position, String for_what) {
        final int i=1;
        imageView.setImageResource(arrayList.get(position).getImage());
        _Maintext.setText(arrayList.get(position).getMaintext());
        Des.setText(arrayList.get(position).getDescribcation());
        dis.setText(arrayList.get(position).getDiscount());
        _wait.setText(arrayList.get(position).getWait());
        price.setText(arrayList.get(position).getPrice());
        add.setVisibility(View.GONE);
        sub.setVisibility(View.GONE);
        _pricessless.setText(arrayList.get(position).getPricessless());
        _Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add.setVisibility(View.VISIBLE);
                sub.setVisibility(View.VISIBLE);
                _Add.setText(""+i);
                AddItem.itemadd(String.valueOf(position),_Maintext.getText().toString(),_Add.getText().toString(),dis.getText().toString(),price.getText().toString(),_pricessless.getText().toString());
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=i-1;
                sub.setText(""+a);
                AddItem.remove(String.valueOf(position));
                if(a==0){
                    sub.setVisibility(View.GONE);
                    _Add.setText("ADD ITEM");
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=i+1;
                add.setText(""+a);
                AddItem.itemadd(String.valueOf(position),_Maintext.getText().toString(),add.getText().toString(),dis.getText().toString(),price.getText().toString(),_pricessless.getText().toString());
            }
        });

    }

    @Override
    public void ViewHolder(View itemView, String for_what) {
        imageView= (ImageView) itemView.findViewById(R.id.dairyimg);
        _Maintext=(TextView)itemView.findViewById(R.id.dairyname);
        Des=(TextView)itemView.findViewById(R.id.freshdairy);
        dis=(TextView)itemView.findViewById(R.id.offpricedairy);
        _wait=itemView.findViewById(R.id.waitdairy);
        price=(TextView)itemView.findViewById(R.id.moneydairy);
        _pricessless=(TextView)itemView.findViewById(R.id.pricelessdairy);
        _Add=(TextView)itemView.findViewById(R.id.Add);
        add=(TextView)itemView.findViewById(R.id.add);
        sub=(TextView)itemView.findViewById(R.id.sub);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }



}
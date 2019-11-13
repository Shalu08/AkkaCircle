package myapp.Akka.akkacircle.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import myapp.Akka.akkacircle.Model.Productlist;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.ListManager;
import myapp.Akka.akkacircle.Util.addItem;

public class Cafe_Fragment extends Fragment implements ListManager.ListManagerInterface {
    private RecyclerView recyclerView;
    private ArrayList<Productlist> arrayList;
    private addItem AddItem;
    private ListManager listManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cafe_fragment,
                container, false);
        recyclerView=view.findViewById(R.id.dairyrecycler);
        arrayList=new ArrayList();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        listManager=new ListManager(Cafe_Fragment.this,arrayList,R.layout.cafecustomlist,recyclerView,"",AddItem);
        for (int i=0;i<9;i++) {
            Productlist productlist = new Productlist();
            productlist.setImage(R.drawable.fullcream);
            productlist.setMaintext("Milk");
            productlist.setDescribcation("Akka Circle Choice Fresh Milk");
            productlist.setDiscount("10%off");
            productlist.setPrice("Rs.100");
            productlist.setPricessless("Rs.120");
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

package myapp.Akka.akkacircle.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import myapp.Akka.akkacircle.Model.Images_list;
import myapp.Akka.akkacircle.R;
import myapp.Akka.akkacircle.Util.GridAdapter;
import myapp.Akka.akkacircle.Util.ListManager;
import myapp.Akka.akkacircle.Util.addItem;

public class Home_Fragment extends Fragment  implements ListManager.ListManagerInterface {
    private RecyclerView gridview, recyclerView;
    private ArrayList<Images_list> arrayList;
private addItem additem;
    private ListManager listManager, listgrid;
    public ImageView imageView,dailygrocery;
    private TextView textView;
    GridView gridView;
    static int pos;
    String[] values={"DietFood","Meat","Grocery","Fruit&Veg","Dairy","Pharmacy","Cafe"};
    int[] Images={R.drawable.dietfood,R.drawable.turkey,R.drawable.basket,R.drawable.harvest,R.drawable.milk,R.drawable.drug,R.drawable.cafe};

    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,
                container, false);
        imageView=view.findViewById(R.id.grocery);
        dailygrocery=view.findViewById(R.id.dailygroceryimg);
        textView=view.findViewById(R.id.dailygrocery);
        recyclerView = view.findViewById(R.id.recyclerimages);
        arrayList = new ArrayList();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        listManager = new ListManager(Home_Fragment.this, arrayList, R.layout.imagerecycler_cusstom, recyclerView, "",additem);


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
        gridView=view.findViewById(R.id.gridview);
        GridAdapter gridAdapter=new GridAdapter(getActivity(),values,Images);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment=null;
                if (position==0) {
                    fragment =new DietFood();
                }
                else if(position==1){
                    fragment=new Meat_Fragment();
                }
                else if (position==2){
                   fragment = new Grocery_Fragment();
                }
                else if (position==3){
                  fragment= new Fruits();
                }
                else if(position==4){
                   fragment= new Dairy_Fragment();
                }
                else if (position==5){
                fragment=new Pharmacy_fragment();
                }
                else if (position==6){
              fragment= new Cafe_Fragment();
                }


                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();

            }});



        /**   gridview= view.findViewById(R.id.List);

         arrayList = new ArrayList();
         GridLayoutManager gridLayoutManager = new GridLayoutManager( getActivity(), 4);
         gridview.setLayoutManager(gridLayoutManager);
         listgrid = new ListManager(Home_Fragment.this, arrayList, R.layout.gridcustomlist, gridview, "ABC");



         listgrid.getAdapter().notifyDataSetChanged();**/
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

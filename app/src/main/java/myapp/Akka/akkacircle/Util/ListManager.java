package myapp.Akka.akkacircle.Util;


import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListManager {

    private ArrayList listdata;

    private int resource;
    private recyclerview recyclerview1;
    private ListManagerInterface listManagerInterface;
    private String for_what;

    public interface ListManagerInterface {
        void onBindView(BaseViewHolder holder, int position, String for_what);
        void ViewHolder(View itemView, String for_what);
        boolean onCreateOptionsMenu(Menu menu);
    }

    public recyclerview getAdapter() {
        return recyclerview1;
    }

    public ListManager(ListManagerInterface listManagerInterface, ArrayList listdata, int resource, RecyclerView recyclerView, String for_what) {
        this.listdata = listdata;
        this.resource = resource;
        this.listManagerInterface = listManagerInterface;
        this.for_what = for_what;
        recyclerview1 = new recyclerview();
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(recyclerview1);
    }


    public class recyclerview extends RecyclerView.Adapter<BaseViewHolder> {


        @Override
        public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem = layoutInflater.inflate(resource, parent, false);
            BaseViewHolder viewHolder = new BaseViewHolder(listItem);
            return viewHolder;
        }


        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            listManagerInterface.onBindView(holder, position, for_what);
        }

        @Override
        public int getItemCount() {
            return listdata.size();
        }
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
            listManagerInterface.ViewHolder(itemView, for_what);

        }
    }
}

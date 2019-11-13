package myapp.Akka.akkacircle.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import myapp.Akka.akkacircle.Fragment.Home_Fragment;
import myapp.Akka.akkacircle.R;

public class GridAdapter extends BaseAdapter {
    Context context;

    public GridAdapter(Context context, String[] values, int[] images) {
        this.context = context;
        this.values = values;
        Images = images;
    }

    private final String[] values;
    private  final int[] Images;
    View view;
    LayoutInflater layoutInflater;
    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){

            view=new View(context);
            view=layoutInflater.inflate(R.layout.gridcustomlist,null);
            ImageView imageView=(ImageView) view.findViewById(R.id.dailygroceryimg);

            TextView textView=(TextView) view.findViewById(R.id.dailygrocery);
            imageView.setImageResource(Images[position]);
            textView.setText(values[position]);


        }
        return view;
    }
}

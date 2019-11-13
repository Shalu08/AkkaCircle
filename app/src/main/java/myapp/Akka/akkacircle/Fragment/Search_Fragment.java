package myapp.Akka.akkacircle.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import myapp.Akka.akkacircle.R;

public class Search_Fragment extends Fragment {
    Toolbar toolbar;
    ArrayAdapter adapter;
    ListView listView;

    TextView emptyView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment,
                container, false);
        setHasOptionsMenu(true);

        toolbar = view.findViewById(R.id.toolbar);
        listView = view.findViewById(R.id.listView);
        emptyView = view.findViewById(R.id.emptyView);
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.months_array));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setEmptyView(emptyView);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.appSearchBar);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Here is where we are going to implement the filter logic
                adapter.getFilter().filter(newText);
                return  true;
            }

        });


    }
}

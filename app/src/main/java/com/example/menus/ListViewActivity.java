package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewActivity extends AppCompatActivity {

    private ListView mainListView;
    private ArrayAdapter<String> listAdapter;
    ArrayList<String> planetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mainListView = findViewById(R.id.mainListView);

        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn"
                , "Uranus", "Neptune"};
        planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));

        listAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, planetList);

        mainListView.setAdapter(listAdapter);

        mainListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        mainListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.listview_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.listDelete:
                        deleteselectedItems();
                        mode.finish();
                        return true;
                    default:
                        return false;

                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }


    private void deleteselectedItems(){
        SparseBooleanArray checkeditempositions = mainListView.getCheckedItemPositions();
        int itemCount = mainListView.getCount();

        for(int i = itemCount - 1;i >= 0;i--){
            if(checkeditempositions.get(i)){
                listAdapter.remove(planetList.get(i));
            }
        }
        checkeditempositions.clear();
        listAdapter.notifyDataSetChanged();
    }


}

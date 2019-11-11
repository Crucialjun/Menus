package com.example.menus;



import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ActionMode mActionMode;

    private ActionMode.Callback mActionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.action_mode_context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.actioncontextmenu1:
                    Toast.makeText(MainActivity.this, "Action Menu Item 1 Selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.actioncontextmenu2:
                    Toast.makeText(MainActivity.this, "Action Menu Item 2 Selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.menuItem3:
                    Toast.makeText(MainActivity.this, "Action Menu Item 3 Selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.txtTitle);
        this.registerForContextMenu(textView);

        Button button = findViewById(R.id.btnActionmenu);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null) {
                    return false;
                } else {
                    mActionMode = startActionMode(mActionModeCallBack);
                    return true;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem1:
                Toast.makeText(this, "Menu Item 1 Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuItem2:
                Toast.makeText(this, "Menu Item 2 Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuItem3:
                Toast.makeText(this, "Menu Item 3 Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floating_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contextmenu1:
                Toast.makeText(this, "Context Menu Item 1 Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contextmenu2:
                Toast.makeText(this, "Context Menu Item 2 Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contextmenu3:
                Toast.makeText(this, "Context Menu Item 3 Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);


        }
    }

    public void showPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.pop_up_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.popmenu1:
                Toast.makeText(this, "Pop Menu Item 1 Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popmenu2:
                Toast.makeText(this, "Pop Menu Item 2 Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popmenu3:
                Toast.makeText(this, "Pop Menu Item 3 Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

}

package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_show, tv_show2;
    ImageButton btn_popup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_show = findViewById(R.id.tv_show);
        tv_show.setOnLongClickListener(context_menu);

        btn_popup = findViewById(R.id.btn_popup);
        btn_popup.setOnClickListener(popup_menu);

    }
    public View.OnClickListener popup_menu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PopupMenu popupMenu  = new PopupMenu(MainActivity.this, btn_popup);
            popupMenu.getMenuInflater().inflate(
                    R.menu.popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch(item.getItemId()){
                        case R.id.item1:
                            intent("bấm vô đây nè");
                            return true;
                        case R.id.item2:
                            intent("bấm dô đây cũng được");
                            return true;
                        case R.id.item3:
                            intent("bấm cái này cũng được");
                            return true;
                        default:
                            return false;
                    }
                }
            });
            popupMenu.show();
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(MainActivity.this);
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mnuAdd:
                intent("thêm thành công rùi :>");
                return true;
            case R.id.mnuEdit:
                intent("sửa thành công rùi :v");
                return true;
            case R.id.mnuDelete:
                intent("xóa thành công rùi :3");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private ActionMode mActionMode;
    public View.OnLongClickListener context_menu = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (mActionMode != null ) return false ;
            mActionMode = MainActivity.this.startActionMode(mActionModeCallBack);
            return false;
        }
    };


    public ActionMode.Callback mActionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            mode.setTitle("context");
            return true;
        }
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.context_add:
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

    public void intent(String msg){
        Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
        intent.putExtra("keymsg", "Bạn " + msg);
        startActivity(intent);
    }
}
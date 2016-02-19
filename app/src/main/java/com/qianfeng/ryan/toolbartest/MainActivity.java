package com.qianfeng.ryan.toolbartest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private boolean isSetBg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        toolbar.setTitle("Toolbar Demo");
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        isSetBg = sharedPreferences.getBoolean("setBg", false);

        if (isSetBg){
            setBackground();
        }

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.action_settings){
                    Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
                }
                if (item.getItemId() == R.id.set_bg){

                    setBackground();

                }

                return false;
            }
        });

    }

    private void setBackground() {

        getWindow().setBackgroundDrawableResource(R.drawable.bj3);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("setBg",true);
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}

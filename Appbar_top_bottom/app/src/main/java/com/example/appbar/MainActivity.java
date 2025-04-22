package com.example.appbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Toolbar topAppBar;
    BottomAppBar bottomAppBar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAppBar = findViewById(R.id.topAppBar);
        bottomAppBar = findViewById(R.id.bottomAppBar);
        fab = findViewById(R.id.fab);

        // Gắn Top AppBar
        setSupportActionBar(topAppBar);

        // Top AppBar Navigation Icon
        topAppBar.setNavigationOnClickListener(v ->
                Toast.makeText(this, "Top AppBar Menu clicked", Toast.LENGTH_SHORT).show()
        );

        // Bottom AppBar Navigation Icon
        bottomAppBar.setNavigationOnClickListener(v ->
                Toast.makeText(this, "Bottom AppBar Menu clicked", Toast.LENGTH_SHORT).show()
        );

        // Bottom AppBar item click
        bottomAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_search_bottom) {
                Toast.makeText(this, "Bottom Search clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.action_more_bottom) {
                Toast.makeText(this, "More clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        // FloatingActionButton
        fab.setOnClickListener(v ->
                Toast.makeText(this, "FAB clicked", Toast.LENGTH_SHORT).show()
        );
    }

    // Gắn menu cho TopAppBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_appbar_menu, menu);
        return true;
    }

    // Xử lý các menu item ở TopAppBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Toast.makeText(this, "Top Search clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_favorite) {
            Toast.makeText(this, "Favorite clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

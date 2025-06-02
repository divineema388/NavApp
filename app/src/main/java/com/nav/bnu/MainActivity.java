package com.nav.bnu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.widget.Toast;
import com.nav.bnu.databinding.ActivityMainBinding;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout; // Good to have for clarity if casting

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // The root is your DrawerLayout
        setSupportActionBar(binding.toolbar); // Your toolbar

        // binding.getRoot() is the DrawerLayout instance from your XML
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                (DrawerLayout) binding.getRoot(), // Explicitly cast for clarity, or rely on the 'if' block
                binding.toolbar,
                R.string.app_name, // Open drawer description
                R.string.app_name  // Close drawer description (consider R.string.navigation_drawer_open/close)
        );

        // The 'if' block from the previous example is robust:
        if (binding.getRoot() instanceof androidx.drawerlayout.widget.DrawerLayout) {
            DrawerLayout drawer = (DrawerLayout) binding.getRoot();
            drawer.addDrawerListener(toggle);
        } else {
            // This branch should not be hit with your current XML
            Log.w("MainActivity", "Root view is not a DrawerLayout. Navigation drawer toggle might not work as expected.");
        }
        toggle.syncState();

        binding.fab.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Replace with your action", Toast.LENGTH_SHORT).show());
    }
}
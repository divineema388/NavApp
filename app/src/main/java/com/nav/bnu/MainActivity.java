package com.nav.bnu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log; // Standard Android logging, can be kept or removed if not used
import android.content.Context;
import android.widget.Toast;
import com.nav.bnu.databinding.ActivityMainBinding;
import androidx.appcompat.app.ActionBarDrawerToggle;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // LogSender.startLogging(this); // REMOVE THIS LINE
        super.onCreate(savedInstanceState);
        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        // Ensure binding.getRoot() is the DrawerLayout if you are using a NavigationView
        // If binding.getRoot() is not the DrawerLayout, you need to pass the correct DrawerLayout instance.
        // For example, if your DrawerLayout has an id like 'drawer_layout':
        // ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.app_name, R.string.app_name);
        // binding.drawerLayout.setDrawerListener(toggle);

        // Assuming binding.getRoot() IS the DrawerLayout as per original code structure
        // If your root layout in activity_main.xml is not a DrawerLayout, this will cause issues.
        // Let's assume for now it is a DrawerLayout as the code implies.
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                binding.getRoot(), // This should be your DrawerLayout
                binding.toolbar,
                R.string.app_name, // Open drawer description
                R.string.app_name  // Close drawer description (you might want a different string here)
        );

        // If binding.getRoot() is indeed a DrawerLayout, you can cast it
        if (binding.getRoot() instanceof androidx.drawerlayout.widget.DrawerLayout) {
            androidx.drawerlayout.widget.DrawerLayout drawer = (androidx.drawerlayout.widget.DrawerLayout) binding.getRoot();
            drawer.addDrawerListener(toggle); // Use addDrawerListener instead of setDrawerListener
        } else {
            // Log a warning or handle the case where the root is not a DrawerLayout
            Log.w("MainActivity", "Root view is not a DrawerLayout. Navigation drawer toggle might not work as expected.");
        }
        toggle.syncState();

        // Use lambdas
        binding.fab.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Replace with your action", Toast.LENGTH_SHORT).show());
    }
}
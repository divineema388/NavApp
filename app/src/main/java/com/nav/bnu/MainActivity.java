package com.nav.bnu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;
import com.nav.bnu.databinding.ActivityMainBinding;
import com.itsaky.androidide.logsender.LogSender;
import androidx.appcompat.app.ActionBarDrawerToggle;

public class MainActivity extends AppCompatActivity {
	
	private ActivityMainBinding binding;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		// Remove this line if you don't want AndroidIDE to show this app's logs
		LogSender.startLogging(this);
        super.onCreate(savedInstanceState);
		// Inflate and get instance of binding
		binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
		setSupportActionBar(binding.toolbar);
		
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.getRoot(), binding.toolbar, R.string.app_name, R.string.app_name);
		binding.getRoot().setDrawerListener(toggle);
		toggle.syncState();

		// Use lambdas
		binding.fab.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Replace with your action", Toast.LENGTH_SHORT).show());
    }
}

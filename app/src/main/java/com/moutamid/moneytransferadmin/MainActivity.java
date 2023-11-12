package com.moutamid.moneytransferadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.fxn.stash.Stash;
import com.moutamid.moneytransferadmin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Constants.checkApp(this);

        binding.egypt.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.EGYPT);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.uae.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.United_Arab_Emirates);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.saudia.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.SAUDI_ARABIA);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.qatar.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.QATAR);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.morocco.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.MOROCCO);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.sudan.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.SUDAN);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.oman.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.OMAN);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.italy.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.ITALY);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.russia.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.RUSSIA);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.syria.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.SYRIA);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
        binding.palestine.setOnClickListener(v -> {
            Stash.put(Constants.VALUE, Constants.PALESTINE);
            startActivity(new Intent(this, CountryRatesActivity.class));
        });
    }
}
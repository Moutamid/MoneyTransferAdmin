package com.moutamid.moneytransferadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fxn.stash.Stash;
import com.moutamid.moneytransferadmin.databinding.ActivityCountryRatesBinding;

public class CountryRatesActivity extends AppCompatActivity {
    ActivityCountryRatesBinding binding;
    String name;
    String currencyCode = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryRatesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Constants.initDialog(this);

        binding.toolbar.back.setOnClickListener(v -> onBackPressed());
        binding.toolbar.title.setText("Set Rates");

        name = Stash.getString(Constants.VALUE, "");

        updateUI(name);

        setValues(name);

        binding.update.setOnClickListener(v -> {
            Constants.showDialog();
            CountriesRates countriesRates = getCountriesRate();
            Constants.databaseReference().child(Constants.VALUE).child(name).setValue(countriesRates)
                    .addOnSuccessListener(unused -> {
                        Constants.dismissDialog();
                        Toast.makeText(this, "Rates Updated", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }).addOnFailureListener(e -> {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        Constants.dismissDialog();
                    });
        });

    }

    private void setValues(String name) {
        Constants.showDialog();
        Constants.databaseReference().child(Constants.VALUE).child(name).get()
                .addOnSuccessListener(dataSnapshot -> {
                    if (dataSnapshot.exists()){
                        CountriesRates countriesRates = dataSnapshot.getValue(CountriesRates.class);
                        binding.egypt.getEditText().setText(String.valueOf(countriesRates.getRates().Egypt));
                        binding.uae.getEditText().setText(String.valueOf(countriesRates.getRates().UAE));
                        binding.saudi.getEditText().setText(String.valueOf(countriesRates.getRates().Saudi_Arabia));
                        binding.qatar.getEditText().setText(String.valueOf(countriesRates.getRates().Qatar));
                        binding.morocco.getEditText().setText(String.valueOf(countriesRates.getRates().Morocco));
                        binding.oman.getEditText().setText(String.valueOf(countriesRates.getRates().Oman));
                        binding.palestine.getEditText().setText(String.valueOf(countriesRates.getRates().Palestine));
                        binding.russia.getEditText().setText(String.valueOf(countriesRates.getRates().Russia));
                        binding.sudan.getEditText().setText(String.valueOf(countriesRates.getRates().Sudan));
                        binding.syria.getEditText().setText(String.valueOf(countriesRates.getRates().Syria));
                        binding.italy.getEditText().setText(String.valueOf(countriesRates.getRates().Italy));
                    }
                    Constants.dismissDialog();
                }).addOnFailureListener(e -> {
                    Constants.dismissDialog();
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private CountriesRates getCountriesRate() {
        CountriesRates.Rates rates = new CountriesRates.Rates(
            Double.parseDouble(binding.egypt.getEditText().getText().toString()),
            Double.parseDouble(binding.uae.getEditText().getText().toString()),
            Double.parseDouble(binding.saudi.getEditText().getText().toString()),
            Double.parseDouble(binding.qatar.getEditText().getText().toString()),
            Double.parseDouble(binding.morocco.getEditText().getText().toString()),
            Double.parseDouble(binding.sudan.getEditText().getText().toString()),
            Double.parseDouble(binding.oman.getEditText().getText().toString()),
            Double.parseDouble(binding.italy.getEditText().getText().toString()),
            Double.parseDouble(binding.russia.getEditText().getText().toString()),
            Double.parseDouble(binding.syria.getEditText().getText().toString()),
            Double.parseDouble(binding.palestine.getEditText().getText().toString())
        );

        return new CountriesRates(
                name, currencyCode, rates
        );
    }

    private void updateUI(String countryName) {
        if (countryName.equals(Constants.EGYPT)) {
            binding.egypt.setVisibility(View.GONE);
            currencyCode = Constants.Egypt;
        } else if (countryName.equals(Constants.ITALY)) {
            // Handle Italy
            binding.italy.setVisibility(View.GONE);
            currencyCode = Constants.Italy;
        } else if (countryName.equals(Constants.United_Arab_Emirates)) {
            // Handle UAE
            binding.uae.setVisibility(View.GONE);
            currencyCode = Constants.UAE;
        } else if (countryName.equals(Constants.SAUDI_ARABIA)) {
            // Handle Saudi Arabia
            binding.saudi.setVisibility(View.GONE);
            currencyCode = Constants.Saudi_Arabia;
        } else if (countryName.equals(Constants.QATAR)) {
            // Handle Qatar
            binding.qatar.setVisibility(View.GONE);
            currencyCode = Constants.Qatar;
        } else if (countryName.equals(Constants.MOROCCO)) {
            // Handle Morocco
            binding.morocco.setVisibility(View.GONE);
            currencyCode = Constants.Morocco;
        } else if (countryName.equals(Constants.SUDAN)) {
            // Handle Sudan
            binding.sudan.setVisibility(View.GONE);
        } else if (countryName.equals(Constants.OMAN)) {
            // Handle Oman
            binding.oman.setVisibility(View.GONE);
            currencyCode = Constants.Oman;
        } else if (countryName.equals(Constants.RUSSIA)) {
            // Handle Russia
            binding.russia.setVisibility(View.GONE);
            currencyCode = Constants.Russia;
        } else if (countryName.equals(Constants.SYRIA)) {
            // Handle Syria
            binding.syria.setVisibility(View.GONE);
            currencyCode = Constants.Syria;
        } else if (countryName.equals(Constants.PALESTINE)) {
            // Handle Palestine
            binding.palestine.setVisibility(View.GONE);
            currencyCode = Constants.Palestine;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Stash.clear(Constants.VALUE);
    }
}
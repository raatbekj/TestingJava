package com.example.testingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testingjava.databinding.ActivityMainBinding;
import com.example.testingjava.domain.Math;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initBtn();
    }

    private void initBtn() {
        binding.btnPlus.setOnClickListener(view ->
                plus(binding.editFirst.getText().toString(),
                        binding.editSecond.getText().toString()));
        binding.btnDiv.setOnClickListener(view ->
                div(binding.editFirst.getText().toString(),
                binding.editSecond.getText().toString()));
    }

    private void plus(String first, String second) {
        Math math = new Math();
        binding.txtResult.setText(math.add(first, second));
    }

    private void div(String first, String second) {
        Math math = new Math();
        binding.txtResult.setText(math.div(first, second));
    }
}
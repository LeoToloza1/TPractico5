package com.leotoloza.tpractico5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.leotoloza.tpractico5.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
private ActivityLoginBinding binding;
private LoginViewModel viewModel;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        viewModel.getMsjeError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.txtError.setText(s);
            }
        });
        Button btn = binding.btnIngresar;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = binding.etUsuario.getText().toString();
                String password = binding.pass.getText().toString();
                viewModel.login(usuario, password);
                binding.etUsuario.setText("");
                binding.pass.setText("");
            }
        });
    }
}
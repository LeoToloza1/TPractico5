package com.leotoloza.tpractico5.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leotoloza.tpractico5.databinding.FragmentSalirBinding;

public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button btn = binding.btnSalir;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    Dialogo.mostrardialogo(getActivity());

                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
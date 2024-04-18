package com.leotoloza.tpractico5.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.leotoloza.tpractico5.databinding.FragmentMusicaBinding;

public class MusicaFragment extends Fragment {

    private FragmentMusicaBinding binding;
    private Intent intent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMusicaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lineas para iniciar el servicio
                intent = new Intent(getContext(), ServicioMusical.class);
                getContext().startService(intent);
            }
        });

        binding.btnPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),ServicioMusical.class);
                getContext().stopService(intent);
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
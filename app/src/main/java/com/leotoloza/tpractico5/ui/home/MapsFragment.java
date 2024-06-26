package com.leotoloza.tpractico5.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.leotoloza.tpractico5.R;
import com.leotoloza.tpractico5.databinding.FragmentMapsBinding;

public class MapsFragment extends Fragment {
private FragmentMapsBinding binding;
private UbicacionViewModel viewModel;
    private Marker marker;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            viewModel.lecturaPermanente();
            viewModel.getMLocation().observe(getViewLifecycleOwner(), location -> {
                if (location != null) {
                    LatLng ubicacion = new LatLng(location.getLatitude(), location.getLongitude());
                    marker = googleMap.addMarker(new MarkerOptions().position(ubicacion).title("Mi Ubicacion"));
                    marker.setPosition(ubicacion);
                    // ajustando zoom
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15.0f));
                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
            });
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UbicacionViewModel.class);
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}
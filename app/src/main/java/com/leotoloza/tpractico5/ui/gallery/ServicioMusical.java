package com.leotoloza.tpractico5.ui.gallery;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.leotoloza.tpractico5.R;

public class ServicioMusical extends Service {
    private MediaPlayer mp;
    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.mi_corazon_encantado);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
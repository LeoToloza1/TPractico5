package com.leotoloza.tpractico5;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<String> msjeError;
    private Intent intent;
    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getMsjeError() {
        if(msjeError ==null){
            msjeError = new MutableLiveData<>();
        }
        return msjeError;
    }

    public void login(String usuario, String pass){
        if(usuario.equalsIgnoreCase("leo")&&pass.equalsIgnoreCase("123")){
            intent = new Intent(getApplication().getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        } else {
            mostrarError();
        }
    }

    public void mostrarError(){
        msjeError.postValue("Acceso denegado");
    }
}

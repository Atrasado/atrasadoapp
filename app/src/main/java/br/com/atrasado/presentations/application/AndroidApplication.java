package br.com.atrasado.presentations.application;

import android.app.Application;

import br.com.atrasado.data.internal.AtrasadosPreferences;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AtrasadosPreferences.setInstance(this);
        initializeInjector();
    }

    public void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}

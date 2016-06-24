package br.com.atrasado.presentations.application;

import android.app.Activity;

import javax.inject.Singleton;

import br.com.atrasado.data.repository.Meeting;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(Activity activity);

    Meeting provideMeeting();
}
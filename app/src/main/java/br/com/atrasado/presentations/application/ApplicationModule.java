package br.com.atrasado.presentations.application;

import javax.inject.Singleton;

import br.com.atrasado.data.repository.Meeting;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final AndroidApplication mApplication;

    public ApplicationModule(final AndroidApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Meeting provideMeeting() {
        return new Meeting();
    }
}
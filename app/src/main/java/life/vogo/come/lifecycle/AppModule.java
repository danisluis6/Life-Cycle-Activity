package life.vogo.come.lifecycle;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application mApplication;
    private Context mContext;

    AppModule(Application application, Context context) {
        this.mApplication = application;
        this.mContext = context;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

}

package life.vogo.come.lifecycle;


import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
class HomeModule {

    private HomeActivity mHomeActivity;

    HomeModule(HomeActivity homeActivity) {
        this.mHomeActivity = homeActivity;
    }

    @Provides
    @ActivityScope
    HomeActivity provideHomeActivity() {
        return mHomeActivity;
    }

    @Provides
    @ActivityScope
    HomePresenter provideHomePresenter(Context context, HomeActivity homeActivity) {
        return new HomePresenterImpl(context, homeActivity);
    }
}
package life.vogo.come.lifecycle;


import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    private HomeActivity mHomeActivity;

    public HomeModule(HomeActivity homeActivity) {
        this.mHomeActivity = homeActivity;
    }

    @Provides
    @ActivityScope
    HomeActivity provideHomeActivity() {
        return mHomeActivity;
    }
}
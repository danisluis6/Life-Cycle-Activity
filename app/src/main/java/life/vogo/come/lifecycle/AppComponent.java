package life.vogo.come.lifecycle;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    HomeComponent plus(HomeModule module);
}

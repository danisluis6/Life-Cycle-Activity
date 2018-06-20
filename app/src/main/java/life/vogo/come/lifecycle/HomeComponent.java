package life.vogo.come.lifecycle;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(

        modules = {
                HomeModule.class
        }
)
public interface HomeComponent {
    HomeActivity inject(HomeActivity activity);
}

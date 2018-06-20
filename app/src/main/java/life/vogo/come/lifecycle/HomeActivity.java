package life.vogo.come.lifecycle;

public class HomeActivity extends BaseActivity implements HomeView {

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule(this))
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void initAttributes() {

    }

    @Override
    protected void initViews() {

    }
}

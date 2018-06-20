package life.vogo.come.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements HomeView {

    @BindView(R.id.tvWrapper)
    TextView tvWrapper;

    @Inject
    Context mContext;

    @Inject
    HomePresenter mPresenter;

    private int backupResume = 0;

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
        mPresenter.bindView(this);
        tvWrapper.setText(getString(R.string.app_name).toString() +Constant.SPACE + backupResume);
        backupResume++;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
}

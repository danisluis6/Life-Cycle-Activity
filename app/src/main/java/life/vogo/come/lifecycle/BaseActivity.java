package life.vogo.come.lifecycle;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Inject
    public Application mContext;

    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        distributedDaggerComponents();
        setContentView(getLayoutRes());
        mUnbinder = ButterKnife.bind(this);
        ButterKnife.bind(this);
        initAttributes();
        initViews();
    }

    public abstract void distributedDaggerComponents();

    protected abstract int getLayoutRes();

    protected abstract void initAttributes();

    protected abstract void initViews();

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }
}
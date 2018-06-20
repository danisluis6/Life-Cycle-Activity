package life.vogo.come.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

    private String TAG = HomeActivity.class.getSimpleName();
    private String x;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule(this))
                .inject(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TAG, "Lorence NGUYEN");
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            x = savedInstanceState.getString(TAG);
        }
        tvWrapper.setText(x);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy");
    }
}

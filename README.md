# LIFE CYCLE ACTIVITY [![Build Status](https://travis-ci.org/nomensa/jquery.hide-show.svg)](https://travis-ci.org/nomensa/jquery.hide-show.svg?branch=master)
  
## Understand

```java
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
}
```
![alt text](https://github.com/danisluis6/Life-Cycle-Activity/blob/fill_ram/img/1.gif)
<img src = "https://github.com/danisluis6/Life-Cycle-Activity/blob/fill_ram/img/1.gif" width="360px" height="640px"/>

# LIFE CYCLE ACTIVITY [![Build Status](https://travis-ci.org/nomensa/jquery.hide-show.svg)](https://travis-ci.org/nomensa/jquery.hide-show.svg?branch=master)
  
## Understand `Quick App Switcher on your device`
1. Click on symbol of your device. It's look like this:
![alt text](https://github.com/danisluis6/Life-Cycle-Activity/blob/master/img/2.png)

2. Go to the application and perform with this manipulation.
![alt text](https://github.com/danisluis6/Life-Cycle-Activity/blob/master/img/1.gif)

<img src = "https://github.com/danisluis6/RxJava-Introduction/blob/level_research_reactive/Deeply/x.png" width="75px" height="40px"/>Don't call <b>onCreate()</b> and <b>onDestroyView()</b>

1. Solution here
- Using method <b>onSaveInstanceState</b> to save 
Example: 1
- Assume when touch switcher. Data will be lost and we need to get data again. By the way, the method onPause will be called.
=> We will remove data on this method.
Follow it.
![alt text](https://github.com/danisluis6/Life-Cycle-Activity/blob/master/img/3.gif)

- Way 1: Using getIntent() default in Activity
- [x] Get it from onCreate or onResume
- [x] Show it in on Resume
```java
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
        String temp = getString(R.string.app_name) + Constant.SPACE;
        getIntent().putExtra(Constant.TAG_STRING, temp);
        tvWrapper.setText(temp);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getExtras() != null ) {
            tvWrapper.setText(getIntent().getExtras().getString(Constant.TAG_STRING));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        tvWrapper.setText("");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}

```
- Way 2: Using global variable
[x] Get it from onCreate or onResume
[x] Show it in on Resume

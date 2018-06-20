package life.vogo.come.lifecycle;

import android.content.Context;

class HomePresenterImpl extends BasePresenter<HomeView> implements HomePresenter {

    private Context mContext;
    private HomeActivity mActivity;

    HomePresenterImpl(Context context, HomeActivity activity) {
        mContext = context;
        mActivity = activity;
    }

    @Override
    public void bindView(HomeView view) {
        super.bindView(view);
    }

    @Override
    public void unbindView() {
        super.unbindView();
    }

    @Override
    void updateView() {

    }
}

package life.vogo.come.lifecycle;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V> {

    private WeakReference<V> view;

    public void bindView(@NonNull V view) {
        this.view = new WeakReference<>(view);
        updateView();
    }

    void unbindView() {
        this.view = null;
    }

    abstract void updateView();
}

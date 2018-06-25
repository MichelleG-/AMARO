package teste.amaro.presentation.ui.base;

import android.support.v7.widget.Toolbar;

public interface BaseView
{
    void createActivity();
    void loadData();
    BaseActivity getBaseActivity();
    void configToolbar(Toolbar toolbar);
    void showProgress();
    void hideProgress();
    void showError(String message);
}

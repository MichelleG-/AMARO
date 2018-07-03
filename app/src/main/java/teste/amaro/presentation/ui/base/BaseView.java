package teste.amaro.presentation.ui.base;

import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import teste.amaro.domain.transferobject.ResponseTO;

public interface BaseView
{
    void createActivity();
    void loadData();
    BaseActivity getBaseActivity();
    void configToolbar(Toolbar toolbar);
    void showProgress();
    void hideProgress();
    void showError(String message);
    List<?> getList();

    void errorHandler(Throwable throwable);
    void errorHandler(ResponseTO responseTO);
    void errorHandler(Throwable throwable, ResponseTO responseTO);
}

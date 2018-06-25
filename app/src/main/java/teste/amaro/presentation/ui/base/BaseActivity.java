package teste.amaro.presentation.ui.base;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

@EActivity
public abstract class BaseActivity extends AppCompatActivity implements BaseView
{
    protected BasePresenter basePresenter;

    @Override
    public void inject()
    {
        this.basePresenter = new BasePresenter();
        this.basePresenter.injectDependencys(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}

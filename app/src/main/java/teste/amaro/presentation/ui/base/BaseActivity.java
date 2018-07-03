package teste.amaro.presentation.ui.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.List;

import teste.amaro.domain.transferobject.ResponseTO;
import teste.amaro.presentation.constant.Constant;
import teste.amaro.presentation.constant.IntentConstant;
import teste.amaro.presentation.ui.helper.TransitionHelper;

@EActivity
public abstract class BaseActivity extends AppCompatActivity implements BaseView
{
    private BasePresenter basePresenter;
    private LoadingFragment loadingFragment;

    @AfterViews
    public void injectDependencys()
    {
        this.basePresenter = new BasePresenter();
        this.basePresenter.injectDependencys(this);
    }

    @Override
    public void configToolbar(Toolbar toolbar)
    {
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void loadData()
    {
    }

    @Override
    public BaseActivity getBaseActivity()
    {
        return this;
    }

    @Override
    public void showProgress()
    {
        this.loadingFragment = new LoadingFragment();
        this.loadingFragment.show(getSupportFragmentManager(), Constant.LOADING_FRAGMENT);
    }

    @Override
    public void hideProgress()
    {
        this.basePresenter.hideLoading(this.loadingFragment);
    }

    @Override
    public void showError(String message)
    {
        Bundle bundle;

        bundle = new Bundle();
        bundle.putString(IntentConstant.MESSAGE_VALIDATE,  message);

        ValidateFragment_.builder().arg(bundle)
                .build()
                .show(this.getSupportFragmentManager(), Constant.VALIDATE_POPUP_FRAGMENT);
    }

    @Override
    public void errorHandler(Throwable throwable)
    {
        this.errorHandler(throwable, null);
    }

    @Override
    public void errorHandler(ResponseTO responseTO)
    {
        this.errorHandler(null, responseTO);
    }

    @Override
    public void errorHandler(Throwable throwable, ResponseTO responseTO)
    {
        this.hideProgress();
        this.basePresenter.errorHandler(throwable, responseTO);
    }

    public void onFailure(ResponseTO result)
    {
        this.errorHandler(result);
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        this.onBackPressed();
        return true;
    }

    @SuppressLint("NewApi")
    @SuppressWarnings("unchecked")
    public void transitionTo(Intent i)
    {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }

    @Override
    public List<?> getList() {
        return null;
    }
}

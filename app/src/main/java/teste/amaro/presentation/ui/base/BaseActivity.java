package teste.amaro.presentation.ui.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import teste.amaro.presentation.helper.TransitionHelper;

@EActivity
public abstract class BaseActivity extends AppCompatActivity implements BaseView
{
    protected BasePresenter basePresenter;

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
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public boolean onSupportNavigateUp()
    {
        this.onBackPressed();
        return true;
    }

    @SuppressLint("NewApi")
    @SuppressWarnings("unchecked") void transitionTo(Intent i)
    {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }
}

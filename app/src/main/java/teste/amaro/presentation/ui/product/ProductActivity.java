package teste.amaro.presentation.ui.product;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import teste.amaro.R;
import teste.amaro.presentation.ui.base.BaseActivity;
import teste.amaro.presentation.ui.base.BasePresenter;

@EActivity(R.layout.product_activity)
public class ProductActivity extends BaseActivity implements ProductView
{
    @AfterViews
    @Override
    public void createActivity()
    {

    }

    @Override
    public void loadData()
    {

    }
}

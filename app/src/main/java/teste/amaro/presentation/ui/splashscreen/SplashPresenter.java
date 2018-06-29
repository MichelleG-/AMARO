package teste.amaro.presentation.ui.splashscreen;

import android.annotation.SuppressLint;
import android.os.Handler;

import org.androidannotations.annotations.EBean;

import teste.amaro.presentation.constant.Constant;
import teste.amaro.presentation.navigator.Navigator;
import teste.amaro.presentation.ui.base.BasePresenter;
import teste.amaro.presentation.ui.base.BaseView;

@EBean
public class SplashPresenter extends BasePresenter
{
    private SplashView splashView;

    protected void injectDependecys(SplashView splashView)
    {
        this.splashView = splashView;
    }

    protected void createAcitivity()
    {
         this.splashView.loadAnimationSplash();
         this.loadSplash();
    }

    private void loadSplash()
    {
        new Handler().postDelayed(new Runnable()
        {
            @SuppressLint("NewApi")
            @Override
            public void run()
            {
                Navigator.navigateToProductActivity(splashView.getBaseActivity());
            }
        }, Constant.SPLASH_TIME_OUT);
    }
}

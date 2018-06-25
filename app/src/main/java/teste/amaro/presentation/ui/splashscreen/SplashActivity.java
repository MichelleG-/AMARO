package teste.amaro.presentation.ui.splashscreen;

import android.view.animation.Animation;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;

import teste.amaro.R;
import teste.amaro.presentation.ui.base.BaseActivity;

@Fullscreen
@EActivity(R.layout.splash_activity)
public class SplashActivity extends BaseActivity implements SplashView
{
    @ViewById(R.id.imgLogo)
    ImageView imgLogo;

    @AnimationRes(R.anim.fade_splash)
    Animation animation;

    @Bean
    SplashPresenter splashPresenter;

    @AfterViews
    public void createActivity()
    {
        this.splashPresenter.injectDependecys(this);
        this.splashPresenter.createAcitivity();
    }

    @Override
    public void loadAnimationSplash()
    {
        imgLogo.startAnimation(animation);
    }
}

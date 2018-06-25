package teste.amaro.presentation.ui.base;


public class BasePresenter
{
    private BaseView baseView;

    protected void injectDependencys(BaseView baseView)
    {
        this.baseView = baseView;
    }
}

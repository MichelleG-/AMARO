package teste.amaro.presentation.ui.base;

public interface BaseView
{
    void inject();
    void loadData();
    void showProgress();
    void hideProgress();
    void showError(String message);
}

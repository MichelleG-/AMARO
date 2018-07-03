package teste.amaro.presentation.ui.base;


import android.view.View;

import teste.amaro.domain.transferobject.ResponseTO;
import teste.amaro.presentation.enuns.ErrorEnum;

public class BasePresenter
{
    private BaseView baseView;

    protected void injectDependencys(BaseView baseView)
    {
        this.baseView = baseView;
    }

    protected void errorHandler(Throwable throwable, ResponseTO responseTO)
    {
        if(responseTO != null)
        {
            this.baseView.showError(this.baseView.getBaseActivity()
                    .getString(responseTO.getErrorEnum().getId()));
        }
        else
        {
            this.baseView.showError(this.baseView.getBaseActivity().getString(ErrorEnum.ERROR_DEFAULT.getId()));
        }
    }
}

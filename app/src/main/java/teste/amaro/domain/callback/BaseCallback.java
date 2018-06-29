package teste.amaro.domain.callback;

import org.springframework.http.HttpStatus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teste.amaro.domain.transferobject.ResponseTO;
import teste.amaro.presentation.enuns.ErrorEnum;
import teste.amaro.presentation.exception.ServiceBusinessException;

public class BaseCallback <T> implements Callback<T>
{
    private CallbackSync callbackSync;

    public BaseCallback(CallbackSync callbackSync)
    {
        this.callbackSync = callbackSync;
    }

    @Override
    public void onResponse(Call call, Response response)
    {
    }

    public void onSucessResponse(ResponseTO responseTO)
    {
        this.callbackSync.onSuccess(responseTO);
    }

    public void onFailureResponse(ResponseTO responseTO)
    {
        this.callbackSync.onFailure(responseTO);
    }

    @Override
    public void onFailure(Call call, Throwable t)
    {
        this.onFailureResponse(new ResponseTO(ErrorEnum.ERROR_DEFAULT));
    }

    public void checkResponse(final Response<?> response, final ErrorEnum error)
    {
        if (response == null || (response.code() != HttpStatus.OK.value() || response.raw().code() != HttpStatus.OK.value()))
        {
            throw new ServiceBusinessException(error);
        }
    }
}
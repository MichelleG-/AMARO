package teste.amaro.domain.callback;

import teste.amaro.domain.transferobject.ResponseTO;

public interface CallbackSync<T>
{
    void onSuccess(ResponseTO<T> result);
    void onFailure(ResponseTO<T> result);
}

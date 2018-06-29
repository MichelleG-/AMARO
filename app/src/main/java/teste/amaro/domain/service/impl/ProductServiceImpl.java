package teste.amaro.domain.service.impl;

import android.content.Context;

import retrofit2.Call;
import teste.amaro.presentation.exception.ServiceBusinessException;
import teste.amaro.presentation.exception.SystemException;
import teste.amaro.domain.callback.CallbackSync;
import teste.amaro.domain.callback.ProductCallback;
import teste.amaro.domain.model.Product;
import teste.amaro.domain.service.ServiceAPILocator;
import teste.amaro.domain.service.api.ProductServiceApi;

public class ProductServiceImpl extends BaseServiceImpl
{
    public void getListProducts(Context context, CallbackSync callback) throws ServiceBusinessException
    {
        Call<Product> callService;
        ProductServiceApi productServiceApi;

        try
        {
            this.doInBackground(context);

            productServiceApi = ServiceAPILocator.getInstance().lookup(ProductServiceApi.class);
            callService = productServiceApi.getProduct();
            callService.enqueue(new ProductCallback(callback));
        }
        catch (ServiceBusinessException exception)
        {
            throw exception;
        }
        catch (Exception exception)
        {
            throw new SystemException(exception.getMessage(), exception);
        }
    }
}

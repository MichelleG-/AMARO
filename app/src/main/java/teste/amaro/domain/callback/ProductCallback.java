package teste.amaro.domain.callback;

import retrofit2.Call;
import retrofit2.Response;
import teste.amaro.domain.builder.BuilderMapper;
import teste.amaro.domain.model.Product;
import teste.amaro.domain.mapper.ProductMapper;
import teste.amaro.domain.transferobject.ResponseTO;
import teste.amaro.presentation.enuns.ErrorEnum;
import teste.amaro.presentation.exception.ServiceBusinessException;
import teste.amaro.presentation.exception.SystemException;
import teste.amaro.domain.builder.ProductBuilder;

public class ProductCallback extends BaseCallback<Product>
{
    public ProductCallback(CallbackSync callbackSync)
    {
        super(callbackSync);
    }

    @Override
    public void onResponse(Call call, Response response)
    {
        BuilderMapper<ResponseTO, ProductMapper> productMapperBuilder;
        try
        {
            this.checkResponse(response, ErrorEnum.ERROR_PRODUCT);

            productMapperBuilder = new ProductBuilder();
            this.onSucessResponse(new ResponseTO(productMapperBuilder.build(new ResponseTO(response.body()))));
        }
        catch (ServiceBusinessException exception)
        {
            throw exception;
        }
        catch (Throwable exception)
        {
            throw new SystemException(exception.getMessage(), exception);
        }
    }

    @Override
    public void onFailure(Call call, Throwable t)
    {
        super.onFailureResponse(new ResponseTO(ErrorEnum.ERROR_DEFAULT));
    }
}
package teste.amaro.domain.service.api;

import retrofit2.Call;
import retrofit2.http.GET;
import teste.amaro.domain.model.Product;
import teste.amaro.presentation.constant.ServiceConstant;

public interface ProductServiceApi
{
    @GET(ServiceConstant.URL_PRODUCT)
    Call<Product> getProduct();
}

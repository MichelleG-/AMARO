package teste.amaro.domain.service;

import org.androidannotations.annotations.EBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import teste.amaro.presentation.constant.ServiceConstant;

@EBean
public class ServiceAPILocator
{
    private static ServiceAPILocator serviceAPILocator = null;

    public static ServiceAPILocator getInstance()
    {
        if (serviceAPILocator == null)
        {
            //Instancia o service
            return new ServiceAPILocator();
        }

        return serviceAPILocator;
    }

    public <T> T lookup(Class<T> serviceAPI)
    {
        return this.lookup(serviceAPI, ServiceConstant.URL_DEFAULT);
    }

    public <T> T lookup(Class<T> serviceAPI, String url)
    {
        Builder builder = new Builder();
        builder.connectTimeout(ServiceConstant.REST_READ_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(ServiceConstant.REST_READ_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(ServiceConstant.REST_READ_TIMEOUT, TimeUnit.SECONDS);

        OkHttpClient okHttpClient = builder.build();
        //this.allowAllCertificate(builder);
        //this.addCertificate(builder);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(serviceAPI);
    }
}

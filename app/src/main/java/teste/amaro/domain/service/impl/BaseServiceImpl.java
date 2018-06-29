package teste.amaro.domain.service.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import teste.amaro.presentation.enuns.ErrorEnum;
import teste.amaro.presentation.exception.ServiceBusinessException;

public class BaseServiceImpl
{
    public void doInBackground(Context context)
    {
        if (!this.verifyConnection(context))
        {
            throw new ServiceBusinessException(ErrorEnum.ERROR_WITHOUT_CONNECTION);
        }
    }

    public boolean verifyConnection(Context context)
    {
        ConnectivityManager connectivityManager = null;
        NetworkInfo activeNetworkInfo = null;

        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null)
        {
            return activeNetworkInfo.isConnected();
        }

        return false;
    }
}

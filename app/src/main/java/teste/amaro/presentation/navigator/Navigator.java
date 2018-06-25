package teste.amaro.presentation.navigator;

import android.content.Intent;

import teste.amaro.presentation.ui.base.BaseActivity;
import teste.amaro.presentation.ui.product.ProductActivity_;

/**
 * Class used to navigate through the application.
 */
public class Navigator
{
    public static void navigateToProductActivity(BaseActivity baseActivity)
    {
        baseActivity.startActivity(new Intent(baseActivity, ProductActivity_.class));
        baseActivity.finish();
    }

}

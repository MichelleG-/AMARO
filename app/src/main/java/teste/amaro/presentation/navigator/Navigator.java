package teste.amaro.presentation.navigator;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.presentation.constant.IntentConstant;
import teste.amaro.presentation.ui.base.BaseActivity;
import teste.amaro.presentation.ui.product.ProductActivity_;
import teste.amaro.presentation.ui.productdetail.ProductDetailActivity;

/**
 * Class used to navigate through the application.
 */
public class Navigator
{
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void navigateToProductActivity(BaseActivity baseActivity)
    {
        baseActivity.transitionTo(new Intent(baseActivity, ProductActivity_.class));
        baseActivity.finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void navigateToProductDetailActivity(BaseActivity baseActivity, ProductDetailMapper productDetailMapper)
    {
        Intent intent;

        intent = new Intent(baseActivity, ProductDetailActivity.class);
        intent.putExtra(IntentConstant.PRODUCT_DETAIL, productDetailMapper);
        baseActivity.transitionTo(intent);
    }
}

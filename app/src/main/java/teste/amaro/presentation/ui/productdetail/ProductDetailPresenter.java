package teste.amaro.presentation.ui.productdetail;

import android.view.View;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

import teste.amaro.R;
import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.domain.mapper.ProductSizeMapper;
import teste.amaro.presentation.constant.Constant;
import teste.amaro.presentation.ui.base.BasePresenter;
import teste.amaro.presentation.ui.product.ProductView;

@EBean
public class ProductDetailPresenter extends BasePresenter
{
    private ProductDetailView productDetailView;
    private List<ProductSizeMapper> listSizes;
    protected void injectDependecys(ProductDetailView productDetailView)
    {
        this.productDetailView = productDetailView;
    }

    protected void createAcitivity()
    {
        productDetailView.loadData();
    }

    public String bindPricePromotional(String priceRegular, String priceActual, boolean isOnSale)
    {
        if(isOnSale)
        {
            return this.productDetailView.getBaseActivity().getString(R.string.price_actual, priceActual) ;
        }

        return priceRegular;
    }


    public int isVisibleOnSale(boolean isOnSale)
    {
        if(isOnSale)
        {
            return View.VISIBLE;
        }

        return View.GONE;
    }

    public int setIconStatus(boolean isOnSale)
    {
        if(isOnSale)
        {
            return R.drawable.sale;
        }

        return R.drawable.sold;
    }

    public String bindDiscount(String discount)
    {
        if(discount.isEmpty())
        {
            return Constant.EMPTY_FIELD;
        }

        return discount;
    }

    public int isVisibleDiscount(String discount)
    {
        if(discount.isEmpty())
        {
            return View.GONE;
        }

        return View.VISIBLE;
    }

    public void saveListSize(List<ProductSizeMapper> listSizes)
    {
        this.listSizes = listSizes;
    }

    public List<ProductSizeMapper> getListSizes()
    {
        return this.listSizes;
    }
}

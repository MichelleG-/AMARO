package teste.amaro.presentation.ui.product;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import org.androidannotations.annotations.EBean;

import java.util.Collections;
import java.util.List;

import teste.amaro.R;
import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.domain.mapper.ProductMapper;
import teste.amaro.domain.transferobject.ResponseTO;
import teste.amaro.presentation.constant.Constant;
import teste.amaro.presentation.exception.ServiceBusinessException;
import teste.amaro.presentation.exception.SystemException;
import teste.amaro.presentation.ui.base.BasePresenter;
import teste.amaro.domain.callback.CallbackSync;
import teste.amaro.domain.service.impl.ProductServiceImpl;
import teste.amaro.presentation.ui.comparator.PriceComparator;

@EBean
public class ProductPresenter extends BasePresenter
{
    private ProductView productView;
    private List<ProductDetailMapper> listProducts;
    private List<ProductDetailMapper> listProductsSale;
    private List<ProductDetailMapper> listFilter;

    protected void injectDependecys(ProductView productView)
    {
        this.productView = productView;
    }

    protected void createAcitivity()
    {
        productView.loadData();
    }


    public void startServiceProductList(CallbackSync callbackSync)
    {
        try
        {
            new ProductServiceImpl().getListProducts(this.productView.getBaseActivity(), callbackSync);
        }
        catch (ServiceBusinessException serviceException)
        {
            serviceException.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void onSuccess(ResponseTO result)
    {
        ProductMapper productMapper;

        try
        {
            if(result.getResult() != null)
            {
                productMapper = (ProductMapper) result.getResult();
                this.saveListProducts(productMapper.getListProducts());
                this.saveListProductsSale(productMapper.getListProductsOnSale());
                this.productView.loadListProduct();
            }
        }
        catch (SystemException systemException)
        {
            systemException.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public List<ProductDetailMapper> getListProducts()
    {
        return this.listFilter;
    }

    public void  saveListProducts(List<ProductDetailMapper> listProducts)
    {
        this.listFilter = listProducts;
        this.listProducts = listProducts;
    }

    public void  saveListProductsSale(List<ProductDetailMapper> listProductsSale)
    {
        this.listProductsSale = listProductsSale;
    }

    public void dialogFilter()
    {
        String[] multiChoiceItems =  this.productView.getBaseActivity().getResources().getStringArray(R.array.dialog_filter);
        final boolean[] checkedItems = {false, false};

        new AlertDialog.Builder(this.productView.getBaseActivity())
                .setTitle(this.productView.getBaseActivity().getString(R.string.filter))
                .setMultiChoiceItems(multiChoiceItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int index, boolean isChecked)
                    {
                        if(index == Constant.FILTER_SALE)
                        {
                            listFilter = listProductsSale;
                            productView.loadListProduct();
                            dialog.dismiss();
                        }
                        else if(index == Constant.FILTER_ALL)
                        {
                            listFilter = listProducts;
                            productView.loadListProduct();
                            dialog.dismiss();
                        }
                    }
                })
                .show();
    }

    public void dialogOrder()
    {
        String[] multiChoiceItems =  this.productView.getBaseActivity().getResources().getStringArray(R.array.dialog_order);
        final boolean[] checkedItems = {false, false};

        new AlertDialog.Builder(this.productView.getBaseActivity())
                .setTitle(this.productView.getBaseActivity().getString(R.string.order))
                .setMultiChoiceItems(multiChoiceItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int index, boolean isChecked)
                    {
                        if(index == Constant.ORDER_GROWING)
                        {
                            Collections.sort(listFilter, new PriceComparator());
                            productView.loadListProduct();
                            dialog.dismiss();
                        }
                        else if(index == Constant.ORDER_DECREASING)
                        {
                            Collections.sort(listFilter, Collections.reverseOrder(new PriceComparator()));
                            productView.loadListProduct();
                            dialog.dismiss();
                        }
                    }
                })
                .show();
    }
}

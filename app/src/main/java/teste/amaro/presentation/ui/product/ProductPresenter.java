package teste.amaro.presentation.ui.product;

import org.androidannotations.annotations.EBean;

import java.util.List;

import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.domain.mapper.ProductMapper;
import teste.amaro.domain.transferobject.ResponseTO;
import teste.amaro.presentation.exception.ServiceBusinessException;
import teste.amaro.presentation.exception.SystemException;
import teste.amaro.presentation.ui.base.BasePresenter;
import teste.amaro.domain.callback.CallbackSync;
import teste.amaro.domain.service.impl.ProductServiceImpl;

@EBean
public class ProductPresenter extends BasePresenter
{
    private ProductView productView;
    private List<ProductDetailMapper> listProducts;
    private List<ProductDetailMapper> listProductsSale;
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
        return this.listProducts;
    }

    public void  saveListProducts(List<ProductDetailMapper> listProducts)
    {
        this.listProducts = listProducts;
    }

    public void  saveListProductsSale(List<ProductDetailMapper> listProductsSale)
    {
        this.listProductsSale = listProductsSale;
    }

    public List<ProductDetailMapper> getListProductsSale()
    {
        return this.listProductsSale;
    }
}
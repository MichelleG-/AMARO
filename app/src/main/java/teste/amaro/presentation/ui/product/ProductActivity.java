package teste.amaro.presentation.ui.product;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import teste.amaro.R;
import teste.amaro.domain.transferobject.ResponseTO;
import teste.amaro.presentation.ui.adapter.ProductAdapter;
import teste.amaro.presentation.ui.base.BaseActivity;
import teste.amaro.domain.callback.CallbackSync;

@EActivity(R.layout.product_activity)
public class ProductActivity extends BaseActivity implements ProductView, CallbackSync
{
    @ViewById(R.id.lstProduct)
    RecyclerView lstProduct;

    @Bean
    ProductPresenter productPresenter;

    @AfterViews
    @Override
    public void createActivity()
    {
        this.productPresenter.injectDependecys(this);
        this.productPresenter.createAcitivity();
    }

    @Override
    public void loadData()
    {
        this.productPresenter.startServiceProductList(this);
    }

    @Override
    public List<?> getList()
    {
        return productPresenter.getListProducts();
    }

    @Override
    public void loadListProduct()
    {
        ProductAdapter productAdapter;
        RecyclerView.LayoutManager layoutManager;

        productAdapter = new ProductAdapter(this);

        layoutManager = new GridLayoutManager(this.getBaseActivity(), 2);
        lstProduct.setLayoutManager(layoutManager);
        lstProduct.setItemAnimator(new DefaultItemAnimator());
        lstProduct.setAdapter(productAdapter);
    }

    @Override
    public void onSuccess(ResponseTO result)
    {
        this.productPresenter.onSuccess(result);
    }

    @Click(R.id.btnFilter)
    public void clickFilter()
    {
        this.productPresenter.dialogFilter();
    }

    @Click(R.id.btnOrder)
    public void clickOrder()
    {
        this.productPresenter.dialogOrder();
    }
}

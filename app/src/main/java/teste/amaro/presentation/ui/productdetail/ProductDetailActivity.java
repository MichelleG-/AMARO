package teste.amaro.presentation.ui.productdetail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import teste.amaro.R;
import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.presentation.constant.IntentConstant;
import teste.amaro.presentation.ui.adapter.ProductAdapter;
import teste.amaro.presentation.ui.adapter.ProductSizesAdapter;
import teste.amaro.presentation.ui.base.BaseActivity;
import teste.amaro.presentation.ui.helper.LoadImageHelper;

@EActivity(R.layout.product_detail_activity)
public class ProductDetailActivity extends BaseActivity implements ProductDetailView
{
    @ViewById(R.id.imgProduct)
    ImageView imgProduct;

    @ViewById(R.id.imgStatus)
    ImageView imgStatus;

    @ViewById(R.id.lstProductSizes)
    RecyclerView lstProductSizes;

    @ViewById(R.id.lblDiscount)
    TextView lblDiscount;

    @ViewById(R.id.lblPricePromotional)
    TextView lblPricePromotional;

    @ViewById(R.id.lblProductName)
    TextView lblProductName;

    @ViewById(R.id.lblInstallments)
    TextView lblInstallments;

    @ViewById(R.id.lblPrice)
    TextView lblPrice;

    @ViewById(R.id.lblColor)
    TextView lblColor;

    @Bean
    ProductDetailPresenter productDetailPresenter;

    @AfterViews
    @Override
    public void createActivity()
    {
        this.productDetailPresenter.injectDependecys(this);
        this.productDetailPresenter.createAcitivity();
    }

    @Override
    public void loadData()
    {
        Intent intent;
        ProductDetailMapper productDetailMapper;

        this.loadAnimationTransaction();

        intent = this.getIntent();
        productDetailMapper = (ProductDetailMapper) intent.getSerializableExtra(IntentConstant.PRODUCT_DETAIL);
        this.productDetailPresenter.saveListSize(productDetailMapper.getProducSizes());
        this.loadListSizes();
        this.bindFieldsProduct(productDetailMapper);
    }

    @SuppressLint("NewApi")
    @Override
    public void loadAnimationTransaction()
    {
        Transition transition;

        transition = TransitionInflater.from(this).inflateTransition(R.transition.slide_from_bottom);
        getWindow().setEnterTransition(transition);
    }

    @Override
    public void bindFieldsProduct(ProductDetailMapper productDetailMapper)
    {
        LoadImageHelper.load(this, productDetailMapper.getImage(), imgProduct);
        lblProductName.setText(productDetailMapper.getName());
        lblPrice.setText(productDetailPresenter.bindPricePromotional(productDetailMapper.getRegularPrice(), productDetailMapper.getActualPrice(), productDetailMapper.isOnSale()));

        lblPricePromotional.setVisibility(productDetailPresenter.isVisibleOnSale(productDetailMapper.isOnSale()));
        lblPricePromotional.setText(this.getString(R.string.price_promotional, productDetailMapper.getRegularPrice()));

        lblInstallments.setText(this.getString(R.string.or, productDetailMapper.getInstallments()));

        lblColor.setText(this.getString(R.string.color, productDetailMapper.getColor()));

        lblDiscount.setText(productDetailPresenter.bindDiscount(productDetailMapper.getDiscountPercentage()));
        lblDiscount.setVisibility(productDetailPresenter.isVisibleDiscount(productDetailMapper.getDiscountPercentage()));

        imgStatus.setImageResource(productDetailPresenter.setIconStatus(productDetailMapper.isOnSale()));
    }

    @Override
    public void loadListSizes()
    {
        ProductSizesAdapter productSizesAdapter;
        RecyclerView.LayoutManager layoutManager;
        LinearLayoutManager linearLayoutManager;

        productSizesAdapter = new ProductSizesAdapter(this);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        lstProductSizes.setLayoutManager(layoutManager);
        lstProductSizes.setItemAnimator(new DefaultItemAnimator());
        lstProductSizes.setAdapter(productSizesAdapter);
        productSizesAdapter.notifyDataSetChanged();
    }

    @Override
    public List<?> getList()
    {
        return this.productDetailPresenter.getListSizes();
    }
}

package teste.amaro.presentation.ui.adapter.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;

import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.domain.mapper.ProductSizeMapper;
import teste.amaro.presentation.navigator.Navigator;
import teste.amaro.presentation.ui.adapter.ViewWrapper;
import teste.amaro.presentation.ui.base.BaseView;
import teste.amaro.presentation.ui.helper.LoadImageHelper;
import teste.amaro.presentation.ui.viewholder.ProductSizeViewHolder;
import teste.amaro.presentation.ui.viewholder.ProductViewHolder;

public class ProductHelper
{
    public static void bindFieldsListProducts(Context context, ViewWrapper<ProductViewHolder> holder, ProductDetailMapper productDetailMapper)
    {
        LoadImageHelper.load(context, productDetailMapper.getImage(), holder.getView().imgProduct);

        holder.getView().lblProductName.setText(productDetailMapper.getName());
        holder.getView().lblPrice.setText(productDetailMapper.getActualPrice());

        if(productDetailMapper.getDiscountPercentage().isEmpty())
        {
            holder.getView().lblDiscount.setVisibility(View.GONE);
        }
        else
        {
            holder.getView().lblDiscount.setText(productDetailMapper.getDiscountPercentage());
            holder.getView().lblDiscount.setVisibility(View.VISIBLE);
        }
    }

    public static void bindFieldsListSizes(ViewWrapper<ProductSizeViewHolder> holder, ProductSizeMapper productSizeMapper)
    {
        holder.getView().lblSize.setText(productSizeMapper.getSize());
    }

    public static void setEventClickItem(final BaseView baseView, final ViewWrapper<ProductViewHolder> holder, final ProductDetailMapper productDetailMapper)
    {
        holder.getView().lnlItem.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v)
            {
                Navigator.navigateToProductDetailActivity(baseView.getBaseActivity(), productDetailMapper);
            }
        });
    }
}

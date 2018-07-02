package teste.amaro.presentation.ui.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.androidannotations.annotations.EViewGroup;

import teste.amaro.R;
import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.domain.mapper.ProductSizeMapper;
import teste.amaro.presentation.ui.adapter.helper.ProductHelper;
import teste.amaro.presentation.ui.base.BaseView;
import teste.amaro.presentation.ui.viewholder.ProductSizeViewHolder;
import teste.amaro.presentation.ui.viewholder.ProductSizeViewHolder_;
import teste.amaro.presentation.ui.viewholder.ProductViewHolder;
import teste.amaro.presentation.ui.viewholder.ProductViewHolder_;

public class ProductSizesAdapter extends RecyclerViewAdapterBase<ProductSizeMapper, ProductSizeViewHolder>
{
    private BaseView baseView;

    public ProductSizesAdapter(BaseView baseView)
    {
        super(baseView);
        this.baseView = baseView;
    }

    @Override
    protected ProductSizeViewHolder onCreateItemView(ViewGroup parent, int viewType)
    {
        return ProductSizeViewHolder_.build(this.baseView.getBaseActivity());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<ProductSizeViewHolder> holder, int position)
    {
        ProductSizeMapper productSizeMapper;

        productSizeMapper = (ProductSizeMapper) this.items.get(position);
        ProductHelper.bindFieldsListSizes(holder, productSizeMapper);
    }
}

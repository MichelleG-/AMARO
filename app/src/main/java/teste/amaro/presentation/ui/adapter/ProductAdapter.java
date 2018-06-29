package teste.amaro.presentation.ui.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.presentation.ui.adapter.helper.ProductHelper;
import teste.amaro.presentation.ui.base.BaseView;
import teste.amaro.presentation.ui.viewholder.ProductViewHolder;
import teste.amaro.presentation.ui.viewholder.ProductViewHolder_;

public class ProductAdapter extends RecyclerViewAdapterBase<ProductDetailMapper, ProductViewHolder>
{
    private BaseView baseView;

    public ProductAdapter(BaseView baseView)
    {
        super(baseView);
        this.baseView = baseView;
    }

    @Override
    protected ProductViewHolder onCreateItemView(ViewGroup parent, int viewType)
    {
        return ProductViewHolder_.build(this.baseView.getBaseActivity());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<ProductViewHolder> holder, int position)
    {
        ProductDetailMapper productDetailMapper;

        productDetailMapper = (ProductDetailMapper) this.items.get(position);
        ProductHelper.bindFieldsListProducts(this.baseView.getBaseActivity(), holder, productDetailMapper);
        ProductHelper.setEventClickItem(this.baseView, holder, null);
    }
}

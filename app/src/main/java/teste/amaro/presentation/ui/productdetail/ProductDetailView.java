package teste.amaro.presentation.ui.productdetail;

import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.presentation.ui.base.BaseView;

public interface ProductDetailView extends BaseView
{
    void loadAnimationTransaction();
    void bindFieldsProduct(ProductDetailMapper productDetailMapper);
    void loadListSizes();
}

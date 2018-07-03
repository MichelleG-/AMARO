package teste.amaro.presentation.ui.comparator;

import java.util.Comparator;

import teste.amaro.domain.mapper.ProductDetailMapper;

public class PriceComparator implements Comparator<ProductDetailMapper>
{
    @Override
    public int compare(ProductDetailMapper productDetailMapper, ProductDetailMapper productComparator)
    {
        double regularPrice;
        double regularPriceCompator;

        regularPrice = productDetailMapper.getRegularPriceNumber();
        regularPriceCompator = productComparator.getRegularPriceNumber();

        return Double.compare(regularPrice, regularPriceCompator);
    }
}

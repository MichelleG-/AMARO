package teste.amaro.domain.mapper;

import java.util.List;

public class ProductMapper implements Mapper
{
    private List<ProductDetailMapper> listProducts;
    private List<ProductDetailMapper> listProductsOnSale;

    public ProductMapper(List<ProductDetailMapper> listProducts, List<ProductDetailMapper> listProductsOnSale)
    {
        this.listProducts = listProducts;
        this.listProductsOnSale = listProductsOnSale;
    }

    public List<ProductDetailMapper> getListProducts()
    {
        return listProducts;
    }

    public List<ProductDetailMapper> getListProductsOnSale()
    {
        return listProductsOnSale;
    }
}

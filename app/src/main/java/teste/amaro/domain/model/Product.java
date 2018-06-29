package teste.amaro.domain.model;

import java.util.List;

import teste.amaro.domain.transferobject.TransferObject;

public class Product extends TransferObject
{
    private List<ProductDetail> products;

    public Product()
    {
    }

    public List<ProductDetail> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetail> products) {
        this.products = products;
    }
}

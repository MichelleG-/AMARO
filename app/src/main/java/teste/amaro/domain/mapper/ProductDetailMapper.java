package teste.amaro.domain.mapper;

import java.util.List;

public class ProductDetailMapper implements Mapper
{
    private String name;
    private String style;
    private String color;
    private boolean onSale;
    private String regularPrice;
    private String actualPrice;
    private String discountPercentage;
    private String installments;
    private String image;
    private List<ProductSizeMapper> producSizes;
    private Double regularPriceNumber;
    public ProductDetailMapper(String name, String style, String color, boolean onSale, String regularPrice, String actualPrice, String discountPercentage, String installments, String image, List<ProductSizeMapper> producSizes, Double regularPriceNumber)
    {
        this.name = name;
        this.style = style;
        this.color = color;
        this.onSale = onSale;
        this.regularPrice = regularPrice;
        this.actualPrice = actualPrice;
        this.discountPercentage = discountPercentage;
        this.installments = installments;
        this.image = image;
        this.producSizes = producSizes;
        this.regularPriceNumber = regularPriceNumber;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public String getColor() {
        return color;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public String getInstallments() {
        return installments;
    }

    public String getImage() {
        return image;
    }

    public List<ProductSizeMapper> getProducSizes() {
        return producSizes;
    }

    public Double getRegularPriceNumber() {
        return regularPriceNumber;
    }
}

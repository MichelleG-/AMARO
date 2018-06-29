package teste.amaro.domain.model;

import java.util.List;

import teste.amaro.domain.transferobject.TransferObject;

public class ProductDetail extends TransferObject
{
    private String name;
    private String style;
    private String code_color;
    private String color_slug;
    private String color;
    private boolean on_sale;
    private String regular_price;
    private String actual_price;
    private String discount_percentage;
    private String installments;
    private String image;
    private List<ProductSizes> sizes;

    public ProductDetail()
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCodeColor() {
        return code_color;
    }

    public void setCodeColor(String code_color) {
        this.code_color = code_color;
    }

    public String getColorSlug() {
        return color_slug;
    }

    public void setColorSlug(String color_slug) {
        this.color_slug = color_slug;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isOnSale() {
        return on_sale;
    }

    public void setOnSale(boolean on_sale) {
        this.on_sale = on_sale;
    }

    public String getRegularPrice() {
        return regular_price;
    }

    public void setRegularPrice(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getActualPrice() {
        return actual_price;
    }

    public void setActualPrice(String actual_price) {
        this.actual_price = actual_price;
    }

    public String getDiscountPercentage() {
        return discount_percentage;
    }

    public void setDiscountPercentage(String discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ProductSizes> getSizes() {
        return sizes;
    }

    public void setSizes(List<ProductSizes> sizes) {
        this.sizes = sizes;
    }
}

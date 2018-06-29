package teste.amaro.domain.model;

import teste.amaro.domain.transferobject.TransferObject;

public class ProductSizes extends TransferObject
{
   private boolean available;
   private String size;
   private String sku;

   public ProductSizes()
   {
   }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}

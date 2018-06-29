package teste.amaro.domain.mapper;

public class ProductSizeMapper implements Mapper
{
    private boolean available;
    private String size;

    public ProductSizeMapper(boolean available, String size)
    {
        this.available = available;
        this.size = size;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public String getSize()
    {
        return size;
    }
}

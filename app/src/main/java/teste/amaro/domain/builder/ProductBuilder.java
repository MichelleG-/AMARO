package teste.amaro.domain.builder;

import java.util.ArrayList;
import java.util.List;

import teste.amaro.domain.model.Product;
import teste.amaro.domain.model.ProductDetail;
import teste.amaro.domain.model.ProductSizes;
import teste.amaro.domain.mapper.ProductDetailMapper;
import teste.amaro.domain.mapper.ProductMapper;
import teste.amaro.domain.mapper.ProductSizeMapper;
import teste.amaro.domain.transferobject.ResponseTO;
import teste.amaro.presentation.constant.Constant;
import teste.amaro.presentation.enuns.ErrorEnum;
import teste.amaro.presentation.exception.SystemException;

public class ProductBuilder implements BuilderMapper<ResponseTO, ProductMapper>
{
    @Override
    public ProductMapper build(ResponseTO responseTO)
    {
        String name;
        String style;
        String color;
        String regularPrice;
        String actualPrice;
        String discountPercentage;
        String installments;
        String image;
        String size;

        List<ProductSizeMapper> listSizes = null;
        List<ProductDetailMapper> listProductDetail;
        List<ProductDetailMapper> listProductDetailOnSale;
        List<ProductDetail> listProducts;
        ProductDetail product;
        ProductSizes productSizes;

        int iCont = 0;
        int iContSizes = 0;

        double regularPriceNumber;

        try
        {
            if(responseTO == null)
            {
                throw new SystemException(ErrorEnum.ERROR_PRODUCT);
            }

            listProducts = ((Product) responseTO.getResult()).getProducts();

            if(listProducts == null || listProducts.size() == 0)
            {
                throw new SystemException(ErrorEnum.ERROR_PRODUCT_NO_PRODUCT);
            }

            listProductDetail = new ArrayList<>();
            listProductDetailOnSale = new ArrayList<>();

            while (iCont < listProducts.size())
            {
                product = listProducts.get(iCont);

                name = product.getName() != null ? product.getName() : Constant.EMPTY_FIELD;
                style = product.getStyle() != null ? product.getStyle() : Constant.EMPTY_FIELD;
                color = product.getColor() != null ? product.getColor() : Constant.EMPTY_FIELD;
                regularPrice = product.getRegularPrice() != null ? product.getRegularPrice() : Constant.EMPTY_FIELD;
                actualPrice = product.getActualPrice() != null ? product.getActualPrice() : Constant.EMPTY_FIELD;
                discountPercentage = product.getDiscountPercentage() != null ? product.getDiscountPercentage() : Constant.EMPTY_FIELD;
                installments = product.getInstallments() != null ? product.getInstallments() : Constant.EMPTY_FIELD;
                image = product.getImage() != null ? product.getImage() : Constant.EMPTY_FIELD;


                String teste = regularPrice.replace("R$ ", "").replace(",", ".");
                regularPriceNumber = Double.parseDouble(teste);

                if(product.getSizes() != null)
                {
                    listSizes = new ArrayList<>();

                    iContSizes = 0;
                    while (iContSizes < product.getSizes().size())
                    {
                        productSizes = product.getSizes().get(iContSizes);
                        size = productSizes.getSize() != null ? productSizes.getSize() : Constant.EMPTY_FIELD;

                        listSizes.add(new ProductSizeMapper(productSizes.isAvailable(), size));

                        iContSizes++;
                    }
                }

                listProductDetail.add(
                        new ProductDetailMapper(name, style, color, product.isOnSale(), regularPrice,
                                actualPrice, discountPercentage, installments, image, listSizes, regularPriceNumber));

                if(product.isOnSale())
                {
                    listProductDetailOnSale.add(
                            new ProductDetailMapper(name, style, color, product.isOnSale(), regularPrice,
                                    actualPrice, discountPercentage, installments, image, listSizes, regularPriceNumber));
                }

                iCont++;
            }
        }
        catch (SystemException exception)
        {
            throw exception;
        }
        catch (Exception exception)
        {
            throw new SystemException(exception.getMessage(), exception);
        }

        return new ProductMapper(listProductDetail, listProductDetailOnSale);
    }
}
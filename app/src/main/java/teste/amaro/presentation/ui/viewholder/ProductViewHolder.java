package teste.amaro.presentation.ui.viewholder;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import teste.amaro.R;

@EViewGroup(R.layout.product_cell)
public class ProductViewHolder extends RelativeLayout
{
    @ViewById(R.id.lnlItem)
    public LinearLayout lnlItem;

    @ViewById(R.id.imgProduct)
    public ImageView imgProduct;

    @ViewById(R.id.lblProductName)
    public TextView lblProductName;

    @ViewById(R.id.lblPrice)
    public TextView lblPrice;

    @ViewById(R.id.lblDiscount)
    public TextView lblDiscount;

    public ProductViewHolder(Context context)
    {
        super(context);
    }
}

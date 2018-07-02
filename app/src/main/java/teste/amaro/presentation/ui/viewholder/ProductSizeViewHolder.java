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

@EViewGroup(R.layout.product_size_cell)
public class ProductSizeViewHolder extends FrameLayout
{
    @ViewById(R.id.lblSize)
    public TextView lblSize;

    public ProductSizeViewHolder(Context context)
    {
        super(context);
    }
}
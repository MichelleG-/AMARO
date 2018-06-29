package teste.amaro.presentation.ui.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;

public class LoadImageHelper
{
    @SuppressLint("CheckResult")
    public static void load(Context context, String imageURL, ImageView imageView)
    {
        RequestManager glideRequestManager;
        RequestBuilder<Drawable> loader;

        glideRequestManager = Glide.with(context);
        loader = glideRequestManager.load(imageURL);
        loader.into(imageView);
    }
}

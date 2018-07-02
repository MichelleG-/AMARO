package teste.amaro.presentation.ui.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

import java.io.File;

public class CustomCachingGlideModuleHelper extends AppGlideModule
{
    private static final long TEN_MB_IN_BYTES = 1024 * 1024 * 10;

    @SuppressLint("NewApi")
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        long deviceDiskAvailableBytes = (getUsableSpace(Environment.getDataDirectory()) / 100);
        long deviceDiskUsableBytes = deviceDiskAvailableBytes > TEN_MB_IN_BYTES ? TEN_MB_IN_BYTES : deviceDiskAvailableBytes;
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, deviceDiskUsableBytes));


        // Get max available VM memory, exceeding this amount will throw an
        // OutOfMemory exception. Stored in kilobytes as LruCache takes an
        // int in its constructor.
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        builder.setMemoryCache(new LruResourceCache(cacheSize));
        builder.setBitmapPool(new LruBitmapPool(cacheSize));
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry)
    {
        // nothing to do here
    }

    private long getUsableSpace(File path)
    {
        final StatFs stats = new StatFs(path.getPath());
        return (long) stats.getBlockSize() * (long) stats.getAvailableBlocks();
    }
}
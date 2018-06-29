package teste.amaro.presentation.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import teste.amaro.presentation.ui.base.BaseView;

public abstract class RecyclerViewAdapterBase<T, V extends View>  extends RecyclerView.Adapter<ViewWrapper<V>>
{
    protected List<T> items = null;

    public RecyclerViewAdapterBase(BaseView baseView)
    {
        this.items = (List<T>) baseView.getList();
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    @Override
    public final ViewWrapper<V> onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ViewWrapper<V>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);
}
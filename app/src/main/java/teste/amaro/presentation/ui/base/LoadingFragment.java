package teste.amaro.presentation.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teste.amaro.R;

public class LoadingFragment extends DialogFragment
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(null);
        this.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.TransparentCompatLoading);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.loading_fragment, container, false);
    }
}
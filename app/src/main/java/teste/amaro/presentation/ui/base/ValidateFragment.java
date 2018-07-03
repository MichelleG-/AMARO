package teste.amaro.presentation.ui.base;


import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import teste.amaro.R;
import teste.amaro.presentation.constant.IntentConstant;


@EFragment(R.layout.validate_popup_fragment)
public class ValidateFragment extends DialogFragment
{
    @ViewById(R.id.btnClose)
    Button btnClose;

    @ViewById(R.id.lblError)
    TextView lblError;

    @AfterViews
    public void bindErrorValidate()
    {
        lblError.setText(this.getArguments().getString(IntentConstant.MESSAGE_VALIDATE));
    }

    @Click(R.id.btnClose)
    public void clickClose()
    {
        this.getActivity().finish();
    }
}

package teste.amaro.domain.transferobject;

import teste.amaro.presentation.enuns.ErrorEnum;

public class ResponseTO<T> extends TransferObject
{
    private T result = null;
    private ErrorEnum errorEnum;

    public ResponseTO()
    {
    }

    public ResponseTO(T result)
    {
        this.result = result;
    }

    public ResponseTO(ErrorEnum errorEnum)
    {
        this.errorEnum = errorEnum;
    }

    public ResponseTO(T result, ErrorEnum errorEnum)
    {
        this.result = result;
        this.errorEnum = errorEnum;
    }

    public T getResult()
    {
        return result;
    }

    public void setResult(T result)
    {
        this.result = result;
    }

    public ErrorEnum getErrorEnum()
    {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum)
    {
        this.errorEnum = errorEnum;
    }
}

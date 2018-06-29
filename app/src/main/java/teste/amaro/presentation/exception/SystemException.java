package teste.amaro.presentation.exception;

import teste.amaro.presentation.enuns.ErrorEnum;

public class SystemException extends RuntimeException
{
    private ErrorEnum errorEnum;

    public SystemException()
    {
    }

    public SystemException(ErrorEnum errorEnum)
    {
        this.errorEnum = errorEnum;
    }

    public SystemException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SystemException(String message, Throwable cause, ErrorEnum errorEnum)
    {
        super(message, cause);
        this.errorEnum = errorEnum;
    }

    public SystemException(Throwable cause)
    {
        super(cause);
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
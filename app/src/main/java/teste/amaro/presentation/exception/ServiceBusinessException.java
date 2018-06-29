package teste.amaro.presentation.exception;


import teste.amaro.presentation.enuns.ErrorEnum;

public class ServiceBusinessException extends RuntimeException
{
    private ErrorEnum errorEnum;

    public ServiceBusinessException()
    {
    }

    public ServiceBusinessException(ErrorEnum errorEnum)
    {
        this.errorEnum = errorEnum;
    }

    public ServiceBusinessException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ServiceBusinessException(String message, Throwable cause, ErrorEnum errorEnum)
    {
        super(message, cause);
        this.errorEnum = errorEnum;
    }

    public ServiceBusinessException(Throwable cause)
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
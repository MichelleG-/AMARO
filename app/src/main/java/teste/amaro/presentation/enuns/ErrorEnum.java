package teste.amaro.presentation.enuns;

import teste.amaro.R;

public enum ErrorEnum
{
    ERROR_DEFAULT(0),
    ERROR_PRODUCT(0),
    ERROR_PRODUCT_NO_PRODUCT(0),
    ERROR_WITHOUT_CONNECTION(0);

    private int id;

    ErrorEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name();
    }
}

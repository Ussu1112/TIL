package item3;

import java.io.Serializable;

public class staticFactorySingleton implements Serializable {
    private static final staticFactorySingleton INSTANCE = new staticFactorySingleton();
    private staticFactorySingleton() {    }
    public static staticFactorySingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}


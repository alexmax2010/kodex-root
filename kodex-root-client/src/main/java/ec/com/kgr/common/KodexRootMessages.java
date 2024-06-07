package ec.com.kgr.common;

import ec.com.kruger.utilitario.loggin.resources.MessageResolver;

/**
 * Values by environment.
 *
 * @author components on 2021/09/18.
 * @version 1.0
 */
public final class KodexRootMessages {

    public static final MessageResolver MESSAGE_RESOLVER = new MessageResolver(
        "ec.com.kgr.KodexRoot");

    private KodexRootMessages() {
        super();
    }

    /**
     * Get string value by key.
     *
     * @param key key propertie
     * @return value
     */
    public static String getString(String key) {
        return MESSAGE_RESOLVER.getString(key);
    }

}

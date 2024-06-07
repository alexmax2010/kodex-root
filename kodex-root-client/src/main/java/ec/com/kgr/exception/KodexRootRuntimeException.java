package ec.com.kgr.exception;

/**
 * KodexRoot Runtime Exception Class.
 *
 * @author components on 2021/09/18.
 * @version 1.0.0
 */
public class KodexRootRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 3263046821289003394L;

    /**
     * Constructor with args.
     *
     * @param message The message
     * @param cause The cause
     */
    public KodexRootRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}

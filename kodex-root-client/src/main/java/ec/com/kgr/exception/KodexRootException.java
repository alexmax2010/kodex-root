package ec.com.kgr.exception;

/**
 * KodexRoot Exception Class.
 *
 * @author components on 2021/09/18.
 * @version 1.0.0
 */
public class KodexRootException extends Exception {

    private static final long serialVersionUID = 3263046821289003394L;

    /**
     * Constructor.
     */
    public KodexRootException() {
        super();
    }

    /**
     * Constructor with args.
     *
     * @param message The message
     * @param cause The cause
     */
    public KodexRootException(String message, Throwable cause) {
        super(message, cause);
    }

}

package ec.com.kgr.exception;

/**
 * Entity not Foud Exception Class.
 *
 * @author components on 2021/08/06.
 * @version 1.0
 */
public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 10L;

    /**
     * EntityNotFoundException message constructor.
     *
     * @param message Message o exception
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}

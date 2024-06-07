package ec.com.kgr.util;

import java.lang.reflect.InvocationTargetException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.kgr.exception.KodexRootRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * ProjectUtil.
 *
 * @author components on 07/03/2022
 * @version 1.0
 */
@Slf4j
public final class ProjectUtil {

    /**
     * Constructor.
     */
    private ProjectUtil() {
    }

    /**
     * Transform to entity.
     *
     * @param source object
     * @param targetType Class type
     * @return entity
     */
    public static <T> T convert(Object source, Class<T> targetType) {
        try {
            T entity = targetType.getDeclaredConstructor().newInstance();
            PropertyUtils.copyProperties(entity, source);
            return entity;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
            | InstantiationException e) {
            throw new KodexRootRuntimeException("Error convert", e);
        }
    }

    /**
     * Transform to entity.
     *
     * @param source object
     * @param targetType Class type
     * @return entity
     */
    public static <T> T convert(Object source, Class<T> targetType, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(source), targetType);
        } catch (JsonProcessingException e) {
            throw new KodexRootRuntimeException("Error convert", e);
        }
    }
}

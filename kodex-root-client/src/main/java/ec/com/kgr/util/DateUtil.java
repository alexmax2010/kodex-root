package ec.com.kgr.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

/**
 * DateUtil.
 *
 * @author components on 07/03/2022
 * @version 1.0
 * @since 1.0.0
 */
public final class DateUtil {

    /**
     * Constructor.
     */
    private DateUtil() {
    }

    /**
     * Obtiene la fecha actual LocalDateTime.
     *
     * @return Date
     * @author components on 07/03/2022
     */
    public static Date currentDate() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date startDate() {
        YearMonth currentYearMonth = YearMonth.now();
        LocalDate firstDayOfMonth = currentYearMonth.atDay(1);
        LocalTime time = LocalTime.of(00, 00, 00);
        LocalDateTime firstDayOfMonthWithTime = LocalDateTime.of(firstDayOfMonth, time);
        return Date.from(firstDayOfMonthWithTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date endDate() {
        YearMonth currentYearMonth = YearMonth.now();
        LocalDate lastDayOfMonth = currentYearMonth.atEndOfMonth();
        LocalTime time = LocalTime.of(23, 59, 59);
        LocalDateTime lastDayOfMonthWithTime = LocalDateTime.of(lastDayOfMonth, time);
        return Date.from(lastDayOfMonthWithTime.atZone(ZoneId.systemDefault()).toInstant());
    }


}

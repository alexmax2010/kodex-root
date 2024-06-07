package ec.com.kgr.util;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilTest {

    @Test
    public void currentDateTest() {
        Date date = DateUtil.currentDate();
        Assert.assertNotNull(date);
    }
}


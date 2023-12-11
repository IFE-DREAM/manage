package com.neu;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class Newj2eeApplicationTests {

    @Test
    void contextLoads() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar cale = Calendar.getInstance();  // 取当前日期。

        Calendar calendar = new GregorianCalendar(cale.get(Calendar.YEAR),cale.get(Calendar.MONTH),cale.get(Calendar.DAY_OF_MONTH),8,30,0);
        Date date = calendar.getTime();
        System.out.println(format.format(date));
        System.out.println(format.format(cale.getTime()));
    }

}

package log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Log4JStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/12 10:41
 * @Version 1.0
 */
public class LogStudy {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogStudy.class);

    @Test
    public void logOne() {
        LOGGER.info("GOOD DAY ! ");
    }


}

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * <p> Project: cloud2020 </p>
 * <p> Package: PACKAGE_NAME </p>
 * <p> FileName: TimeTest <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2021/1/23
 */

public class TimeTest {

    @Test
    void getTime() {
        // 2021-01-23T09:52:52.886+08:00[Asia/Shanghai]
        System.out.println(LocalDateTime.now().atZone(ZoneId.of("Asia/Shanghai")));
    }

}

package com.jiayulou.order;

import com.jiayulou.order.feign.MovieFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieTest {

    @Autowired
    MovieFeignClient movieFeignClient;

    @Test
    void test() {
       String s = movieFeignClient.getMovie("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkY2ZmMTljMDlkYWVkMTE5MDY2YjBhNzI5ZTczMGFlZiIsIm5iZiI6MS43NDYwNTE4ODY1NjE5OTk4ZSs5LCJzdWIiOiI2ODEyYTMyZWZlMjI4MDUwMWExNDU4ZGMiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.rVVcHFVKSzfmaIt1wTEK01ZvfycBQ93JWQtwoKQu6LM");
        System.out.println(s);
    }
}

package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kx.redis.redlock.RedLockApplication;
import org.kx.redis.redlock.RedissonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * create by sunkx on 2018/1/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedLockApplication.class)
public class ConfTest {
    @Autowired
    private RedissonProperties myProps;

    @Test
    public void propsTest() throws JsonProcessingException {
        System.out.println("simpleProp: " + myProps.getHost());
    }
}

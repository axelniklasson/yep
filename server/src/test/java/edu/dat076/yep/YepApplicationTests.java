package edu.dat076.yep;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = YepServer.class)
public class YepApplicationTests {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}

}

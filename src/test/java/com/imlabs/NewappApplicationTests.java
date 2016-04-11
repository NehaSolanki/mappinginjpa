package com.imlabs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.imlabs.config.NewappApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NewappApplication.class)
@WebAppConfiguration
public class NewappApplicationTests {

	@Test
	public void contextLoads() {
	}

}

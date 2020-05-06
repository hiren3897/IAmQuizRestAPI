package fr.epita.tests.unit;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestSpring {

	private static final Logger LOGGER = LogManager.getLogger(TestSpring.class);

	@Inject
	@Named("firstQuery")
	String query;

	@Test
	public void testSimpleInject() {
		Assert.assertNotNull(query);

	}

}

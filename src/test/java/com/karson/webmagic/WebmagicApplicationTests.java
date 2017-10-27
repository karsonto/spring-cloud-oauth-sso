package com.karson.webmagic;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebmagicApplicationTests {
	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		  
	        String s = restTemplate.getForEntity("http://localhost:9002/product/1", String.class).getBody();
	        System.out.println(s);
	        
	}

}

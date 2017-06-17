package pl.home.spring.bean;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {
	
	private static Logger logger = Logger.getLogger(BeanFactory.class);
	
	public BeanFactory() {
		String mess = "Construct BeanFactory";
		System.out.println(mess);
		logger.info(mess);
	}
	
	@Bean
	public BikesCollectionBean2 bikesBean() {
		return new BikesCollectionBean2();
	}
}
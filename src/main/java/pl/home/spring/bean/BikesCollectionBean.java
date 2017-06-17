package pl.home.spring.bean;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BikesCollectionBean {

	private static Logger logger = LoggerFactory.getLogger(BikesCollectionBean.class);
	
	public BikesCollectionBean() {
		String mess = "Construct BikesCollecttionBean";
		System.out.println(mess);
		logger.info(mess);
	}
	
	public List<String> getBikesName() {
		return Arrays.asList("Cannondale", "Kona", "Santa Cruze");
	}
}

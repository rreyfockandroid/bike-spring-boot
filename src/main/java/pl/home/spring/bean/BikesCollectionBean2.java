package pl.home.spring.bean;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BikesCollectionBean2 {

	private static Logger logger = LoggerFactory.getLogger(BikesCollectionBean2.class);
	
	public BikesCollectionBean2() {
		String mess = "Construct BikesCollecttionBean___2";
		System.out.println(mess);
		logger.info(mess);
	}
	
	public List<String> getBikesName() {
		return Arrays.asList("Cannondale_2", "Kona_2", "Santa Cruze_2");
	}
}

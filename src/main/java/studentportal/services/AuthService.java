package studentportal.services;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import studentportal.model.UserInfo;
import studentportal.model.data.MockedData;

@Service
public class AuthService {

	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
	
	// Mocked service to always authenticate non null credentials and return a random user object
	public UserInfo getUserInfo(String email,
								String password){

		if(email == null || password == null){
			return null; // TODO throw exception
		}

		return MockedData.getUsers().get(new Random().nextInt(10));
	}
}  

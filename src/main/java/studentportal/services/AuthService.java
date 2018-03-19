package studentportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentportal.dao.ICredentialRepo;
import studentportal.dao.IStudentRepo;
import studentportal.exceptions.AuthException;
import studentportal.model.Credential;
import studentportal.model.Student;

@Service
public class AuthService {

	@Autowired
	private ICredentialRepo credentialDAO;
	
	@Autowired
	private IStudentRepo studentDAO;
	
	public Student authenticate(String email,
								String password) throws Exception{

		if(email == null || password == null){
			throw new AuthException("Null credentials");
		}

		Credential crd = credentialDAO.findByUserid(email);

		if(crd == null || !crd.getPwd().equals(password)){
			throw new AuthException("Incorrect credentials");
		}

		return studentDAO.findByEmail(email);

	}
}  

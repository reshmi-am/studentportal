package studentportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import studentportal.model.Credential;

public interface ICredentialRepo extends JpaRepository<Credential, String>{

	Credential findByUserid(String email);
}

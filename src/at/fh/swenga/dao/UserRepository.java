package at.fh.swenga.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import at.fh.swenga.model.UserModel;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	
	UserModel findByUserId(long id);
	List<UserModel> findByUsername(String name);
	
	

	}

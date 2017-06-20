
package at.fh.swenga.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import at.fh.swenga.model.UserModel;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	
	UserModel findByUserId(long id);
	List<UserModel> findByUsername(String name);
}

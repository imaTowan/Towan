package at.fh.swenga.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import at.fh.swenga.model.UserModel;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	
	UserModel findByUserId(long id);
	List<UserModel> findByUsername(String name);
	
	@Modifying
    @Query("UPDATE UserModel u SET u.isActivated = 1 WHERE u.userId = :userId")
    int setUserActivated(@Param("userId") long userId);
}

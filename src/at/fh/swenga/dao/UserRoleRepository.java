package at.fh.swenga.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.UserRoleModel;

@Repository
@Transactional
public interface UserRoleRepository extends CrudRepository<UserRoleModel, Integer>{

}

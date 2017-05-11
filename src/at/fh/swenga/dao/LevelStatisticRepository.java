package at.fh.swenga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.model.LevelStatisticModel;

@Repository
@Transactional
public interface LevelStatisticRepository extends JpaRepository<LevelStatisticModel, Integer>{

}

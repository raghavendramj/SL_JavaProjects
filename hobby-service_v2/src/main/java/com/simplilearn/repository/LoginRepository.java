package com.simplilearn.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.LoginUser;

@Repository
public interface LoginRepository extends CrudRepository<LoginUser, Long> {

	// @Query("select l from LoginUser l where l.username =?1 and l.password=?2")
	LoginUser findByUsernameAndPassword(String username, String password);

	LoginUser findByUsername(String username);

	@Modifying
	@Transactional
	@Query("update LoginUser log set log.password=:password where log.id=:id")
	void changePassword(@Param(value = "password") String password, @Param(value = "id") Long id);
}

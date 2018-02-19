package com.epoch.wsbrg_movies.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epoch.wsbrg_movies.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>  {
	User findByIdentity(String identity);
}

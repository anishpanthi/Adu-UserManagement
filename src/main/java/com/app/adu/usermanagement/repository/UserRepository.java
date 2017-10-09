package com.app.adu.usermanagement.repository;

import com.app.adu.usermanagement.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>, BaseRepository {
}

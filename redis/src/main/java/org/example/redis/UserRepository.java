package org.example.redis;

import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, String> {
}

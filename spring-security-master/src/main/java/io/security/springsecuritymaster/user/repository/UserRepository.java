package io.security.springsecuritymaster.user.repository;

import io.security.springsecuritymaster.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {

}

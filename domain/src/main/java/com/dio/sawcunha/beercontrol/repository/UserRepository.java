package com.dio.sawcunha.beercontrol.repository;

import com.dio.sawcunha.beercontrol.entity.Permissions;
import com.dio.sawcunha.beercontrol.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginAndPassword(String login, String password);

    @Query(" SELECT profile.permissions FROM User user INNER JOIN Profile profile ON user.profile = profile " +
           " WHERE user.login = :login")
    Set<Permissions> findPermissionsByLogin(String login);

}
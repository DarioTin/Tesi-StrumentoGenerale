package com.dariotintore.backend.Repository;


import com.dariotintore.backend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT COUNT(*) AS nelem FROM users U WHERE U.email = ?1", nativeQuery = true)
    Long checkEmailAlreadyExists(String email);

    @Query(value = "SELECT password FROM users  WHERE email = ?1", nativeQuery = true)
    String loginUser(String email, String password);

    @Query(value = "SELECT COUNT(*) as nelem FROM users U WHERE U.email = ?1", nativeQuery = true)
    Long doesUserExist(String email);

    @Query(value = "SELECT userid FROM users U WHERE U.email =?1", nativeQuery = true)
    Long getIdByEmail(String Email);

}


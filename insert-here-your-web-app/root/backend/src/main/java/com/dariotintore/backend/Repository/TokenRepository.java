package com.dariotintore.backend.Repository;

import com.dariotintore.backend.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query(value = "SELECT COUNT(*) AS nelem FROM activetokens A WHERE A.email = ?1", nativeQuery = true)
    Long checkTokenAlreadyExists(String email);

    @Query(value = "SELECT COUNT(*) AS nelem FROM activetokens WHERE email = ?1 AND tk = ?2", nativeQuery = true)
    Long validateToken(String email, String token);

    @Modifying
    @Query(value = "delete from activetokens where email = ?1", nativeQuery = true)
    void deleteByEmail(String email);

}

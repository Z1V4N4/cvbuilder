package com.batm.cvbuilder.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("""
            SELECT u, e, r  FROM User u INNER JOIN u.Employee e INNER JOIN u.Role r
            WHERE u.Email = ?1
                """)
    User getUserByEmail(String email);
}

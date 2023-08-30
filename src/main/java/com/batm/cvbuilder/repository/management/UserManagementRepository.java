package com.batm.cvbuilder.repository.management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batm.cvbuilder.model.master.User;

@Repository
public interface UserManagementRepository extends JpaRepository<User, Integer> {
    @Query("""
            SELECT u, e, r  FROM User u INNER JOIN u.Employee e INNER JOIN u.Role r
            WHERE u.Email = ?1 and u.Password = ?2
                """)
    User getLogin(String email, String password);

    @Query("""
            SELECT u FROM User u
            WHERE u.Email = ?1
                """)
    User getByEmail(String email);

    @Query("""
            SELECT u, e, r  FROM User u INNER JOIN u.Employee e INNER JOIN u.Role r
            WHERE u.Email = ?1
                """)
    User Login(String email);
}

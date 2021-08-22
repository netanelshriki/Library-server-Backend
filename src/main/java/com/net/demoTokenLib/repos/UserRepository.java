package com.net.demoTokenLib.repos;

import com.net.demoTokenLib.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
   boolean existsByEmailAndPassword(String email,String password);

    User findByEmailAndPassword(String email, String password);
}

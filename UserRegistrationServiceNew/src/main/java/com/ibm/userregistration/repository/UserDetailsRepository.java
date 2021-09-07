package com.ibm.userregistration.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.userregistration.entity.UserDetails;
import java.util.Optional;
public interface UserDetailsRepository extends JpaRepository<UserDetails,String>
{
        Optional<UserDetails> findByEmailId(String emailId);
        Optional<UserDetails> findByMobileNo(long mobileNo);
        @Query("select count(*) from UserDetails where username=:username  and password=:password")
        public int getUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}

package com.ibm.userregistration.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ibm.userregistration.entity.UserDetails;
import com.ibm.userregistration.repository.UserDetailsRepository;
import java.util.Optional;
@Service
public class UserDetailsService 
{
    @Autowired
    UserDetailsRepository userDetailsRepository;
    
    @Transactional
    public boolean insertUserDetails(UserDetails userDetails)
    {
    	return userDetailsRepository.save(userDetails)!=null ? true : false;
    }
    
    @Transactional
    public boolean modifyUserDetails(UserDetails userDetails)
    {
    	return userDetailsRepository.save(userDetails)!=null ? true : false;
    }
    
    @Transactional(readOnly=true)
    public UserDetails getUSerDetailsByUsername(String username)
    {
    	Optional<UserDetails> userDetails = userDetailsRepository.findById(username);
    	if(userDetails.isPresent()) return userDetails.get();
    	return null;
    }
    
    @Transactional(readOnly=true)
    public UserDetails getUSerDetailsByEmailId(String emailId)
    {
    	Optional<UserDetails> userDetails = userDetailsRepository.findByEmailId(emailId);
    	if(userDetails.isPresent()) return userDetails.get();
    	return null;
    }
    
    @Transactional(readOnly=true)
    public UserDetails getUSerDetailsByMobileNo(long mobileNo)
    {
    	Optional<UserDetails> userDetails = userDetailsRepository.findByMobileNo(mobileNo);
    	if(userDetails.isPresent()) return userDetails.get();
    	return null;
    }

    @Transactional(readOnly=true)
    public boolean authenticateUser(String username,String password)
    {
    	return userDetailsRepository.getUserByUsernameAndPassword(username, password) == 1;
    }
}

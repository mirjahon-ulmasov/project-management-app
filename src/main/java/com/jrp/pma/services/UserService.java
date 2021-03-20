package com.jrp.pma.services;

import com.jrp.pma.dao.UserRepository;
import com.jrp.pma.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public UserAccount save(UserAccount user){
        return userRepo.save(user);
    }

    public List<UserAccount> getAll(){
        return userRepo.findAll();
    }
}

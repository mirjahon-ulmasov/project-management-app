package com.jrp.pma.dao;

import com.jrp.pma.entities.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserAccount, Long> {

    @Override
    List<UserAccount> findAll();


}

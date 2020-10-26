package com.performance.testing.performance.controller;


import com.performance.testing.performance.model.Accounts;
import com.performance.testing.performance.model.Courses;
import com.performance.testing.performance.model.Roles;
import com.performance.testing.performance.repository.AccountRepo;
import com.performance.testing.performance.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    @Qualifier("accountRepo")
    private AccountRepo accountRepo;

    @RequestMapping(method = RequestMethod.POST)
    public List<Accounts> addAccounts(@RequestBody List<Accounts> accounts){
        return this.accountRepo.saveAll(accounts);
    }
    @RequestMapping
    @Transactional(readOnly = true)
    public List<Accounts> getAccounts(){
        Stream<Accounts> list =  this.accountRepo.getAll();
        return list.collect(Collectors.toList());
    }
    @RequestMapping("/v2")
    public List<Accounts> getAccounts2(){
        List<Accounts> list =  this.accountRepo.getAll2();
        return list;
    }
}

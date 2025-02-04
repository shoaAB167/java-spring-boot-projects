package com.s_project_hibernate.service;

import com.s_project_hibernate.model.Users;
import com.s_project_hibernate.model.UsersContact;
import com.s_project_hibernate.repository.UsersContactRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rest/userscontact")
@RestController
public class UsersContactService {

    private final UsersContactRepository usersContactRepository;

    public UsersContactService(UsersContactRepository usersContactRepository) {
        this.usersContactRepository = usersContactRepository;
    }

    @GetMapping(value = "/all")
    public List<UsersContact> getUsersContact() {
        return usersContactRepository.findAll();
    }

    @GetMapping(value = "/update/{name}")
    public List<UsersContact> update(@PathVariable final String name) {
        UsersContact usersContact = new UsersContact();
        Users users = new Users();

        users.setTeamName("Development");
        users.setSalary(10000);
        users.setName(name);

        usersContact.setPhoneNo(11111);
        usersContact.setUsers(users);

        usersContactRepository.save(usersContact);

        return usersContactRepository.findAll();
    }


}
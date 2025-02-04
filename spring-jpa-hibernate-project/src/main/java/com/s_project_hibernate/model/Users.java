package com.s_project_hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users", catalog = "test")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates ID
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    private Integer salary;
    private String teamName;

    //bidirectional mapping
    //When you frequently need to access both related entities
    //(e.g., fetching a user's contact or getting the user from a contact).
    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private UsersContact userContact;

    public Users() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
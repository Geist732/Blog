package com.example.Models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nick on 1/9/17.
 */
public interface Users extends CrudRepository<User, Long>{
    public User findByUsername(String username);

    //    void save(User user);

}

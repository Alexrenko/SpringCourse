package edu.geek.spring.springsecurity.services;

import edu.geek.spring.springsecurity.entities.User;
import edu.geek.spring.springsecurity.repositories.RoleRepository;
import edu.geek.spring.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).get());
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}

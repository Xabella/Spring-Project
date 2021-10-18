package com.practice.project.service;

import com.practice.project.configuration.UserDetailsImpl;
import com.practice.project.model.User;
import com.practice.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    public void saveUser(User userModel) {

        userModel.setPassword(encoder.encode(userModel.getPassword()));

        userRepository.save(userModel);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);

        if (user == null) {
            throw new IllegalStateException("User does not exist");
        }

        return UserDetailsImpl.build(user);
    }

    public List<User> getUser() {
        List<User> all = userRepository.findAll();

        return all;
    }

    public void delete(long id) {
        Optional<User> optionalUserModel = userRepository.findById(id);

        if (optionalUserModel.isEmpty()) {
            throw new IllegalArgumentException("User does not exist");
        }

        userRepository.deleteById(id);
    }

    public void editUser(User userModel) {
        Optional<User> optionalUserModel = userRepository.findById(userModel.getId());

        if (optionalUserModel.isEmpty()) {
            throw new IllegalArgumentException("User does not exist");
        }

        optionalUserModel.get().setUsername(userModel.getUsername());
        optionalUserModel.get().setEmail(userModel.getEmail());
        optionalUserModel.get().setPassword(userModel.getPassword());

        userRepository.save(optionalUserModel.get());
    }

}

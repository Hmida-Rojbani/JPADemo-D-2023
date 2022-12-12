package de.tekup.jpademo.security.services;

import de.tekup.jpademo.security.entities.Role;
import de.tekup.jpademo.security.entities.User;
import de.tekup.jpademo.security.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository ;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public void registerUser(User user){

            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
    }

    public User userByUsername(String username){
        return userRepository.findByUsername(username).get();
    }


}

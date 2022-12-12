package de.tekup.jpademo.security.services;

import de.tekup.jpademo.security.entities.SecurityUser;
import de.tekup.jpademo.security.entities.User;
import de.tekup.jpademo.security.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BDUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        User user = userRepository.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException("UsernameNotFound"));
//        return new SecurityUser(user);

        return userRepository.findByUsername(username)
                .map(user -> new SecurityUser(user))
                .orElseThrow(()-> new UsernameNotFoundException("UsernameNotFound"));


//        return userRepository.findByUsername(username)
//                .map(SecurityUser::new)
//                .orElseThrow(()-> new UsernameNotFoundException("UsernameNotFound"));

    }
}

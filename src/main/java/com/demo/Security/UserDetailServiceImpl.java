// package com.demo.Security;

// import java.util.ArrayList;
// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.provisioning.UserDetailsManager;
// import org.springframework.stereotype.Service;

// import com.demo.Service.UserService;
// import com.demo.Model.User ;

// @Service
// public class UserDetailServiceImpl implements UserDetailsService {
//     private UserService userService;

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//         User userFromDb = userService.findUserByEmail(email);
//         if (userFromDb == null) {
//             throw new UsernameNotFoundException("Member Not Found");
//         }

//         return new MyPrincipalUser(userFromDb);

//         // Member member = memberService.loadMemberByUsername(username);
//         // if (member == null) {
//         //     throw  new UsernameNotFoundException("Member Not Found");
//         // }

//         // Collection<GrantedAuthority> authorities = new ArrayList<>();
//         // SimpleGrantedAuthority authority = new SimpleGrantedAuthority("member");
//         // authorities.add(authority);
//         // User userDetails = new User(member.getUsername(), member.getPassword(), authorities);

//         // return userDetails;
//     }
// }

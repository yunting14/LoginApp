// package com.demo.Security;

// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.demo.Model.User;

// public class MyPrincipalUser implements UserDetails {
//     private User user;
//     public MyPrincipalUser(User user) {
//         this.user = user;
//     }
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
//     }
//     @Override
//     public String getPassword() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
//     }
//     @Override
//     public String getUsername() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
//     }
//     @Override
//     public boolean isAccountNonExpired() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
//     }
//     @Override
//     public boolean isAccountNonLocked() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
//     }
//     @Override
//     public boolean isCredentialsNonExpired() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
//     }
//     @Override
//     public boolean isEnabled() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
//     }
// }

package hepl.isen.MainApp.auth;

import hepl.isen.MainApp.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationUser implements UserDetails {

    private Long id;
    private final String password;
    private final String username;
    private final boolean isEnabled;
    private final List<? extends GrantedAuthority> grantedAuthorities;

    public ApplicationUser(List<? extends GrantedAuthority> grantedAuthorities, String password, String username, boolean isEnabled, Long id) {
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.username = username;
        this.isEnabled = isEnabled;
        this.id = id;
    }

    public ApplicationUser(User user) {
        this.id = user.getId();
        this.grantedAuthorities = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.password = user.getPassword();
        this.username = user.getUserName();
        this.isEnabled = user.isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}

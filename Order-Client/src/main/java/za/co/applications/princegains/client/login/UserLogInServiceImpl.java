package za.co.applications.princegains.client.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.co.applications.princegains.shopping.shopping.model.State;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.model.UserProfile;
import za.co.applications.princegains.shopping.shopping.service.UserService;
import za.co.applications.princegains.shopping.shopping.service.UserServiceImpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by kholofelo on 2016/08/21.
 */

@Service("logInUserDetail")
public class UserLogInServiceImpl implements UserDetailsService {

    UserService userService = UserServiceImpl.getInstance();

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = userService.findBySso(username);
        if (systemUser == null) {
            throw new UsernameNotFoundException("The username and password combination given did not match any records. Check your spelling again");

        }

        return new User(systemUser.getSsoId(), systemUser.getPassword(), State.ACTIVE == systemUser.getState(), true, true, true, getGrantedAuthorities(systemUser));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(final SystemUser user) {
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (UserProfile userProfile : user.getUserProfiles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        return grantedAuthorities;
    }
}

package za.co.orionencoded.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.model.UserProfile;
import za.co.applications.princegains.shopping.shopping.service.UserService;
import za.co.applications.princegains.shopping.shopping.service.impl.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.HttpStatus.OK;

@RestController("/userauth")
public class UserAuthenticationController {
    private static final UserService USER_SERVICE = UserServiceImpl.getInstance();


    @CrossOrigin
    @PostMapping("/register/{username}/{password}/{email}/{firstName}/{lastName}")
    public SystemUser registerUser(@PathVariable String firstName, @PathVariable String lastName,
                                   @PathVariable String email,
                                   @PathVariable String username, @PathVariable String password) {
        System.out.println("==== in registerUser ====");

        SystemUser systemUser = new SystemUser();
        systemUser.setFirstName(firstName);
        systemUser.setLastName(lastName);
        systemUser.setEmail(email);
        systemUser.setSsoId(username);
        systemUser.setPassword(password);
        Set<UserProfile> userProfiles = new HashSet<>();

        UserProfile userProfile = new UserProfile();
        userProfile.setType("USER");
        userProfiles.add(userProfile);
        systemUser.setUserProfiles(userProfiles);

        USER_SERVICE.createUser(systemUser);
        return systemUser;
    }

    @CrossOrigin
    @PostMapping("/login/{username}/{password}")
    public SystemUser logIn(@PathVariable String username, @PathVariable String password) {
        System.out.println("==== in login ====");
        SystemUser systemUser = USER_SERVICE.logIn(username, password);
        return systemUser;
    }

    @CrossOrigin
    @PostMapping("/authenticate")
    public ResponseEntity<LoginUser> authenticate(@RequestBody LoginUser user) {
        System.out.println("==== in authenticate ====");
        System.out.println("username is " + user.getUsername() + ", and pass is " + user.getPassword());
//        SystemUser systemUser = USER_S ERVICE.logIn(username, password);
//        return systemUser;
        user.setToken("654325654");
        return new ResponseEntity<LoginUser>(user, OK);

    }

    @CrossOrigin
    @PostMapping("/logOff/{username}")
    public boolean logOff(@PathVariable String username) {
        System.out.println("==== in logOff ====");
        USER_SERVICE.logoff(username);

        return true;
    }

    //TODO: need to write a function to return ONE catalog
    @CrossOrigin
    @PostMapping("/isAuthenticated/{username}")
    public Boolean isAuthenticated(@PathVariable String username) {
        System.out.println("==== in isAuthenticated ====");
        Boolean authenticated = USER_SERVICE.isAuthenticated(username);
        System.out.println("Authentication: " + authenticated);
        return authenticated;
    }


}

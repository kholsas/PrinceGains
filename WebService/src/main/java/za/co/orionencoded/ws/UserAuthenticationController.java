package za.co.orionencoded.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.model.UserProfile;
import za.co.applications.princegains.shopping.shopping.service.UserService;
import za.co.applications.princegains.shopping.shopping.service.impl.UserServiceImpl;
import za.co.orionencoded.security.CustomWebSecurity;
import za.co.orionencoded.security.LoginUser;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.HttpStatus.OK;

@RestController("/userauth")
public class UserAuthenticationController extends CustomWebSecurity {
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
    @PostMapping("/authenticate")
    public ResponseEntity<LoginUser> authenticate(@RequestBody LoginUser user) {
        System.out.println("==== in authenticate ====");
        LoginUser loggedInUser = loginUser(user);
        return new ResponseEntity<LoginUser>(loggedInUser, OK);

    }

    @CrossOrigin
    @PostMapping("/logOff/")
    public ResponseEntity<LoginUser> logOff(@RequestBody LoginUser user) {
        System.out.println("==== in logOff ====");

        return new ResponseEntity<LoginUser>(logoutUser(user), OK);
    }

    //TODO: need to write a function to return ONE catalog
    @CrossOrigin
    @PostMapping("/isAuthenticated/{username}")
    public boolean isAuthenticated(@RequestBody LoginUser user) {
        System.out.println("==== in isAuthenticated ====");

        return isAuthenticated(user.getUsername());
    }


}

package za.co.applications.princegains.client.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("logInUserDetail")
     UserDetailsService userDetailsService ;

    @Autowired
    @Transactional(readOnly = true)
    public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/register-form/**").access("hasRole('USER')")
                .antMatchers("/show-nannies/**").access("hasRole('USER')")
                .antMatchers("/search/**").access("hasRole('USER')")
                .antMatchers("/myProfile/**").access("hasRole('USER')")
                .antMatchers("/edit-nanny-form/**").access("hasRole('USER')")
              //  .antMatchers("/edit-nanny-form/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("ssoId").passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}

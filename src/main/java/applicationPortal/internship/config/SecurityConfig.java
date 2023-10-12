package applicationPortal.internship.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .authorities("READ")
                .build();

        UserDetails admin = users
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .authorities("READ", "CREATE", "DELETE")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()
                .requestMatchers("/applicationPortal/add2NewJobs").permitAll()
                .requestMatchers("/applicationPortal/displayJobsByEmployer").permitAll()
                .requestMatchers("/applicationPortal/displayApplicantsByEmployer").hasRole("ADMIN")
                .requestMatchers("/applicationPortal/displayApplicantsByJobListing").permitAll()
                .anyRequest().authenticated();

        return httpSecurity.build();
    }

}

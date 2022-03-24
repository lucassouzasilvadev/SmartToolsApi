package smart.tools.api.mvp.smart.tools.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration //acho que não precisa dessa notação
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticacaoService autenticacaoService;

    //configurações autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //configurações de autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/clientes").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/clientes/*").permitAll()
                .antMatchers("/h2/*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }

    // configurações para recursos estáticos(js, css, img, etc)
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("12345"));
//    }
}

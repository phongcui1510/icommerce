package com.icommerce.product.configuration;

import com.icommerce.product.service.shared.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.ConcurrentSessionFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(new MyCustomAuthenticationFilter(), ConcurrentSessionFilter.class);
        http.authorizeRequests()
                .antMatchers(Constants.PRODUCT_RESOURCE).authenticated()
                .antMatchers(Constants.PRODUCT_RESOURCE + "/*").authenticated()
                .anyRequest().permitAll();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/h2-console/**");
    }
}

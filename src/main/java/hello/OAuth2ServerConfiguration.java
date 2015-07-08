/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class OAuth2ServerConfiguration {

    private static final String RESOURCE_ID = "restservice";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            // @formatter:off
            resources.resourceId(RESOURCE_ID).tokenStore(AuthorizationServerConfiguration.tokenStore);
            // @formatter:on
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/oauth/**").access("#oauth2.hasScope('read')")
                    .antMatchers(HttpMethod.OPTIONS, "/oauth/**").access("#oauth2.hasScope('read')")
                    .antMatchers(HttpMethod.POST, "/oauth/**").access("#oauth2.hasScope('write')")
                    .antMatchers(HttpMethod.PUT, "/oauth/**").access("#oauth2.hasScope('write')")
                    .antMatchers(HttpMethod.PATCH, "/oauth/**").access("#oauth2.hasScope('write')")
                    .antMatchers(HttpMethod.DELETE, "/oauth/**").access("#oauth2.hasScope('write')")
                    .antMatchers("/users").hasRole("ADMIN")
                    .antMatchers("/greeting").authenticated();
            // @formatter:on
            /*
            /oauth/authorize
            /oauth/authorize POST
            /oauth/token GET
            /oauth/token POST
            /oauth/check_token
            /oauth/confirm_access
            /oauth/error
            */
        }

    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        public static TokenStore tokenStore = new InMemoryTokenStore();
        /*@Autowired
         private TokenStore tokenStore;

         private String oauthDbJdbc = "jdbc:mysql://localhost:3306/oauthserver";

         private String oauthUser = "oauth_user";

         private String oauthPass = "oauth_pass";

         private String oauthDriver = "com.mysql.jdbc.Driver";*/

        /*@Bean
         public TokenStore tokenStore() {
         DataSource tokenDataSource = DataSourceBuilder.create().driverClassName(oauthDriver).url(oauthDbJdbc).username(oauthUser).password(oauthPass).build();
         return new JdbcTokenStore(tokenDataSource);
         }*/
        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Autowired
        private CustomUserDetailsService userDetailsService;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints)
                throws Exception {
            // @formatter:off
            endpoints
                    .tokenStore(this.tokenStore)
                    .authenticationManager(this.authenticationManager)
                    .userDetailsService(userDetailsService);
            // @formatter:on
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            // @formatter:off
            clients
                    .inMemory()
                    .withClient("clientapp")
                    .authorizedGrantTypes("password", "refresh_token")
                    .authorities("USER")
                    .scopes("read", "write")
                    .resourceIds(RESOURCE_ID)
                    .secret("123456")
                    .and()
                    .withClient("curl")
                    .authorizedGrantTypes("client_credentials")
                    .authorities("USER", "ADMIN")
                    .scopes("read", "write")
                    .resourceIds(RESOURCE_ID)
                    .secret("password");
            // @formatter:on
        }

        @Bean
        @Primary
        public DefaultTokenServices tokenServices() {
            DefaultTokenServices tokenServices = new DefaultTokenServices();
            tokenServices.setSupportRefreshToken(true);
            tokenServices.setTokenStore(this.tokenStore);
            return tokenServices;
        }

    }

}

/*
 * Copyright 2014 the original author or authors.
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
package com.proycomp.rest.auth.service.controller;

import com.proycomp.rest.auth.service.Application;
import com.proycomp.rest.auth.service.controller.GreetingController;
import java.nio.file.AccessDeniedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Roy Clarkson
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
// Enable JMX so we can test the MBeans (you can't do this in a properties file)
@TestPropertySource(properties = {"spring.jmx.enabled:true",
    "spring.datasource.jmx-enabled:true"})
@ActiveProfiles("scratch")
public class GreetingControllerTest {

    @Autowired
    WebApplicationContext context;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @InjectMocks
    GreetingController controller;

    private MockMvc mvc;

    public static final String TEST_API_KEY = "clientapp";
    public static final String TEST_SECRET_KEY = "123456";
    public static final String USRPASS_OAUTH_USERNAME = "roy";
    public static final String USRPASS_OAUTH_PASSWORD = "spring";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(springSecurityFilterChain)
                .build();
    }

    @Test
    public void greetingUnauthorized() throws Exception {
        // @formatter:off
        ResultActions ra = mvc.perform(get("/greeting").accept(MediaType.APPLICATION_JSON));
        System.out.println("greetingUnauthorized:::" + ra.andReturn().getResponse().getContentAsString());
        ra.andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.error", is("unauthorized")));
        // @formatter:on
    }

    private String getAccessToken(String username, String password) throws Exception {
        String authorization = "Basic " + new String(Base64Utils.encode((TEST_API_KEY + ":" + TEST_SECRET_KEY).getBytes()));
        String contentType = MediaType.APPLICATION_JSON + ";charset=UTF-8";

        // @formatter:off
        String content = mvc.perform(post("/oauth/token").header("Authorization", authorization)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", username)
                        .param("password", password)
                        .param("grant_type", "password")
                        .param("scope", "read write")
                        .param("client_id", TEST_API_KEY)
                        .param("client_secret", TEST_SECRET_KEY))
                //.andExpect(status().isOk())
                //.andExpect(content().contentType(contentType))
                //.andExpect(jsonPath("$.access_token", is(notNullValue())))
                //.andExpect(jsonPath("$.token_type", is(equalTo("bearer"))))
                //.andExpect(jsonPath("$.refresh_token", is(notNullValue())))
                //.andExpect(jsonPath("$.expires_in", is(greaterThan(50))))
                //.andExpect(jsonPath("$.scope", is(equalTo("read write"))))
                .andReturn().getResponse().getContentAsString();

        // @formatter:on
        System.out.println("getAccessToken Result::: " + content);
        return content.substring(17, 53);
    }

    @Test
    public void greetingAuthorized() throws Exception {
        String accessToken = getAccessToken(USRPASS_OAUTH_USERNAME, USRPASS_OAUTH_PASSWORD);

        // @formatter:off
        ResultActions ra = mvc.perform(get("/greeting").header("Authorization", "Bearer " + accessToken));
        System.out.println("greetingAuthorized 1 :::" + ra.andReturn().getResponse().getContentAsString());
        ra.andExpect(status().isOk())
          .andExpect(jsonPath("$.id", is(1)))
          .andExpect(jsonPath("$.content", containsString("Hello")));
     // @formatter:on

        // @formatter:off
        mvc.perform(get("/greeting").header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.content", containsString("Hello, roy!")));
     // @formatter:on

        // @formatter:off
        mvc.perform(get("/greeting")
                .header("Authorization", "Bearer " + accessToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.content", containsString("Hello, roy!")));
        // @formatter:on
    }

    @Test
     public void usersEndpointAuthorized() throws Exception {
     // @formatter:off
     mvc.perform(get("/users")
     .header("Authorization", "Bearer " + getAccessToken("roy", "spring")))
     .andExpect(status().isOk())
     .andExpect(jsonPath("$", hasSize(3)));
     // @formatter:on
     }

    @Test
     public void usersEndpointAccessDenied() throws Exception {
     // @formatter:off
     mvc.perform(get("/users")
     .header("Authorization", "Bearer " + getAccessToken("craig", "spring")))
     .andExpect(status().is(403));
     // @formatter:on
     }
}

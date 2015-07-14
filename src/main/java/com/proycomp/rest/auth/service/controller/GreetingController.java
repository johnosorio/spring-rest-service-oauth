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

import com.proycomp.rest.auth.service.dto.Greeting;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(OAuth2Authentication user) {
        System.out.println("JJOC Authorization: " + user.getPrincipal() + ":" + user.getName() + ":" + user.getAuthorities());
        if (user != null) {
            return new Greeting(counter.incrementAndGet(), String.format(template, user.getName()));
        } else {
            return new Greeting(counter.incrementAndGet(), String.format(template, "App") + user);
        }
    }

}

insert into user (id, name, login, password) values (1,'Roy','roy','$2a$10$cV6KUnjACdYys0YVVTY6IeayMmoN2asTDGbp/HaTcsO9WcVfPEcvu');
insert into user (id, name, login, password) values (2,'Craig','craig','$2a$10$cV6KUnjACdYys0YVVTY6IeayMmoN2asTDGbp/HaTcsO9WcVfPEcvu');
insert into  user (id, name, login, password) values (3,'Greg','greg','$2a$10$cV6KUnjACdYys0YVVTY6IeayMmoN2asTDGbp/HaTcsO9WcVfPEcvu');
 
insert into role (id, name) values (1,'ROLE_USER');
insert into role (id, name) values (2,'ROLE_ADMIN');
insert into role (id, name) values (3,'ROLE_GUEST'); 

insert into user_role (user_id, role_id) values (1,1);
insert into user_role (user_id, role_id) values (1,2);
insert into user_role (user_id, role_id) values (2,1);
insert into user_role (user_id, role_id) values (3,1);

INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('clientapp', 'restservice', '123456', 'read,write', 'password,refresh_token', NULL, 'USER', 3600, NULL, NULL, NULL);
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('curl', 'restservice', 'password', 'read,write', 'client_credentials', NULL, 'ROLE_USER,ROLE_ADMIN', 3600, NULL, NULL, NULL);
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('oauth-admin', 'adminservices,restservice', 'oauth-admin-service-secret-key', 'read,write,trust', 'password,refresh_token', NULL, 'ROLE_OAUTH_ADMIN', 3600, NULL, NULL, NULL);
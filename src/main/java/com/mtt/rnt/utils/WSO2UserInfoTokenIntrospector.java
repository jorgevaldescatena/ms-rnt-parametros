package com.mtt.rnt.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.BadOpaqueTokenException;
import org.springframework.security.oauth2.server.resource.introspection.OAuth2IntrospectionAuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WSO2UserInfoTokenIntrospector implements OpaqueTokenIntrospector {

    private final RestTemplate restTemplate;
    private final String userInfoEndpoint;

    public WSO2UserInfoTokenIntrospector(String userInfoEndpoint) {
        this.restTemplate = new RestTemplate();
        this.userInfoEndpoint = userInfoEndpoint;
    }

    @Override
    public OAuth2AuthenticatedPrincipal introspect(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        try {
            @SuppressWarnings("rawtypes")
            ResponseEntity<Map> response = restTemplate.exchange(
                userInfoEndpoint,
                HttpMethod.GET,
                entity,
                Map.class
            );

            @SuppressWarnings("unchecked")
            Map<String, Object> claims = response.getBody();
            if (claims == null || !claims.containsKey("sub")) {
                throw new BadOpaqueTokenException("Invalid UserInfo response");
            }

            String subject = claims.get("sub").toString();

            // Crear un mapa de atributos que incluya el 'sub'
            Map<String, Object> attributes = new HashMap<>(claims);

            return new OAuth2IntrospectionAuthenticatedPrincipal(
                subject,
                attributes,
                Collections.emptyList()  // No hay autoridades específicas
            );
        } catch (Exception e) {
            throw new BadOpaqueTokenException("Invalid token", e);
        }
    }

}
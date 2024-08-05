package com.mtt.rnt.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.BadOpaqueTokenException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class WSO2UserInfoTokenIntrospectorTest {

    private RestTemplate restTemplate;
    private String userInfoEndpoint;
    private WSO2UserInfoTokenIntrospector introspector;

    @BeforeEach
    void setUp() throws Exception {
        restTemplate = mock(RestTemplate.class);
        userInfoEndpoint = "https://amqa.mtt.cl:8244/userinfo";
        introspector = new WSO2UserInfoTokenIntrospector(userInfoEndpoint);

        // Utilizamos reflexión para inyectar el mock de RestTemplate
        Field restTemplateField = introspector.getClass().getDeclaredField("restTemplate");
        restTemplateField.setAccessible(true);
        restTemplateField.set(introspector, restTemplate);
    }

    @Test
    void introspect_ValidToken_ReturnsAuthenticatedPrincipal() {
        String token = "hgrthrthtg";//Texto de prueba que simula un token
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("sub", "sub de prueba");
        responseMap.put("name", "name de prueba");

        ResponseEntity<Map> responseEntity = ResponseEntity.ok(responseMap);

        when(restTemplate.exchange(
                eq(userInfoEndpoint),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Map.class)
        )).thenReturn(responseEntity);

        OAuth2AuthenticatedPrincipal principal = introspector.introspect(token);

        assertNotNull(principal);
        assertEquals("sub de prueba", principal.getName());
        assertEquals("name de prueba", principal.getAttribute("name"));
    }

    @Test
    void introspect_TokenWithoutSub_ThrowsBadOpaqueTokenException() {
        String token = "token-sin-sub";
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("name", "name de prueba");

        ResponseEntity<Map> responseEntity = ResponseEntity.ok(responseMap);

        when(restTemplate.exchange(
                eq(userInfoEndpoint),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Map.class)
        )).thenReturn(responseEntity);

        assertThrows(BadOpaqueTokenException.class, () -> introspector.introspect(token));
    }

    @Test
    void introspect_RestTemplateThrowsException_ThrowsBadOpaqueTokenException() {
        String token = "token-invalido";

        when(restTemplate.exchange(
                eq(userInfoEndpoint),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Map.class)
        )).thenThrow(new RuntimeException("Error en RestTemplate"));

        assertThrows(BadOpaqueTokenException.class, () -> introspector.introspect(token));
    }
}

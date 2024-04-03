package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestServiceApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testDefaultDoubling() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/double", String.class))
                .contains("\"number\":0");
    }

    @Test
    void testDoubling() throws Exception {
        int number = 5, expect = 10;
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/double?number=" + number,
                String.class)).contains("\"number\":" + expect);
    }
}

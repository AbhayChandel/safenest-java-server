package com.zerosolutions.safenestjavaserver.workermanagement;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerosolutions.safenestjavaserver.workermanagement.dataaccess.api.entity.Worker;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WorkerManagementIT {

    @Autowired
    ObjectMapper objectMapper;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllWorkers() throws Exception {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/v1/worker/", String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        assertTrue(root.size() > 0);
    }

    @Test
    public void testGetWorkerById() throws Exception {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/v1/worker/2", String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        assertEquals(2L, root.path("id").asLong());
    }

    @Test
    public void testWorkerNotFound() throws Exception {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("/v1/worker/10", String.class);
        Assert.assertEquals(404, responseEntity.getStatusCodeValue());
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        JsonNode errorCode = root.path("errorCode");
        assertEquals(404, errorCode.asInt());
        JsonNode errorCause = root.path("errorCause");
        assertEquals("Worker with id 10 not found", errorCause.asText());
        JsonNode errorFix = root.path("errorFix");
        assertEquals("Choose a different worker", errorFix.asText());
    }

    @Test
    public void testCreatingWorker() throws IOException {
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("/v1/worker/create", new Worker(), String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        assertTrue(root.path("id").asLong() > 0);
    }
}

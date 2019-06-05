package com.zerosolutions.safenestjavaserver.jobmanagement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobManagementIT {

    @Autowired
    ObjectMapper objectMapper;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreatingJob() throws IOException {
        HttpEntity<MultiValueMap<String, String>> httpEntity = getHttpRequest();
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("/v1/job/create", httpEntity, String.class);
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
        JsonNode root = objectMapper.readTree(responseEntity.getBody());
        JsonNode jobId = root.path("id");
        assertTrue(jobId.asLong()>0);
    }

    private HttpEntity<MultiValueMap<String, String>> getHttpRequest(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params= new LinkedMultiValueMap<>();
        params.add("jobStartDateTime", "2019-06-10T08:00");
        params.add("jobEndDateTime", "2019-06-12T20:00");
        params.add("workerId", "1");
        return new HttpEntity<>(params, headers);
    }
}

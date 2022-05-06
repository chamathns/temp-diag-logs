package com.chamath.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import sun.misc.Request;

import java.time.Instant;
import java.util.Map;

public class TestParsing {

    public static void main(String[] args) throws JsonProcessingException {

        Map<String, Object> input = new java.util.HashMap<>();
        Map<String, Object> configurations = new java.util.HashMap<>();

        configurations.put("name", "Chamath");
        configurations.put("age", "25");
        configurations.put("date", Instant.now());

        input.put("person", new Person("Chamath", "Kandy", 25));
        input.put("request", "GET");

        DiagnosticLog diagnosticLog1 = new DiagnosticLog("log1", Instant.now(), "request1", null,
                "resultStatus1", "resultMessage1", "action1", "component1", input, configurations);

        DiagnosticLog diagnosticLog2 = new DiagnosticLog("log2", Instant.now(), "request2", "flow2",
                "resultStatus2", "resultMessage2", "action2", "component2", input, configurations);

        ObjectMapper objectMapper = new ObjectMapper();
        GsonBuilder builder = new GsonBuilder();
//        builder.serializeNulls();

//        String diagnosticLog1Json = objectMapper.writeValueAsString(diagnosticLog1);
        String diagnosticLog1Json = builder.create().toJson(diagnosticLog1);
        System.out.println(diagnosticLog1Json);

        DiagnosticLog diagnosticLog3 = builder.create().fromJson(diagnosticLog1Json, DiagnosticLog.class);
        System.out.println(diagnosticLog3);
    }

}

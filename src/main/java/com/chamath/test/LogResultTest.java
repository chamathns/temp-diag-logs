package com.chamath.test;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LogResultTest {

    public static void main(String[] args) {

        String logEntry = "TID: [38] Tenant: [risekite.com] [2022-05-05 15:12:33,714] " +
                "[0YelzYgAAAAA2e1vhlxsLTrZ7445lawWWRFhCMzBFREdFMDIwNwAxOWY3NzcyNC04MTJjLTQ0ODYtYTJkMy1iMzQ2MDM4NjhmY2Q=] " +
                ": iam-cloud-diagnostics : INFO {org.wso2.carbon.utils.CarbonUtils.publishDiagnosticLog(CarbonUtils.java:1465)}" +
                " - {\"logId\":\"47f36c8b-0ecd-42a0-8fa1-8fbd0604dffa\",\"recordedAt\":{\"seconds\":1651763553,\"nanos\":714760000}," +
                "\"requestId\":\"0YelzYgAAAAA2e1vhlxsLTrZ7445lawWWRFhCMzBFREdFMDIwNwAxOWY3NzcyNC04MTJjLTQ0ODYtYTJkMy1iMzQ2MDM4NjhmY2Q\\u003d\"," +
                "\"resultStatus\":\"SUCCESS\",\"resultMessage\":\"Issued Authorization Code to user.\",\"actionId\":\"issue-authz-code\"," +
                "\"componentId\":\"oauth-inbound-service\",\"input\":{\"redirectUri\":\"http://localhost:8080/oidc-sample-app/oauth2client\"," +
                "\"clientId\":\"vfzG8oy0NtKmQlOrcD2zOIVxfCca\",\"requestedScopes\":\"address email openid profile\",\"user\":" +
                "\"27d678a5-38d5-40f7-9946-1e07bfe7e2fa\"},\"configurations\":{\"authzCodeValidityPeriod\":\"300000\"}}";


//        String logJSON = "{\"logId"+ StringUtils.substringAfter(logEntry, "{\"logId");
//        System.out.println(logJSON);
//
//        DiagnosticLog diagnosticLog = new Gson().fromJson(logJSON, DiagnosticLog.class);
//        System.out.println(diagnosticLog.getLogId());

        String logJSON = extractJSONFromString(logEntry);
        System.out.println(logJSON);
    }

    private static String extractJSONFromString(String text) {

        List<Character> stack = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        List<String> jsons = new ArrayList<String>();
        for (char eachChar : text.toCharArray()) {
            if (stack.isEmpty() && eachChar == '{') {
                stack.add(eachChar);
                temp.append(eachChar);
            } else if (!stack.isEmpty()) {
                temp.append(eachChar);
                if (stack.get(stack.size() - 1).equals('{') && eachChar == '}') {
                    stack.remove(stack.size() - 1);
                    if (stack.isEmpty()) {
                        jsons.add(temp.toString());
                        temp = new StringBuilder();
                    }
                } else if (eachChar == '{' || eachChar == '}')
                    stack.add(eachChar);
            } else if (temp.length() > 0 && stack.isEmpty()) {
                jsons.add(temp.toString());
                temp = new StringBuilder();
            }
        }
        for (String entry : jsons) {
            if (StringUtils.contains(entry, "logId")) {
                // TODO validations for the log message.
                return entry;
            }
        }
        return StringUtils.EMPTY;
    }

}

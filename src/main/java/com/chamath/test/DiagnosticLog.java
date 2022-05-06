package com.chamath.test;

import java.time.Instant;
import java.util.Map;

/**
 * Diagnostic log.
 */
public class DiagnosticLog {

    private final String logId;
    private final Instant recordedAt;
    private final String requestId;
    private final String flowId;
    private final String resultStatus;
    private final String resultMessage;
    private final String actionId;
    private final String componentId;
    private final Map<String, Object> input;
    private final Map<String, Object> configurations;

    public DiagnosticLog(String logId, Instant recordedAt, String requestId, String flowId,
                         String resultStatus, String resultMessage, String actionId, String componentId,
                         Map<String, Object> input, Map<String, Object> configurations) {

        this.logId = logId;
        this.recordedAt = recordedAt;
        this.requestId = requestId;
        this.flowId = flowId;
        this.resultStatus = resultStatus;
        this.resultMessage = resultMessage;
        this.actionId = actionId;
        this.componentId = componentId;
        this.input = input;
        this.configurations = configurations;
    }

    public String getLogId() {

        return logId;
    }

    public Instant getRecordedAt() {

        return recordedAt;
    }

    public String getRequestId() {

        return requestId;
    }

    public String getFlowId() {

        return flowId;
    }

    public String getResultStatus() {

        return resultStatus;
    }

    public String getResultMessage() {

        return resultMessage;
    }

    public String getActionId() {

        return actionId;
    }

    public String getComponentId() {

        return componentId;
    }

    public Map<String, Object> getInput() {

        return input;
    }

    public Map<String, Object> getConfigurations() {

        return configurations;
    }
}

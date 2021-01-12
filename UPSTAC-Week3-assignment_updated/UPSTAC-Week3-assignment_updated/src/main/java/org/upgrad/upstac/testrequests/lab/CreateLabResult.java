package org.upgrad.upstac.testrequests.lab;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateLabResult {

    @NotNull
    private String bloodPressure;

    @NotNull
    private String heartBeat;
    @NotNull
    private String temperature;
    private String oxygenLevel;
    private String comments;
    @NotNull
    private TestStatus result;

    public String getBloodPressure() {
        return this.bloodPressure;
    }

    public String getComments() {
        return this.comments;
    }

    public String getHeartBeat() {
        return this.heartBeat;
    }

    public String getOxygenLevel() {
        return this.oxygenLevel;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public TestStatus getResult() {
        return this.result;
    }
}

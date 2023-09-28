package com.example.runsearcher;

public class Run {
    private String runner;
    private String runName;
    private String runLink;

    public Run(String runner, String runName, String runLink) {
        this.runner = runner;
        this.runName = runName;
        this.runLink = runLink;
    }

    public String getRunner() {
        return runner;
    }

    public void setRunner(String runner) {
        this.runner = runner;
    }

    public String getRunName() {
        return runName;
    }

    public void setRunName(String runName) {
        this.runName = runName;
    }

    public String getRunLink() {
        return runLink;
    }

    public void setRunLink(String runLink) {
        this.runLink = runLink;
    }
}

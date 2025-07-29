package com.example.swot.model;

import java.util.List;

public class SwotAnalysis {
    private List<String> strengths;
    private List<String> weaknesses;
    private List<String> opportunities;
    private List<String> threats;

    // Constructors
    public SwotAnalysis() {
    }

    public SwotAnalysis(List<String> strengths, List<String> weaknesses, List<String> opportunities, List<String> threats) {
        this.strengths = strengths;
        this.weaknesses = weaknesses;
        this.opportunities = opportunities;
        this.threats = threats;
    }

    // Getters and Setters
    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<String> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<String> opportunities) {
        this.opportunities = opportunities;
    }

    public List<String> getThreats() {
        return threats;
    }

    public void setThreats(List<String> threats) {
        this.threats = threats;
    }

    @Override
    public String toString() {
        return "SwotAnalysis{" +
               "strengths=" + strengths +
               ", weaknesses=" + weaknesses +
               ", opportunities=" + opportunities +
               ", threats=" + threats +
               '}';
    }
}
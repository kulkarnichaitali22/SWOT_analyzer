package com.example.swot.controller;

import com.example.swot.model.SwotAnalysis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SwotController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("swotAnalysis", new SwotAnalysis());
        return "swot-form"; 
    }

    @PostMapping("/analyze")
    public String analyzeSwot(@RequestParam("strengths") String strengthsInput,
                              @RequestParam("weaknesses") String weaknessesInput,
                              @RequestParam("opportunities") String opportunitiesInput,
                              @RequestParam("threats") String threatsInput,
                              Model model) {

        // Convert comma-separated strings to lists
        List<String> strengths = parseInput(strengthsInput);
        List<String> weaknesses = parseInput(weaknessesInput);
        List<String> opportunities = parseInput(opportunitiesInput);
        List<String> threats = parseInput(threatsInput);

        // Create SwotAnalysis object
        SwotAnalysis swotAnalysis = new SwotAnalysis(strengths, weaknesses, opportunities, threats);
        model.addAttribute("swotAnalysis", swotAnalysis);

        // Optional: Generate a simple suggestion (can be expanded)
        String suggestion = generateSuggestion(swotAnalysis);
        model.addAttribute("suggestion", suggestion);

        return "swot-result"; 
    }

    // Helper method to parse comma-separated input strings into a List<String>
    private List<String> parseInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return List.of(); // Return empty list for empty input
        }
        return Arrays.stream(input.split(","))
                     .map(String::trim)
                     .filter(s -> !s.isEmpty())
                     .collect(Collectors.toList());
    }

    // Simple suggestion generation logic
    private String generateSuggestion(SwotAnalysis swot) {
        if (!swot.getStrengths().isEmpty() && !swot.getOpportunities().isEmpty()) {
            return "Consider using your strength '" + swot.getStrengths().get(0) +
                   "' to capitalize on the opportunity '" + swot.getOpportunities().get(0) + "'.";
        } else if (!swot.getWeaknesses().isEmpty() && !swot.getThreats().isEmpty()) {
            return "Address your weakness '" + swot.getWeaknesses().get(0) +
                   "' to mitigate the threat '" + swot.getThreats().get(0) + "'.";
        } else {
            return "Reflect on your SWOT elements for strategic insights.";
        }
    }
}
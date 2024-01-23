package org.example;

import java.util.List;

// MessageRequest class to represent the request body
public class MessageRequest {
    private List<String> targets; // Change the field name to targets
    private String text;

    // Getters and setters

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


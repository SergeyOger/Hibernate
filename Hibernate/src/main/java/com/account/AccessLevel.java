package com.account;

public enum AccessLevel {
    CUSTOMER("CUSTOMER"), ADMIN("ADMIN"), VISITOR("VISITOR");

    private String accessLevel;

    AccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}

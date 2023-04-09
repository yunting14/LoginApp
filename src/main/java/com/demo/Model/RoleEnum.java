package com.demo.Model;

public enum RoleEnum {
    MANAGER, EMPLOYEE;

    // for spring security hasRole()
    public static class RoleNames{
        public static final String EMPLOYEE = "EMPLOYEE";
        public static final String MANAGER = "MANAGER";

    }
}

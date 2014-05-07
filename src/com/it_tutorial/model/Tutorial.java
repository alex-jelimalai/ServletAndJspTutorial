package com.it_tutorial.model;

/**
 * @author Alexandr Jelimalai
 */
public class Tutorial {

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String DATE = "date";

    private String name;
    private String description;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}

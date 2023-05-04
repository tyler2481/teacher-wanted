package com.project3.teacherwanted.constant;

public enum CourseCategory {
    PROGRAMMING("程式語言", 1),
    LIFE("生活", 2),
    LANGUAGE("語言", 3),
    GAME("電競", 4),;

    private String categoryName;
    private int categoryId;

    CourseCategory(String categoryName, int categoryId) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }
}

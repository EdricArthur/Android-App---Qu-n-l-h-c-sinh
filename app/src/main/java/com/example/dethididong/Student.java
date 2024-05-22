package com.example.dethididong;

public class Student {
    private String name;
    private int mathScore;
    private int literatureScore;
    private int languageScore;
    private int totalScore;

    public Student(String name, int mathScore, int literatureScore, int languageScore, int totalScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.literatureScore = literatureScore;
        this.languageScore = languageScore;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getLiteratureScore() {
        return literatureScore;
    }

    public int getLanguageScore() {
        return languageScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return name + " - Toán: " + mathScore + " - Văn: " + literatureScore + " - Anh: " + languageScore + " - Tổng 3 môn: " + totalScore;
    }
}

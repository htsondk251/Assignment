package com.company;

public class Class implements Cloneable {
    private String classCode, className, lecturerName, studyTime, studyDays;

    public Class(String classCode) {
        this.classCode = classCode;
    }

    public Class() {}

    public Class(String classCode, String className, String lecturerName, String studyTime, String studyDays) {
        this.classCode = classCode;
        this.className = className;
        this.lecturerName = lecturerName;
        this.studyTime = studyTime;
        this.studyDays = studyDays;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getStudyDay() {
        return studyDays;
    }

    public void setStudyDay(String studyDays) {
        this.studyDays = studyDays;
    }

    public String toString() {
        return "Class{code=" + classCode + ",name=" + className + ",lecturer=" + lecturerName + ",studyTime=" + studyTime + ",studyDays=" + studyDays + "}";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

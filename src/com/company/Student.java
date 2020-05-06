package com.company;

public class Student implements Cloneable {
    private String studentCode, studentName, address, dateOfBirth, classCode;

    public Student() {};

    public Student(String studentCode) {
        this.studentCode = studentCode;
    }

    public Student(String studentCode, String studentName, String address, String dateOfBirth, String classCode) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.classCode = classCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentCode() {
        return this.studentCode;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassCode() {
        return this.classCode;
    }

    public String toString() {
        return "Student{code=" + studentCode + ",name=" + studentName + ",address=" + address + ",dateOfBirth=" + dateOfBirth + ",classCode=" + classCode + "}";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

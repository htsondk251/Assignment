package com.company;

public class Mark implements Cloneable {
    private String studentCode, classCode, studentName, subject;
    private double mark;
    private boolean evaluation;

    public Mark() {}

//    public Mark(String studenCode, String subject, double mark) {
//        this.studentCode = studenCode;
//        this.subject = subject;
//        this.mark = mark;
//    }

    public Mark(String classCode, String studentName, String subject, double mark, boolean evaluation) {
        this.classCode = classCode;
        this.studentName = studentName;
        this.subject = subject;
        this.mark = mark;
        this.evaluation = evaluation;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public void setStudenName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return this.studentCode;
    }

    public String getClassCode() {
        return this.classCode;
    }

    public String getSubject() {
        return this.subject;
    }

    public String toString() {
        return "Mark[class="+ classCode + ",student=" + studentName + ",subject=" + subject + ",mark=" + mark + "]"; //",evaluation=" + evaluation +
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
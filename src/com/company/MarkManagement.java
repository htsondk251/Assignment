package com.company;

import java.util.*;

public class MarkManagement {
    private ArrayList<Mark> list = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();

    Scanner in = new Scanner(System.in);
    public void setList(List<Mark> markList, List<Student> students) throws CloneNotSupportedException {
        list.clear();
        if (markList != null) {
            for (Mark c : markList) {
                list.add((Mark) c.clone());
            }
        }
        this.studentList.clear();
        if (students != null) {
            for (Student c : students) {
                this.studentList.add((Student) c.clone());
            }
        }

    }

    public boolean Add() {
        boolean result = false;
        Mark e = inputInfo();

        if (e != null) {
            list.add(e);
            result = true;
        }
        return result;
    }

    public void DisplaySubject() {
        Collections.sort(list, new SubjectCompare());
        for (Mark e : list) {
            System.out.println(e);
//            System.out.println(e.getStudenCode());
        }
    }

    public void DisplayClass() {
        Collections.sort(list, new ClassCompare());
        for (Mark e : list)
            System.out.println(e);
    }

    public Mark inputInfo() {
        String input;
        double mark;
        boolean evaluation;
//        Scanner in = new Scanner(System.in);
        System.out.print("nhap ma sinh vien: ");
        String studentCode = in.nextLine();
        int i = studentList.indexOf(getStudentInfo(studentCode));
        if (i == -1) {
            System.out.println("Khong ton tai");
            return null;
        } else {
            String studentName = studentList.get(i).getStudentName();
            String classCode = studentList.get(i).getClassCode();
            System.out.print("nhap mon thi: ");
            String subject = in.nextLine();
            boolean do1 = false;
            do {
                System.out.print("nhap diem: ");
                input = in.nextLine();
                if ((!isNumber(input)) || (isNumber(input) && ((Integer.parseInt(input) > 20.0) || (Integer.parseInt(input) < 0.0)))) {
                    System.out.println("Nhap so thuc tu 0.0 -> 20.0");
                } else {
                    do1 = true;
                }
            } while (!do1);
            mark = Double.parseDouble(input);
            if (mark >= 10.0) evaluation = true;
            else evaluation = false;
            Mark e = new Mark(classCode, studentName, subject, mark, evaluation);
            return e;
        }
    }

    //return student on the list base on studentCode
    public Student getStudentInfo(String studentCode) {        //how to get 1st instance variable
        for (Student e : studentList) {
            if (e.getStudentCode().equals(studentCode)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Mark> go() {
        boolean do1 = false, isTrue;
        String input;
        int choice = 0;
//        Scanner in = new Scanner(System.in);

        do {
            System.out.println("====================================");
            System.out.println("1. Nhap diem thi");
            System.out.println("2. Hien thi diem theo lop");
            System.out.println("3. Hien thi diem theo mon");
            System.out.println("0. Tro ve Menu chinh");
            System.out.println("====================================");
            boolean do2 = false;
            do {
                System.out.print("Chon ");
                input = in.nextLine();
                if ((input.trim().isEmpty()) || (!isNumber(input)) || (isNumber(input) && ((Integer.parseInt(input) > 3) || (Integer.parseInt(input) < 0)))) {
                    System.out.println("Nhap so nguyen tu 0 -> 3");
                } else {
                    do2 = true;
                }
            } while (!do2);

            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    boolean do3 = false;
                    do {
                        isTrue = this.Add();
                        if (isTrue == true) {
                            System.out.println("add compleate");
                        } else {
                            System.out.println("not add");
                        }
                        boolean do4 = false;
                        do {
                            System.out.println("Ban muon tiep tuc?(Y/N)");
                            input = in.nextLine();
                            if (input.toLowerCase().equals("y")) {
                                do3 = false;
                                do4 = true;
                            } else if (input.toLowerCase().equals("n")) {
                                do3 = true;
                                do4 = true;
                            }
                        } while(!do4);
                    } while(!do3);
                    break;
                case 2:
                    this.DisplayClass();
                    break;
                case 3:
                    this.DisplaySubject();
                    break;
                case 0:
                    do1 = true;
                    break;
//                default:
//                    System.out.println("Nhap tu 0 den 3 thoi cha noi");
//                    break;
            }
        } while (!do1);
        return list;
    }

    boolean isNumber(String s) {
        if (s != "") {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i)) == false) return false;
            }
        }
        return true;
    }

    class SubjectCompare implements Comparator<Mark> {
        @Override
        public int compare(Mark o1, Mark o2) {
            return o1.getSubject().compareToIgnoreCase(o2.getSubject());
        }
    }

    class ClassCompare implements Comparator<Mark> {
        @Override
        public int compare(Mark o1, Mark o2) {
            return o1.getClassCode().compareToIgnoreCase(o2.getClassCode());
        }
    }
}

//    public boolean Modify() {
//        boolean result = false;
//        Mark e = new Mark();
//        Scanner in = new Scanner(System.in);
//
//        System.out.print("Nhap ma:  ");
//        String code = in.nextLine();
//        int i = list.indexOf(getMark(code));
//        if(i != -1) {
//            System.out.println(list.get(i));
//            System.out.println("Ban muon sua lop nay? Y/N");
//            code = in.nextLine();
//            if (code.toLowerCase().equals("y")) {
//                e = inputInfo();
//            }
//            if(e != null) {
//                list.set(i, e);
//                result = true;
//            }
//        } else {
//            System.out.println("Khong ton tai");
//        }
//        return result;
//    }

//    public boolean Remove() {
//        boolean result = false;
//        Scanner in = new Scanner(System.in);
////		do {
//        System.out.print("Nhap code:  ");
//        String code = in.nextLine();
//        int i = list.indexOf(getMark(code));
//        if(i != -1) {
//            System.out.println(list.get(i));
//            System.out.println("Ban muon xoa nguoi nay? Y/N");
//            code = in.nextLine();
//            if (code.toLowerCase().equals("y")) {
//                list.remove(i);
//                result = true;
//            }
//        } else {
//            System.out.println("Khong ton tai");
//            System.out.println(result);
//        }
////		} while(!do);
//
//        return result;
//    }
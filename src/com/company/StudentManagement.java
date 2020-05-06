package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> list = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    public void setList(List<Student> studentList) throws CloneNotSupportedException {
        list.clear();
        if (studentList != null) {
            for (Student c : studentList) {
                list.add((Student) c.clone());
            }
        }
//        this.list = (ArrayList<Student>) studentList;
    }

    public boolean Add() {
        boolean result = false;
        Student e = new Student();
//        Scanner in = new Scanner(System.in);

        System.out.print("Nhap ma:  ");
        String code = in.nextLine();
        int i = list.indexOf(getStudent(code));
        if(i != -1) {
            System.out.print("Ma da ton tai. ");
        } else {
            e = inputInfo();
            if(e != null) {
                list.add(e);
                result = true;
            }
        }
        return result;
    }

    public boolean Modify() {
        boolean result = false;
        Student e = new Student();
//        Scanner in = new Scanner(System.in);

        System.out.print("Nhap ma:  ");
        String code = in.nextLine();
        int i = list.indexOf(getStudent(code));
        if(i != -1) {
            e = inputInfo();
            boolean do1 = false;
            do {
                System.out.println("Ban co muon cap nhat thong tin?(Y/N)");
                code = in.nextLine();
                if (code.toLowerCase().equals("y")) {
                    do1 = true;
                    if (e != null) {
                        list.set(i, e);
                        result = true;
                    }
                } else if ((code.toLowerCase().equals("n"))) {
                    do1 = true;
                }
            } while(!do1);
        } else {
            System.out.println("Khong ton tai");
        }
        return result;

    }

//    public boolean Remove() {
//        boolean result = false;
//        Scanner in = new Scanner(System.in);
////		do {
//        System.out.print("Nhap code:  ");
//        String code = in.nextLine();
//        int i = list.indexOf(getStudent(code));
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

    public void Display() {
        for(Student e: list)
            System.out.println(e);
    }

    //import info
    public Student inputInfo() {
        Scanner in = new Scanner(System.in);

        System.out.print("Nhap ma: ");
        String code = in.nextLine();
        System.out.print("Nhap ten: ");
        String name = in.nextLine();
        System.out.print("Nhap dia chi: ");
        String lecturer = in.nextLine();
        System.out.print("Nhap ngay sinh (dd/mm/yyyy): ");
        String studyTime = in.nextLine();
        System.out.print("Nhap ma lop: ");
        String studyDays = in.nextLine();

        Student e = new Student(code, name, lecturer, studyTime, studyDays);
        return e;
    }

    //return student on the list base on studentCode
    public Student getStudent(String code) {		//how to get 1st instance variable
        for(Student e : list) {
            if (e.getStudentCode().equals(code)) {
                return e;
            }
        }
        return null;
    }

    //start method
    public ArrayList<Student> go() {
        boolean do1 = false, do2 = false, isTrue;
        String input;
        int choice = 0;
//        Scanner in = new Scanner(System.in);

        do {
            System.out.println("====================================");
            System.out.println("1. Xem danh sach sinh vien");
            System.out.println("2. Cap nhat thong tin sinh vien");
            System.out.println("3. Them moi mot sinh vien");
            System.out.println("0. Tro ve Menu chinh");
            System.out.println("====================================");
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

            switch(choice) {
                case 1:
                    this.Display();
                    break;
                case 2:
                    boolean do3 = false;
                    do {
                        isTrue = this.Modify();
                        if (isTrue == true) {
                            System.out.println("Thong tin da duoc cap nhat");
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
//                            } else {
//                                do4 = false;
//                            }
                        } while(!do4);
                    } while(!do3);
                    break;
                case 3:
                    boolean do5 = false;
                    do {
                        isTrue = this.Add();
                        if (isTrue == true) {
                            System.out.println("add complete");
                        } else {
                            System.out.println("not add");
                        }
                        boolean do6 = false;
                        do {
                            System.out.println("Ban muon tiep tuc?(Y/N)");
                            input = in.nextLine();
                            if (input.toLowerCase().equals("y")) {
                                do5 = false;
                                do6 = true;
                            } else if (input.toLowerCase().equals("n")) {
                                do5 = true;
                                do6 = true;
                            }
//                            } else {
//                                do6 = false;
//                            }
                        } while(!do6);
                    } while(!do5);
                    break;
                case 0:
                    do1 = true;
                    break;
//                default:
//                    System.out.println("Nhap tu 0 den 3 thoi cha noi");
//                    break;
            }
        } while(!do1);
        return list;
    }

    boolean isNumber(String s) {
        if(s != "") {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i)) == false) return false;
            }
        }
        return true;
    }
}

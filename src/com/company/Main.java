package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        File dir = new File("Data");
        if (!dir.exists()) {
            dir.mkdir();
        }

        File classFile = new File("Data/Class.txt");
        if (!classFile.exists()) {
            classFile.createNewFile();
        }

        File studentFile = new File("Data/Student.txt");
        if (!studentFile.exists()) {
            studentFile.createNewFile();
        }

        File markFile = new File("Data/Mark.txt");
        if (!markFile.exists()) {
            try {
                markFile.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        List<Student> studentList = new ArrayList<>();
        List<Class> classList = new ArrayList<>();
        List<Mark> markList = new ArrayList<>();

        StudentManagement sm = new StudentManagement();
        ClassManagement cm = new ClassManagement();
        MarkManagement mm = new MarkManagement();

        String input;
        boolean do1 = false;
        int choice = 0;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Chao mung den voi Techmaster Vietnam");
            System.out.println("====================================");
            System.out.println("1. Quan ly danh sach sinh vien");
            System.out.println("2. Quan ly lop hoc");
            System.out.println("3. Quan ly diem thi");
            System.out.println("0. Thoat");
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
                    studentList = fileToArrayList(studentFile, Student[].class);
                    if (studentList != null) sm.setList(studentList);

                    studentList = sm.go();
                    writeFile(studentList, studentFile);
                    break;
                case 2:
                    classList = fileToArrayList(classFile, Class[].class);
                    if (classList != null) cm.setList(classList);

                    classList = cm.go();
                    writeFile(classList, classFile);
                    break;
                case 3:

                    markList = fileToArrayList(markFile, Mark[].class);
                    studentList = fileToArrayList(studentFile, Student[].class);
                    //if (markList != null)
                        mm.setList(markList, studentList);
                    markList = mm.go();
                    writeFile(markList, markFile);
                    break;
                case 0:
                    do1 = true;
                    break;
//			default:
//				System.out.println("Nhap so nguyen tu 0 -> 3");
//				System.out.println();
//				break;
            }
        } while (!do1);
    }

    static boolean isNumber(String s) {
        if(s != "") {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i)) == false) return false;
            }
        }
        return true;
    }

    public static <T> boolean writeFile(List<T> list, File file) { // throws IOException {
        boolean isWrited = false;
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter(file, false);

            //fileWriter.write("");
            String text = gson.toJson(list);
            fileWriter.write(text);

            fileWriter.close();
            isWrited = true;
        } catch (IOException ex) {
            ex.printStackTrace();
            //isWrited = false;
        }
        return isWrited;
    }

    public static <T> List<T> fileToArrayList(File file, java.lang.Class<T[]> clazz) {
        String s = fileToString(file);
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr);
    }

    public static String fileToString(File file) {
        String line, dataJson = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                dataJson = line;
            }
            fileReader.close();
            bufferedReader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return dataJson;
    }

    class Management<T> {
        private TypeToken<List<T>> type;
        private List<T> list;

        public Management(TypeToken<List<T>> type) {
            this.type = type;
        }

        public void stringToList(String s) {
            this.list = new Gson().fromJson(s, type.getType());
        }

        public List<T> getList() {
            return this.list;
        }

//        public <T> getElement(List<T> list, String code) throws NoSuchFieldException {
//            for (T e: list) {
//                if (e.getClass().getDeclaredField(code)[0] == code) return e;
//            }
//    }

    }
}
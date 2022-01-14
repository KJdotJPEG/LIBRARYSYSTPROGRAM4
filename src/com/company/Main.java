package com.company;

// IMPORTS

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import com.company.Mainmenu;

public class Main {

    private static File bookfile = new File("bookinfo.txt");
    private static File memberfile = new File("memberinfo.txt");
    private static int filepassword;
    private static Scanner input = new Scanner(System.in);

    //create a main menu
    //give the user the ability to add/edit/delete books
    //give the user the ability to add/edit/delete members

    public static int filereader() {
        try {
            Scanner input = new Scanner(System.in);
            FileReader fileread = new FileReader("admininfo.txt");
            int i;
            while ((i = fileread.read()) != -1) {
                System.out.print((char) i);
                filepassword = Integer.parseInt(input.next());
            }
        } catch (IOException E) {
            System.out.println("bruh");
        }
        return filepassword;
    }

    public static void bookdelete() {
        File tempfileb = new File("temp.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(bookfile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempfileb));

            String removeline = "type the line of text you want removed.";
            String currentline;

            while((currentline = reader.readLine()) != null) {
                String trimline = currentline.trim();

                if (trimline.equals(removeline)) continue;

                writer.write(currentline + System.getProperty("line.separator"));
                }
                writer.close();
                reader.close();

                boolean success = tempfileb.renameTo(bookfile);
            }

        catch (IOException E) {
            System.out.println(E);
        }
    }

    public static void memberdelete() {
        File tempfilem = new File("temp.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(bookfile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempfilem));

            String removeline = "type the line of text you want removed.";
            String currentline;

            while((currentline = reader.readLine()) != null) {
                String trimline = currentline.trim();

                if (trimline.equals(removeline)) continue;

                writer.write(currentline + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            boolean success = tempfilem.renameTo(bookfile);
        }

        catch (IOException E) {
            System.out.println(E);
        }
    }

    public static String getInput(String prompt) { // getInput method for the other methods

        System.out.println(prompt);
        return input.nextLine();


    public static void bookadd(booktitle,ISBN,author,genre) {
        try {
            FileWriter filewrite = new FileWriter(bookfile.getName(), false);
            String fulltext = (booktitle + "," + ISBN + "," + author + "," + genre);
            filewrite.write(fulltext);
            filewrite.close();
            System.out.println("adding was successful.");
        } catch (IOException E){
            System.out.println(E);
            System.out.println("adding was unsuccessful.");

        }
    }
    public static void main(String[] args) {

        //main code

        //admin confirmation system

        Mainmenu.menu();
        boolean adminpass = false;
        Scanner input = new Scanner(System.in);
        System.out.println("do you want to delete anything from the system? : ");
        String validation = input.next();

        if (validation.equalsIgnoreCase("yes")){
            bookdelete();
            memberdelete();
        } else {
            System.out.println("Do you want to add anything to the system? : ");
            String addconfirm = input.next();
            if  (addconfirm.equalsIgnoreCase("yes")){
                String booktitle = getInput("input book title : ");
                int ISBN = Integer.ParsetoInt("input ISBN : ");
                String author = getInput("input author name : ");
                String genre = getInput("input genre : ");
                bookadd(booktitle,ISBN,author,genre);

            }
        }



        System.out.println("Are you an admin");
        String Adminconfirmation = input.next();

        if (Adminconfirmation.equalsIgnoreCase("yes")) {
            System.out.println("Input the password");
            filereader();
            String password = (input.next());
            if (password.equals(filepassword)){
                adminpass = true;
                System.out.println("accepted.");
            }
                Integer.valueOf(password);
        } else {}

        if ( adminpass = false) {
            System.out.println("(non-admin login) ");
        }
}}
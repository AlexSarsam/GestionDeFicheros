package model;

import java.io.*;
import java.util.*;

public class Funciones {

    private static final String PATH = "F:\\"; // Ruta fija por defecto

    public static void createFolder(String folderName) {
        File folder = new File(PATH + folderName);
        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("Carpeta creada en " + PATH + folderName);
        } else {
            System.out.println("La carpeta ya existe.");
        }
    }

    public static void createFile(String fileName, String content) {
        File folder = new File(PATH);
        if (!folder.exists()) {
            System.out.println("La ruta F:\\ no existe.");
            return;
        }

        try {
            File file = new File(PATH, fileName);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al crear o escribir el archivo.");
        }
    }

    public static String[] showListFiles() {
        File folder = new File(PATH);
        if (folder.exists() && folder.isDirectory()) {
            return folder.list();
        }
        return new String[0];
    }

    public static String showFile(String fileName) {
        File file = new File(PATH, fileName);
        String content = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                content += sc.nextLine() + "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            return "Archivo no encontrado.";
        }
        return content;
    }

    public static boolean overWriteFile(String fileName, String newContent) {
        File file = new File(PATH, fileName);
        if (!file.exists()) return false;

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newContent);
            bw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(PATH, fileName);
        if (file.exists()) {
            file.delete();
            System.out.println("Archivo borrado.");
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public static int countChars(String fileName) {
        String content = showFile(fileName);
        return content.replace("\n", "").length();
    }

    public static int countWords(String fileName) {
        String content = showFile(fileName);
        if (content.trim().isEmpty()) return 0;
        String[] words = content.trim().split("\\s+");
        return words.length;
    }

    public static String swapWords(String fileName, String oldWord, String newWord) {
        String content = showFile(fileName);
        String newContent = content.replace(oldWord, newWord);
        overWriteFile(fileName, newContent);
        return newContent;
    }

    public static void printPDF(String fileName) {
        System.out.println("Función no implementada. (Requiere librería externa)");
    }
}

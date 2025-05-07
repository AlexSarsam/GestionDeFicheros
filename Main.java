package view.console;

import java.util.Scanner;
import model.Funciones;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU GESTION DE ARCHIVOS (F:\\) ---");
            System.out.println("1. Crear carpeta");
            System.out.println("2. Crear archivo");
            System.out.println("3. Listar archivos");
            System.out.println("4. Mostrar archivo");
            System.out.println("5. Sobrescribir archivo");
            System.out.println("6. Borrar archivo");
            System.out.println("7. Contar caracteres");
            System.out.println("8. Contar palabras");
            System.out.println("9. Reemplazar palabras");
            System.out.println("10. Crear PDF (no implementado)");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
       

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Nombre de la nueva carpeta: ");
                        String folder = sc.nextLine();
                        Funciones.createFolder(folder);
                    }
                    case 2 -> {
                        System.out.print("Nombre del archivo: ");
                        String file = sc.nextLine();
                        System.out.print("Contenido: ");
                        String content = sc.nextLine();
                        Funciones.createFile(file, content);
                    }
                    case 3 -> {
                        String[] files = Funciones.showListFiles();
                        if (files.length == 0) System.out.println("No hay archivos.");
                        else {
                            System.out.println("Archivos encontrados:");
                            for (String f : files) System.out.println("- " + f);
                        }
                    }
                    case 4 -> {
                        System.out.print("Nombre del archivo: ");
                        String file = sc.nextLine();
                        System.out.println("Contenido:");
                        System.out.println(Funciones.showFile(file));
                    }
                    case 5 -> {
                        System.out.print("Nombre del archivo: ");
                        String file = sc.nextLine();
                        System.out.print("Nuevo contenido: ");
                        String content = sc.nextLine();
                        boolean ok = Funciones.overWriteFile(file, content);
                        if (ok) System.out.println("Archivo sobrescrito.");
                        else System.out.println("El archivo no existe.");
                    }
                    case 6 -> {
                        System.out.print("Nombre del archivo: ");
                        String file = sc.nextLine();
                        Funciones.deleteFile(file);
                    }
                    case 7 -> {
                        System.out.print("Nombre del archivo: ");
                        String file = sc.nextLine();
                        int chars = Funciones.countChars(file);
                        System.out.println("Caracteres: " + chars);
                    }
                    case 8 -> {
                        System.out.print("Nombre del archivo: ");
                        String file = sc.nextLine();
                        int words = Funciones.countWords(file);
                        System.out.println("Palabras: " + words);
                    }
                    case 9 -> {
                        System.out.print("Nombre del archivo: ");
                        String file = sc.nextLine();
                        System.out.print("Palabra a reemplazar: ");
                        String oldWord = sc.nextLine();
                        System.out.print("Nueva palabra: ");
                        String newWord = sc.nextLine();
                        String result = Funciones.swapWords(file, oldWord, newWord);
                        System.out.println("Nuevo contenido:");
                        System.out.println(result);
                    }
                    case 10 -> {
                        System.out.print("Nombre del archivo: ");
                        String file = sc.nextLine();
                        Funciones.printPDF(file);
                    }
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado.");
        sc.close();
    }
}

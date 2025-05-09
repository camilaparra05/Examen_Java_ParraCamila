/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.outsourcing.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class Contrato extends Contrato {
    private int Fechainicio;
    private int Fechafin;
    private int CostoTotal;
    private String Estado;

    public int getFechainicio() {
        return Fechainicio;
    }

    public int getFechafin() {
        return Fechafin;
    }

    public int getCostoTotal() {
        return CostoTotal;
    }

    public String getEstado() {
        return Estado;
    }
    
    public Contrato(String nombre, int telefono, String Representante, String Correo, String Direccion, String Sector) {
        super(nombre, telefono, Representante, Correo, Direccion, Sector);
    }
    
    
public class Main {
    private static final String FILE_NAME = "Contratos.dat";

    public static void main(String[] args) throws IOException {
        List<Contrato>Contrato = CargarContrato();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión deContrato ---");
            System.out.println("1. Registrar Contrato");
            System.out.println("2. Mostrar Contrato");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Representante: ");
                    int Representante = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Correo: ");
                    String Correo = scanner.nextLine();
                     System.out.print("telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Direccion ");
                    String Direccion = scanner.nextLine();
                    System.out.print("Sector ");
                    String Sector = scanner.nextLine();
                    Contrato.add(new Contrato(nombre, Representante, Correo,telefono,Direccion,Sector ));
                {
                    List<Contrato> Contrato = null;
                    guardarContrato(Contrato);
                }
                    break;

                case 2:
                   Contrato.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Ingrese nombre a buscar: ");
                    String buscar = scanner.nextLine();
                   Contrato.stream()
                            .filter(e -> e.getNombre().equalsIgnoreCase(buscar))
                           
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion inválida.");
            }
        } while (opcion != 4);
    }

    private static void guardarContrato(List<Contrato> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error guardando: " + e.getMessage());
        }
    }

    private static List<Contrato> CargarContrato() throws FileNotFoundException, IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Contrato>) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Error cargando: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}


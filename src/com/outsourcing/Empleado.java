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
public class Empleado {

    static void add(Empleado cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String nombre;
    private String Representante;
    private String Correo;
    private int telefono;
    private String Direccion;
    private String Sector;

    public Empleado(String nombre, int telefono, String Representante, String Correo, String Direccion, String Sector) {
        this.nombre = nombre;
        this.Representante = Representante;
        this.Correo = Correo;
        this.telefono = telefono;
        this.Direccion = Direccion;
        this.Sector = Sector;
    }
    public String getNombre() {
        return nombre;
    }

    public String getRepresentante() {
        return Representante;
    }

    public String getCorreo() {
        return Correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getSector() {
        return Sector;
    }
    

     @Override
    public String toString() {
        return "Nombre: " + nombre + ", Representante " + Representante + " correo " + Correo + " Telefono " + telefono + " Direccion " + Direccion + "Nombre: " + nombre ;
    }
    

public class Main {
    private static final String FILE_NAME = "Clientes.dat";

    public static void main(String[] args) throws IOException {
        List<Empleado> cliente = cargarClientes();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión de cliente ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Mostrar cliente");
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
                    cliente.add(new Empleado(nombre, Representante, Correo,telefono,Direccion,Sector ));
                {
                    
                         guardarClientes(cliente);
                }
                    break;


                case 2:
                    cliente.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Ingrese nombre a buscar: ");
                    String buscar = scanner.nextLine();
                    cliente.stream()
                            .filter(e -> e.getNombre().equalsIgnoreCase(buscar))
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion inválida.");
            }
        } while (opcion != 4);
    }

    private static void guardarClientes(List<Empleado> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error guardando: " + e.getMessage());
        }
    }

    private static List<Empleado> cargarClientes() throws FileNotFoundException, IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Empleado>) ois.readObject();
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



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mariacamilaparrasierra
 */
package com.outsourcing;

import java.util.List;
import java.util.Scanner;

public class ClienteView {
    private static final Scanner sc = new Scanner(System.in);
    private static final ClienteController controller = new ClienteController();

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ CLIENTES ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> listarClientes();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void registrarCliente() {
        System.out.println("\n--- Registrar Cliente ---");
        System.out.print("Nombre empresa: ");
        String nombre = sc.nextLine();
        System.out.print("Representante: ");
        String representante = sc.nextLine();
        System.out.print("Correo electrónico: ");
        String correo = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Sector (Tecnología, Salud, Educación, Comercio, Manufactura): ");
        String sector = sc.nextLine();

        Cliente cliente = new Cliente(nombre, representante, correo, telefono, direccion, sector);
        controller.registrar(cliente);
    }

    private static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> clientes = controller.listar();
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + " | " + c.getNombre() + " | Sector: " + c.getSector());
        }
    }
     public static void main(String[] args) {
        mostrarMenu();
    }
}

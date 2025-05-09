/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author mariacamilaparrasierra
 */

package com.outsourcing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void registrarCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (nombre, representante, correo_electronico, telefono, direccion, sector) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getRepresentante());
            stmt.setString(3, cliente.getCorreo());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getSector());

            stmt.executeUpdate();
            System.out.println("cliente registrado");

        } catch (SQLException e) {
            System.err.println(" nose registrar cliente ");
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setRepresentante(rs.getString("representante"));
                cliente.setCorreo(rs.getString("correo_electronico"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setSector(rs.getString("sector"));
                lista.add(cliente);
            }

        } catch (SQLException e) {
            System.err.println(" no se pudo listar clientes: " + e.getMessage());
        }

        return lista;
    }
}

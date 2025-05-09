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

public class ClienteController {
    private ClienteDAO dao = new ClienteDAO();

    public void registrar(Cliente cliente) {
        dao.registrarCliente(cliente);
    }

    public List<Cliente> listar() {
        return dao.listarClientes();
    }
}

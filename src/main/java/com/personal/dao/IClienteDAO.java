package com.personal.dao;

import java.util.List;

import com.personal.model.Cliente;

public interface IClienteDAO {
	
	public void save(Cliente cliente);
	
	public List<Cliente> findAll();

}

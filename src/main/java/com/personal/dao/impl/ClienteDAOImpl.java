package com.personal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.personal.dao.IClienteDAO;
import com.personal.model.Cliente;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ClienteDAOImpl implements IClienteDAO {
	
	
	///private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    ///@PersistenceContext
    ///public void setEntityManager(EntityManager em) {
    ///    this.em = em;
    ///}
	private EntityManagerFactory emf;
	@PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
	
	@SuppressWarnings("unchecked")
	//@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		EntityManager em = this.emf.createEntityManager();
		return em.createQuery("FROM Cliente").getResultList();
	}

	@Override
	//@Transactional
	public void save(Cliente cliente) {
	
		EntityManager em = this.emf.createEntityManager();
		em.getTransaction();
		em.persist(cliente);
	}

}

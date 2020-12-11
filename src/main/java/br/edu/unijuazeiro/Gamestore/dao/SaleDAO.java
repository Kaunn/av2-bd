package br.edu.unijuazeiro.Gamestore.dao;

import java.util.List;

import javax.persistence.EntityManager;


import br.edu.unijuazeiro.Gamestore.Models.Business.Sale;
import br.edu.unijuazeiro.Gamestore.dao.util.ConnectionFactory;

public class SaleDAO {
    
    public static void save(Sale sale) {
        EntityManager em = ConnectionFactory.getEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(sale);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            } finally {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
    
        public void update(Sale sale) {
            EntityManager em = ConnectionFactory.getEntityManager();
            try {
                em.getTransaction().begin();
                em.merge(sale);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            } finally {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
    
        public void remove(Integer saleid) {
            EntityManager em = ConnectionFactory.getEntityManager();
            try {
                em.getTransaction().begin();
                Sale sale = em.find(Sale.class, saleid);
                em.remove(sale);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            } finally {
                if (em.isOpen()) {
                    em.close();
                }
            }
        }
    
        public Sale findById(Integer code) {
            EntityManager em = ConnectionFactory.getEntityManager();
            Sale sale = em.find(Sale.class, code);
            if (em.isOpen()) {
                em.close();
            }
            return sale;
        }
     
        public List<Sale> list() {
            EntityManager em = ConnectionFactory.getEntityManager();
            List<Sale> sales = em.createQuery("from Sale", Sale.class).getResultList();
            if (em.isOpen()) {
                em.close();
            }
            return sales;
        }
}

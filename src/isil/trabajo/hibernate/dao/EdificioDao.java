package isil.trabajo.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import isil.trabajo.hibernate.util.HibernateConfigWeb;
import isil.trabajo.hibernate.model.Edificio;

public class EdificioDao {

    /**
     * Save Edificio
     * @param edificio
     */
    public void saveEdificio(Edificio edificio) {
        Transaction transaction = null;
        try (Session session = HibernateConfigWeb.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(edificio);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Edificio
     * @param edificio
     */
    public void updateEdificio(Edificio edificio) {
        Transaction transaction = null;
        try (Session session = HibernateConfigWeb.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(edificio);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Edificio
     * @param id
     */
    public void deleteEdificio(int id) {

        Transaction transaction = null;
        try (Session session = HibernateConfigWeb.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Edificio edificio = session.get(Edificio.class, id);
            if (edificio != null) {
                session.delete(edificio);
                System.out.println("El edificio fue borrado");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Edificio By ID
     * @param id
     * @return
     */
    public Edificio getEdificio(int id) {

        Transaction transaction = null;
        Edificio edificio = null;
        try (Session session = HibernateConfigWeb.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            edificio = session.get(Edificio.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return edificio;
    }

    /**
     * Get all Edificios
     * @return
     */
    @SuppressWarnings("unchecked")
    public List < Edificio > getAllEdificio() {

        Transaction transaction = null;
        List < Edificio > listOfEdificio = null;
        try (Session session = HibernateConfigWeb.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfEdificio = session.createQuery("from Edificio").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfEdificio;
    }


	
}

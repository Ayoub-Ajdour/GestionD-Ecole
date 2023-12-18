package dao.impl;

import dao.FiliereDAO;
import entities.Filiere;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import unity.HibernateUtil;

import java.util.Collections;
import java.util.List;


public class FiliereDAOImpl extends HibernateUtil implements FiliereDAO {
    private Session s=null;
    Transaction tx=null;

    public FiliereDAOImpl() {
    }

    @Override
    public Filiere getByCode(String code) {

        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();

            String hql = "FROM Filiere WHERE code = :code";
            Query<Filiere> query = session.createQuery(hql, Filiere.class);
            query.setParameter("code", code);
            Filiere filiere = query.uniqueResult();
            tx.commit();

            return filiere;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean create(Filiere filiere) {

        try{
        s= HibernateUtil.getSession();
        tx=s.beginTransaction();
        s.save(filiere);
        tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            System.out.println("pb insert fl "+e.getMessage());
            return false;
        }finally {
            s.close();
        }

        return true;
    }
    @Override
    public boolean saveOrUpdate(Filiere filiere) {

        if (filiere != null) {
            return this.getById(filiere.getIdFiliere()) != null ? this.update(filiere) : this.create(filiere);
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Filiere filiere) {

        try{
            s= HibernateUtil.getSession();
            tx=s.beginTransaction();
            s.update(filiere);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            System.out.println("pb update fl "+e.getMessage());
            return false;
        }finally {
            s.close();
        }

        return true;
    }

    @Override
    public boolean delete(Filiere filiere) {

        try{
            s= HibernateUtil.getSession();
            tx=s.beginTransaction();
            s.delete(filiere);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            System.out.println("pb delete fl "+e.getMessage());
            return false;
        }finally {
            s.close();
        }

        return true;
    }

    @Override
    public Filiere getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {

            Transaction transaction = session.beginTransaction();
            Filiere filiere = session.get(Filiere.class, id);
            transaction.commit();
            return filiere;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Filiere> getAll() {
        try  {
            s = HibernateUtil.getSession();
            Query<Filiere> query = s.createQuery("from Filiere", Filiere.class);
            List<Filiere> filieres = query.list();

            System.out.println(filieres.toString());

            return filieres;
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("eroorr f affichage "+e.getMessage());
            return Collections.emptyList();
        }

    }
    }


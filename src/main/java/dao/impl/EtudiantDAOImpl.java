package dao.impl;


import dao.EtudiantDAO;
import entities.Etudiant;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import unity.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class EtudiantDAOImpl extends HibernateUtil implements EtudiantDAO {
    private Session s=null;
    Transaction tx=null;
    public EtudiantDAOImpl() {
    }
    @Override
    public Etudiant getByCne(String cne) {
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();

            String hql = "FROM Etudiant WHERE cne = :cne";
            Query<Etudiant> query = session.createQuery(hql, Etudiant.class);
            query.setParameter("cne", cne);
            Etudiant etudiant = query.uniqueResult();
            tx.commit();

            return etudiant;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean create(Etudiant c) {
        try{
            s= HibernateUtil.getSession();
            tx=s.beginTransaction();
            s.save(c);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            System.out.println("pb insert etud "+e.getMessage());
            return false;
        }finally {
            s.close();
        }

        return true;
    }

    @Override
    public boolean saveOrUpdate(Etudiant c) {
        if (c != null) {
            return this.getById(c.getIdEtudiant()) != null ? this.update(c) : this.create(c);
        } else {
            return false;
        }
    }
    @Override
    public boolean update(Etudiant c) {
        try{
            s= HibernateUtil.getSession();
            tx=s.beginTransaction();
            s.update(c);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            System.out.println("pb update etud "+e.getMessage());
            return false;
        }finally {
            s.close();
        }
        return true;
    }

    @Override
    public boolean delete(Etudiant c) {
        try{
            s= HibernateUtil.getSession();
            tx=s.beginTransaction();
            s.delete(c);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            System.out.println("pb delete etudiant "+e.getMessage());
            return false;
        }finally {
            s.close();
        }

        return true;
    }

    @Override
    public Etudiant getById(Integer c) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Etudiant etudiant = session.get(Etudiant.class, c);
            transaction.commit();

            return etudiant;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Etudiant> getAll() {
        try  {
            System.out.println("hnaaa  2");
            s = HibernateUtil.getSession();

            Query<Etudiant> query = s.createQuery("from Etudiant ", Etudiant.class);
            List<Etudiant> etudiants = query.list();

            System.out.println(etudiants.toString());

            return etudiants;
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("eroorr f affichage  etudiant"+e.getMessage());
            return Collections.emptyList();
        }
    }
}



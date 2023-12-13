package dao.impl;

import dao.ConnectionTool;
import dao.EtudiantDAO;
import dao.FiliereDAO;
import entities.Etudiant;
import entities.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAOImpl extends ConnectionTool implements EtudiantDAO {
    private static final Connection connexion = getConnexion();

    public EtudiantDAOImpl() {
    }

    @Override
    public Etudiant getByCne(String cne) {
        if (connexion == null) {
            return null;
        }
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from etudiant where idEtudiant = ?");
            ps.setString(1, cne);
            ResultSet rs = ps.executeQuery();
            Etudiant etudiant = null;
            if (rs.next()) {
                etudiant = new Etudiant();
                etudiant.setIdEtudiant(rs.getInt(1));
                etudiant.setNom(rs.getString(2));
                etudiant.setPrenom(rs.getString(3));
                etudiant.setCne(rs.getString(4));
                int t=rs.getInt(5);
                FiliereDAO filiereDAO=new FiliereDAOImpl();
                etudiant.setFiliere(filiereDAO.getById(t));

            }

            rs.close();
            ps.close();
            System.out.println("etudiant by cne ok");
            return etudiant;
        } catch (SQLException var5) {
            System.out.println("probleme filiere by cne " + var5.getMessage());
            return null;
        }
    }

    @Override
    public boolean create(Etudiant c) {
        if (connexion != null && c != null) {
            try {
                PreparedStatement ps = connexion.prepareStatement("INSERT INTO etudiant (nom, prenom, cne, filiere) values (?,?,?,?)", 1);
                ps.setString(1, c.getNom());
                ps.setString(2, c.getPrenom());
                ps.setString(3, c.getCne());
                Filiere cc=c.getFiliere();
                ps.setInt(4, cc.getIdFiliere());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                c.setIdEtudiant(rs.getInt(1));
                rs.close();
                ps.close();
                System.out.println("etudiant bien ajoute");
                return true;
            } catch (SQLException var4) {
                System.out.println("probleme ajout etudiant" + var4.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean saveOrUpdate(Etudiant c) {
        if (connexion != null && c != null) {
            return this.getById(c.getIdEtudiant()) != null ? this.update(c) : this.create(c);
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Etudiant c) {
        if (connexion != null && c != null) {
            try {
                PreparedStatement ps = connexion.prepareStatement("update etudiant set nom=?,prenom=?,cne=?,filiere=? where idEtudiant = ?");
                ps.setString(1, c.getNom());
                ps.setString(2, c.getPrenom());
                ps.setString(3, c.getCne());
                Filiere cc=c.getFiliere();
                ps.setInt(4, cc.getIdFiliere());
                ps.setInt(5, c.getIdEtudiant());
                ps.executeUpdate();
                ps.close();
                System.out.println("Etudiant bien modifie");
                return true;
            } catch (SQLException var3) {
                System.out.println("probleme mfd Etudiant" + var3.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Etudiant c) {
        if (connexion != null && c != null) {
            try {
                PreparedStatement ps = connexion.prepareStatement("delete from etudiant where idEtudiant = ?");
                ps.setInt(1, c.getIdEtudiant());
                ps.executeUpdate();
                ps.close();
                System.out.println("Etudiant bien supprime");
                return true;
            } catch (SQLException var3) {
                System.out.println("probleme suppression de etudiant " + var3.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Etudiant getById(Integer c) {
        if (connexion != null && c != null) {
            try {
                PreparedStatement ps = connexion.prepareStatement("select * from etudiant where idEtudiant = ?");
                ps.setInt(1, c);
                ResultSet rs = ps.executeQuery();
                Etudiant etudiant = null;
                if (rs.next()) {
                    etudiant = new Etudiant();
                    etudiant.setIdEtudiant(rs.getInt(1));
                    etudiant.setNom(rs.getString(2));
                    etudiant.setPrenom(rs.getString(3));
                    etudiant.setCne(rs.getString(4));
                    int t=rs.getInt(5);
                    FiliereDAO filiereDAO=new FiliereDAOImpl();
                    etudiant.setFiliere(filiereDAO.getById(t));
                }

                rs.close();
                ps.close();
                System.out.println("etudiant by id ok");
                return etudiant;
            } catch (SQLException var5) {
                System.out.println("probleme etudiant by id " + var5.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<Etudiant> getAll() {
        if (connexion == null) {
            return null;
        } else {
            try {
                PreparedStatement ps = connexion.prepareStatement("select * from etudiant");
                ResultSet rs = ps.executeQuery();
                List<Etudiant> etudiants = new ArrayList<Etudiant>();

                while(rs.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setIdEtudiant(rs.getInt(1));
                    etudiant.setNom(rs.getString(2));
                    etudiant.setPrenom(rs.getString(3));
                    etudiant.setCne(rs.getString(4));
                    int t=rs.getInt(5);
                    FiliereDAO filiereDAO=new FiliereDAOImpl();
                    etudiant.setFiliere(filiereDAO.getById(t));

                    etudiants.add(etudiant);
                }

                rs.close();
                ps.close();
                System.out.println("etudiant all okey");
                return etudiants;
            } catch (SQLException var5) {
                System.out.println("probleme etudiants all " + var5.getMessage());
                return null;
            }
        }
    }
}



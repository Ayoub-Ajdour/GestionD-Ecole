package dao.impl;

import dao.ConnectionTool;
import dao.FiliereDAO;
import entities.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FiliereDAOImpl extends ConnectionTool implements FiliereDAO {
    private static Connection connexion = getConnexion();

    public FiliereDAOImpl() {
    }

    @Override
    public Filiere getByCode(String code) {
        if (this.connexion == null) {
            return null;
        } else {
            try {
                PreparedStatement ps = this.connexion.prepareStatement("select * from filiere where code = ?");
                ps.setString(1, code);
                ResultSet rs = ps.executeQuery();
                Filiere filiere = null;
                if (rs.next()) {
                    filiere = new Filiere();
                    filiere.setIdFiliere(rs.getInt(1));
                    filiere.setCode(rs.getString(2));
                    filiere.setLibelle(rs.getString(3));
                }

                rs.close();
                ps.close();
                System.out.println("filiere by code ok");
                return filiere;
            } catch (SQLException var5) {
                System.out.println("probleme filiere by code " + var5.getMessage());
                return null;
            }
        }
    }

    public boolean create(Filiere filiere) {
        if (this.connexion != null && filiere != null) {
            try {
                PreparedStatement ps = this.connexion.prepareStatement("insert into filiere (code, libelle) values (?,?)", 1);
                ps.setString(1, filiere.getCode());
                ps.setString(2, filiere.getLibelle());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                filiere.setIdFiliere(rs.getInt(1));
                rs.close();
                ps.close();
                System.out.println("filiere bien ajoute");
                return true;
            } catch (SQLException var4) {
                System.out.println("probleme ajout filiere" + var4.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
    @Override
    public boolean saveOrUpdate(Filiere filiere) {
        if (this.connexion != null && filiere != null) {
            return this.getById(filiere.getIdFiliere()) != null ? this.update(filiere) : this.create(filiere);
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Filiere filiere) {
        if (this.connexion != null && filiere != null) {
            try {
                PreparedStatement ps = this.connexion.prepareStatement("update filiere set code = ? , libelle = ? where idFiliere = ?");
                ps.setString(1, filiere.getCode());
                ps.setString(2, filiere.getLibelle());
                ps.setInt(3, filiere.getIdFiliere());
                ps.executeUpdate();
                ps.close();
                System.out.println("filiere bien modifie");
                return true;
            } catch (SQLException var3) {
                System.out.println("probleme mfd filiere" + var3.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Filiere filiere) {
        if (this.connexion != null && filiere != null) {
            try {
                PreparedStatement ps = this.connexion.prepareStatement("delete from filiere where idFiliere = ?");
                ps.setInt(1, filiere.getIdFiliere());
                ps.executeUpdate();
                ps.close();
                System.out.println("filiere bien supprime");
                return true;
            } catch (SQLException var3) {
                System.out.println("probleme suppression de filiere " + var3.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Filiere getById(Integer id) {
        if (connexion != null && id != null) {
            try {
                PreparedStatement ps = connexion.prepareStatement("select * from filiere where idFiliere = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                Filiere filiere = null;
                if (rs.next()) {
                    filiere = new Filiere();
                    filiere.setIdFiliere(rs.getInt(1));
                    filiere.setCode(rs.getString(2));
                    filiere.setLibelle(rs.getString(3));
                }

                rs.close();
                ps.close();
                System.out.println("filiere by id ok");
                return filiere;
            } catch (SQLException var5) {
                System.out.println("probleme filiere by id " + var5.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<Filiere> getAll() {
        if (this.connexion == null) {
            return null;
        } else {
            try {
                PreparedStatement ps = this.connexion.prepareStatement("select * from filiere");
                ResultSet rs = ps.executeQuery();
                List<Filiere> filieres = new ArrayList();

                while(rs.next()) {
                    Filiere filiere = new Filiere();
                    filiere.setIdFiliere(rs.getInt(1));
                    filiere.setCode(rs.getString(2));
                    filiere.setLibelle(rs.getString(3));
                    filieres.add(filiere);
                }

                rs.close();
                ps.close();
                System.out.println("filiere all okey");
                return filieres;
            } catch (SQLException var5) {
                System.out.println("probleme filiere all " + var5.getMessage());
                return null;
            }
        }
    }
}

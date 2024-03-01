/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import comon.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Criteria;
import model.Feature;
import model.Function;
import model.Setting;
import model.Team;
import model.User;

/**
 *
 * @author PC PHUC
 */
public class FunctionDao extends DBContext {

    Connection conn = null;        //ket noi voi sql sever
    PreparedStatement ps = null;   //nem cau lenh query sang sql sever
    ResultSet rs = null;           //nhan ket qua tra ve

    public List<Function> getAllFunction(int index) {
        String sql = "select * from function_tb ORDER BY function_id limit ?, 10 ;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Function> getAllFunction1() {
        String sql = "select * from function_tb;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Function getFunctionByID(int id) {
        String query = "select * from function_tb where function_id = ? ;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Function> searchFunction(String txtSearch, int index) {
        List<Function> list = new ArrayList<>();
        String query = "select * from function_tb where team_name like ? or function_id like ? "
                + "or function_name like ? or feature_name like ?\n"
                + "ORDER BY function_id limit ?, 5 ;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            ps.setString(4, "%" + txtSearch + "%");
            ps.setInt(5, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getTotalSearchFunction(String txtSearch) {
        String query = "select count(*) from function_tb where team_name like ? or function_id like ?"
                + "or function_name like ? or feature_name like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            ps.setString(4, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int getTotalFunction() {
        String query = "select count(*) from function_tb;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Function> getFuctbyString(String str) throws Exception {
        String sql = "select * from function_tb where  1=1 ";
        List<Function> list = new ArrayList();

        if (!str.isEmpty()) {
            sql = sql + str;
        }
        System.out.println(sql);
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void changeStatusFunction(int id) throws Exception {

        String sql = " update function_tb set  status =  ?   where function_id = ? ";
        int status = 1;
        Function f = new Function();
        f = getFunctionByID(id);
        if (f.getStatus() == 0) {
            status = 1;
        } else if (f.getStatus() == 1) {
            status = 2;
        } else {
            status = 3;
        }
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            //............
            st.setInt(1, status);
            st.setInt(2, id);
            ///...................
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Team> getAllTeamName() {
        String sql = "select team_id, team_name from team;";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Feature> getAllFeatureName() {
        String sql = "select feature_id, feature_name from feature;";
        List<Feature> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feature(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Function> getAllRole() {
        String sql = "select distinct access_role from function_tb;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<User> getAllOwner() {
        String sql = "select full_name from user;";
        List<User> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void updatetFunction(String team_name, String function_name, String feature_name, String priority,
            String access_role, String description, String complexity_id, String owner_name, String status, int id) {
        String query = "update function_tb set team_name = ? , function_name = ? , feature_name = ? , access_role = ? , description = ?"
                + ",  complexity_id = ?, owner_name = ?, priority = ? , status = ? where function_id = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, team_name);
            ps.setString(2, function_name);
            ps.setString(3, feature_name);
            ps.setString(4, access_role);
            ps.setString(5, description);
            ps.setString(6, complexity_id);
            ps.setString(7, owner_name);
            ps.setString(8, priority);
            ps.setString(9, status);
            ps.setInt(10, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void addFunction(String team_name, String function_name, String feature_name, String priority,
            String access_role, String description, String complexity_id, String owner_name, String status) {
        String query = "insert into function_tb (team_name, function_name, feature_name, access_role, description, complexity_id, owner_name, priority, status)\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, team_name);
            ps.setString(2, function_name);
            ps.setString(3, feature_name);
            ps.setString(4, access_role);
            ps.setString(5, description);
            ps.setString(6, complexity_id);
            ps.setString(7, owner_name);
            ps.setString(8, priority);
            ps.setString(9, status);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void addFunction1(int function_id, String team_name, String function_name, String feature_name, int priority,
            int access_role, String description, int complexity_id, String owner_name, int status) {
        String query = "insert into function_tb (function_id, team_name, function_name, feature_name, access_role, description, complexity_id, owner_name, priority, status)\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, function_id);
            ps.setString(2, team_name);
            ps.setString(3, function_name);
            ps.setString(4, feature_name);
            ps.setInt(5, access_role);
            ps.setString(6, description);
            ps.setInt(7, complexity_id);
            ps.setString(8, owner_name);
            ps.setInt(9, priority);
            ps.setInt(10, status);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<Function> sortFunctIDasc(int index) {
        String sql = "select * from function_tb ORDER BY function_id asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
     public List<Function> sortFunctIDdesc(int index) {
        String sql = "select * from function_tb ORDER BY function_id desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortTeamasc(int index) {
        String sql = "select * from function_tb ORDER BY team_name asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortTeamdesc(int index) {
        String sql = "select * from function_tb ORDER BY team_name desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortNameasc(int index) {
        String sql = "select * from function_tb ORDER BY function_name asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortNamedesc(int index) {
        String sql = "select * from function_tb ORDER BY function_name desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortFeaNameasc(int index) {
        String sql = "select * from function_tb ORDER BY feature_name asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortFeaNamedesc(int index) {
        String sql = "select * from function_tb ORDER BY feature_name desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortRoleasc(int index) {
        String sql = "select * from function_tb ORDER BY access_role asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortRoledesc(int index) {
        String sql = "select * from function_tb ORDER BY access_role desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortComplexasc(int index) {
        String sql = "select * from function_tb ORDER BY complexity_id asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortComplexdesc(int index) {
        String sql = "select * from function_tb ORDER BY complexity_id desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortOwnerNameasc(int index) {
        String sql = "select * from function_tb ORDER BY owner_name asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortOwnerNamedesc(int index) {
        String sql = "select * from function_tb ORDER BY owner_name desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortPriorityasc(int index) {
        String sql = "select * from function_tb ORDER BY priority asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortPrioritydesc(int index) {
        String sql = "select * from function_tb ORDER BY priority desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
     public List<Function> sortStatusasc(int index) {
        String sql = "select * from function_tb ORDER BY status asc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     public List<Function> sortStatusdesc(int index) {
        String sql = "select * from function_tb ORDER BY status desc limit ?, 10;";
        List<Function> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Function(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        FunctionDao dao = new FunctionDao();
//
        List<Function> list = dao.getAllFunction(2);
        for (Function o : list) {
            System.out.println(o);
        }
//        int d = dao.getTotalFunction();
//        System.out.println(d);

//        Setting s = new Setting();
//        dao.updatetTeam("SE1602", "bvmt1", "Duck", "Bao ve moi truong", "hehe", "1", 1);
//        System.out.println(s);
    }
}

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
import model.Feature;


/**
 *
 * @author My PC
 */
public class FeatureDao extends DBContext{
    Connection conn = null;        //ket noi voi sql sever
    PreparedStatement ps = null;   //nem cau lenh query sang sql sever
    ResultSet rs = null;           //nhan ket qua tra ve

    public List<Feature> getAllFeature(int index) {
        String sql = "select * from feature limit ?, 7;";
        List<Feature> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feature(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


    public void changeStatus(String id) throws Exception {

        String sql = "update feature set status =  ?  where feature_id = ?;";
        String status = "1";
        Feature sb = new Feature();
        sb = getFeatureByID(id);
        if (sb.getFeature_status().compareTo("1") == 0) {
            status = "0";
        } else {
            status = "1";
        }
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, status);
            st.setString(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Feature getFeatureByID(String id) {
        String query = "select * from feature where  feature_id = ?; ";
        try { 
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Feature(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int getTotalFeature() {
        String query = "select count(*) from feature";
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

     public List<Feature> getSortFeatureByStatus1(int index) {
        String sql = "select * from feature where status = 1 ORDER BY feature_id limit ?, 7";
        List<Feature> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feature(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
        public List<Feature> getSortFeatureByStatus0(int index) {
        String sql = "select * from feature where status = 0 ORDER BY feature_id limit ?, 7";
        List<Feature> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feature(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
        public List<Feature> search(String txtSearch) {
        List<Feature> list = new ArrayList<>();
        String query = "select * from feature where feature_id like ? or team_id like ? or feature_name like ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feature(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
        
    public void AddFeature(Feature p) throws Exception {
        String sql = "insert into feature(team_id, feature_name, status) values(?, ?, ?);";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, p.getTeam_id());
            st.setString(2, p.getFeature_name());
            st.setString(3, p.getFeature_status());
            ///...................
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }    
        public void EditFeature(String team,String name,String status, String id) throws Exception {
        String sql = "update spm_database.feature set team_id = ?, feature_name = ?, status = ? where feature_id = ? ;";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            //............
            st.setString(1, team);
            st.setString(2, name);
            st.setString(3, status);
            st.setString(4, id);
            ///...................
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
        public List<Feature> getSortFeatureByTeam(int t) {
        String sql = "select * from feature where team_id = ? order by feature_id;";
        List<Feature> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, t);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feature(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Feature> getSortFeatureByName(int index) {
        String sql = "SELECT * FROM spm_database.feature order by feature_name asc limit ?, 7 ;";
        List<Feature> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feature(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
            public List<Feature> getTeam() {
        String sql = "select team_id from feature group by team_id;";
        List<Feature> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Feature(rs.getString(1)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}

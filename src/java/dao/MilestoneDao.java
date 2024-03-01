/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import comon.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.Milestone;
import model.Class;
import model.Iteration;

/**
 *
 * @author NamOK
 */
public class MilestoneDao extends DBContext {
    //1.1  Get all Milestone  

    public List<Milestone> getAllMilestone() {
        String sql = "select milestone_id , milestone.class_id ,class_code, milestone.iteration_id , iteration_name, DATE_FORMAT(from_date, \" %d/%m/%Y\") as from_date , DATE_FORMAT(to_date, \" %d/%m/%Y\") as to_date , milestone.status from  milestone  join class,iteration where milestone.class_id = class.class_id and milestone.iteration_id= iteration.iteration_id order by  milestone_id ";
        List<Milestone> list = new ArrayList();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //Get user from database 
            while (rs.next()) {
                list.add(new Milestone(rs.getInt("milestone_id"), rs.getInt("iteration_id"), rs.getString("iteration_name"),
                        rs.getString("class_id"), rs.getString("class_code"), rs.getString("from_date"),
                        rs.getString("to_date"), rs.getInt("status")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Milestone> getAllMilestoneSort(String str) {
        String sql = "select milestone_id , milestone.class_id ,class_code, milestone.iteration_id , iteration_name, DATE_FORMAT(from_date, \" %d/%m/%Y\") as from_date , DATE_FORMAT(to_date, \" %d/%m/%Y\") as to_date , milestone.status from  milestone  join class,iteration where milestone.class_id = class.class_id and milestone.iteration_id= iteration.iteration_id"
                + " order by  ";
        sql += str;
        List<Milestone> list = new ArrayList();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //Get user from database 
            while (rs.next()) {
                list.add(new Milestone(rs.getInt("milestone_id"), rs.getInt("iteration_id"), rs.getString("iteration_name"),
                        rs.getString("class_id"), rs.getString("class_code"), rs.getString("from_date"),
                        rs.getString("to_date"), rs.getInt("status")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    //2.3 Get Milestone by ID

    public Milestone GetMilestonebyID(int id) throws Exception {
        String sql = "select milestone_id , milestone.class_id ,class_code, milestone.iteration_id , iteration_name, DATE_FORMAT(from_date, \" %d/%m/%Y\") as from_date , DATE_FORMAT(to_date, \" %d/%m/%Y\") as to_date , milestone.status from  milestone  join class,iteration \n"
                + "where ( milestone.class_id = class.class_id and milestone.iteration_id= iteration.iteration_id ) and  milestone_id =  ?   ";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                return new Milestone(rs.getInt("milestone_id"), rs.getInt("iteration_id"), rs.getString("iteration_name"),
                        rs.getString("class_id"), rs.getString("class_code"), rs.getString("from_date"),
                        rs.getString("to_date"), rs.getInt("status"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    //1.3 Change Status Milestone 
    public void changeStatus(String id) throws Exception {

        String sql = " update milestone set  status =  ?  where milestone_id = ?";
        int status = 1;
        Milestone mi = new Milestone();
        int numid = Integer.parseInt(id);
        mi = GetMilestonebyID(numid);
        //Get new status 
        if (mi.getStatus() == 0) {
            status = 1;
        } else {
            status = 0;
        }
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            //............
            st.setInt(1, status);
            st.setInt(2, numid);
            ///...................
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //2.2 Update Milestone 
    public void update(Milestone p) throws Exception {

        String sql = " update milestone set milestone_id = ? , class_id  = ?  , iteration_id  = ?  , from_date  = ? , to_date = ?  , status  = ? \n"
                + "where milestone_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            st.setInt(1, p.getId());
            st.setString(2, p.getClass_id());
            st.setInt(3, p.getIteration_id());
            st.setString(4, p.getFrom_date());
            st.setString(5, p.getTo_date());
            st.setInt(6, p.getStatus());
            st.setInt(7, p.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //...................
    public List<Class> getAllClass() {
        String sql = "select * from class ";
        List<Class> list = new ArrayList();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //Get user from database 
            while (rs.next()) {
                list.add(new Class(rs.getString("class_id"), rs.getString("class_code")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Iteration> getAllIter() {
        String sql = "select * from iteration ";
        List<Iteration> list = new ArrayList();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //Get user from database 
            while (rs.next()) {
                list.add(new Iteration(rs.getInt("iteration_id"), rs.getString("iteration_name")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //..........
    //2.3 Get Milestone by from date to date 
    public List<Milestone> SearchbyDate(String from, String to) throws Exception {
        String sql = "select milestone_id , milestone.class_id ,class_code, milestone.iteration_id , iteration_name, DATE_FORMAT(from_date, \" %d/%m/%Y\") as from_date , DATE_FORMAT(to_date, \" %d/%m/%Y\") as to_date , milestone.status from  milestone  join class,iteration \n"
                + "where ( milestone.class_id = class.class_id and milestone.iteration_id= iteration.iteration_id ) \n"
                + "                 and ( from_date between ? and ? ) and  ( to_date between ? and ? ) ;  ";
        List<Milestone> list = new ArrayList();

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, from);
            st.setString(2, to);
            st.setString(3, from);
            st.setString(4, to);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Milestone(rs.getInt("milestone_id"), rs.getInt("iteration_id"), rs.getString("iteration_name"),
                        rs.getString("class_id"), rs.getString("class_code"), rs.getString("from_date"),
                        rs.getString("to_date"), rs.getInt("status")));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    //..................................
    public List<Milestone> getMilestonebyString(String str) throws Exception {
        String sql = "select milestone_id , milestone.class_id ,class_code, milestone.iteration_id , iteration_name, DATE_FORMAT(from_date, \" %d/%m/%Y\") as from_date , DATE_FORMAT(to_date, \" %d/%m/%Y\") as to_date , milestone.status from  milestone  join class,iteration \n"
                + "where ( milestone.class_id = class.class_id and milestone.iteration_id= iteration.iteration_id ) ";
        List<Milestone> list = new ArrayList();

        if (!str.isEmpty()) {
            sql = sql + str;
        }
        System.out.println(sql);
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Milestone(rs.getInt("milestone_id"), rs.getInt("iteration_id"), rs.getString("iteration_name"),
                        rs.getString("class_id"), rs.getString("class_code"), rs.getString("from_date"),
                        rs.getString("to_date"), rs.getInt("status")));
            }
        } catch (SQLException e) {
//        }

        }
        return list;
    }

    public void addMilestone(Milestone mi) {
        String sql = "INSERT INTO milestone (milestone_id, iteration_id, class_id, from_date, to_date, status )\n"
                + "VALUES(?,?,?,?,?,1);";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setInt(1, mi.getId());
            st.setInt(2, mi.getIteration_id());
            st.setString(3, mi.getClass_id());
            st.setString(4, mi.getFrom_date());
            st.setString(5, mi.getTo_date());

            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public int lastid() {
        String sql = "select milestone_id from milestone\n"
                + "order by milestone_id  desc; ";
        int lastid = 1 ;      
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            //Get user from database 
            if (rs.next()) {
                lastid = rs.getInt("milestone_id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lastid;
    }
   
}

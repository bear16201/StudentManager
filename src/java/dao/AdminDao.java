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
import model.Iteration;
import model.Setting;
import model.Subject;
import model.SubjectSetting;
import model.Team;
import model.Class;
import model.ClassUser;

/**
 *
 * @author PC PHUC
 */
public class AdminDao extends DBContext {

    Connection conn = null;        //ket noi voi sql sever
    PreparedStatement ps = null;   //nem cau lenh query sang sql sever
    ResultSet rs = null;           //nhan ket qua tra ve

    // Setting //
    public List<Setting> getAllSetting(int index) {
        String sql = "select * from setting ORDER BY setting_id limit ?, 5 ;";
        List<Setting> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Setting(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getTotalSetting() {
        String query = "select count(*) from setting;";
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

    public int getTotalSearchSetting(String txtSearch) {
        String query = "select count(*) from setting where type_id like ? or setting_title like ?"
                + " or subject_name like ? or setting_value like ? or display_order like ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            ps.setString(4, "%" + txtSearch + "%");
            ps.setString(5, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Setting> search(String txtSearch, int index) {
        List<Setting> list = new ArrayList<>();
        String query = "select * from setting where type_id like ? or setting_title like ?"
                + "or subject_name like ? or setting_value like ? or display_order like ?"
                + "ORDER BY setting_id limit ?,5 ;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            ps.setString(4, "%" + txtSearch + "%");
            ps.setString(5, "%" + txtSearch + "%");
            ps.setInt(6, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Setting(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

//    public void deleteSubject(String id) {
//        String query = "delete from subject_setting where type_id = ?;";
//        try {
//            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
//            ps.setString(1, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    public Setting getSettingByID(String id) {
        String query = "select * from setting where type_id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Setting(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void updatetSetting(String type, String subject_name, String setting_title, String setting_value,
            String display_order, String status, String description, String setting_id) {
        String query = "update setting set \n"
                + "setting_title = ?, subject_name = ?, setting_type = ?, setting_value = ?, "
                + "display_order = ?, status = ? , description = ?\n"
                + "where setting_id = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, setting_title);
            ps.setString(2, subject_name);
            ps.setString(3, type);
            ps.setString(4, setting_value);   
            ps.setString(5, display_order);
            ps.setString(6, status);
            ps.setString(7, description);
            ps.setString(8, setting_id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public Setting checkSubjectExist(String type_id, String subject_name, String subject_value) {
//        String query = "select type_id, subject_name, subject_value\n"
//                + "from subject_setting ss join subject s on ss.subject_id = s.subject_id\n"
//                + "where type_id = ? or subject_name = ? or subject_value = ? ORDER BY setting_id asc;";
//        try {
//            conn = new DBContext().getConnection();//mo ket noi voi sql
//            ps = conn.prepareStatement(query);
//            ps.setString(1, type_id);
//            ps.setString(2, subject_name);
//            ps.setString(3, subject_value);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                return new Setting(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7));
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return null;
//    }
    public void addSubject(int type_id, String setting_title, String subject_name, String setting_value,
            String display_order, int status, String description) {
        String query = "insert into setting ( type_id, setting_title, subject_name, setting_value, display_order, status, description) \n"
                + "values (?, ?, ?, ?, ?, ?, ? );";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, type_id);
            ps.setString(2, setting_title);
            ps.setString(3, subject_name);
            ps.setString(4, setting_value);
            ps.setString(5, display_order);
            ps.setInt(6, status);
            ps.setString(7, description);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void changeStatus(String id) {
        String sql = " update setting set status = ? where type_id = ?; ";
        String status = "1";
        Setting sb = new Setting();
        sb = getSettingByID(id);
        if (sb.getStatus().compareTo("1") == 0) {
            status = "0";
        } else {
            status = "1";
        }
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Setting> getSettingbyString(String str) throws Exception {
        String sql = "select * from setting where  1=1 ";
        List<Setting> list = new ArrayList();

        if (!str.isEmpty()) {
            sql = sql + str;
        }
        System.out.println(sql);
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Setting(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    // Setting //
    // Iteration //
    public Iteration getIterationByID(int id) {
        String query = "select * from iteration where iteration_id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Iteration(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addIteration(String subject_id, String iteration_name, String duration, String status) {
        String query = "insert into iteration (subject_id, iteration_name, duration, status)\n"
                + "values(?, ?, ?, ?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, subject_id);
            ps.setString(2, iteration_name);
            ps.setString(3, duration);
            ps.setString(4, status);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatetIteration(String subject_id, String iteration_name,
            String duration, String status, int id) {
        String query = "update iteration set subject_id = ? , iteration_name = ?"
                + ",  duration = ?, status = ? where iteration_id = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, subject_id);
            ps.setString(2, iteration_name);
            ps.setString(3, duration);
            ps.setString(4, status);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Iteration> getAllIter() {
        String sql = "select * from iteration  ";
        List<Iteration> list = new ArrayList();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Iteration(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //System.out.println(list);
        return list;
    }

    public List<Subject> getAllIterSubId() {
        String sql = "select subject_id from subject;";
        List<Subject> list = new ArrayList();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString("subject_id")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //System.out.println(list);
        return list;
    }

    public void changeStatusIter(int id) throws Exception {

        String sql = " update iteration set  status =  ?   where iteration_id = ? ";
        int status = 1;
        Iteration i = new Iteration();
        i = getIterationByID(id);
        if (i.getStatus() == 0) {
            status = 1;
        } else {
            status = 0;
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

    public Iteration checkIterExist(String name) {
        String query = "select * from iteration where iteration_name = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Iteration(rs.getString("subject_id"),
                        rs.getString("iteration_name"),
                        rs.getDate("duration"),
                        rs.getInt("status"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public List<Iteration> getIterbyString(String str) throws Exception {
        String sql = "select * from Iteration where  1=1 "; //and iteration_name = \"iter1\"";
        List<Iteration> list = new ArrayList();

        if (!str.isEmpty()) {
            sql = sql + str;
        }
        System.out.println(sql);
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Iteration(rs.getInt("iteration_id"), rs.getString("subject_id"), rs.getString("iteration_name"), rs.getDate("duration"), rs.getInt("status")));
            }
        } catch (SQLException e) {

        }
        return list;
    }

    // Iteration //
    // Subject Setting //
    public List<SubjectSetting> getAllSubjectSetting(int index) {
        String sql = "select * from subject_setting ORDER BY setting_id limit ?, 5 ;";
        List<SubjectSetting> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SubjectSetting(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public SubjectSetting getSubjectSettingByID(String id) {
        String query = "select * from subject_setting where setting_id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new SubjectSetting(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void changeStatusSS(String id) {

        String sql = " update subject_setting set  status =  ?   where type_id = ? ";
        String status = "1";
        SubjectSetting sb = new SubjectSetting();
        sb = getSubjectSettingByID(id);
        if (sb.getStatus().compareTo("1") == 0) {
            status = "0";
        } else {
            status = "1";
        }
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Subject> getAllSubject() {
        String sql = "select * from subject ";
        List<Subject> list = new ArrayList();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString("subject_id"), rs.getString("subject_code"), rs.getString("subject_name"), rs.getString("author_id"), rs.getString("status")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //System.out.println(list);
        return list;
    }

    public void updatetSubjectSetting(String subject_id, String type_id, String title,
            String value, String display_order, String status, String subSid) {
        String query = "update spm_database.subject_setting set \n"
                + "subject_id = ?, type_id = ?, setting_title = ?, "
                + "setting_value = ?, display_order = ? , status = ?\n"
                + "where setting_id = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, subject_id);
            ps.setString(2, type_id);
            ps.setString(3, title);
            ps.setString(5, value);
            ps.setString(4, display_order);
            ps.setString(6, status);
            ps.setString(7, subSid);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Subject Setting //
    // Criteria //
    public List<Criteria> getAllCriteria(int index) {
        String sql = "select * from evaluation_criteria ORDER BY criteria_id limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Subject> getAllSubjectName() {
        String sql = "select subject_id, subject_name from subject;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString("subject_id"), rs.getString("subject_name")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void changeStatusCriteria(int id) throws Exception {

        String sql = " update evaluation_criteria set  status =  ?   where criteria_id = ? ";
        int status = 1;
        Criteria c = new Criteria();
        c = getCriteriaByID(id);
        if (c.getStatus() == 0) {
            status = 1;
        } else {
            status = 0;
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

    public Criteria getCriteriaByID(int id) {
        String query = "select * from evaluation_criteria where criteria_id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int getTotalCriteria() {
        String query = "select count(*) from evaluation_criteria;";
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

    public List<Criteria> getCritbyString(String str) throws Exception {
        String sql = "select * from evaluation_criteria where  1=1 ";
        List<Criteria> list = new ArrayList();

        if (!str.isEmpty()) {
            sql = sql + str;
        }
        System.out.println(sql);
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Criteria> searchCriteria(String txtSearch, int index) {
        List<Criteria> list = new ArrayList<>();
        String query = "select * from evaluation_criteria where criteria_id like ? or iteration_id like ?"
                + "or iteration_name like ? or evaluation_weight like ? or team_evaluation like ? "
                + "or criteria_order like ? or max_loc like ? or criteria_name like ? or subject_name like ?"
                + "ORDER BY criteria_id limit ?,5 ;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            ps.setString(4, "%" + txtSearch + "%");
            ps.setString(5, "%" + txtSearch + "%");
            ps.setString(6, "%" + txtSearch + "%");
            ps.setString(7, "%" + txtSearch + "%");
            ps.setString(8, "%" + txtSearch + "%");
            ps.setString(9, "%" + txtSearch + "%");
            ps.setInt(10, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getTotalSearchCriteria(String txtSearch) {
        String query = "select count(*) from evaluation_criteria where criteria_id like ? or iteration_id like ?"
                + "or iteration_name like ? or evaluation_weight like ? or team_evaluation like ? "
                + "or criteria_order like ? or max_loc like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            ps.setString(4, "%" + txtSearch + "%");
            ps.setString(5, "%" + txtSearch + "%");
            ps.setString(6, "%" + txtSearch + "%");
            ps.setString(7, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public void updatetCriteria(String criteria_name, String subject_name, String iteration_name, String evaluation_weight,
            String team_evaluation, String criteria_order, String max_loc, String status, String description, int id) {
        String query = "update evaluation_criteria set criteria_name = ?, subject_name = ?, iteration_name = ? , evaluation_weight = ?"
                + ",  team_evaluation = ?, criteria_order = ?, max_loc = ?, status = ?, description = ? where criteria_id = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, criteria_name);
            ps.setString(2, subject_name);
            ps.setString(3, iteration_name);
            ps.setString(4, evaluation_weight);
            ps.setString(5, team_evaluation);
            ps.setString(6, criteria_order);
            ps.setString(7, max_loc);
            ps.setString(8, status);
            ps.setString(9, description);
            ps.setInt(10, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addCriteria(String criteria_name, String subject_name, String iteration_name, String evaluation_weight,
            String team_evaluation, String criteria_order, String max_loc, String status, String description) {
        String query = "insert into evaluation_criteria (criteria_name, iteration_name, subject_name, evaluation_weight, team_evaluation, criteria_order, max_loc, status, description)\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, criteria_name);
            ps.setString(2, iteration_name);
            ps.setString(3, subject_name);
            ps.setString(4, evaluation_weight);
            ps.setString(5, team_evaluation);
            ps.setString(6, criteria_order);
            ps.setString(7, max_loc);
            ps.setString(8, status);
            ps.setString(9, description);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Criteria> sortCriteriaIDdesc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY criteria_id desc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortCriteriaIDasc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY criteria_id asc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortIterNameasc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY iteration_name asc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortIterNamedesc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY iteration_name desc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortWeightasc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY evaluation_weight asc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortWeightdesc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY evaluation_weight desc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortTeamasc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY team_evaluation asc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortTeamdesc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY team_evaluation desc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortStatusasc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY status asc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortStatusdesc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY status desc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortLocasc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY max_loc asc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Criteria> sortLocdesc(int index) {
        String sql = "select * from evaluation_criteria ORDER BY max_loc desc limit ?, 5;";
        List<Criteria> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Criteria(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // Criteria //
    // Team //
    public List<Team> getAllTeam(int index) {
        String sql = "select * from team ORDER BY team_id limit ?, 5;";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Team getTeamByID(int id) {
        String query = "select * from team where team_id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int getTotalTeam() {
        String query = "select count(*) from team;";
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

    public void changeStatusTeam(int id) throws Exception {

        String sql = " update team set  status =  ? where team_id = ? ";
        int status = 1;
        Team t = new Team();
        t = getTeamByID(id);
        if (t.getStatus() == 0) {
            status = 1;
        } else {
            status = 0;
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

    public List<Team> getTeambyString(String str) throws Exception {
        String sql = "select * from team where  1=1 ";
        List<Team> list = new ArrayList();

        if (!str.isEmpty()) {
            sql = sql + str;
        }
        System.out.println(sql);
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Team> getAllTopic() {
        String sql = "select distinct topic_name from team;";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getString("topic_name")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> searchTeam(String txtSearch, int index) {
        List<Team> list = new ArrayList<>();
        String query = "select * from team where team_id like ? or class_id like ? or team_name like ?"
                + "or class_code like ? or topic_code like ? or topic_name like ?"
                + "ORDER BY team_id limit ?,5 ;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            ps.setString(4, "%" + txtSearch + "%");
            ps.setString(5, "%" + txtSearch + "%");
            ps.setString(6, "%" + txtSearch + "%");
            ps.setInt(7, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getTotalSearchTeam(String txtSearch) {
        String query = "select count(*) from team where team_id like ? or class_id like ?"
                + "or class_code like ? or topic_code like ? or topic_name like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            ps.setString(4, "%" + txtSearch + "%");
            ps.setString(5, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Class> getAllClassCode() {
        String sql = "select class_code from class;";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString("class_code")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void updatetTeam(String class_code, String topic_code, String team_name,
            String topic_name, String gitlab_url, String status, int id) {
        String query = "update team set class_code = ? , topic_code = ? , team_name = ?"
                + ",  topic_name = ?, gitlab_url = ?, status = ? where team_id = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, class_code);
            ps.setString(2, topic_code);
            ps.setString(3, team_name);
            ps.setString(4, topic_name);
            ps.setString(5, gitlab_url);
            ps.setString(6, status);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addTeam(String class_code, String topic_code, String team_name,
            String topic_name, String gitlab_url, String status) {
        String query = "insert into team (team_name, class_code, topic_code, topic_name, gitlab_url, status)\n"
                + "values(?, ?, ?, ?, ?, ?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, team_name);
            ps.setString(2, class_code);
            ps.setString(3, topic_code);
            ps.setString(4, topic_name);
            ps.setString(5, gitlab_url);
            ps.setString(6, status);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Team> sortTeamIDasc(int index) {
        String sql = "select * from team ORDER BY team_id asc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortTeamIDdesc(int index) {
        String sql = "select * from team ORDER BY team_id desc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortClassasc(int index) {
        String sql = "select * from team ORDER BY class_code asc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortClassdesc(int index) {
        String sql = "select * from team ORDER BY class_code desc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortTopicCodeasc(int index) {
        String sql = "select * from team ORDER BY topic_code asc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortTopicCodedesc(int index) {
        String sql = "select * from team ORDER BY topic_code desc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortTopicNameasc(int index) {
        String sql = "select * from team ORDER BY topic_name asc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortTopicNamedesc(int index) {
        String sql = "select * from team ORDER BY topic_name desc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortStatusTeamasc(int index) {
        String sql = "select * from team ORDER BY status asc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> sortStatusTeamdesc(int index) {
        String sql = "select * from team ORDER BY status desc limit ?, 5; ";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    // Team //

    // Class User //
    public List<ClassUser> getAllClassUser() {
        String sql = "select * from class_user";
        List<ClassUser> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
//            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ClassUser(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Team> getAllTeam() {
        String sql = "select * from team";
        List<Team> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
//            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Team(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // Class User //
    public static void main(String[] args) {
        AdminDao dao = new AdminDao();
//
        List<Setting> list = dao.getAllSetting(1);
        for (Setting o : list) {
            System.out.println(o);
        }
//        Iteration d = dao.getIterationByID(1);
//        System.out.println(d);

//        Setting s = new Setting();
//        dao.updatetTeam("SE1602", "bvmt1", "Duck", "Bao ve moi truong", "hehe", "1", 1);
////        System.out.println(s);
    }
}

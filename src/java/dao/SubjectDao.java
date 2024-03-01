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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClassUser;
import model.Subject;

/**
 *
 * @author My PC
 */
public class SubjectDao extends DBContext {

    Connection conn = null;        //ket noi voi sql sever
    PreparedStatement ps = null;   //nem cau lenh query sang sql sever
    ResultSet rs = null;           //nhan ket qua tra ve

    public List<Subject> getAllSubject(int index) {
        String sql = "select subject_id, subject_code, subject_name, full_name, subject.status from spm_database.user join spm_database.subject where user_id = author_id limit ?, 7;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void changeStatus(String id) throws Exception {

        String sql = "update subject set status =  ?  where subject_id = ?;";
        String status = "1";
        Subject sb = new Subject();
        sb = getSubjectByID(id);
        if (sb.getSubject_status().compareTo("1") == 0) {
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

    public Subject getSubjectByID(String id) {
        String query = "select * from subject where  subject_id = ?; ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int getTotalSubject() {
        String query = "select count(*) from subject";
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

    public List<Subject> search(String txtSearch) {
        List<Subject> list = new ArrayList<>();
        String query = "select * from subject where subject_id like ? or subject_code like ? or subject_name like ? ;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setString(2, "%" + txtSearch + "%");
            ps.setString(3, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Subject> getSortSubjectByID(int index) {
        String sql = "select * from subject ORDER BY subject_id limit ?, 7 ;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Subject> getSortSubjectByCode(int index) {
        String sql = "select * from subject ORDER BY subject_code limit ?, 7 ;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Subject> getSortSubjectByName(int index) {
        String sql = "select * from subject ORDER BY subject_name limit ?, 7 ;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Subject> getSortSubjectByStatus1(int index) {
        String sql = "select * from subject where status = 1 ORDER BY subject_id limit ?, 7 ";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Subject> getSortSubjectByStatus0(int index) {
        String sql = "select * from subject where status = 0 ORDER BY subject_id limit ?, 7 ";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void EditClassUser(String Class_id, String team_id, String user_id, String dropout_date, String user_notes, String ongoing_eval, String final_pres_eval, String final_topic_eval, String status, String id) {
        String sql = "update spm_database.class_user set class_id = ? , team_id = ? ,  user_id = ? , dropout_date  = STR_TO_DATE(?, '%d-%m-%Y'),user_notes = ?,ongoing_eval=? , final_pres_eval=? , final_topic_eval=?, status =? where class_user_id = ?;";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, Class_id);

            ps.setString(2, team_id);
            ps.setString(3, user_id);
//            ps.setString(4, avatar);
            ps.setString(4, dropout_date);
            ps.setString(5, user_notes);
            ps.setString(6, ongoing_eval);
            ps.setString(7, final_pres_eval);
            ps.setString(8, final_topic_eval);
            ps.setString(9, status);
            ps.setString(10, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ClassUser getClassUserByID(String id) {
        String query = "select * from class_user where  class_user_id = ?; ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ClassUser(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<ClassUser> searchClassUser(String txtSearch) {
        List<ClassUser> list = new ArrayList<>();
        String query = "select * from class_user where dropout_date like ? or class_id like ? or team_id like ? or user_id like ? or user_notes like ? or ongoing_eval like ? or final_pres_eval like ? or final_topic_eval like ? ;";
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
//            ps.setString(9, "%" + txtSearch + "%");
//            ps.setInt(7, (index - 1) * 5);

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

    public void changeStatusClassUser(String id) throws Exception {

        String sql = "update class_user set status =  ?  where class_user_id = ?;";
        String status = "1";
        ClassUser sb = new ClassUser();
        sb = getClassUserByID(id);
        if (sb.getStatus().compareTo("1") == 0) {
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

    public List<ClassUser> ClassUserStatus1() {
        String sql = "select * from class_user where status = 1  ";
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

    public List<ClassUser> ClassUserStatus0() {
        String sql = "select * from class_user where status = 0  ";
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

    public void EditSubject(String code, String name, String author, String status, String id) throws Exception {
        String sql = "update spm_database.subject set subject_code = ?, subject_name = ?, author_id = ?,  status = ? where subject_id = ? ;";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            //............
            st.setString(1, code);
            st.setString(2, name);
            st.setString(3, author);
            st.setString(4, status);
            st.setString(5, id);
            ///...................
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Subject> getSortSubjectByAuthor(int index, String author) {
        String sql = "select subject_id, subject_code, subject_name, full_name, subject.status from spm_database.user join spm_database.subject where user_id = author_id and author_id like ? order by subject_id limit ?, 7 ;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, author);
            ps.setInt(2, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Subject> getSortSubjectByIDASC(int index) {
        String sql = "select subject_id, subject_code, subject_name, full_name, subject.status from spm_database.user join spm_database.subject where user_id = author_id ORDER BY subject_id limit ?, 7 ;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Subject> getSortSubjectByIDDESC(int index) {
        String sql = "select subject_id, subject_code, subject_name, full_name, subject.status from spm_database.user join spm_database.subject where user_id = author_id ORDER BY subject_id desc limit ?, 7 ;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 7);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void AddSubject(Subject p) throws Exception {
        String sql = "insert into subject(subject_code, subject_name, author_id, status) values(?, ?, ?, ?);";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, p.getSubject_code());
            st.setString(2, p.getSubject_name());
            st.setString(3, p.getSubject_author());
            st.setString(4, p.getSubject_status());
            ///...................
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<Subject> getAllSubject() {
        String sql = "select * from spm_database.subject ;";
        List<Subject> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {

        SubjectDao dao = new SubjectDao();
        List<Subject> list = dao.getAllSubject(1);
        for (Subject o : list) {
            System.out.println(o);
        }

    }
}

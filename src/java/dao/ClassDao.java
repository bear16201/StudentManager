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
import java.util.ArrayList;
import java.util.List;
import model.Class;

/**
 *
 * @author ASUS
 */
public class ClassDao extends DBContext {

    Connection conn = null;        //ket noi voi sql sever
    PreparedStatement ps = null;   //nem cau lenh query sang sql sever
    ResultSet rs = null;           //nhan ket qua tra ve

    public List<Class> getAllListClass(int index) {
        String sql = "select * from spm_database.class ORDER BY spm_database.class.class_id limit ?, 5 ;";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Class> getAllListClass() {
        String sql = "select * from spm_database.class";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void changeStatus(String id) {
        String sql = " update spm_database.class set spm_database.class.status = ? "
                + "where spm_database.class.class_id = ?; ";
        String status;
        Class clas = getClassByID(id);
        if (clas.getStatus().compareTo("1") == 0) {
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

    public Class getClassByID(String id) {
        String query = "select * from spm_database.class where spm_database.class.class_id = ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

//    public List<Class> getListClassByID(String id) {
//        String query = "select * from spm_database.class where spm_database.class.class_id = ?;";
//        List<Class> list = new ArrayList<>();
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, id);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                 list.add( new Class(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8)));
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return list;
//    }
    public int getTotalClass() {
        String query = "select count(*) from spm_database.class;";
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

    public List<Class> search(String txtSearch) {
        List<Class> list = new ArrayList<>();
        String query = "select * from spm_database.class "
                + "where spm_database.class.class_id like ? or spm_database.class.class_code like ? "
                + "or spm_database.class.class_year like ? or spm_database.class.subject_id like ?"
                + " or spm_database.class.trainer_id like ? ;";
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
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    public List<Class> getSortClassByID(int index) {

        String sql = "select * from spm_database.class ORDER BY spm_database.class.class_id limit ?, 7 ;";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Class> getSortClassByCode(int index) {
        String sql = "select * from spm_database.class ORDER BY spm_database.class.class_code limit ?, 7 ;";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Class> getSortClassByName(int index) {
        String sql = "select * from spm_database.class ORDER BY spm_database.class.subject_id limit ?, 7 ;";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Class> getSortClassBySubID(String SubID) {
        String sql = "select * from spm_database.class where spm_database.class.subject_id = ? ";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, SubID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public List<Class> getSortClassByYear(String Year) {
        String sql = "select * from spm_database.class where spm_database.class.class_year = ? ";
               
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, Year);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Class> getSortClassByBlock1(int index) {
        String sql = "select * from spm_database.class where spm_database.class.block5_class = 1 "
                + "ORDER BY spm_database.class.class_id limit ?, 7 ";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Class> getSortClassByBlock0(int index) {
        String sql = "select * from spm_database.class where spm_database.class.block5_class = 0 "
                + "ORDER BY spm_database.class.class_id limit ?, 7 ";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Class> getSortClassByStatus1(int index) {
        String sql = "select * from spm_database.class where spm_database.class.status = 1 "
                + "ORDER BY spm_database.class.class_id limit ?, 7 ";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Class> getSortClassByStatus0(int index) {
        String sql = "select * from spm_database.class where spm_database.class.status = 0 "
                + "ORDER BY spm_database.class.class_id limit ?, 7 ";
        List<Class> list = new ArrayList();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Class(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void addClass(String class_code, String trainer_id, String subject_id, String class_year, String class_term, String block5_class, String status) {
        String query = " INSERT INTO `spm_database`.`class`\n"
                + "(`class_code`,\n"
                + "`trainer_id`,\n"
                + "`subject_id`,\n"
                + "`class_year`,\n"
                + "`class_term`,\n"
                + "`block5_class`,\n"
                + "`status`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, class_code);
            ps.setString(2, trainer_id);
            ps.setString(3, subject_id);
            ps.setString(4, class_year);
            ps.setString(5, class_term);
            ps.setString(6, block5_class);
            ps.setString(7, status);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void updatetClass(String classId, String class_code, String trainer_id, String subject_id,
            String class_year, String class_term, String block5_class, String status) {
        String query = "update spm_database.class set \n"
                + "class_code = ?, trainer_id = ?, subject_id = ?, "
                + "class_year = ?, class_term = ? ,"
                + "block5_class = ? , status = ?\n"
                + "where class_id = ?;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, class_code);
            ps.setString(2, trainer_id);
            ps.setString(3, subject_id);
            ps.setString(4, class_year);
            ps.setString(5, class_term);
            ps.setString(6, block5_class);
            ps.setString(7, status);
            ps.setString(8, classId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        ClassDao dao = new ClassDao();
//        dao.addClass("a", "HE150003", "MAD219", "a", "A", "1", "0");
//        List<Class> classNew = dao.getListClassByID("1");
//        List<Class> classNew = dao.getSortClassBySubID("SWP301");
////        classNew.isEmpty()
//        for (Class class1 : classNew) {
//            System.out.println(class1);
//        }
    }

}

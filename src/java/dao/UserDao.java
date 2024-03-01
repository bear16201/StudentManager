/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import comon.ConnectDB;
import comon.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ASUS
 */
public class UserDao extends DBContext {

    public void EditUser(String FullName, String date, String mobile, String linkFB, String address, String email) {

        String sql = "update spm_database.user set full_name = ? , date_of_birth = ? ,  mobile = ? , facebook_link = ?,address = ?   where email = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, FullName);

            ps.setString(2, date);
            ps.setString(3, mobile);
//            ps.setString(4, avatar);
            ps.setString(4, linkFB);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void EditAvater(String avatar, String email) {

        String sql = "update spm_database.user set avatar_link = ?   where email = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, avatar);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public User getCheck(String username,
            String password) {
        String sql = "Select * from spm_database.user where email='" + username + "' and password ='" + password + "'";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String Users = rs.getString(1); //(1,1)
                int roll = rs.getInt(2);
                String FullName = rs.getString(3);
                Boolean gender = rs.getBoolean(4);
                String date = rs.getString(5);
                String Email = rs.getString(6);
                int Mobile = rs.getInt(7);
                String Avatar = rs.getString(8);
                String LinkFB = rs.getString(9);
                int RollId = rs.getInt(10);
                String Status = rs.getString(11);
                String Password = rs.getString(12);

                User user = new User(Users, roll,
                        FullName, true, date, Email, Mobile, Avatar,
                        LinkFB, RollId, Status, Password);
                return user;

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<User> UserList() {
        String sql = "Select * from spm_database.user";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String Users = rs.getString(1); //(1,1)
                int roll = rs.getInt(2);
                String FullName = rs.getString(3);
                Boolean gender = rs.getBoolean(4);
                String date = rs.getString(5);
                String Email = rs.getString(6);
                int Mobile = rs.getInt(7);
                String Avatar = rs.getString(8);
                String LinkFB = rs.getString(9);
                int RollId = rs.getInt(10);
                String Status = rs.getString(11);
                String Password = rs.getString(12);

                User user = new User(Users, roll,
                        FullName, true, date, Email, Mobile, Avatar,
                        LinkFB, RollId, Status, Password);
                list.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public String checkUserID() {
        UserDao dao = new UserDao();
        List<User> list = dao.UserList();

        User user = new User();
        String userID = "HE150001";
        if (list == null) {
            return userID;
        } else {
            for (User users : list) {
                user = users;
            }
            String lastUserID = user.getUserID();
            for (int i = lastUserID.length() - 1; i >= 0; --i) {
                int max = 57;
                int count = 1;
                if ((lastUserID.charAt(i) + 0) == max) {
                    String newID = lastUserID.substring(0, i - count);

                    if (i == 7) {
                        if ((lastUserID.charAt(i - count) + 0) == max) {
                            count++;
                            if ((lastUserID.charAt(i - count) + 0) == max) {
                                count++;
                                newID = lastUserID.substring(0, i - count);
                                String checkID = String.valueOf((char) (lastUserID.charAt(i - count) + 1));
                                String checkIDnew = checkID + "000";
                                newID = newID.concat(checkIDnew);
                                user.setUserID(newID);
                                break;
                            }
                            newID = lastUserID.substring(0, i - count);
                            String checkID = String.valueOf((char) (lastUserID.charAt(i - count) + 1));
                            String checkIDnew = checkID + "00";
                            newID = newID.concat(checkIDnew);
                            user.setUserID(newID);

                            break;
                        }
                        String checkID = String.valueOf((char) (lastUserID.charAt(i - count) + 1));
                        String checkIDnew = checkID + "0";
                        newID = newID.concat(checkIDnew);
                        user.setUserID(newID);

                    }
                    break;
                } else {
                    String newID = lastUserID.substring(0, i);
                    String checkID = String.valueOf((char) (lastUserID.charAt(i) + 1));
                    newID = newID.concat(checkID);
                    user.setUserID(newID);
                    break;

                }

            }
            return user.getUserID();
        }

    }

    public int checkRoll() {
        UserDao dao = new UserDao();
        List<User> list = dao.UserList();

        int roll = 1;
        if (list == null) {
            return roll;
        }
        for (User u : list) {
//            System.out.println(u);
            roll++;
        }

        return roll;
    }

    public int addUsers(User users) {
        int n = 0;
        String sql = "INSERT INTO `spm_database`.`user`\n"
                + "(`user_id`,\n"
                + "`roll_number`,\n"
                + "`full_name`,\n"
                + "`gender`,\n"
                + "`email`,\n"
                + "`mobile`,\n"
                + "`role_id`,\n"
                + "`password`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            st.setString(1, users.getUserID());
            st.setInt(2, users.getRoll());
            st.setString(3, users.getFullName());
            st.setBoolean(4, users.isGender());
            st.setString(5, users.getEmail());
            st.setInt(6, users.getMobile());
            st.setInt(7, users.getRollId());
            st.setString(8, users.getPassword());

            n = st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public User getUserByUsername(String username) {
        String sql = "Select * from spm_database.user where email='" + username + "' ";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String Users = rs.getString(1); //(1,1)
                int roll = rs.getInt(2);
                String FullName = rs.getString(3);
                String gender = rs.getString(4);
                String date = rs.getString(5);
                String Email = rs.getString(6);
                int Mobile = rs.getInt(7);
                String Avatar = rs.getString(8);
                String LinkFB = rs.getString(9);
                int RollId = rs.getInt(10);
                String Status = rs.getString(11);
                String Password = rs.getString(12);
                String address = rs.getString(13);

                User user = new User(Users, roll,
                        FullName, true, date, Email, Mobile, Avatar,
                        LinkFB, RollId, Status, Password, address);
                return user;

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public User checkMail(String email) {
        UserDao dao = new UserDao();
        List list = dao.UserList();
        String sql = "Select * from spm_database.user where email='" + email + "'";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String Users = rs.getString(1); //(1,1)
                int roll = rs.getInt(2);
                String FullName = rs.getString(3);
                Boolean gender = rs.getBoolean(4);
                String date = rs.getString(5);
                email = rs.getString(6);
                int Mobile = rs.getInt(7);
                String Avatar = rs.getString(8);
                String LinkFB = rs.getString(9);
                int RollId = rs.getInt(10);
                String Status = rs.getString(11);
                String Password = rs.getString(12);

                User user = new User(Users, roll,
                        FullName, true, date, email, Mobile, Avatar,
                        LinkFB, RollId, Status, Password);
                return user;

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String checkUserByID(String userID) {
        String sql = "Select * from spm_database.user where user_id='" + userID + "'";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String Users = rs.getString(1); //(1,1)
                int roll = rs.getInt(2);
                String FullName = rs.getString(3);
                Boolean gender = rs.getBoolean(4);
                String date = rs.getString(5);
                String Email = rs.getString(6);
                int Mobile = rs.getInt(7);
                String Avatar = rs.getString(8);
                String LinkFB = rs.getString(9);
                int RollId = rs.getInt(10);
                String Status = rs.getString(11);
                String Password = rs.getString(12);

                User user = new User(Users, roll,
                        FullName, true, date, Email, Mobile, Avatar,
                        LinkFB, RollId, Status, Password);
                return user.getPassword();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String checkUserID(String email) {
        String sql = "Select * from spm_database.user where email='" + email + "'";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String Users = rs.getString(1); //(1,1)
                int roll = rs.getInt(2);
                String FullName = rs.getString(3);
                Boolean gender = rs.getBoolean(4);
                String date = rs.getString(5);
                String Email = rs.getString(6);
                int Mobile = rs.getInt(7);
                String Avatar = rs.getString(8);
                String LinkFB = rs.getString(9);
                int RollId = rs.getInt(10);
                String Status = rs.getString(11);
                String Password = rs.getString(12);

                User user = new User(Users, roll,
                        FullName, true, date, Email, Mobile, Avatar,
                        LinkFB, RollId, Status, Password);
                return user.getUserID();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String randomString(int len) {
        String passwordCheck = null;
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
//        int len = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        passwordCheck = generatedString.toUpperCase();
        return passwordCheck;
    }

    public void UpdatePassword(String passwordCheck, String UserID) {
        String sql = "UPDATE `spm_database`.`user`\n"
                + "SET\n"
                + "`password` = ?\n"
                + "WHERE `user_id` = ?";
        try {

            PreparedStatement pre = getConnection().prepareStatement(sql);
            pre.setString(1, passwordCheck);
            pre.setString(2, UserID);
            pre.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<User> getAllUser() {
        String sql = "select * from user  ";
        List<User> list = new ArrayList();
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString("user_id"), rs.getInt("roll_number"), rs.getString("full_name"), rs.getBoolean("gender"),
                        rs.getString("date_of_birth"), rs.getString("email"), rs.getInt("mobile"), rs.getString("avatar_link"), rs.getString("facebook_link"), rs.getInt("role_id"),
                        rs.getString("status"), rs.getString("password"), rs.getString("address")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //System.out.println(list);
        return list;
    }
    //1.2 Search 

    public List<User> getUserbyString(int role, String status, String str) throws Exception {
        String sql = "select * from User where  1=1 ";
        List<User> list = new ArrayList();
        if (role != 0) {
            sql = sql + " and roll_number=" + role + " ";
        }
        if (!status.isEmpty()) {
            sql = sql + " and status=" + status + " ";
        }
        if (!str.isEmpty()) {
            sql = sql + " and ( full_name = " + str + "or" + "mobile = " + str + "or" + "email = " + str + " )";
        }
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString("user_id"), rs.getInt("roll_number"), rs.getString("full_name"), rs.getBoolean("gender"),
                        rs.getString("date_of_birth"), rs.getString("email"), rs.getInt("mobile"), rs.getString("avatar_link"), rs.getString("facebook_link"), rs.getInt("role_id"),
                        rs.getString("status"), rs.getString("password"), rs.getString("address")));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    //1.3 Change Status user
    public void changeStatus(String id) throws Exception {

        String sql = " update User set  status =  ?   where user_id = ? ";
        String status = "1";
        User user = new User();
        user = GetUserbyID(id);
        if (user.getStatus().compareTo("1") == 0) {
            status = "0";
        } else {
            status = "1";
        }
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            //............
            st.setString(1, status);
            st.setString(2, id);
            ///...................
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //2--User Detail DAO
    //2.1 Adđ User 
    public void insert(User p) throws Exception {
        String sql = "insert into user(user_id, roll_number, full_name, gender, date_of_birth, email,mobile,  avatar_link, facebook_link, role_id, status,password, address)\n"
                + "values(?,?,?,?,?,?,?);";

        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            //............

            st.setString(1, p.getUserID());
            st.setInt(2, p.getRoll());
            st.setString(3, p.getFullName());
            st.setBoolean(4, p.isGender());
            st.setString(5, p.getDate());
            st.setString(6, p.getEmail());
            st.setInt(7, p.getMobile());
            st.setString(8, p.getAvatar());
            st.setString(9, p.getLinkFB());
            st.setInt(10, p.getRollId());
            st.setString(11, p.getStatus());
            st.setString(12, p.getPassword());
            st.setString(13, p.getAddress());

            ///...................
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //2.2 Update User 
    public void update(User p) throws Exception {

        String sql = "update User set "
                + "user_id = ? , roll_number = ?, full_name = ?,gender = ? ,date_of_birth = ? , email = ?,"
                + " mobile = ? ,  avatar_link = ? , facebook_link = ? , role_id = ? , status = ? ,password = ? , address = ? "
                + " where user_id = ?";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);

            st.setString(1, p.getUserID());
            st.setInt(2, p.getRoll());
            st.setString(3, p.getFullName());
            st.setBoolean(4, p.isGender());
            st.setString(5, p.getDate());
            st.setString(6, p.getEmail());
            st.setInt(7, p.getMobile());
            st.setString(8, p.getAvatar());
            st.setString(9, p.getLinkFB());
            st.setInt(10, p.getRollId());
            st.setString(11, p.getStatus());
            st.setString(12, p.getPassword());
            st.setString(13, p.getAddress());
            st.setString(14, p.getUserID());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //2.3 Get User by ID

    public User GetUserbyID(String str) throws Exception {
        String sql = "select * from User where  user_id = ?  ";
        try {
            PreparedStatement st = getConnection().prepareStatement(sql);
            st.setString(1, str);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("user_id"), rs.getInt("roll_number"), rs.getString("full_name"), rs.getBoolean("gender"),
                        rs.getString("date_of_birth"), rs.getString("email"), rs.getInt("mobile"), rs.getString("avatar_link"), rs.getString("facebook_link"), rs.getInt("role_id"),
                        rs.getString("status"), rs.getString("password"), rs.getString("address"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void updatePass(String newPass, String email, String oldPass) {

        String sql = "update spm_database.user set password = ? where email = ? and  password = ?";
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, newPass);
            ps.setString(2, email);
            ps.setString(3, oldPass);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    

    public static void main(String[] args) {
        UserDao dao = new UserDao();
//        User n = dao.getUserByUsername("thaidoan911@gmail.com");
        User n = dao.getCheck("phuc@gmail.com", "phuc166");
        if (n != null) {
            System.out.println(n);
            System.out.println("connect");
        } else {
            System.out.println("none");
        }
//        List<Users> list = dao.UserList();
//        for (Users u : list) {
//            System.out.println(u);
//        }
//        int n = dao.checkUserID();
//        Users user = new Users(3, 3, "Tuan anh", true, "tuannna", 0212312, "123456");
//        int n = dao.addUsers(user);
//        if (n < 0) {
//            System.out.println("connect");
//        }
    }

}

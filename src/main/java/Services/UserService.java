package Services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.UserDao;
import Model.User;

public class UserService implements UserDao{

    private static Connection connection = null;


    @Override
    public int addUser(User user) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int updateUser(User user) {
        int res = 0;
        PreparedStatement pstmt = null;
        Connection connection = null;
        try {

            //create sql to get selected user
            String sql = "Update user set username=?,password=? where id=?";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            //set parameters
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getId());
            // execute statement
            res = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return res;
    }
    @Override
    public int deleteUser(int userId) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public User getUserById(int id) {
        User u = null;
        PreparedStatement pstmt = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            //create sql to get selected user
            String sql = "Select * from user where id=?";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            //set params
            pstmt.setInt(1, id);
            // execute statement
            rs = pstmt.executeQuery();

            if(rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getString("type"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return u;

    }
    @Override
    public User getUserByUserNameAndPassword(String username, String password) {
        User u = null;
        PreparedStatement pstmt = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            //create sql to get selected user
            String sql = "Select * from user where username=? and password=?";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            //set params
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            // execute statement
            rs = pstmt.executeQuery();

            if(rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getString("type"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return u;
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        User u = null;
        PreparedStatement pstmt = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            //create sql to get selected user
            String sql = "Select * from user";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            // execute statement
            rs = pstmt.executeQuery();

            while(rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setType(rs.getString("type"));

                users.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return users;
    }

}

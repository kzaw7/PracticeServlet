package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Reimbursement;
import Dao.ReimbursementDao;
import Model.User;

public class ReimbursementService implements ReimbursementDao{
    @Override
    public int addReimbursement(Reimbursement rb) {
        int res = 0;
        PreparedStatement pstmt = null;
        Connection connection = null;
        try {
            //create sql to get selected user
            String sql =  "Insert into reimbursement(title,description,status,submittedAt,resolvedAt,userId) Values(?,?,?,?,?,?)";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            //set parameters
            pstmt.setString(1, rb.getTitle());
            pstmt.setString(2, rb.getDescription());
            pstmt.setString(3, "pending");
            pstmt.setTimestamp(4, rb.getSubmitted());
            pstmt.setTimestamp(5, rb.getSubmitted());
            pstmt.setInt(6, rb.getUser().getId());
            // execute statement
            res = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return res;
    }
    @Override
    public int resolveReimbursement(Reimbursement reimbursement) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Reimbursement getReimbursementByName(String title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reimbursement getReimbursementByAuthorId(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<Reimbursement> getAllPendingReimbursements() {
        List<Reimbursement> rbs = new ArrayList<>();
        Reimbursement rb = null;
        PreparedStatement pstmt = null;
        Connection connection = null;
        ResultSet rs = null;
        User u = null;
        try {
            //create sql to get selected user
            String sql = "Select * from reimbursement where status='pending'";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            // execute statement
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rb = new Reimbursement();
                rb.setId(rs.getInt("id"));
                rb.setTitle(rs.getString("title"));
                rb.setDescription(rs.getString("description"));
                rb.setSubmitted(rs.getTimestamp("submittedAt"));
                rb.setStatus(rs.getString("status"));
                u = new User();
                u.setId(rs.getInt("userId"));
                rb.setUser(u);

                rbs.add(rb);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return rbs;
    }

    @Override
    public List<Reimbursement> getAllResolvedReimbursements() {
        List<Reimbursement> rbs = new ArrayList<>();
        User u = null;
        PreparedStatement pstmt = null;
        Connection connection = null;
        ResultSet rs = null;
        Reimbursement rb = null;
        try {
            //create sql to get selected user
            String sql = "Select * from reimbursement where status='resolved'";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            // execute statement
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rb = new Reimbursement();
                rb.setId(rs.getInt("id"));
                rb.setTitle(rs.getString("title"));
                rb.setDescription(rs.getString("description"));
                rb.setResolvedBy(rs.getString("resolvedBy"));
                rb.setSubmitted(rs.getTimestamp("submittedAt"));
                rb.setResolved(rs.getTimestamp("resolvedAt"));
                rb.setStatus(rs.getString("status"));

                u = new User();
                u.setId(rs.getInt("userId"));

                rb.setUser(u);

                rbs.add(rb);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return rbs;
    }

    @Override
    public List<Reimbursement> getAllPendingReimbursementByAuthor(int id) {
        List<Reimbursement> rbs = new ArrayList<>();
        User u = null;
        PreparedStatement pstmt = null;
        Connection connection = null;
        ResultSet rs = null;
        Reimbursement rb = null;
        try {
            //create sql to get selected user
            String sql = "Select * from reimbursement where userId=? and status='pending'";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rb = new Reimbursement();
                rb.setId(rs.getInt("id"));
                rb.setTitle(rs.getString("title"));
                rb.setDescription(rs.getString("description"));
                rb.setSubmitted(rs.getTimestamp("submittedAt"));
                rb.setStatus(rs.getString("status"));

                u = new User();
                u.setId(rs.getInt("userId"));

                rb.setUser(u);

                rbs.add(rb);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return rbs;
    }

    @Override
    public List<Reimbursement> getAllResolvedReimbursementByAuthor(int id) {
        List<Reimbursement> rbs = new ArrayList<>();
        User u = null;
        PreparedStatement pstmt = null;
        Connection connection = null;
        Reimbursement rb = null;
        ResultSet rs = null;
        try {
            //create sql to get selected user
            String sql = "Select * from reimbursement where userId=? and status='resolved'";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            //set params
            pstmt.setInt(1, id);
            // execute statement
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rb = new Reimbursement();
                rb.setId(rs.getInt("id"));
                rb.setTitle(rs.getString("title"));
                rb.setDescription(rs.getString("description"));
                rb.setResolvedBy(rs.getString("resolvedBy"));
                rb.setSubmitted(rs.getTimestamp("submittedAt"));
                rb.setResolved(rs.getTimestamp("resolvedAt"));
                rb.setStatus(rs.getString("status"));

                u = new User();
                u.setId(rs.getInt("userId"));

                rb.setUser(u);

                rbs.add(rb);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return rbs;
    }

    @Override
    public List<Reimbursement> getAllReimbursementsByAuthorId(int id) {
        List<Reimbursement> rbs = new ArrayList<>();
        User u = null;
        PreparedStatement pstmt = null;
        Connection connection = null;
        Reimbursement rb = null;
        ResultSet rs = null;
        try {
            //create sql to get selected user
            String sql = "Select * from reimbursement where userId=?";
            // create prepared statement
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                rb = new Reimbursement();
                rb.setId(rs.getInt("id"));
                rb.setTitle(rs.getString("title"));
                rb.setDescription(rs.getString("description"));
                rb.setResolvedBy(rs.getString("resolvedBy"));
                rb.setSubmitted(rs.getTimestamp("submittedAt"));
                rb.setResolved(rs.getTimestamp("resolvedAt"));
                rb.setStatus(rs.getString("status"));

                u = new User();
                u.setId(rs.getInt("userId"));

                rb.setUser(u);

                rbs.add(rb);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return rbs;
    }

}

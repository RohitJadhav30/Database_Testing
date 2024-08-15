package org.dbCrud;

import org.connection.BaseClass;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crude_Operation extends BaseClass {

    @Test
    public void createQuery() throws SQLException {
        con = this.setUp();

        String createQuery = "create table users (userId int primary key auto_increment, userName varchar(50), email varchar(50) not null)";

        try{
            PreparedStatement st = con.prepareStatement(createQuery);
            st.execute();
        }
        catch (SQLException e) {
            System.out.println("Error in the Syntax");
            e.printStackTrace();
        }
        finally {
            if(con != null){
                con.close();
            }
        }
    }

    @Test
    public void insertQuery() throws SQLException {
        con = this.setUp();

        String inserQuery = "insert into users(userName, email) values(?, ?)";

        try{
            PreparedStatement ps = con.prepareStatement(inserQuery);
            ps.setString(1, "Rohit Jadhav");
            ps.setString(2, "jadhavrohit3004@gmail.com");
            ps.addBatch();

            ps.setString(1, "Harshal Goterne");
            ps.setString(2, "harshalgoterne@gmail.com");
            ps.addBatch();

            ps.setString(1, "Nitish Prajapati");
            ps.setString(2, "nitish@gmail.com");
            ps.addBatch();

            ps.setString(1, "Akash Chaudhary");
            ps.setString(2, "akash@gmail.com");
            ps.addBatch();

            ps.setString(1, "Vaibhav Thete");
            ps.setString(2, "vaibhavthete21@gmail.com");
            ps.addBatch();

            int[] affectedRow = ps.executeBatch();
            System.out.println("Inserted rows " + affectedRow.length);
        }
        catch (SQLException e){
            System.out.println("Error in the insert query");
            e.printStackTrace();
        }
        finally {
            if (con != null)
                con.close();;
        }
    }

    @Test
    public void selectQuery() throws SQLException {
        con = this.setUp();

        try {

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("Select * from users");
            while (rs.next()) {
                String userId = rs.getString(1);
                String userName = rs.getString(2);
                System.out.println(userId + " " + userName);
            }
        }catch (SQLException e){
            System.out.println("Error in the select query");
            e.printStackTrace();
        }
        finally {
            if(con != null)
                con.close();
        }
    }

    @Test
    public void deleteQuery() throws SQLException {
        con = this.setUp();

        String deleteQuery = "delete from users where userId = 2";

        try {
            PreparedStatement st = con.prepareStatement(deleteQuery);
            st.execute();
        }
        catch (SQLException e) {
            System.out.println("Error in the Syntax");
            e.printStackTrace();
        }
        finally {
            if(con != null)
                con.close();
        }
    }

    @Test
    public void updateQuery() throws SQLException {
        con = this.setUp();

        String updateQuery = "update users set userName = 'Aku Chaudhary' where userId= 4";

        try {
            PreparedStatement st = con.prepareStatement(updateQuery);
            st.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Error in the syntax");
            e.printStackTrace();
        }
        finally {
            if(con != null)
                con.close();
        }
    }
}

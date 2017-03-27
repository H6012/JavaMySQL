import java.sql.*;

/**
 * A Java MySQL SELECT statement example.
 * Demonstrates the use of a SQL SELECT statement against a
 * MySQL database, called from a Java program.
 * 
 */
public class JavaMysqlSelectExample
{

  public static void main(String[] args)
  {
    try
    {
      // create our mysql database connection
      String myDriver = "com.mysql.jdbc.Driver"; 
      String myUrl = "jdbc:mysql://localhost:3306/miotdb?useSSL=false";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "miotuser", "M!otPass1");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM itbcontacts";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        int id = rs.getInt("id");
        String firstName = rs.getString("fname");
        String lastName = rs.getString("lname");
		String email = rs.getString("email");
      
        int staffid = rs.getInt("id");
        
        // print the results
        System.out.format("%s, %s, %s, %s, %s\n", id, firstName, lastName, email, staffid);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}
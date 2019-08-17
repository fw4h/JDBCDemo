import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","19921104Mysql");
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			
			statement.executeUpdate(sql);
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(columnIndex));
			}
			
			connection.commit();
		} catch (Exception e) {

			e.printStackTrace();
			connection.rollback();
		}finally {
			connection.close();
		}
		

	}

}

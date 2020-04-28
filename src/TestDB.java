import java.sql.*;

public class TestDB {
    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-P9CVGRS\\SQLEXPRESS01:1433;databaseName=quanly";// your db name
            String user="sac"; // your db username
            String password="chutiendat"; // your db password
//            String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
//                    "databaseName=Tutorial;username=sa;password=123;";
            Connection conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Connect success!");
            }

            String sql = "select * from dbo.Customer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            showResutl(resultSet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showResutl(ResultSet resultSet) throws SQLException {

        Person p;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String Name = resultSet.getString("name");
            //var address = resultSet.getString("Adress");
            String email = resultSet.getString("email");
            //var dob = resultSet.getDate("DOB");
            String gender = resultSet.getString("gender");
            String phoneNumnber = resultSet.getString("phone");
            p = new Person(id,Name,gender,phoneNumnber,email);
            p.toString();
            System.out.println(p.toString());
        }

    }
}

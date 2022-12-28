package database;

import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    public static void main(String[] args) throws SQLException {

        Statement statement = MySQLClient.connection.createStatement();

        //create
        statement.execute("INSERT INTO user(first_name, last_name, email, password, birthday) "
            + "VALUES ('Petr', 'Petrov', 'abs@gmail.com', 'asasdadada', '2002-03-15')");

        //read
        statement.executeQuery("SELECT * FROM user");

        //update
        statement.executeUpdate("UPDATE user SET first_name='Vasiliy' WHERE last_name='Petrov'");

        //delete
        statement.execute("DELETE FROM user WHERE email='abs@gmail.com'");
    }
}
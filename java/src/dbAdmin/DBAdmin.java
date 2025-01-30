package dbAdmin;

import dbAdmin.DBConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Date;
import java.util.ArrayList;

public class DBAdmin {

    public void iud(String sql) {
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName(DBConfig.DRIVER);

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
	}
}

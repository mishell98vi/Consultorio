
package consultorio.accesoadatos;
import java.sql.*;
import java.util.*;
public class Conexion {
    Scanner entrada = new Scanner(System.in);
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://172.30.3.77:1433;databaseName=Tratamiento";
    String usr = "mishell";
    String pass = "123";
    Connection con = null;
    public void conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usr, pass);
            System.out.println("Conexion Establecida!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en con: " + e.getMessage());
        }
    }
    public ResultSet ejecutarQuery(String sql, ArrayList<Parametro> listaParametros) {
        ResultSet resultado = null;
        try {
            PreparedStatement std = con.prepareStatement(sql);
            if (listaParametros != null) {
                for (Parametro val : listaParametros) {
                    
                    if (val.getValor() instanceof java.util.Date) {
                        std.setObject(val.getPosicion(), new java.sql.Date(((java.util.Date) val.getValor()).getTime()));
                    } else {
                        std.setObject(val.getPosicion(), val.getValor());
                    }
                }
            }
            resultado = std.executeQuery();
        }catch (SQLException e) {
            System.out.println("Error en Ejecucion SQL: " + e.getMessage());
        }
        return resultado;
    }
    public int ejecutarComando(String sql, ArrayList<Parametro> lisPar) {
        int nFilasAfectadas=0;
        ResultSet resultado = null;
        try {
            PreparedStatement std = con.prepareStatement(sql);
            if (lisPar != null) {
                for (Parametro val : lisPar) {
                    if (val.getValor() instanceof java.util.Date) {
                        std.setObject(val.getPosicion(), new java.sql.Date(((java.util.Date) val.getValor()).getTime()));
                    } else {
                        std.setObject(val.getPosicion(), val.getValor());
                    }
                }
            }
            nFilasAfectadas=std.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Ejecucion SQL: " + e.getMessage());
        }
        return nFilasAfectadas;
    }
    public void desconectar() {
        try {
            if (con != null) {
                if (!con.isClosed()) {
                    con.close();
                    System.out.println("Conexion Cerrada");
                }
            }
        } catch (Exception e) {
            System.out.println("Error de descon: " + e.getMessage());
        }
    }
}

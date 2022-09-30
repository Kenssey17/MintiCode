package org.mintic.modelo;


import java.sql.*;

public class ConexionBd {


    private static final String url="jdbc:mysql://localhost:3306/solicitudes";
    private static final String user = "root";
    private static final String password = "Kenssey17";

    private static Connection conx = null;
    private static PreparedStatement ps = null;
    private static ResultSet resultado;

    public static Connection conectar() {
        Connection conx = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conx = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        return conx;
    }

    public static void main (String[] args){
        try {
            conx = conectar();
            String consulta = "INSERT INTO usuarios (id_usuario, nombre_usuario, apellido_usuario, email_usuario, password_usuario, telefono_usuario, direccion_usuario, cod_rol) VALUES ('1010198','Leandro','Calderon','bra123@mintic.com','br123','31029274','calle 3a','3')";
            ps = conx.prepareStatement(consulta);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("se guardaron los datos");
            } else {
                System.out.println("no se guardaron los datos");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }


    }

}


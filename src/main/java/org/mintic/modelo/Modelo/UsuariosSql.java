package org.mintic.modelo.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UsuariosSql extends ConexionBd {

    public boolean registrar(Usuarios usr) {
        PreparedStatement ps = null;
        Connection cx = conectar();

        boolean registro = false;

        String sql = "INSERT INTO usuarios (id_usuario, nombre_usuario, apellido_usuario, email_usuario, password_usuario, telefono_usuario, direccion_usuario, cod_rol) VALUES (?,?,?,?,?,?,?,?)";
        try {
            ps = cx.prepareStatement(sql);
            ps.setInt(1, usr.getIdUsuario());
            ps.setString(2, usr.getNombre());
            ps.setString(3, usr.getApellido());
            ps.setString(4, usr.getEmail());
            ps.setString(5, usr.getPassword());
            ps.setInt(6, usr.getTelefono());
            ps.setString(7, usr.getDireccion());
            ps.setInt(8, usr.getRol());

            int resultaingreso = ps.executeUpdate();
            if (resultaingreso > 0) {
                registro = true;
                System.out.println("El usuario se a registrado correctamente");
            } else {
                registro = false;
                System.out.println("El usuario se a registrado correctamente");
            }
            cx.close();
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            try {
                cx.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }

        return registro;
    }
    public boolean userRepetido(Usuarios usr){
        boolean userRepetido = false;
        String consulta = "SELECT email FROM usuarios WHERE email";
        return userRepetido;
    }
}


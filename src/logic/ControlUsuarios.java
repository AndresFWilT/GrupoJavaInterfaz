/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import models.Usuario;

/**
 *
 * @author ssrs_
 */
public class ControlUsuarios {

    private ArrayList<Usuario> usuarios;

    public ControlUsuarios() {
        usuarios = new ArrayList<Usuario>();
        cargarDatos();
    }

    public void cargarDatos() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("src/archives/usuarios.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] atributos = linea.split(",");
                Usuario usuario = new Usuario();
                usuario.setNombreUsuario(atributos[0]);
                usuario.setClaveUsuario(atributos[1]);
                usuario.setCorreoUsuario(atributos[2]);
                usuario.setImagenUsuario(new ImageIcon(atributos[3]));
                usuarios.add(usuario);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verificarUsuario(String correoUsuario, String claveUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreoUsuario().equals(correoUsuario)) {
                if (usuario.getClaveUsuario().equals(claveUsuario)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Usuario devolverUsuario(String correoUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreoUsuario().equals(correoUsuario)) {
                return usuario;
            }
        }
        return null;
    }

}

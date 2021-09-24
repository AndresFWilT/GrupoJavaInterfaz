/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.client.login;

/**
 *
 * @author AndresFWilT
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.services.servicesLogic.UsuarioService;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.Timer;

public class LoginComponent implements ActionListener, MouseListener {

    private LoginTemplate loginTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private UsuarioService sUsuario;
    private int estado = 1, estadoAnterior = 0, direccion = -1;
    private Timer timer;

    public LoginComponent() {
        this.loginTemplate = new LoginTemplate(this);
        this.timer = new Timer(1, this);
        sUsuario = UsuarioService.getService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.estadoAnterior = estado;
        if (e.getSource() == loginTemplate.getBOpcion(1)) {
            this.estado = 1;
            this.direccion = -1;
        }
        if (e.getSource() == loginTemplate.getBOpcion(2)) {
            this.estado = 2;
        }
        if (e.getSource() == loginTemplate.getBOpcion(3)) {
            this.estado = 3;
            this.direccion = 1;
        }
        timer.start();
        moverImagenes();

    }

    public void enviarDatosUsuario() {
        String correoUsuario = loginTemplate.getTCorreoUsuario().getText();
        String claveUsuario = new String(loginTemplate.getTClaveUsuario().getPassword());
        String check = "";
        if (sUsuario.verificarDatosUsuario(correoUsuario, claveUsuario)) {
            JOptionPane.showMessageDialog(null, "Ingreso Exitoso", "Advertencia", 1);
            entrar();
        } else {
            JOptionPane.showMessageDialog(null, "Algo quedo mal", "Advertencia", 2);
        }
    }

    public void entrar() {
        if (vistaPrincipalComponent == null) {
            vistaPrincipalComponent = new VistaPrincipalComponent(this);
        } else {
            this.vistaPrincipalComponent.restaurarValores();
            vistaPrincipalComponent.getVistaPrincipalTemplate().setVisible(true);
        }
        loginTemplate.setVisible(false);
    }

    public LoginTemplate getLoginTemplate() {
        return this.loginTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == loginTemplate.getBEntrar()) {
            this.enviarDatosUsuario();
        }
        if (me.getSource() == loginTemplate.getBCerrar()) {
            System.exit(0);
        }
        if (me.getSource() == loginTemplate.getBOpcion1()) {
            JOptionPane.showMessageDialog(null, "Boton Opcion", "Advertencia", 1);
        }
        if (me.getSource() == loginTemplate.getBRegistrarse()) {
            JOptionPane.showMessageDialog(null, "Boton Registro", "Advertencia", 1);
        }
        if (me.getSource() == loginTemplate.getTCorreoUsuario()) {
            loginTemplate.getTCorreoUsuario().setText("");
        }

        if (me.getSource() == loginTemplate.getTClaveUsuario()) {
            loginTemplate.getTClaveUsuario().setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    private void moverImagenes() {
        switch (estado) {
            case 1:
                if (loginTemplate.getPSvg().getX() == 100) {
                    timer.stop();
                } else {
                    loginTemplate.getPSvg().setLocation(
                            loginTemplate.getPSvg().getX() + 1, loginTemplate.getPSvg().getY()
                    );
                }
                break;
            case 2:
                if (loginTemplate.getPSvg().getX() == -500) {
                    timer.stop();
                } else {
                    loginTemplate.getPSvg().setLocation(
                            loginTemplate.getPSvg().getX() + direccion, loginTemplate.getPSvg().getY()
                    );
                }
                break;
            case 3:
                if (loginTemplate.getPSvg().getX() == -1100) {
                    timer.stop();
                } else {
                    loginTemplate.getPSvg().setLocation(
                            loginTemplate.getPSvg().getX() - 1, loginTemplate.getPSvg().getY()
                    );
                }
                break;
        }
    }

    public void restaurarValores() {
        this.getLoginTemplate().getTCorreoUsuario().setText("Correo electronico");
        this.getLoginTemplate().getTCorreoUsuario().setBorder(
                this.getLoginTemplate().getRecursosService().getBorderInferiorNaranja()
        );
        this.getLoginTemplate().getTCorreoUsuario().setForeground(
                this.getLoginTemplate().getRecursosService().getColorGrisOscuro()
        );
        this.getLoginTemplate().getTClaveUsuario().setText("clave Usuario");
        this.getLoginTemplate().getTClaveUsuario().setBorder(
                this.getLoginTemplate().getRecursosService().getBorderInferiorNaranja()
        );
        this.getLoginTemplate().getTClaveUsuario().setForeground(
                this.getLoginTemplate().getRecursosService().getColorGrisOscuro()
        );
        this.getLoginTemplate().getCbTipoUsuario().setSelectedIndex(0);
    }
}

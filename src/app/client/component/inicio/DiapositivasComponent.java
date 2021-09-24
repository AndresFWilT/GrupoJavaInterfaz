/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.client.component.inicio;

import app.client.component.BarraRecientesComponent;
import app.services.servicesGraphics.ObjGraficosService;
import app.services.servicesGraphics.RecursosService;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ssrs_
 */
public class DiapositivasComponent implements MouseListener {

    private String nombreDp, nombreArch;
    private int diap = 0, opcionAcp, opcionCnl, pos = 0;
    private DiapositivasTemplate diapositivasTemplate;
    private ObjGraficosService objGraficosService;
    private RecursosService sRecursos;
    private BarraRecientesComponent barraRecientesComponent;
    private JPanel pReciente;

    public DiapositivasComponent(String nombreDp, ImageIcon Diapositiva) {
        diapositivasTemplate = new DiapositivasTemplate(this, nombreDp, Diapositiva);
        this.nombreDp = nombreDp;
    }

    public DiapositivasTemplate getDiapositivasTemplate() {
        return this.diapositivasTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        diap++;
        nombreArch = JOptionPane.showInputDialog(null, "Nueva diapositiva", nombreDp + " " + diap);

        if (nombreArch != null) {
        }
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.client.component;

import app.client.component.inicio.DiapositivasComponent;
import app.services.servicesGraphics.ObjGraficosService;
import app.services.servicesGraphics.RecursosService;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ssrs_
 */
public class BarraRecientesTemplate extends JPanel {
//Declaración objetos gráficos

    private JPanel pSuperior, pInferior, pReciente1, pReciente2, pReciente3;
    private JLabel lRecursivo, lLogo1, lLogo2, lLogo3, R1, R2, R3;

    //Declaracion objetos Decoradores
    private ImageIcon iLogo, iDimAux;
    private BarraRecientesComponent navegacionUsuarioComponent;
    private ObjGraficosService objGraficosService;
    private RecursosService sRecursos;
    private DiapositivasComponent diapositivasComponent;

    int pos = 0;

    public BarraRecientesTemplate(BarraRecientesComponent navegacionUsuarioComponent) {
        this.navegacionUsuarioComponent = navegacionUsuarioComponent;
        objGraficosService = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        crearJPanelsyRecientes();
        crearJLabels();
        this.setSize(400, 760);
        this.setBackground(sRecursos.getColorGrisFondo());
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJPanelsyRecientes() {

        this.pSuperior = objGraficosService.construirJPanel(
                0, 0, 400, 200, sRecursos.getColorNaranja(), null
        );
        this.add(pSuperior);

        this.pInferior = objGraficosService.construirJPanel(
                0, 200, 400, 560, sRecursos.getColorNaranja(), null
        );
        this.add(pInferior);
        iLogo = new ImageIcon("src/resources/Logo.jpg");
        iDimAux = new ImageIcon(iLogo.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        lLogo1 = new JLabel();
        lLogo1.setIcon(iDimAux);
        lLogo1.setBounds(0, 0, 20, 20);

        lLogo2 = new JLabel();
        lLogo2.setIcon(iDimAux);
        lLogo2.setBounds(0, 0, 20, 20);

        lLogo3 = new JLabel();
        lLogo3.setIcon(iDimAux);
        lLogo3.setBounds(0, 0, 20, 20);

        /*R1 = new JLabel();
        R1.setText("Expo. Inglés");
        R1.setBounds(50, 0, 150, 50);*/
        R1 = objGraficosService.construirJLabel(
                "Expo. Inglés", 50, 0, 95, 20, null,
                Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getFontDiaRec(), "c"
        );

        R2 = objGraficosService.construirJLabel(
                "Presentacion 1", 50, 0, 115, 20, null,
                Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getFontDiaRec(), "c"
        );

        R3 = objGraficosService.construirJLabel(
                "SISTEMAS", 50, 0, 85, 20, null,
                Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getFontDiaRec(), "c"
        );

        pReciente1 = objGraficosService.construirJPanel(
                15, 20, 200, 30, sRecursos.getColorNaranja(), null
        );

        pReciente2 = objGraficosService.construirJPanel(
                15, 60, 200, 30, sRecursos.getColorNaranja(), null
        );

        pReciente3 = objGraficosService.construirJPanel(
                15, 100, 200, 30, sRecursos.getColorNaranja(), null
        );

        pReciente1.add(lLogo1);
        pReciente1.add(R1);

        pReciente2.add(lLogo2);
        pReciente2.add(R2);

        pReciente3.add(lLogo3);
        pReciente3.add(R3);

        pInferior.add(pReciente1);
        pInferior.add(pReciente2);
        pInferior.add(pReciente3);

    }

    public void crearJLabels() {

        // LABEL POWER POINT--------------------------------------------------------------------
        this.lRecursivo = objGraficosService.construirJLabel(
                "PowerPoint", 15, 55, 230, 40, null, Color.WHITE, null, sRecursos.getFontTPrincipal(), "c"
        );
        pSuperior.add(lRecursivo);

        // LABEL RECIENTES--------------------------------------------------------------------
        this.lRecursivo = objGraficosService.construirJLabel(
                "Recientes", 15, 115, 130, 35, null, Color.WHITE, null, sRecursos.getFontTRecientes(), "c"
        );
        pSuperior.add(lRecursivo);

        // LABEL DIA--------------------------------------------------------------------
        this.lRecursivo = objGraficosService.construirJLabel(
                "Hoy", 15, 175, 36, 20, null, Color.WHITE, null, sRecursos.getFontDiaRec(), "c"
        );
        pSuperior.add(lRecursivo);

    }

    public JPanel getPanel() {
        return pInferior;
    }

}

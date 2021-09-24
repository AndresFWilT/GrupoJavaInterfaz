/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.client.component.inicio;

import app.services.servicesGraphics.ObjGraficosService;
import app.services.servicesGraphics.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author ssrs_
 */
public class PresentacionesTemplate extends JPanel {

    private PresentacionesComponent presentacionesComponent;
    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;
    private JScrollPane PGeneral;
    private JPanel PGen, PDiapositiva0, PDiapositiva1, PDiapositiva2, PDiapositiva3,
            PDiapositiva4, PDiapositiva5, PDiapositiva6, PDiapositiva7;
    private ImageIcon IDiapositiva0, IDiapositiva1, IDiapositiva2, IDiapositiva3,
            IDiapositiva4, IDiapositiva5, IDiapositiva6, IDiapositiva7;
    //private String TDiagrama1, TDiagrama2, TDiagrama3, TDiagrama4;

    public PresentacionesTemplate(PresentacionesComponent presentacionesComponent) {
        this.presentacionesComponent = presentacionesComponent;
        this.presentacionesComponent.getClass();
        this.objGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();
        this.crearJScrollPanel();
        this.crearJPaneles();
        this.crearobjetosDecoradores();
        this.crearContenidoDiagramas();
        this.setSize(960, 760);
        this.setBackground(recursosService.getColorGrisFondo());
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJScrollPanel() {
        this.PGeneral = objGraficosService.construirPanelBarra(
                PGeneral, 0, 0, 960, 760, recursosService.getColorGrisFondo(), null
        );
        this.add(PGeneral);

        this.PGen = objGraficosService.construirJPanel(
                0, 0, 960, 760, recursosService.getColorGrisFondo(), null);
        PGen.setPreferredSize(new Dimension(960, 1000));
        PGeneral.setViewportView(PGen);
    }

    public void crearJPaneles() {
        this.PDiapositiva0 = objGraficosService.construirJPanel(
                20, 0, 222, 150, recursosService.getColorGrisFondo(), null
        );
        PGen.add(PDiapositiva0);

        this.PDiapositiva1 = objGraficosService.construirJPanel(
                252, 0, 222, 150, recursosService.getColorGrisOscuro(), null
        );
        PGen.add(PDiapositiva1);

        this.PDiapositiva2 = objGraficosService.construirJPanel(
                484, 0, 222, 150, recursosService.getColorNaranja(), null
        );
        PGen.add(PDiapositiva2);

        this.PDiapositiva3 = objGraficosService.construirJPanel(
                716, 0, 222, 150, recursosService.getColorNegro(), null
        );
        PGen.add(PDiapositiva3);

        this.PDiapositiva4 = objGraficosService.construirJPanel(
                20, 150, 222, 150, recursosService.getColorGrisFondo(), null
        );
        PGen.add(PDiapositiva4);

        this.PDiapositiva5 = objGraficosService.construirJPanel(
                252, 150, 222, 150, recursosService.getColorGrisFondo(), null
        );
        PGen.add(PDiapositiva5);
        this.PDiapositiva6 = objGraficosService.construirJPanel(
                484, 150, 222, 150, recursosService.getColorGrisFondo(), null
        );
        PGen.add(PDiapositiva6);
        this.PDiapositiva7 = objGraficosService.construirJPanel(
                716, 150, 222, 150, recursosService.getColorGrisFondo(), null
        );
        PGen.add(PDiapositiva7);
    }

    public void crearobjetosDecoradores() {
        this.IDiapositiva0 = new ImageIcon("src/resources/PIDiapositiva0.jpg");
        this.IDiapositiva1 = new ImageIcon("src/resources/PIDiapositiva1.jpg");
        this.IDiapositiva2 = new ImageIcon("src/resources/PIDiapositiva2.jpg");
        this.IDiapositiva3 = new ImageIcon("src/resources/PIDiapositiva3.jpg");
        this.IDiapositiva4 = new ImageIcon("src/resources/PIDiapositiva4.jpg");
        this.IDiapositiva5 = new ImageIcon("src/resources/PIDiapositiva5.jpg");
        this.IDiapositiva6 = new ImageIcon("src/resources/PIDiapositiva6.jpg");
        this.IDiapositiva7 = new ImageIcon("src/resources/PIDiapositiva7.jpg");
    }

    public void crearContenidoDiagramas() {
        this.PDiapositiva0.add(new DiapositivasComponent(
                "Presentacion en blanco",
                IDiapositiva0).getDiapositivasTemplate());
        this.PDiapositiva1.add(new DiapositivasComponent(
                "Galería",
                IDiapositiva1).getDiapositivasTemplate());
        this.PDiapositiva2.add(new DiapositivasComponent(
                "Paquete",
                IDiapositiva2).getDiapositivasTemplate());
        this.PDiapositiva3.add(new DiapositivasComponent(
                "Letras en madera",
                IDiapositiva3).getDiapositivasTemplate());
        this.PDiapositiva4.add(new DiapositivasComponent(
                "Citable",
                IDiapositiva4).getDiapositivasTemplate());
        this.PDiapositiva5.add(new DiapositivasComponent(
                "Berlín",
                IDiapositiva5).getDiapositivasTemplate());
        this.PDiapositiva6.add(new DiapositivasComponent(
                "Savon",
                IDiapositiva6).getDiapositivasTemplate());
        this.PDiapositiva7.add(new DiapositivasComponent(
                "Recorte",
                IDiapositiva7).getDiapositivasTemplate());

    }

}

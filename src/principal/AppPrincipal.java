/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controlador.ControlNaveLanzadera;
import controlador.ControlNaveNoTripulada;
import controlador.ControlNaveTripulada;
import controlador.ControlPrincipal;
import modelo.ConsultasNaveLanzadera;
import modelo.ConsultasNaveNoTripulada;
import modelo.ConsultasNaveTripulada;
import modelo.NaveLanzadera;
import modelo.NaveNoTripulada;
import modelo.NaveTripulada;
import vista.frmNaveLanzadera;
import vista.frmNaveNoTripulada;
import vista.frmNaveTripulada;
import vista.frmPrincipal;

/**
 *
 * @author edyos
 */
public class AppPrincipal {

    public static void main(String[] args) {

        NaveLanzadera naveLan = new NaveLanzadera();
        ConsultasNaveLanzadera conNaveLan = new ConsultasNaveLanzadera();
        frmNaveLanzadera frmNaveLan = new frmNaveLanzadera();

        ControlNaveLanzadera ctrlNaveLan = new ControlNaveLanzadera(naveLan, conNaveLan, frmNaveLan);
        ctrlNaveLan.iniciar();
        //frmNaveLan.setVisible(true);

        NaveNoTripulada naveNoTrip = new NaveNoTripulada();
        ConsultasNaveNoTripulada conNaveNoTrip = new ConsultasNaveNoTripulada();
        frmNaveNoTripulada frmNaveNoTrip = new frmNaveNoTripulada();

        ControlNaveNoTripulada ctrlNaveNoTrip = new ControlNaveNoTripulada(naveNoTrip, conNaveNoTrip, frmNaveNoTrip);
        ctrlNaveNoTrip.iniciar();
        //frmNaveNoTrip.setVisible(true);

        NaveTripulada naveTrip = new NaveTripulada();
        ConsultasNaveTripulada conNaveTrip = new ConsultasNaveTripulada();
        frmNaveTripulada frmNaveTrip = new frmNaveTripulada();

        ControlNaveTripulada ctrlNaveTrip = new ControlNaveTripulada(naveTrip, conNaveTrip, frmNaveTrip);
        ctrlNaveTrip.iniciar();
        //frmNaveTrip.setVisible(true);

        ControlPrincipal ctrlPrincipal = new ControlPrincipal();
        ctrlPrincipal.iniciar();

    }

}

package controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
public class ControlPrincipal implements ActionListener {

    //private NaveNoTripulada miNave;
    //private ConsultasNaveNoTripulada modC;
    //private frmNaveNoTripulada frm;
    //ArrayList<NaveNoTripulada> listaNaves;
    private frmPrincipal frm;

    public ControlPrincipal() {
        this.frm = new frmPrincipal();
        frm.btnLanzadera.addActionListener(this);
        frm.btnNoTripuladas.addActionListener(this);
        frm.btnTripuladas.addActionListener(this);
        frm.btnBuscar.addActionListener(this);
    }

    /*
    public ControlPrincipal(NaveNoTripulada miNave, ConsultasNaveNoTripulada modC, frmNaveNoTripulada frm) {
        this.miNave = miNave;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnBorrar.addActionListener(this);
        this.frm.btnConsultar.addActionListener(this);
        this.frm.btnActualizar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnListar.addActionListener(this);
        this.frm.btnSalir.addActionListener(this);
        this.frm.tblDatos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt){
                JTable table = (JTable) evt.getSource();
                Point point = evt.getPoint();
                int row = table.rowAtPoint(point);
                if(evt.getClickCount()== 2){
                    frm.txtNombre.setText(String.valueOf(frm.tblDatos.getValueAt(frm.tblDatos.getSelectedRow(), 0)));
                    frm.txtPais.setText(String.valueOf(frm.tblDatos.getValueAt(frm.tblDatos.getSelectedRow(), 1)));
                    frm.txtPeso.setText(String.valueOf(frm.tblDatos.getValueAt(frm.tblDatos.getSelectedRow(), 2)));
                    frm.txtVelocidad.setText(String.valueOf(frm.tblDatos.getValueAt(frm.tblDatos.getSelectedRow(), 3)));
                    frm.txtPotencia.setText(String.valueOf(frm.tblDatos.getValueAt(frm.tblDatos.getSelectedRow(), 4)));
                    frm.txtCombustible.setText(String.valueOf(frm.tblDatos.getValueAt(frm.tblDatos.getSelectedRow(), 5)));
                }
            
            }
            
        });
        
        
    }*/
    public void iniciar() {
        frm.setTitle("Gestionar Naves Espaciales");
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel modelo = (DefaultTableModel) frm.tblDatos.getModel();
        int numRow;
        if (e.getSource() == frm.btnLanzadera) {
            NaveLanzadera naveLan = new NaveLanzadera();
            ConsultasNaveLanzadera conNaveLan = new ConsultasNaveLanzadera();
            frmNaveLanzadera frmNaveLan = new frmNaveLanzadera();

            ControlNaveLanzadera ctrlNaveLan = new ControlNaveLanzadera(naveLan, conNaveLan, frmNaveLan);
            ctrlNaveLan.iniciar();
            frmNaveLan.setVisible(true);

        }

        if (e.getSource() == frm.btnNoTripuladas) {
            NaveNoTripulada naveNoTrip = new NaveNoTripulada();
            ConsultasNaveNoTripulada conNaveNoTrip = new ConsultasNaveNoTripulada();
            frmNaveNoTripulada frmNaveNoTrip = new frmNaveNoTripulada();

            ControlNaveNoTripulada ctrlNaveNoTrip = new ControlNaveNoTripulada(naveNoTrip, conNaveNoTrip, frmNaveNoTrip);
            ctrlNaveNoTrip.iniciar();
            frmNaveNoTrip.setVisible(true);
        }

        if (e.getSource() == frm.btnTripuladas) {

            NaveTripulada naveTrip = new NaveTripulada();
            ConsultasNaveTripulada conNaveTrip = new ConsultasNaveTripulada();
            frmNaveTripulada frmNaveTrip = new frmNaveTripulada();

            ControlNaveTripulada ctrlNaveTrip = new ControlNaveTripulada(naveTrip, conNaveTrip, frmNaveTrip);
            ctrlNaveTrip.iniciar();
            frmNaveTrip.setVisible(true);
        }      
        
       
    }
    /*
    public void limpiar() {
        frm.txtNombre.setText(null);
        frm.txtPais.setText(null);
        frm.txtPeso.setText(null);
        frm.txtVelocidad.setText(null);
        frm.txtPotencia.setText(null);
        frm.txtCombustible.setText(null);
    }*/

}

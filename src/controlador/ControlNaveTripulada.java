/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.ConsultasNaveTripulada;
import modelo.NaveLanzadera;
import modelo.NaveTripulada;
import vista.frmNaveLanzadera;
import vista.frmNaveTripulada;

/**
 *
 * @author edyos
 */
public class ControlNaveTripulada implements ActionListener {
    
    private NaveTripulada miNave;
    private ConsultasNaveTripulada modC;
    private frmNaveTripulada frm;
    ArrayList<NaveTripulada> listaNaves;
     
    
    public ControlNaveTripulada(NaveTripulada miNave, ConsultasNaveTripulada modC, frmNaveTripulada frm) {
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
                    frm.txtCapPersonas.setText(String.valueOf(frm.tblDatos.getValueAt(frm.tblDatos.getSelectedRow(), 6)));
                    
                }
            
            }
            
        });
        
        
    }
    
    public void iniciar() {
        frm.setTitle("Naves Espaciales Tripuladas");
        frm.setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel modelo = (DefaultTableModel) frm.tblDatos.getModel();
        int numRow;
        if (e.getSource() == frm.btnRegistrar) {
            
            miNave.setNombre(frm.txtNombre.getText());
            miNave.setPais(frm.txtPais.getText());
            miNave.setPeso(Double.parseDouble(frm.txtPeso.getText()));
            miNave.setVelocidad(Double.parseDouble(frm.txtVelocidad.getText()));
            miNave.setPotencia(Double.parseDouble(frm.txtPotencia.getText()));
            miNave.setCombustible(frm.txtCombustible.getText());
            miNave.setCapacidadPersonas(Integer.parseInt(frm.txtCapPersonas.getText()));            
            
            if (modC.registrarNave(miNave)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al  guardado");
            }
        }
        if (e.getSource() == frm.btnActualizar) {
            
            miNave.setNombre(frm.txtNombre.getText());
            miNave.setPais(frm.txtPais.getText());
            miNave.setPeso(Double.parseDouble(frm.txtPeso.getText()));
            miNave.setVelocidad(Double.parseDouble(frm.txtVelocidad.getText()));
            miNave.setPotencia(Double.parseDouble(frm.txtPotencia.getText()));
            miNave.setCombustible(frm.txtCombustible.getText());
            miNave.setCapacidadPersonas(Integer.parseInt(frm.txtCapPersonas.getText()));           
            
            if (modC.modificarNave(miNave)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al  modificar");
            }
        }
        
        if (e.getSource() == frm.btnBorrar) {
            
            miNave.setNombre(frm.txtNombre.getText());
            
            if (modC.eliminarNave(miNave)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al  eliminar");
            }
        }
        
        if (e.getSource() == frm.btnConsultar) {
            
            miNave.setNombre(frm.txtNombre.getText());
            
            if (modC.buscarNave(miNave)) {
                
                frm.txtNombre.setText(miNave.getNombre());
                frm.txtPais.setText(miNave.getPais());
                frm.txtPeso.setText(String.valueOf(miNave.getPeso()));
                frm.txtVelocidad.setText(String.valueOf(miNave.getVelocidad()));
                frm.txtPotencia.setText(String.valueOf(miNave.getPotencia()));
                frm.txtCombustible.setText(miNave.getCombustible());
                frm.txtCapPersonas.setText(String.valueOf(miNave.getCapacidadPersonas()));                
            } else {
                JOptionPane.showMessageDialog(null, "Registro no Encontrado");
                limpiar();
            }
        }
        
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
        
        if (e.getSource() == frm.btnSalir) {
            this.frm.dispose();
        }
        if (e.getSource() == frm.btnListar) {
            modelo.setRowCount(0);
            
            listaNaves = modC.listarNaves();
            for (NaveTripulada listaNave : listaNaves) {   
                modelo.addRow(new Object[]{
                    listaNave.getNombre(), listaNave.getPais(), listaNave.getPeso(), listaNave.getVelocidad(),
                    listaNave.getPotencia(), listaNave.getCombustible(), listaNave.getCapacidadPersonas()
                });

                frm.tblDatos.setModel(modelo);
                limpiar();
            }
        }
        listaNaves.clear();
    }
    
    public void limpiar() {
        frm.txtNombre.setText(null);
        frm.txtPais.setText(null);
        frm.txtPeso.setText(null);
        frm.txtVelocidad.setText(null);
        frm.txtPotencia.setText(null);
        frm.txtCombustible.setText(null);
        frm.txtCapPersonas.setText(null);
        
    }
    
}

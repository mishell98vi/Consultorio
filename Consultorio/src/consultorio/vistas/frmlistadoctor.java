/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import consultorio.negocio.impl.*;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import java.util.*;
public class frmlistadoctor extends JInternalFrame {
    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane sr;
    public frmlistadoctor(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE DOCTOR");
        tabla = new JTable();
        sr = new JScrollPane(tabla);
        this.add(titulo, BorderLayout.NORTH);
        this.add(sr, BorderLayout.CENTER);

        cargarTabla();
    }
    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Horario");
        modelo.addColumn("Especialidad");

      

        List<Doctor> lista = new ArrayList<>();
        try {
            IDoctor docDao = new ImplDoctor();
            lista = docDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Doctor doc : lista) {
            modelo.addRow(new Object[]{doc.getCodigo(), doc.getNombre(), doc.getApellido(), doc.getHorario(), doc.getEspecialidad()});
        }
        tabla.setModel(modelo);
    }

    
    
}


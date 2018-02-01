package consultorio.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import consultorio.negocio.impl.*;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import java.util.*;
public class frmlistapaciente extends JInternalFrame {
    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane sr;
    public frmlistapaciente(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE PACIENTE");
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
        modelo.addColumn("Enfermedad");
        

      

        List<Paciente> lista = new ArrayList<>();
        try {
            IPaciente pacDao = new ImplPaciente();
            lista = pacDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Paciente pac : lista) {
            modelo.addRow(new Object[]{pac.getCodigo(), pac.getNombre(), pac.getApellido(), pac.getEnfermedad()});
        }
        tabla.setModel(modelo);
    }

}

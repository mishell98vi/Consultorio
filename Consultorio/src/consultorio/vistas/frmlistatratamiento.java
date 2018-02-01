package consultorio.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import consultorio.negocio.impl.*;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import java.util.*;
public class frmlistatratamiento extends JInternalFrame {
    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane sr;
    public frmlistatratamiento(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE TRATAMIENTO");
        tabla = new JTable();
        sr = new JScrollPane(tabla);
        this.add(titulo, BorderLayout.NORTH);
        this.add(sr, BorderLayout.CENTER);

        cargarTabla();
    }
    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Doctor");
        modelo.addColumn("Paciente");
        modelo.addColumn("Diagnostico");
        modelo.addColumn("Receta");
        modelo.addColumn("Tratamiento");

      

        List<Tratamiento> lista = new ArrayList<>();
        try {
            ITratamiento traDao = new ImplTratamiento();
            lista = traDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Tratamiento tra : lista) {
            modelo.addRow(new Object[]{tra.getDoctor().getNombre(), tra.getPaciente().getNombre(), tra.getDiagnostico(), tra.getReceta(), tra.getTratamiento()});
        }
        tabla.setModel(modelo);
    }

}
package consultorio.vistas;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import consultorio.negocio.impl.*;

public class frmTratamiento extends JInternalFrame {

    List<Doctor> lstDoc;

    List<Paciente> lstPac;

    JComboBox<Doctor> cmbDoc;
    JComboBox<Paciente> cmbPac;

    JLabel Titulo;
    JLabel Doctor;
    JLabel Paciente;
    JLabel Diagnostico;
    JLabel Receta;
    JLabel Tratamiento;

    JTextField txtDiagnostico;
    JTextField txtReceta;
    JTextField txtTratamiento;
    JButton btnLimpiar;
    JButton btnAceptar;

    JPanel pnlA;
    JPanel pnlB;

    public frmTratamiento() {

        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        pnlA = new JPanel();
        pnlB = new JPanel();

        pnlA.setLayout(new GridLayout(12, 2, 5, 5));
        pnlB.setLayout(new GridLayout(1, 2, 5, 5));

        Titulo = new JLabel("DATOS DEL TRATAMIENTI");

        Doctor = new JLabel("DOCTOR");
        Paciente = new JLabel("PCIENTE");
        Diagnostico = new JLabel("DIAGNOSTICO");
        Receta = new JLabel("RECETA");
        Tratamiento = new JLabel("TRATAMIENTO");

        txtDiagnostico = new JTextField();
        txtReceta = new JTextField();
        txtTratamiento = new JTextField();
        cargarDoctor();
        cmbDoc = new JComboBox(lstDoc.toArray());
        cargarPaciente();
        cmbPac = new JComboBox(lstPac.toArray());

        btnAceptar = new JButton("ACEPTAR");
        btnLimpiar = new JButton("LIMPIAR");

        this.add(Titulo, BorderLayout.NORTH);

        pnlA.add(Doctor);
        pnlA.add(cmbDoc);
        pnlA.add(Paciente);
        pnlA.add(cmbPac);
        pnlA.add(Diagnostico);
        pnlA.add(txtDiagnostico);
        pnlA.add(Receta);
        pnlA.add(txtReceta);
        pnlA.add(Tratamiento);
        pnlA.add(txtTratamiento);
        pnlB.add(btnAceptar);
        pnlB.add(btnLimpiar);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }

            }
        });

        this.add(Titulo, BorderLayout.NORTH);
        this.add(pnlA, BorderLayout.CENTER);
        this.add(pnlB, BorderLayout.SOUTH);
        this.setClosable(true);

    }

    public static void main(String[] args) {

        frmTratamiento trata = new frmTratamiento();
        trata.setVisible(true);

    }

    public void btnAceptarActionListener(ActionEvent e) {

        ITratamiento traDao = new ImplTratamiento();
        Tratamiento ntra = new Tratamiento();
        ntra.setDoctor((Doctor) cmbDoc.getSelectedItem());
        ntra.setPaciente((Paciente) cmbPac.getSelectedItem());
        ntra.setDiagnostico(txtDiagnostico.getText());
        ntra.setReceta(txtReceta.getText());
        ntra.setTratamiento(txtTratamiento.getText());

        try {

            if (traDao.insertar(ntra) > 0) {

                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargarDoctor() {

        IDoctor docDao = new ImplDoctor();
        try {

            lstDoc = docDao.obtener();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR !!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    }

     private void cargarPaciente() {
       
        IPaciente pacDao = new ImplPaciente();
        try{
            
            lstPac = pacDao.obtener();
            
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LOS CLIENTES!!", "Transaction", JOptionPane.ERROR_MESSAGE);
        }
    
    }
}

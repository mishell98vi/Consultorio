package consultorio.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import consultorio.negocio.dao.*;
import consultorio.negocio.impl.*;
import consultorio.negocio.entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class frmPaciente extends JInternalFrame {

    List<frmPaciente> lstPacinte;
    JComboBox<String> cmbEnfermedad;
    JLabel codigo;
    JLabel nombre;
    JLabel apellido;
    JLabel fechaIng;
    JLabel fechaSal;
    JLabel enfermedad;
    JLabel titulo;
    JTextField txtCodigo;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtFechaing;  
    JTextField txtFechasal;
    JTextField txtEnfermedad;
    JTextField txtTitulo;
    
    JComboBox cmbenfermedad;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public frmPaciente() {
        this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(6, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo = new JLabel("Datos del Paciente");

        codigo = new JLabel("Codigo Paciente");
        nombre = new JLabel("Nombre");
        apellido = new JLabel("Apellido");
        fechaIng = new JLabel("Fecha Ingreso");
        fechaSal = new JLabel("Fecha Salida");
        enfermedad = new JLabel("Enfermedad");
        
        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtFechaing = new JTextField();
        txtFechasal = new JTextField();
        txtEnfermedad = new JTextField();
        
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        
        pnlcentral.add(codigo);
        pnlcentral.add(txtCodigo);
        pnlcentral.add(nombre);
        pnlcentral.add(txtNombre);
        pnlcentral.add(apellido);
        pnlcentral.add(txtApellido);
        pnlcentral.add(fechaIng);
        pnlcentral.add(txtFechaing);
        pnlcentral.add(fechaSal);
        pnlcentral.add(txtFechasal);
        pnlcentral.add(enfermedad);
        pnlcentral.add(txtEnfermedad);

        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);

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
        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);
        this.setClosable(true);

    }

    public static void main(String[] args) {

        frmPaciente frmMenu = new frmPaciente();
        frmMenu.setVisible(true);

    }

    public void btnAceptarActionListener(ActionEvent e) {
        IPaciente pacDao = new ImplPaciente();

        try {

            Paciente pac = new Paciente();
            pac.setCodigo(txtCodigo.getText());
            pac.setNombre(txtNombre.getText());
            pac.setApellido(txtApellido.getText());
             pac.setEnfermedad(txtEnfermedad.getText());

            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pac.setFechaIng(formatoFecha.parse(txtFechaing.getText()));
                pac.setFechaSal(formatoFecha.parse(txtFechasal.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Fecha Incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
                if (pacDao.insertar(pac) > 0) {
                    JOptionPane.showMessageDialog(this, "Proceso Completado!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR !! "+ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}


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

public class frmDoctor extends JInternalFrame {

    List<frmDoctor> lstDoctor;
    JComboBox<String> cmbEspecialidad;
    JLabel codigo;
    JLabel nombre;
    JLabel apellido;
    JLabel especialidad;
    JLabel horario;
    JLabel titulo;

    JTextField txtCodigo;
    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtHorario;
    
    
    JTextField txtTitulo;
    JTextField txCodi0;

    JComboBox cmbEspeciliadad;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public frmDoctor() {
        this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo = new JLabel("Datos del Doctor");

        codigo = new JLabel("Codigo  Doctor");

        nombre = new JLabel("Nombre");

        apellido = new JLabel("Apellido");

        especialidad = new JLabel("Especialidad");

        horario = new JLabel("Horario");

        
        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        
        txtHorario = new JTextField();
        txCodi0 = new JTextField();
        cmbEspecialidad = new JComboBox(new String[]{"medicina general", "odontologia","traumatologia","Cardiologia","Dermatologia"});
        
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        this.add(titulo, BorderLayout.NORTH);
        pnlcentral.add(codigo);
        pnlcentral.add(txtCodigo);
        pnlcentral.add(codigo);
        pnlcentral.add(txtNombre);
        pnlcentral.add(nombre);
        pnlcentral.add(txtApellido);
        pnlcentral.add(apellido);
        pnlcentral.add(txtHorario);
        pnlcentral.add(horario);
        pnlcentral.add(especialidad);
        pnlcentral.add(cmbEspecialidad);

   
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

        frmDoctor frmMenu = new frmDoctor();
        frmMenu.setVisible(true);

    }

    public void btnAceptarActionListener(ActionEvent e) {
        IDoctor docDao = new ImplDoctor();

        try {

            Doctor doc = new Doctor();
            doc.setCodigo(txtCodigo.getText());
            doc.setNombre(txtNombre.getText());
            doc.setApellido(txtApellido.getText());
            doc.setHorario(txtHorario.getText());
            int opcionEspecialidad=0;
            opcionEspecialidad=cmbEspecialidad.getSelectedIndex();
            if(opcionEspecialidad==0){
                doc.setEspecialidad("medicina general");
            } else if(opcionEspecialidad==1){
                doc.setEspecialidad("odontologia");
            }else if(opcionEspecialidad==2){
                doc.setEspecialidad("traumatologia");
            }else if(opcionEspecialidad==3){
                doc.setEspecialidad("Cardiologia");
            }else if(opcionEspecialidad==4){
                doc.setEspecialidad("Dermatologia");
            }
                if (docDao.insertar(doc) > 0) {
                    JOptionPane.showMessageDialog(this, "Proceso Completado!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR !! "+ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}



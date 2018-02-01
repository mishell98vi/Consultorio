package consultorio.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import consultorio.negocio.impl.*;

public class menuprincipal extends JFrame {

    JMenuBar menuBarraPrincipal;
    JMenu menuInicio;
    JMenuItem menuItemLogin;
    JMenuItem menuItemSalir;
    
    
    ////////////////////////////////
    
    JMenu menuDoctor;
    JMenuItem nuevoDoctor;
    JMenuItem modificarDoctor;
    JMenuItem eliminarDoctor;
    JMenuItem buscarDoctor;
    JMenuItem listDoctor;
    
    JMenu menuPaciente;
    JMenuItem nuevoPaciente;
    JMenuItem modificarPaciente;
    JMenuItem eliminarPaciente;
    JMenuItem buscarPaciente;
    JMenuItem listPaciente;
    
    JMenu menuTratamiento;
    JMenuItem nuevoTratamiento;
    JMenuItem modificarTratamiento;
    JMenuItem eliminarTratamiento;
    JMenuItem buscarTratamiento;
    JMenuItem listTratamiento;
    
    JDesktopPane escritorio;

    public menuprincipal() {
        
        
        escritorio = new JDesktopPane();
        escritorio.setBackground(new Color(250, 30, 70));

        menuBarraPrincipal = new JMenuBar();
        //menu Inicio
        menuInicio = new JMenu("Inicio");
        menuItemLogin = new JMenuItem("Iniciar Sesion");
        menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menuSalirActionPerformed(e);
                } catch (Exception ex) {
                    System.out.println("error: " + ex.getMessage());
                }
            }
        });
        menuBarraPrincipal.add(menuInicio);
        menuInicio.add(menuItemLogin);
        menuInicio.add(menuItemSalir);
        
        
         menuDoctor = new JMenu("DOCTOR");
        nuevoDoctor = new JMenuItem("Nuevo Doctor");
        nuevoDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoDoctorActionPerformed(e);
            }
        });
        modificarDoctor = new JMenuItem("Modificar Doctor");
        eliminarDoctor = new JMenuItem("Eliminar Doctor");
        buscarDoctor = new JMenuItem("Buscar Doctor");
        listDoctor = new JMenuItem("Listar Doctors");
        listDoctor.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDoctorActionPerformed(e);
            }
        });
        menuDoctor.add(nuevoDoctor);
        menuDoctor.add(modificarDoctor);
        menuDoctor.add(eliminarDoctor);
        menuDoctor.addSeparator();
        menuDoctor.add(buscarDoctor);
        menuDoctor.add(listDoctor);
        
        menuBarraPrincipal.add(menuDoctor);
        
        
        
        
         menuPaciente = new JMenu("PACIENTE");
        nuevoPaciente = new JMenuItem("Nuevo Paciente");
        nuevoPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoPacienteActionPerformed(e);
            }
        });
        modificarPaciente = new JMenuItem("Modificar Paciente");
        eliminarPaciente = new JMenuItem("Eliminar Paciente");
        buscarPaciente = new JMenuItem("Buscar Paciente");
        listPaciente = new JMenuItem("Listar Paciente");
        listPaciente.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPacienteActionPerformed(e);
            }
        });
        menuPaciente.add(nuevoPaciente);
        menuPaciente.add(modificarPaciente);
        menuPaciente.add(eliminarPaciente);
        menuPaciente.addSeparator();
        menuPaciente.add(buscarPaciente);
        menuPaciente.add(listPaciente);
        
        menuBarraPrincipal.add(menuPaciente);
        
         menuTratamiento = new JMenu("TRATAMIENTO");
        nuevoTratamiento = new JMenuItem("Nueva Tratamiento");
        nuevoTratamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoTratamientoActionPerformed(e);
            }
        });
        modificarTratamiento = new JMenuItem("Modificar Tratamiento");
        eliminarTratamiento = new JMenuItem("Eliminar Tratamiento");
        buscarTratamiento = new JMenuItem("Buscar Tratamiento");
        listTratamiento = new JMenuItem("Listar Tratamiento");
        listTratamiento.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaTratamientoActionPerformed(e);
            }
        });
        menuTratamiento.add(nuevoTratamiento);
        menuTratamiento.add(modificarTratamiento);
        menuTratamiento.add(eliminarTratamiento);
        menuTratamiento.addSeparator();
        menuTratamiento.add(buscarTratamiento);
        menuTratamiento.add(listTratamiento);
        
        menuBarraPrincipal.add(menuTratamiento);
        
        
          
        this.setLayout(new BorderLayout());
        //this.setSize(360,240);
        this.add(menuBarraPrincipal, BorderLayout.NORTH);
        this.add(escritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //PARA MAXIMIZAR LA VENTANA
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//terminar proceso de la ventana ejecutada
        
        
    }
    
     public static void main(String[] args) {
        menuprincipal ventana = new menuprincipal();
        ventana.setVisible(true);
    }

    public void menuSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
     public void listaDoctorActionPerformed(ActionEvent e) {
        frmlistadoctor frm = new frmlistadoctor();
        escritorio.add(frm);
        frm.setVisible(true);
    }
      public void listaTratamientoActionPerformed(ActionEvent e) {
        frmlistatratamiento frm = new frmlistatratamiento();
        escritorio.add(frm);
        frm.setVisible(true);
    }
     
     public void listaPacienteActionPerformed(ActionEvent e) {
        frmlistapaciente frm = new frmlistapaciente();
        escritorio.add(frm);
        frm.setVisible(true);
    }
     public void NuevoDoctorActionPerformed(ActionEvent e) {
        frmDoctor frm = new frmDoctor();
        escritorio.add(frm);
        frm.setVisible(true);
    }

      public void NuevoTratamientoActionPerformed(ActionEvent e) {
        frmTratamiento frm = new frmTratamiento();
        escritorio.add(frm);
        frm.setVisible(true);
    }
      
       public void NuevoPacienteActionPerformed(ActionEvent e) {
        frmPaciente frm = new frmPaciente();
        escritorio.add(frm);
        frm.setVisible(true);
    }
    
}

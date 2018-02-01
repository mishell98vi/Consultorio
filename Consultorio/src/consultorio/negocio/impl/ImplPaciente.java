package consultorio.negocio.impl;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import consultorio.accesoadatos.*;
import java.util.*;
import java.sql.*;

public class ImplPaciente implements IPaciente {

    @Override
    public int insertar(Paciente paciente) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Paciente (codigo, nombre, apellido, fechaIng, fechaSal, enfermedad) Values (?,?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, paciente.getCodigo()));
        lstP.add(new Parametro(2, paciente.getNombre()));
        lstP.add(new Parametro(3, paciente.getApellido()));
        if(paciente.getFechaIng() instanceof java.util.Date){
            lstP.add(new Parametro(4, new java.sql.Date(((java.util.Date) paciente.getFechaIng()).getTime())));
        }
        else{
            lstP.add(new Parametro(4, paciente.getFechaIng()));
        }
        if(paciente.getFechaSal() instanceof java.util.Date){
            lstP.add(new Parametro(5, new java.sql.Date(((java.util.Date) paciente.getFechaSal()).getTime())));
        }
        else {
            lstP.add(new Parametro(5, paciente.getFechaSal()));
        }
        lstP.add(new Parametro(6, paciente.getEnfermedad()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public int modificar(Paciente paciente) throws Exception {
        int nFilas=0;
        String csql="Update Paciente Set codigo=?, nombre=?, apellido=?, fechaIng=?, fechaSal=?, enfermedad=? Where codigo=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, paciente.getCodigo()));
        lstPar.add(new Parametro(2, paciente.getNombre()));
        lstPar.add(new Parametro(3, paciente.getApellido()));
        lstPar.add(new Parametro(4, paciente.getFechaIng()));
        lstPar.add(new Parametro(5, paciente.getFechaSal()));
        lstPar.add(new Parametro(6, paciente.getEnfermedad()));
        lstPar.add(new Parametro(7, paciente.getCodigo()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            nFilas=con.ejecutarComando(csql, lstPar); 
        } catch (Exception e) {
            System.out.println("Error de modificacion: "+e.getMessage());
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public int eliminar(Paciente paciente) throws Exception {
        int nFilas=0;
        String csql="Delete from Paciente Where codigo=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, paciente.getCodigo()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            nFilas=con.ejecutarComando(csql, lstPar); 
        } catch (Exception e) {
            System.out.println("Error de Eliminacionn: "+e.getMessage());
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public Paciente obtener(String codigo) throws Exception {
        Paciente doc = null;
        String csql = "select codigo, nombre, apellido, fechaIng, fechaSal, enfermedad from Paciente where codigo=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                doc=new Paciente();
                doc.setCodigo(rst.getString(1));
                doc.setNombre(rst.getString(2));
                doc.setApellido(rst.getString(3));
                doc.setFechaIng(rst.getDate(4));
                doc.setFechaSal(rst.getDate(5));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return doc;
    }

    @Override
    public ArrayList<Paciente> obtener() throws Exception {
        ArrayList<Paciente> docs = new ArrayList<>();
        String csql="select codigo, nombre, apellido, fechaIng, fechaSal, enfermedad from Paciente";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Paciente doc=null;
            while(rst.next()){
                doc=new Paciente();
                doc.setCodigo(rst.getString(1));
                doc.setNombre(rst.getString(2));
                doc.setApellido(rst.getString(3));
                doc.setFechaIng(rst.getDate(4));
                doc.setFechaSal(rst.getDate(5));
                doc.setEnfermedad(rst.getString(6));
                docs.add(doc);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return docs;
    }

}

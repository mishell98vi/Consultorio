package consultorio.negocio.impl;
import consultorio.negocio.dao.*;
import consultorio.negocio.entidades.*;
import consultorio.accesoadatos.*;
import java.util.*;
import java.sql.*;

public class ImplDoctor implements IDoctor {

    @Override
    public int insertar(Doctor doctor) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Doctor (codigo, nombre, apellido, especialidad, horario) Values (?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, doctor.getCodigo()));
        lstP.add(new Parametro(2, doctor.getNombre()));
        lstP.add(new Parametro(3, doctor.getApellido()));
        lstP.add(new Parametro(4, doctor.getEspeciadlidad()));
        lstP.add(new Parametro(5, doctor.getHorario()));
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
    public int modificar(Doctor doctor) throws Exception {
        int nFilas=0;
        String csql="Update Doctor Set codigo=?, nombre=?, apellido=?, especialidad=?, horario=? Where codigo=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, doctor.getCodigo()));
        lstPar.add(new Parametro(2, doctor.getNombre()));
        lstPar.add(new Parametro(3, doctor.getApellido()));
        lstPar.add(new Parametro(4, doctor.getEspeciadlidad()));
        lstPar.add(new Parametro(5, doctor.getHorario()));
        lstPar.add(new Parametro(6, doctor.getCodigo()));
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
    public int eliminar(Doctor doctor) throws Exception {
        int nFilas=0;
        String csql="Delete from Doctor Where codigo=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, doctor.getCodigo()));
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
    public Doctor obtener(String codigo) throws Exception {
        Doctor doc = null;
        String csql = "Select codigo, nombre, apellido, especialidad, horario From Doctor Where codigo=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                doc=new Doctor();
                doc.setCodigo(rst.getString(1));
                doc.setNombre(rst.getString(2));
                doc.setApellido(rst.getString(3));
                doc.setEspeciadlidad(rst.getString(4));
                doc.setHorario(rst.getString(5));
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
    public ArrayList<Doctor> obtener() throws Exception {
        ArrayList<Doctor> docs = new ArrayList<>();
        String csql="select codigo, nombre, apellido, especialidad, horario from Doctor";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Doctor doc=null;
            while(rst.next()){
                doc=new Doctor();
                doc.setCodigo(rst.getString(1));
                doc.setNombre(rst.getString(2));
                doc.setApellido(rst.getString(3));
                doc.setEspeciadlidad(rst.getString(4));
                doc.setHorario(rst.getString(5));
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

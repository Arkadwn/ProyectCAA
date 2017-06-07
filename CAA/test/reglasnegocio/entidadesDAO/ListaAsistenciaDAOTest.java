/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reglasnegocio.entidadesDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import reglasnegocio.asesor.IListaAsistenciaDAO;
import reglasnegocio.entidades.ActividadProgramada;
import reglasnegocio.entidades.ListaAsistencia;
import reglasnegocio.entidades.UsuarioAutonomo;

/**
 *
 * @author Leonardo
 */
public class ListaAsistenciaDAOTest {
    
    public ListaAsistenciaDAOTest() {
    }
    
    
    /**
     * Test of verificarAntecedentes method, of class ListaAsistenciaDAO.
     */
    @Test
    public void pruebaYaSeHaPasadoLista() throws SQLException, IOException {
        String idActividad = "ACP03";
        ListaAsistenciaDAO instance = new ListaAsistenciaDAO();
        boolean expResult = true;
        boolean result = instance.verificarAntecedentes(idActividad);
        assertEquals(expResult, result);
    }
    @Test
    public void pruebaNoSeHaPasadoLista() throws SQLException, IOException {
        String idActividad = "ACP08";
        ListaAsistenciaDAO instance = new ListaAsistenciaDAO();
        boolean expResult = false;
        boolean result = instance.verificarAntecedentes(idActividad);
        assertEquals(expResult, result);
    }
    
    @Test
    public void pruebaPasoDeLista() throws SQLException, IOException{
        ListaAsistencia asistencia = new ListaAsistencia();
        ActividadProgramada actividad = new ActividadProgramada();
        actividad.setIdActividadProgramada("ACP07");
        UsuarioAutonomo usuario = new UsuarioAutonomo();
        usuario.setMatricula("S15011621");
        Boolean[] asistio= new Boolean[1];
        asistio[0] = true;
        List<UsuarioAutonomo> lista = new ArrayList<>();
        lista.add(usuario);
        String fecha = ActividadProgramada.sacarFechaActual();
        
        asistencia.setFechaModificacion(fecha);
        asistencia.setActividad(actividad);
        asistencia.setAsistencia(asistio);
        asistencia.setListaAsistencia(lista);
        
        
        IListaAsistenciaDAO listaAsistencia = new ListaAsistenciaDAO();
        
        assertEquals(true,listaAsistencia.guardarListaAsistencia(asistencia));
        
        
    }
    
}

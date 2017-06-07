package reglasnegocio.asesor;

import reglasnegocio.entidades.ListaAsistencia;

/**
 *
 * @author Leonardo
 */
public interface IListaAsistenciaDAO {
    public boolean guardarListaAsistencia(ListaAsistencia asistencia);
    public ListaAsistencia sacarListaAsistencia(String idActividad);
    public boolean verificarAntecedentes(String idActividad);
}

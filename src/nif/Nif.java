package nif;
/**
 * @author XavierCamps
 * @author Yeliene Hernández
 * @author Rita Cassiello
 * @author Jesús Cuevas
 * @author Pau Gaston
 */
public class Nif {
    
    char letra;
    int numero;
    String idDocumento;
    
    public static int tipoDoc (String idDocumento){
        
        int tipoDocumento=0;
        
        
        
        return tipoDocumento;
    }
    
    public static char calcularLetra (int numero){
        
        char letra = 0;    
    
    
    
        return letra;
    }
    
    public static boolean verificarLetra(int numero, char letra){
   
    
        boolean check = true;
        
    
    
        return check;
    
    }
/**
 * Método tipoEmpresa que determina el tipo de Empresa en función del
 * Nif/Cif (para personas jurídicas). En las personas jurídicas
 * la primera posición del nif/cif es una letra que determina la 
 * naturaleza jurídica:  
 * <ul>
 *  <li> A -- Sociedades anónimas.</li> 
 *  <li> B -- Sociedades de responsabilidad limitada.</li> 
 *  <li> C -- Sociedades colectivas.</li> 
 *  <li> D -- Sociedades comanditarias.</li> 
 *  <li> E -- Comunidades de bienes.</li> 
 *  <li> F -- Sociedades cooperativas.</li> 
 *  <li> G -- Asociaciones y fundaciones.</li>
 *  <li> H -- Comunidades de propietarios en régimen de propiedad horizontal.</li>
 *  <li> J -- Sociedades civiles.</li>
 *  <li> N -- Entidades no residentes.</li>
 *  <li> P -- Corporaciones locales.</li>
 *  <li> Q -- Organismos autónomos, estatales o no, y asimilados.</li>
 *  <li> R -- Congregaciones e instituciones religiosas </li>
 *  <li> S -- Órganos de la Administración del Estado ycomunidades autónomas </li> 
 *  <li> U -- Uniones Temporales de Empresas.</li> 
 *  <li> V -- Sociedad Agraria de Transformación.</li>
 *  <li> W -- Establecimientos permanentes de entidades no residentes en España </li>
 * </ul>
 * @param idDocumento Es una cadena con el Nif/Cif a evaluar
 * @return            El tipo de entidad con el valor de la primera posicion de
 *                    la cadena idDocumento, si este se encuentra en la lista
 *                    de letras de nif correspondientes a personas jurídicas. 
 *                    En caso contrario, no es persona jurídica devuelve un espacio (' '). 
 */
    
    public static char tipoEmpresa (String idDocumento){
        // variable de retorno
        char tipoEntidad = ' ';
        // lista de letras de nif a buscar
        String letras = "AaBbCcDdEeFfGgHhJjPpQqRrSsUuVvWw";
        // asigna el valor de la primera posición de la cadena, si este se
        // encuentra en la lista de letras de nif, en caso contrario asigna
        // un espacio (' ').
        for (int i = 0; i < letras.length(); i++) {
            if (idDocumento.charAt(0) == letras.charAt(i)) {
                tipoEntidad = letras.charAt(i);
            }
        }
        return tipoEntidad;
        
    }
}

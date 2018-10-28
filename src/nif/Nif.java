package nif;
/**
 * @author Pau Gastón
 * @author Yeliene Hernández
 * @author Rita Cassiello
 * @author Jesús Cuevas
 * @author Xavier Camps
 */
public class Nif {
    
    char letra;
    int numero;
    String idDocumento;
    
    /**
    Creamos una función privada que devuelve true si la última letra se 
    encuentra en la lista de letras del DNI, en caso contrario devuelve
    false
    * @param idDocumento Cadena de caracteres introducidos por el usuario
    * @return Devuelve true o false después de verificar si es DNI.
    */
    private static boolean esDNI (String idDocumento){
       
        //Lista de letras del DNI
        String letrasDNI="TtRrWwAaGgMmYyFfPpDdXxBbNnJjZzSsQqVvHhLlCcKkEe"; 
                   
        /*
        Usamos el método length que nos devuelve la longitud y el método charAt
        que nos devuelve el caracter de la última posición del DNI.
        */
        String ultimaLetra = Character.toString(idDocumento.charAt(idDocumento.length() -1)); 
           
        if(letrasDNI.contains(ultimaLetra)){
           
            return true;
        }
                     
        return false;
       
    }
   
    /**
    Función que nos devuelve true si el documento contiene en la primera posición
    las letras X, Y ó Z. En caso contrario devuelve un false.
    * @param idDocumento Cadena de caracteres introducidos por el usuario
    * @return Devuelve true o false después de verificar si es NIE.
    */
    private static boolean esNIE (String idDocumento){
   
        if(idDocumento.charAt(0)== 'X' ||
           idDocumento.charAt(0)== 'Y'||
           idDocumento.charAt(0)== 'Z'){
           
            return true;
        }  
       
        return false;  
             
    }
   
    /**
    Función que devuelve true si la primera letra está en la lista de letras,
    em caso contrario devuelve false.
    * @param idDocumento Cadena de caracteres introducidos por el usuario
    * @return Devuelve true o false después de verificar si es CIF.
    */
    private static boolean esCIF (String idDocumento){
        
        //Lista de letras del NIF
        String letrasNIF="AaBbCcDdEeFfGgHhJjPpQqRrSsUuVvWw"; 
        
        /*
        Usamos el método charAt que nos devuelve el caracter de la posición
        que le hemos indicado.
        */   
        String primeraLetra = Character.toString(idDocumento.charAt(0));
        
        /*
        Con esta condición, en caso de que se cumpla nos devolverá un true, sino
        devolverá un false.
        */
        if(letrasNIF.contains(primeraLetra)){ 
            
            return true;
        }
                     
        return false; //
       
    }
 
    /**
    Método que devuelve el tipo de documento DNI, NIE ó CIF
    * @param idDocumento Es una cadena con el Nif/Cif a evaluar
    * @return Devuelve el tipo de documento en función de los datos
    * enviados.
    */
    public static int tipoDoc (String idDocumento){
       
        int tipoDocumento=0;
       
        //Llamo a la función esDNI
        if(esDNI(idDocumento)) {
           
            //Le asignamos un valor a TipoDocumento "1" para DNI
            tipoDocumento=1; 
        }
       
        //Llamo a la función esNIE
        if(esNIE(idDocumento)) {
           
            //Le asignamos un valor a TipoDocumento "2" para NIE
            tipoDocumento=2; 
        }
       
        //Llamo a la función esNIF.
        if(esCIF(idDocumento)) {
           
            //Le asignamos un valor a TipoDocumento "3" para NIF
            tipoDocumento=3; 
        }
             
        //Retornará tipoDocumento (1 ó 2 ó 3).
        return tipoDocumento; 
    }
    
    /**
    * Esta función devuelve dado un número de DNI la letra que le corresponde,
    * asigna el resto de dividir el número de dni por 23 y el resultado es una
    * posición de una tabla donde le corresponde la letra.
    * @param numero Es una cadena con el Nif/Cif a evaluar
    * @return Devuelve la letra correspondiente a la numeración introducida.
    */    
    public static char calcularLetra (int numero){
        
        char letra;
        /* Creo el siguiente string donde
        recreeo la tabla de equivalencias, para una vez tenga el resultado del
        resto, será la posición de la letra con el método charAt.
        */
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE"; 
        
        numero = numero % 23;
        
        letra = letrasDNI.charAt(numero);
        
        return letra;
    }
    
    /**
    *Función que verifica si la letra del DNI introducida por el usuario
    *es la correcta. Devuelve un booleano true si es correcta y false si es
    *errónea 
    * @param numero
    * @param letra
    * @return Devuelve un valor booleano en función de si la letra introducida
    * es válida o no.
    */
    public static boolean verificarLetra(int numero, char letra){
        
        /* Variable String que contiene la tabla de equivalencias de letra,
        una vez verificamos si el resto del nro de DNI dividido 23 dá la
        posición de la letra con el metodo CharAt().
         */
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        //Declaramos una variable char comparativa
        char letraValida; 
        boolean check = false;
 
        /*
        Función que calcula la letra de un DNI y la guarda en la variable
        letraValida
        */
        numero = numero % 23;
        letraValida = letrasDNI.charAt(numero);
 
        //Comparamos si el char del usuario es igual a la letraValida
        if (letra == letraValida) {
            check = true;
 
        }
 
        return check;

    }
    
    /**
    * Método que determina el tipo de Empresa en función del
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
    * @return El tipo de entidad con el valor de la primera posicion de
    * la cadena idDocumento, si este se encuentra en la lista
    * de letras de nif correspondientes a personas jurídicas. 
    * En caso contrario, no es persona jurídica devuelve un espacio (' '). 
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

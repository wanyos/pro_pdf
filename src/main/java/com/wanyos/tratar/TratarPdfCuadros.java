
package com.wanyos.tratar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanyos
 */
public class TratarPdfCuadros {
    
    private List<String> datos_pdf_leidos;
    private List<String> nombres_cuadros;   //guarda el nombre de cada cuadro por el orden de lectura
    private LeerPdf lpdf;
    private List<String> datos_pdf;
    
    
    public TratarPdfCuadros(String ruta, String nombre_archivo){
        nombres_cuadros = new ArrayList<>();
        lpdf = new LeerPdf(ruta, nombre_archivo);
        datos_pdf = lpdf.getDatosPdf();
        this.setDatosPdf(datos_pdf);
    }
    
    /**
     * Devuelve una lista con cabecera de los cuadros leidos por pdf
     * En un pdf puede existir más de un cuadro
     * @return 
     */
    public List<String> getCuadrosLeidosPdf(){
        return this.datos_pdf_leidos;
    }
    
    public List<String> getNombresCuadros(){
        return this.nombres_cuadros;
    }
    
    /**
     * Quita la cabecera que temga cada cuadro del pdf
     * En un pdf puede existir más de un cuadro
     * @return 
     */
    public List<String> getCuadroSinCabecera(){
        List<String> datos_pdf = new ArrayList<>();
        if(datos_pdf_leidos != null){
            for(String aux: datos_pdf_leidos){
                if(Character.isDigit(aux.charAt(0)) || aux.equals(";")){
                    datos_pdf.add(aux);
                }
            }
        }
        return datos_pdf;
    }
    
    
    private void setDatosPdf(List<String> datos){
        if(datos != null){
            List<String> lines_cut = cutLines(datos);
            List<String> extract_lines = extractLines(lines_cut);
            datos_pdf_leidos = delimitarCuadros(extract_lines);
        }
    }
    
    
    /**
     * Corta cada String de la lista por saltos de línea
     * elimina espacios en blanco al principio, final y entre palabras
     * convierte todas las lineas a minusculas
     * no incluye String vacíos
     * para separar los archivos incluye una línea con ; al inicio
     * @return 
     */
    private List<String> cutLines(List<String> datos_pdf) {
        List<String> lines_format = new ArrayList<>();
        if (!datos_pdf.isEmpty()) {
            for (String aux : datos_pdf) {
                String[] part = aux.split("\n");
                for (int a = 0; a < part.length; a++) {
                    String line = part[a].replace(" ", "").trim().toLowerCase();
                    if(!line.isEmpty()){
                      lines_format.add(line);  
                    }
                }
                lines_format.add(";");
            }
        }
        return lines_format;
    }

    
    /**
     * Separa las lineas con el siguiente formato:
     * nombre de la estación
     * nombre cuadro, línea, tipo de cuadro
     * solo admite lineas que contienen turnos
    */
    private List<String> extractLines(List<String> datos) {
        List<String> extraer_tratados = new ArrayList<>();
        int contador = 0;

        if (!datos.isEmpty()) {
            for (int a = 0; a < datos.size(); a++) {
                if (datos.get(a).startsWith("c.o.")) {
                    extraer_tratados.add(datos.get(a).trim());
                    contador++;
                }
                if (datos.get(a).startsWith("división")) {
                    String[] d = datos.get(a).split("y");
                    extraer_tratados.add(d[1].trim());
                    contador++;
                }
                if (datos.get(a).startsWith("linea")) {
                    String [] cabecera = this.getCabecera(datos.get(a));
                    extraer_tratados.add(cabecera[0]);
                    contador++;
                    String t = extraer_tratados.get(extraer_tratados.size()-2);
                    String t_aux = t.concat("_").concat(cabecera[2]);
                    nombres_cuadros.add(t_aux);
                    extraer_tratados.set(extraer_tratados.size()-2, t_aux);
                    extraer_tratados.add(cabecera[1]);
                    contador++;
                }

                if (contador == 4) {
                    contador = a;
                    boolean fin_cuadro = false;
                    while (contador < datos.size() && !fin_cuadro) {
                        if (this.isTurno(datos.get(contador))) {
                            extraer_tratados.add(datos.get(contador));
                        } else if (datos.get(contador).startsWith(";")) {
                            //marca el fin de una hoja. Hay que ver si empieza otro cuadro o continua el mismo
                            //hay que llegar hasta el primer turno de esa hoja y ver si es mayor que el anterior leido
                            int c = contador;
                            while (c < datos.size() && !this.isTurno(datos.get(c))) {
                                c++;
                            }
                            if (c >= datos.size()) {
                                c = datos.size() - 1;
                            }
                            if (getPosTurno(extraer_tratados.get(extraer_tratados.size() - 1), datos.get(c)) == -1) {
                                contador = c - 1;
                            } else {
                                a = contador;
                                contador = -1;
                                extraer_tratados.add(";");
                                fin_cuadro = true;
                            }
                        }
                        contador++;
                    }
                }
            }
        }
        return extraer_tratados;
    }
    
    
    /**
     * Corta en tres partes la linea del parámetro
     * linea, cuadro, tipo de dia
     * @param line linea completa con los tres datos
     * @return 
     */
    private String[] getCabecera(String line) {
        String[] cabecera = new String[3];

        //crea un espacio en blanco al final de la palabra
        String linea = line.substring(0, 5) + " ";
        String cuadro = line.substring(line.indexOf("cuadro"), line.indexOf("cuadro") + 6) + " ";

        linea = linea.concat(line.substring(5, line.indexOf("cuadro")));
        cuadro = cuadro.concat(line.substring(line.indexOf("cuadro") + 7, line.indexOf("tipo")));
        cabecera[0] = linea;
        cabecera[1] = cuadro;
        cabecera[2] = line.substring(line.indexOf("tipo") + 9, line.length());

        return cabecera;
    }
    
    
    /**
     * Comprueba si la linea es un turno
     * Para ello los tres primeros caracteres deben ser digitos
     * @param line
     * @return 
     */
    private boolean isTurno(String line) {
        String sub;
        boolean correcto = true;
        if (line.length() < 3) {
            return false;
        }
        sub = this.extractTurno(line);
        int contador = 0;
        while (correcto && contador < sub.length()) {
            if (Character.isDigit(sub.charAt(contador))) {
                contador++;
            } else {
                correcto = false;
            }
        }
        return correcto;
    }
    

    /**
     * Devuelve -1 si el turno1 es anterior al turno2
     * @param t1
     * @param t2
     * @return 
     */
    private int getPosTurno(String t1, String t2) {
        int a = 0;
        try {
            String t1_aux = this.extractTurno(t1);
            String t2_aux = this.extractTurno(t2);

            int uno = Integer.parseInt(t1_aux);
            int dos = Integer.parseInt(t2_aux);

            if (uno < dos) {
                a = -1;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
        return a;
    }
    
    
    /**
     * Extrae los tres primeros caracteres de la línea del turno
     * @param t
     * @return 
     */
    private String extractTurno(String t) {
        String turno = "";
        if (t.length() > 3) {
            if (t.startsWith("p") || t.startsWith("s")) {
                turno = t.substring(1, 4);
            } else {
                turno = t.substring(0, 3);
            }
        }
        return turno;
    }
    
    
    /**
     * El final de un cuadro se delimita por ";"
     * cada línea del cuadro se separa por campos
     * @return 
     */
    private List<String> delimitarCuadros(List<String> lines_cut) {
        List<String> datos_delimitados = new ArrayList<>();
        if (!lines_cut.isEmpty()) {
            for (int a = 0; a < lines_cut.size(); a++) {
                if (lines_cut.get(a).startsWith("c.o.")) {
                    datos_delimitados.add(lines_cut.get(a++));
                    datos_delimitados.add(lines_cut.get(a++));
                    datos_delimitados.add(lines_cut.get(a++));
                    datos_delimitados.add(lines_cut.get(a++));
                    
                    for (int b = a; b < lines_cut.size(); b++) {
                        if (lines_cut.get(b).startsWith(";")) {
                            a = --b;
                            datos_delimitados.add(";");
                            break;
                        } else {
                            String ln = this.getFormatLinea(lines_cut.get(b));
                            if (ln != null) {
                                datos_delimitados.add(ln);
                            }
                        }
                    }
                }
            }
        }
        return datos_delimitados;
    }

    
    /**
     * Separa una línea por campos
     * @param l
     * @return 
     */
    private String getFormatLinea(String l) {
        String li_format;
        try {
            int init = 0;
            if (l.startsWith("p0") || l.startsWith("s0")) {     //puede empezar por P0 o S0 
                init = 1;
            }
            if (init == 0) {
                li_format = l.substring(init, init + 3).concat(";");                         //si no se añadio nada
            } else {
                li_format = l.substring(init, init + 3).concat(";");                        //turno 
            }
            int h1 = l.indexOf(":", init);                                              //número de caracter de la 1º hora
            li_format = li_format.concat(l.substring(h1 - 5, h1 - 2)).concat(";");      //vamos hacia atras y coge coche cuadro, evitando X
            li_format = li_format.concat(l.substring(h1 - 2, h1 + 3)).concat(";");          //añade primer horario
            int h2 = l.indexOf(":", h1 + 1);                                             //segunda hora desde la anterior
            li_format = li_format.concat(l.substring(h1 + 3, h2 - 2)).concat(";");         //añade lo que tenga antes de la segunda hora
            li_format = li_format.concat(l.substring(h2 - 2, h2 + 3)).concat(";");         //añade el segundo horario
            int h3 = l.indexOf(":", h2 + 1);                                             //tercera hora desde la anterior
            li_format = li_format.concat(l.substring(h2 + 3, h3 - 2)).concat(";");         //añade lo que tenga antes del tercer horario
            li_format = li_format.concat(l.substring(h3 - 2, h3 + 3)).concat(";");         //añande el tercer horario
            li_format = li_format.concat(l.substring(h3 + 3, l.length()));               //añade el final de la cadena
        } catch (Exception e) {
            return null;
        }
        return li_format;
    }
    
    
    
    
    

}

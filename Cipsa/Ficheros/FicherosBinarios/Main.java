package FicherosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		Persona persona = new Persona ();
        
        // Asignamos los valores que queramos a cada persona
        persona.setDni("1234678A");
        persona.setNombre("María");
        persona.setEdad(34);
         
        // Creamos un objeto de tipo fila para asignarle un archivo
        File archivo = new File("C:/Users/userg/Documents/CIPSA/escritura.dat");
         
        try {
            // Para poder escribir utilizaremos un FileOutputStream pasandole
            // como referencia el archivo de tipo File.
            FileOutputStream fos = new FileOutputStream(archivo);
             
            // Y crearemos también una instancia del tipo ObjectOutputStream
            // al que le pasaremos por parámetro
            // el objeto de tipo FileOutputStream
            ObjectOutputStream escribir = new ObjectOutputStream(fos);
             
            // Escribimos los objetos en el archivo.
            escribir.writeObject(persona);
             
            // Cerramos los objetos para no consumir recursos.
            escribir.close();
            fos.close();
             
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo. "
                    + e.getMessage());   
        }
        
     // Creamos un objeto de tipo fila para asignarle un archivo
        archivo = new File("C:/Users/userg/Documents/CIPSA/escritura.dat");
         
        try {
            // Para poder leer utilizaremos un FileInputStream pasandole
            // como referencia el archivo de tipo File.
            FileInputStream fis = new FileInputStream(archivo);
             
            // Declaramos una variable objeto del tipo ObjectInputStream
            ObjectInputStream leer;
             
            // Creamos un bucle para leer la información
            // Mientras haya bytes en el archivo.
            while(fis.available()>0){
                leer= new ObjectInputStream(fis);
                 
                // En una variable objeto de tipo Persona almacenaremos
                // el objeto leido de tipo Object convertido en un objeto
                // de tipo persona
                Persona personaLeida= (Persona) leer.readObject();
                 
                // Imprimimos el objeto leido en consola
                System.out.println(personaLeida);   
            }
             
        } catch (Exception e) {
            System.out.println("Error al leer el archivo. "
                    + e.getMessage());   
        }

	}

}

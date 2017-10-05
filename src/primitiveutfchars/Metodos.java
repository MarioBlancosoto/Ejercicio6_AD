
package primitiveutfchars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Metodos {
    String cadea =" Esta e unha cadea\n";
    String letras="";
    String ruta="/home/local/DANIELCASTELAO/mblancosoto/NetBeansProjects/PrimitiveUtfChars/text3.txt";
    DataOutputStream dos;
    DataInputStream dis;
    
    
    public void entSal(){
           
        try {
             dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)));
             dis = new DataInputStream(new BufferedInputStream(new FileInputStream(ruta)));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void escribirUtfChar(){
       
        try {
            
            for(int i=0;i<3;i++){
            
             dos.writeUTF(cadea);
                 System.out.println("WriteUTF Escribiu :"+cadea);
                System.out.println("WriteUTF escribiu : "+dos.size());
            if(i==2){
           dos.writeChars(cadea);
                System.out.println(" WriteChars Escribiu "+dos.size()+ " bytes" );
            }
                  
                System.out.println("");  
            }
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}


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
    String cadea ="Esta e unha cadea\n";
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
       
        int bytes =0;
        int total =0;
        
        try {
            
            for(int i=0;i<3;i++){
                
            if(i==1){
                 
                 dos.writeChars(cadea);
                 System.out.println("WriteChars Escribiu :"+cadea);
                 System.out.println(" WriteChars Escribiu "+(dos.size()-bytes)+ " bytes" );
                 bytes += dos.size()-bytes;
            }else{
             
                 dos.writeUTF(cadea);
                 System.out.println("WriteUTF Escribiu :"+cadea);
                 System.out.println("WriteUTF escribiu : "+(dos.size()-bytes)+" Bytes "); 
                 bytes +=dos.size()-bytes;
             }
          
           
                  
                System.out.println("Bytes Totais Escritos = "+dos.size());  
            }
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dos.close();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ler(){
           int disponible=0;
           int actual=0;
        try {
            
              for(int i=0;i<3;i++){
                actual +=dis.available();
                
            if(i==1){
                 disponible +=dis.available();
                 for(int j=0;j<18;j++){
                 letras += dis.readChar();
                 
                }
                 
            }else{
               
                  
                 if(i==0){
                 System.out.println("Lemos a primeira cadea en UTF :\n"+dis.readUTF());
                 System.out.println("Número de bytes lidos = "+(actual-dis.available()));
                 System.out.println("Bytes restantes por ler :"+dis.available());
                 }else{
                     System.out.println("Lemos a segunda cadea Chars :");   
                     System.out.println(letras);
                     System.out.println("Número de bytes lidos : "+(disponible-dis.available()));
                     System.out.println("Bytes restantes por ler :"+dis.available());
                 }
                
                 
             }
              }  
         
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            dis.close();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
}

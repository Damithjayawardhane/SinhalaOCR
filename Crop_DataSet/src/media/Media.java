/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package media;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 *
 * @author Damith Jayawardhane
 */
public class Media {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            int pos_x=946;
            
            for(int i=0;i<18;i++){
            
                File fols=new File("C:\\Users\\Damith Jayawardhane\\Desktop\\padded-images\\"+(i+1)+"\\");
                fols.mkdirs();
                
                
                Thumbnails.of("C:\\Users\\Damith Jayawardhane\\Desktop\\Dataset-04.jpg")
                    .crop(Positions.CENTER).sourceRegion(pos_x, 60, 116, 116).size(116, 116)        
                    .toFile("C:\\Users\\Damith Jayawardhane\\Desktop\\padded-images\\"+(i+1)+"\\1.jpg");
                
                pos_x=pos_x+118;
                
                System.out.println(i+1+" Created");
            }
            
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Media.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

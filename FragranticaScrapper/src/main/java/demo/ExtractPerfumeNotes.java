package demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;

import java.io.*;

/**
 * Created by MJ00479956 on 6/2/2017.
 */
public class ExtractPerfumeNotes {
    public static void main(String[] args) throws IOException, NotFound, ResponseException, InterruptedException {
        //Read files from directory
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("D:/Fragrantica");
        File[] files = file.listFiles();
        //Iterate files
        for(File perfumeHouseFile : files){
            System.out.println("Reading: "+perfumeHouseFile.getName());
            //Read files line by line
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(perfumeHouseFile)));
            String url;
            while((url = reader.readLine()) != null){
                //Hit URLs on each line
                // Extract notes from perfume
                Perfume perfume = ExtractNotesFromPerfume.extrateNoteFromPerfume(url);
                //Write Json Object to file.
                String perfumeName = perfume.getPerfumeName();
                perfumeName = perfumeName.replaceAll("\\*","");
                mapper.writeValue(new File("D:/Fragrantica/Perfumes/"+perfume.getBrandName()+"_"+perfumeName+".json"), perfume);
                Thread.sleep(15000);
            }

            reader.close();
            System.out.println("All perfumes done for: "+perfumeHouseFile.getName());
            perfumeHouseFile.delete();
        }
    }
}

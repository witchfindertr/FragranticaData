package demo;

import java.io.*;
import java.util.List;

/**
 * Created by MJ00479956 on 5/29/2017.
 */
public class PerfumesList {
    public static void main(String[] args) throws Exception {
        File file = new File("D:/Fragrantica/List_of_houses.txt");
        BufferedReader reader =  new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String perfumeHouseUrl;
        while((perfumeHouseUrl = reader.readLine()) != null){
            String[] perfumeHouseNameParts = perfumeHouseUrl.split("/");
            String perfumeHouseName = perfumeHouseNameParts[perfumeHouseNameParts.length - 1].replace(".html","");

            System.out.println("Fetching data for " + perfumeHouseName);
            List<String> perfumeLinks = PerfumesByHouse.getPerfumesByHouse(perfumeHouseUrl);

            System.out.println("Data fetched for " + perfumeHouseName);
            System.out.println("Writing data to file");
            File perfumeLinksByHouse = new File("D:/Fragrantica/"+perfumeHouseName+".txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(perfumeLinksByHouse)));
            for(String link : perfumeLinks){
                writer.append(link);
                writer.append("\n");
            }
            System.out.println("Data written to file");
            writer.close();
        }

        reader.close();
    }
}

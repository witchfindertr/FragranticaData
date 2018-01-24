package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaunt.*;

/**
 * Created by MJ00479956 on 6/1/2017.
 */
public class ExtractNotesFromPerfume {
    public static Perfume extrateNoteFromPerfume(String perfumeUrl) throws ResponseException, NotFound, JsonProcessingException {
        String url = perfumeUrl;
        UserAgent userAgent = new UserAgent();
        userAgent.setProxyHost("10.3.6.247");
        userAgent.setProxyPort(3128);
        userAgent.visit(url);
        Perfume perfume = new Perfume();

        Elements brandNameSpan =  userAgent.doc.findEvery("<span itemprop=\"name\"");
        int count = 0;
        for(Element e : brandNameSpan){
            if(count == 0){
//                System.out.print("Brand Name: ");
                perfume.setBrandName(e.getText());
                count++;
            }else{
//                System.out.print("Product Name: ");
                perfume.setPerfumeName(e.getText());
            }
            System.out.print(e.getText() + " ");
        }

        Element pyramidDiv = userAgent.doc.findFirst("<div id=\"pyramid\">");
        Element parentDiv = pyramidDiv.getParent();
        Elements pyramid = parentDiv.findEvery("<p>");
        for(Element el : pyramid){
            //System.out.println(el.innerHTML());
            if(el.innerHTML().contains("Top Notes")){
//                System.out.println("Top Notes:");
                Elements notes = el.findEvery("<img>");
                for(Element note : notes){
//                    System.out.println(note.getAt("alt"));
                    perfume.getTopNotes().add(note.getAt("alt"));
                }
            } else if (el.innerHTML().contains("Middle Notes")){
//                System.out.println("Middle Notes:");
                Elements notes = el.findEvery("<img>");
                for(Element note : notes){
//                    System.out.println(note.getAt("alt"));
                    perfume.getMiddleNotes().add(note.getAt("alt"));
                }
            }else  if(el.innerHTML().contains("Base Notes")){
//                System.out.println("Base Notes:");
                Elements notes = el.findEvery("<img>");
                for(Element note : notes){
//                    System.out.println(note.getAt("alt"));
                    perfume.getBaseNotes().add(note.getAt("alt"));
                }
            } else{
//                System.out.println("General Notes:");
                Elements notes = el.findEvery("<img>");
                for(Element note : notes){
//                    System.out.println(note.getAt("alt"));
                    perfume.getNotes().add(note.getAt("alt"));
                }
            }
        }

        System.out.println();
        return perfume;

    }
}

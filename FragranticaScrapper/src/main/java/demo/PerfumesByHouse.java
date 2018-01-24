package demo;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.UserAgent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJ00479956 on 5/29/2017.
 */
public class PerfumesByHouse {
    public static List<String> getPerfumesByHouse(String houseUrl) throws Exception{
        String url = houseUrl;
        UserAgent userAgent = new UserAgent();
        userAgent.setProxyHost("10.3.6.247");
        userAgent.setProxyPort(3128);
        userAgent.visit(url);
        List<String> links = new ArrayList<String>();

        Elements divs = userAgent.doc.findEach("<div class=\"perfumeslist\">");

        for(Element e : divs){
            Element el = e.findEvery("<a");
            String urls = el.innerHTML();
            String[] urlParts = urls.split("\"");
            System.out.println(urlParts[1]);
            links.add(urlParts[1]);
        }
        return links;
    }
}

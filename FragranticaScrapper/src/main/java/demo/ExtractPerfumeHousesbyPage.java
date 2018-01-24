package demo;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.Node;
import com.jaunt.UserAgent;

import java.util.List;

/**
 * Created by MJ00479956 on 5/29/2017.
 */
public class ExtractPerfumeHousesbyPage {

    public static void main(String[] args) throws Exception{
        String url = "https://www.fragrantica.com/designers-11/#T";
        UserAgent userAgent = new UserAgent();
        userAgent.setProxyHost("10.3.6.247");
        userAgent.setProxyPort(3128);
        userAgent.visit(url);

        Elements divs = userAgent.doc.findEach("<div class=\"nduList\">");

        for(Element e : divs){
            Element el = e.findEvery("<a");
            String urls = el.innerHTML();
            String[] urlParts = urls.split("\"");
            System.out.println(urlParts[1]);

        }

    }
}

package demo;

import com.jaunt.*;

/**
 * Created by MJ00479956 on 5/3/2017.
 */
public class FirstClass {

    public static void main(String[] args) throws ResponseException, NotFound {
        String url = "https://www.fragrantica.com";
        UserAgent userAgent = new UserAgent();
        userAgent.setProxyHost("10.3.6.247");
        userAgent.setProxyPort(3128);
        userAgent.visit(url);
        Elements alphabetLinks = userAgent.doc.findFirst("<div id=\"ndalphabet\">").findEvery("<a>");
        Elements alphabetLinksWithSpan = userAgent.doc.findFirst("<div id=\"ndalphabet\">").findEvery("<span>");

        for(Element link : alphabetLinks){
            System.out.println(link.getAt("href"));
        }

        for(Element span : alphabetLinksWithSpan){
            System.out.println(url + span.getAt("title"));
        }
    }
}

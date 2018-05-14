

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "jSFManagedBean")
@RequestScoped
public class JSFManagedBean {

    private String URL = "http://daily.digpro.se/bios/servlet/bios.servlets.web.RecruitmentTestServlet";
    String returnData;
    
  static  ArrayList<Mapping> coord = new ArrayList<>();
   
    public JSFManagedBean() {
    }
    
    public String getContent() throws MalformedURLException, IOException {
        URL url = new URL(URL);
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));
        String line;
        returnData = "";
        while ((line = br.readLine()) != null) {
            if (line.contains("#")) {
                continue;
            }
            returnData += line + "\n";
        }
        return returnData;
    }
    
    public void updateData() throws IOException{
        String[] $lines = getContent().split("\n");
        if(!coord.isEmpty()){
            coord.clear();
        }
        
        for (String $line : $lines) {
            $line = $line.replaceAll("\\s+","");
            coord.add(new Mapping(parseInt($line.split(",")[0]),parseInt($line.split(",")[1]),$line.split(",")[2]));
        }
        System.out.println(coord);
    }

    public ArrayList<Mapping> getCoord() {
        return coord;
    }

    public void setCoord(ArrayList<Mapping> coord) {
        this.coord = coord;
    }
 
    }

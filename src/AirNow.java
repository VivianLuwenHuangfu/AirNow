


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;

public class AirNow {
	
	
	public static void main(String[] args) {
		
		String urlString = "http://www.airnowapi.org/aq/data/?startDate=2015-05-04T22&endDate=2015-05-04T23&parameters=O3,PM25,PM10,CO,NO2,SO2&BBOX=-124.205070,28.716781,-75.337882,45.419415&dataType=A&format=text/csv&API_KEY=269106BB-33F7-40D2-9989-9952D8D69D70";
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3_6);
		WebResponse webResponse = null;
		try {
			URL url = new URL(urlString);
			webResponse = webClient.loadWebResponse(new WebRequest(url));
			webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(new File("result.csv")));
			bw.write(webResponse.getContentAsString("utf-8"));
			bw.flush();
			bw.close();
			
			Thread.sleep((int)(5000*Math.random()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}
}
		
				
								



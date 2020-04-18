import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

public class SendSMS {
	
	public static void sendSms(String message,String number)
	{
		
		
//		System.out.println(message);
//		System.out.println(number);
		try
		{
		
		String apiKey="WrHbtOfLe1iEDZKI3Nk0aR2jlSAsyT4xQBqCp7dvV5YwmPnUuG75rK1R4GfNM0zDwUQjY9VL3knyHupF";
		String sendId="FSTSMS";
		//important step...
		message=URLEncoder.encode(message, "UTF-8");
		String language="english";
		
		String route="p";
		
		
		String myUrl="https://www.fast2sms.com/dev/bulk?authorization="+apiKey+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;
		
		//sending get request using java..
		
		URL url=new URL(myUrl);
		
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		System.out.println("Wait..............");
		
		int code=con.getResponseCode();
		
		System.out.println("Response code : "+code);
		
		StringBuffer response=new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line=br.readLine();
			if(line==null)
			{
				break;
			}
			response.append(line);
		}
		
		System.out.println(response);
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Program started.....");
		Random rand = new Random(); 
		  
        // Generate random integers in range 0 to 9999
        int otp = rand.nextInt(10000); 
        
		SendSMS.sendSms("Hii Topper sent By Harshit Sachdeva through Java. Your otp is " + otp, "9138256325");
		//SendSMS.sendSms("Rs 10,000 has been debited from your bank account", "9");
		
	}
}
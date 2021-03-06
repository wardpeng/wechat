import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;

public class ProcessorGetFollowerIdsList
{
	public static String[] run()
	{
		Utility.SetProxy();
		
		byte[] authEncBytes = Base64.encodeBase64(Constant.strAuthorization.getBytes());
		String authStringEnc = new String(authEncBytes);

		String strFullURL = Constant.strFollowersIdJson + "?source=" + Constant.strAppKey + "&screen_name=" 
		 + Constant.strScreenName;
		
		URL url;
		StringBuffer sb = new StringBuffer();
		try 
		{
			url = new URL(strFullURL);
			URLConnection urlConnection;
			urlConnection = url.openConnection(); 
			urlConnection.setRequestProperty("Authorization", "Basic "+ authStringEnc);
			urlConnection.setRequestProperty("Accept-Charset", "UTF-8"); 
			InputStream is = urlConnection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			int numCharsRead;
			char[] charArray = new char[Constant.MaxLine];
			while ((numCharsRead = in.read(charArray)) > 0) 
			{
				sb.append(charArray, 0, numCharsRead);
			}
		
			in.close();
		}
		catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Utility.getFollowupID(sb.toString());
	}
}
package glass.eyelead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteData {
	
	JSONArray json_r;
	Vector<Coords> coordsVector;		
	

	public RemoteData() throws JSONException{
		
		json_r = getRemoteJson();
		
	}
	
	public JSONArray getRemoteJson() throws JSONException{
		String url2Fetch = "";
		JSONArray jsonArry = null;
		//String address=((EditText)findViewById(R.id.textBox)).getText().toString();
	       //  mTextView=(TextView)findViewById(R.id.text);
	        HttpClient client=new DefaultHttpClient();
	        HttpGet request=new HttpGet(url2Fetch);
	        try
	        {
	            HttpResponse response= client.execute(request);
	            HttpEntity entity= response.getEntity();
	            InputStreamReader in=new InputStreamReader(entity.getContent());
	            BufferedReader reader=new BufferedReader(in);
	 
	            StringBuilder stringBuilder=new StringBuilder();
	            String line ="";
	 
	            while ((line=reader.readLine())!=null)
	            {
	                  stringBuilder.append(line);
	 
	            }
	 
	            jsonArry=new JSONArray(stringBuilder.toString());
	            JSONObject jsonObject;
	 
	            for(int i=0 ;i<jsonArry.length();i++)
	            {
	            	String [] s = new String[2];
	                jsonObject=jsonArry.getJSONObject(i);
	                s[0] = jsonObject.getString("nombre");
	                s[1] = jsonObject.getString("imagen");
	                double lat = jsonObject.getDouble("latitude");
	                double lon = jsonObject.getDouble("latitude");
	                Coords coor = new Coords(lat,lon,s);
	                coordsVector.add(coor);
	            }
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
		
		return jsonArry;
	}
	
	public Vector<Coords> getCoordsVector(){
		
		return coordsVector;
		
	}
	
}

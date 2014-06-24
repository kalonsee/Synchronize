/**
 * 
 */
package com.sync.ui.cloud;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * @author kalon
 * 
 */
public class LoginService
{

	public static String	url	= "http://localhost:8080/SyncService/login!login.do";

	public void login ( String account , String pwd ) throws Exception
	{//
		CloseableHttpResponse httpresponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault ();// HTTP
		try
		{
			HttpPost post = new HttpPost ( url );
			List<NameValuePair> namevaluepairs = new ArrayList<NameValuePair> ();
			namevaluepairs
					.add ( new BasicNameValuePair ( "account" , account ) );
			namevaluepairs.add ( new BasicNameValuePair ( "password" , "" + pwd ) );

			post.setEntity ( new UrlEncodedFormEntity ( namevaluepairs ) );
			httpresponse = httpclient.execute ( post );

			if ( httpresponse.getStatusLine ().getStatusCode () == 200 )
			{

				HttpEntity resEntity = httpresponse.getEntity ();//

			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		finally
		{
			if ( httpresponse != null )
			{
				httpresponse.close ();
				httpresponse = null;
			}

			if ( httpclient != null )
			{
				httpclient.close ();
				httpclient = null;
			}
		}
	}
}

package com.sync.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectByteArray
{

	@SuppressWarnings ( "finally" )
	public static byte[] objectToByteArray ( Object obj )
	{

		byte[] data = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream ();
		ObjectOutputStream oos = null;
		try
		{
			oos = new ObjectOutputStream ( baos );
			oos.writeObject ( obj );
			oos.flush ();
			data = baos.toByteArray ();
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
		finally
		{
			try
			{
				baos.close ();
				if ( oos != null )
					oos.close ();
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}

			return data;
		}
	}

	@SuppressWarnings ( "finally" )
	public static Object byteArrayToObject ( byte[] array )
	{
		Object obj = null;
		ByteArrayInputStream bais = new ByteArrayInputStream ( array );
		ObjectInputStream ois = null;
		try
		{
			ois = new ObjectInputStream ( bais );
			obj = ois.readObject ();

		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace ();
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
		finally
		{
			try
			{
				bais.close ();
				if ( ois != null )
					ois.close ();
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}

			return obj;
		}

	}

	public static InputStream objectToStream ( Object object )
	{
		InputStream stream = null;
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try
		{
			baos = new ByteArrayOutputStream ();
			oos = new ObjectOutputStream ( baos );
			oos.writeObject ( object );
			oos.flush ();
			stream = new ByteArrayInputStream ( baos.toByteArray () );
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
		finally
		{
			try
			{
				baos.close ();
				baos = null;
				if ( oos != null )
				{
					oos.close ();
					oos = null;
				}
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

		return stream;
	}

	@SuppressWarnings ( "finally" )
	public static Object streamToObject ( InputStream stream )
	{
		Object obj = null;
		ObjectInputStream ois = null;
		try
		{
			ois = new ObjectInputStream ( stream );
			obj = ois.readObject ();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace ();
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
		finally
		{
			try
			{
				stream.close ();
				if ( ois != null )
					ois.close ();
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}

			return obj;
		}
	}
}

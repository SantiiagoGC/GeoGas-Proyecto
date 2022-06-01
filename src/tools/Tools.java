package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Tools
{

	public static String leer ( String ruta )
	{

		String msn = "";

		try
		{
			FileReader input = new FileReader(getPath(ruta));
			BufferedReader buffer = new BufferedReader(input);
			String aux = "";

			while ( aux != null )
			{
				aux = buffer.readLine();
				msn += (aux == null) ? "" : aux;
			}

			buffer.close();
			input.close();

		} catch ( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IOException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msn;

	}

	public static void escribir ( String msn, String ruta, boolean bool )
	{
		try
		{
			FileWriter output = new FileWriter(getPath(ruta), bool);
			BufferedWriter buffer = new BufferedWriter(output);

			buffer.write(msn);
			buffer.flush();
			buffer.close();
		} catch ( IOException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void crearArchivo ( String ruta )
	{
		File f = new File(getPath(ruta));
		if ( !f.exists() )
		{
			try
			{
				f.createNewFile();
			} catch ( IOException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void crearFichero ( String ruta )
	{
		File f = new File(getPath(ruta));
		f.mkdirs();
		if ( !f.exists() )
		{
			try
			{
				f.createNewFile();
			} catch ( IOException e )
			{
				e.printStackTrace();
			}
		}
	}

	private static String getPath ( String ruta )
	{
		String raiz = System.getProperty("user.dir");
		String filePath = raiz + "/" + ruta;
		return filePath;
	}

}

package modelo;

import java.util.Random;
import tools.Tools;

public class Generador
{

	private Pais[] paises =
	{ new Pais("USA", aleatorio(10, 35)), new Pais("CANADA", aleatorio(10, 35)),
			new Pais("MEXICO", aleatorio(10, 35)), new Pais("HONDURAS", aleatorio(10, 35)),
			new Pais("SALVADOR", aleatorio(10, 35)) };

	private int[] fecha =
	{ 1, 1, 2016 };

	public Generador ()
	{
		archivosPlano();
	}

	private void archivosPlano ()
	{
		String archivo = "";
		int numRegistros = 0;
		for ( int k = 0; k < 7; k++ )
		{
			fecha[0] = k + 1;

			for ( int i = 0; i < paises.length; i++ )
			{
				//
				numRegistros = aleatorio(100, 350);
				archivo += fecha() + "#";

				for ( int j = 0; j < numRegistros; j++ )
				{
					archivo += aleatorio(paises[i].getPuntosV() - (paises[i].getPuntosV() - 1),
							paises[i].getPuntosV()) + "&"
							+ Gasolina.getGasolina(aleatorio(1, 4)) + ";" + aleatorio(5, 30)
							+ ";\n%";
				}

				paises[i].getArchivosPlanos().add(archivo);
				archivo = "";
			}
		}
	}

	public void guardarArchivos ()
	{
		String[] file = null, file1 = null, file2 = null;

		Tools.crearFichero("src/files");

		for ( int i = 0; i < paises.length; i++ )
		{
			for ( int j = 0; j < paises[i].getArchivosPlanos().size(); j++ )
			{
				file = paises[i].getArchivosPlanos().get(j).split("#");
				Tools.crearFichero("src/files/" + paises[i].getNombre() + "/" + file[0]);
				file1 = file[1].split("%");

				for ( int k = 0; k < file1.length; k++ )
				{
					file2 = file1[k].split("&");
					Tools.crearArchivo("src/files/" + paises[i].getNombre() + "/" + file[0]
							+ "/" + "puntoDeVenta_" + file2[0] + ".csv");
					Tools.escribir(file2[1], "src/files/" + paises[i].getNombre() + "/"
							+ file[0] + "/" + "puntoDeVenta_" + file2[0] + ".csv", true);
				}
			}
		}

	}

	public void imprimir ()
	{
		for ( int i = 0; i < paises.length; i++ )
		{
			System.out.print("\n" + paises[i].getNombre() + "\n");
			System.out.print(paises[i].getArchivosPlanos().toString() + "\n");
		}
	}

	private int aleatorio ( int i, int j )
	{
		Random n = new Random();
		return n.nextInt(j - i + 1) + i;
	}

	private String fecha ()
	{
		return fecha[0] + "." + fecha[1] + "." + fecha[2];
	}
}

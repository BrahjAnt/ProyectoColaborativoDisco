import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sText = new Scanner(System.in);
		Scanner sInteger = new Scanner(System.in);
		// Declaro un array de 10 objetos de tipo cancion.
		Cancion[] canciones = new Cancion[12];
		Disco[] disco = new Disco[5];
		DiscoRecopilatorio[] recopilatorio = new DiscoRecopilatorio[3];
		// Llamo al metodo que rellena el array de canciones con canciones reales
		Main.rellenarRecopilatorio(recopilatorio, disco);
		Main.rellenarCanciones(canciones);
		Main.rellenarDisco(disco, canciones);

		int opc = 0;
		do {
			// Llamo al metodo que muestra el menu de nuestra aplicaci�n.
			Main.mostrarMenu();
			opc = sInteger.nextInt();
			switch (opc) {
			case 1:
				showTitleCancion(canciones);
				break;
			case 2:
				showTitlexDuration(canciones);
				break;
			case 3:
				System.out.println("song's duration: " + showCancionLongDuration(canciones));
				break;
			case 4:
				showTitleCancion(canciones);
				break;
			case 5:
				System.out.println("the sum of song is " + showSumDurationSong(canciones));
				break;
			case 6:
				System.out.println("all duration of songs: ");
				double[] allDuration = showAllDurationSongs(canciones);
				for (int i = 0; i < allDuration.length; i++) {
					System.out.println(allDuration[i]);
				}
				break;
			case 7:
				System.out.println("insert disc's name");
				String name = sText.nextLine();
				showDiscxTittle(disco, name);
			case 8:
				System.out.println("insert song's name");
				String song = sText.nextLine();
				System.out.println("name of disc: ");
				System.out.println(showDiscxSong(disco, song));
				break;

			case 9:
				System.out.println("insert letter");
				String letter = sText.nextLine();
				String[] tittlesDisc = showDiscxLetter(disco, letter);

				for (int i = 0; i < tittlesDisc.length; i++) {
					System.out.println(tittlesDisc[i]);
				}
				break;

			case 10:
				Disco[] durationDisc = durationDisc(disco);
				for (int i = 0; i < durationDisc.length; i++) {
					System.out.println(durationDisc[i]);
				}
			case 11:
				System.out.println("insert song");
				song = sText.nextLine();
				System.out.println("number of times the song appears on multiple discs: " + numTimesSong(disco, song));
				break;
			case 12:
				showSongsDiscxLetterAE(disco);
				break;
			case 13:
				System.out.println("insert name of disc");
				name = sText.nextLine();
				cleanSongsDisc(disco, name);
				break;
			case 14:
				ShowRecopilatorio(recopilatorio);
				break;
			case 15:
			case 16:
				recoMoreDurationSong(recopilatorio);
				break;

			case 17:
				recolowerDurationSong(recopilatorio);
				break;
			case 18:
				tittleRecoMoreDuration(recopilatorio);
			case 19:
			case 20:
			case 21:
			case 22:
			}
		} while (opc != 22);

	}

	/**
	 * M�todo que muestra en pantalla el men� de opciones del ejercicio en el que
	 * est�s.
	 */
	public static void mostrarMenu() {
		System.out.println(
				"1. Mostrar todos los títulos de las canciones que hay en un array de canciones, unicamente los títulos, a modo de listado con las canciones numeradas, 1….2..3..4..."
						+ "\r\n2. Mostrar todos los títulos de las canciones que hay en un array de canciones pero solo de las canciones que su duración no exceda de 4 minutos."
						+ "\r\n3. Mostrar la duración de la canción con mayor longitud en el título que hay en un array de canciones, y puede que necesite mosrtar algún atributo más de esa canción."
						+ "\r\n4. Mostrar todos títulos de las canciones de un array de canciones separados por comas."
						+ "\r\n5. Mostrar la duración de la suma de todas las canciones de un array de canciones."
						+ "\r\n6. Mostrar todas las duraciones de todas las canciones de un array de canciones. (El método devolverá un array de duraciones)."
						+ "\r\n7. Mostrar los datos de las canciones de un disco que quiera el usuario de un array de discos, el usuario dará el título del disco. Los datos de las canciones se mostrarán de la siguiente manera:"
						+ "\r\nTitulo Cancion 1: Pausa - Duración: 1,4"
						+ "\r\nTitulo Cancion 2: El Baile - Duración: 2,4"
						+ "\r\n8. Momento mostrar el título del disco donde se encuentre un título de una canción pedida al usuario, de un array de discos."
						+ "\r\n9. Mostrar todos los títulos de los discos que empiezan por una letra pedida al usuario, de un array de discos.(El método devolverá un array con los títulos de los discos)."
						+ "\r\n10. Mostrar los datos del disco con mayor duración de un array de discos.(El método devolverá el\r\n"
						+ "disco con mayor duración)."
						+ "\r\n11. Mostrar en pantalla el nº de veces que aparece una misma canción en varios discos. El título de\r\n"
						+ "la canción debes pedírsela al usuario."
						+ "\r\n12. Mostrar la duración de todas las canciones de los discos de un array de discos, pero solo de los\r\n"
						+ "discos que su título empiece por la letra a o por la e."
						+ "\r\n13. Pedir al usuario un titulo de disco y vaciar todo su array de canciones.\r\n"
						+ "14. Deberás crear una clase DiscoRecopilatorio, esta clase tendrá los siguientes atributos: (Titulo,\r\n"
						+ "código y un array de discos.\r\n"
						+ "15. Mostrar el título de la primera y última canción de un disco recopilatorio de la siguiente manera:\r\n"
						+ "\r\n" + "Tilulo1: jdshfjdshfjhdsf – Título2: dsjhgfjhsdgfjhds\r\n" + "\r\n"
						+ "16. Mostrar los datos del disco recopilatorio que tenga mayor duración de un array de discos\r\n"
						+ "recopilatorios.\r\n"
						+ "17. Mostrar los datos del disco recopilatorio que tenga menor duración, de un array de discos\r\n"
						+ "recopilatorios.\r\n"
						+ "18. Mostrar el Título de los 2 discos recopilatorios con mayor duración de un array de discos\r\n"
						+ "recopilatorios.\r\n"
						+ "19. Mostrar el Título de los 2 discos recopilatorios con menor duración de un array de discos\r\n"
						+ "recopilatorios.\r\n"
						+ "20. Mostrar los datos de los discos recopilatorios que tengan discos producidos por un productor\r\n"
						+ "pedido al usuario.\r\n"
						+ "21. Mostrar los datos de los discos recopilatorios que tengan discos publicados antes de un año\r\n"
						+ "pedido al usuario.\r\n" + "22. Salir.");
	}

	/**
	 * M�todo que rellena el array de canciones con 12 canciones del f�ntastico
	 * grupo Indie Izal.
	 * 
	 * @param canciones (Array de objetos de la clase Cancion)
	 */
	public static void rellenarCanciones(Cancion[] canciones) {
		canciones[0] = new Cancion("La mujer de verde", 2.1);
		canciones[1] = new Cancion("Copacabana", 3.9);
		canciones[2] = new Cancion("Pausa", 3);
		canciones[3] = new Cancion("Que bien", 3);
		canciones[4] = new Cancion("Pánico Práctico", 3.6);
		canciones[5] = new Cancion("El pozo", 3);
		canciones[6] = new Cancion("La increible historia del hombre que no sabía volar", 3);
		canciones[7] = new Cancion("Autoterapia", 4.3);
		canciones[8] = new Cancion("Bill Murray", 1);
		canciones[9] = new Cancion("El baile", 6);
		canciones[10] = new Cancion("Magia y efectos especiales", 4);
		canciones[11] = new Cancion("Pequeña gran revolución", 2);
	}

	public static void rellenarDisco(Disco[] disco, Cancion[] canciones) {
		disco[0] = new Disco("Izal", 2000, 12223, "Izal", canciones);
		disco[1] = new Disco("Izal2", 2020, 13323, "Extra", canciones);
		disco[2] = new Disco("Izal3", 2030, 14423, "Sona", canciones);
		disco[3] = new Disco("Izal4", 2010, 15523, "Ziggs", canciones);
		disco[4] = new Disco("Izal5", 2002, 16623, "Meno", canciones);

	}

	public static void rellenarRecopilatorio(DiscoRecopilatorio[] reco, Disco[] disc) {
		reco[0] = new DiscoRecopilatorio("Recopilatorio1", 111111111, disc);
		reco[1] = new DiscoRecopilatorio("Recopilatorio2", 222222222, disc);
		reco[2] = new DiscoRecopilatorio("Recopilatorio3", 333333333, disc);
	}

	// exercise 1

	public static void showTitleCancion(Cancion[] canciones) {
		for (int i = 0; i < canciones.length; i++) {
			System.out.println((i + 1) + ") " + canciones[i].getTitulo());
		}
	}

	// exercise 2

	public static void showTitlexDuration(Cancion[] canciones) {
		for (int i = 0; i < canciones.length; i++) {
			if (canciones[i].getDuracion() < 4.0) {
				System.out.println((i + 1) + ") " + canciones[i].getTitulo());
			}
		}
	}

	// exercise 3

	public static double showCancionLongDuration(Cancion[] canciones) {
		Cancion duration = new Cancion();
		double maxDuration = 0;
		double count = 0;
		for (int i = 0; i < canciones.length; i++) {
			for (int j = 0; j < canciones[i].getTitulo().length(); j++) {
				if (canciones[i].getTitulo().length() > count) {
					count = canciones[i].getTitulo().length();
					maxDuration = canciones[i].getDuracion();
				}
			}
		}
		return maxDuration;
	}

	// exercise 4

	public static void showTittleSongs(Cancion[] canciones) {
		for (int i = 0; i < canciones.length; i++) {
			System.out.print(i + ") " + canciones[i].getTitulo() + ", ");
		}

	}

	// exercise 5

	public static double showSumDurationSong(Cancion[] canciones) {
		double sumDuration = 0;
		for (int i = 0; i < canciones.length; i++) {
			sumDuration += canciones[i].getDuracion();
		}
		return sumDuration;
	}

	// exercise 6

	public static double[] showAllDurationSongs(Cancion[] canciones) {
		double[] allDuration = new double[canciones.length];
		for (int i = 0; i < canciones.length; i++) {
			allDuration[i] = canciones[i].getDuracion();
			// System.out.println(allDuration[i]);
		}
		return allDuration;
	}

	// exercise 7

	public static void showDiscxTittle(Disco[] disco, String name) {

		for (int i = 0; i < disco.length; i++) {
			if (disco[i].getTitulo().equalsIgnoreCase(name)) {
				for (int j = 0; j < disco[i].getCanciones().length; j++) {
					System.out.println("Tittle of song " + (j + 1) + ": " + disco[i].getCanciones()[j].getTitulo()
							+ " - Duration : " + disco[i].getCanciones()[j].getDuracion());

				}
			}
		}
	}

	// exercise 8

	public static String showDiscxSong(Disco[] disco, String name) {
		String nameDisc = "";
		for (int i = 0; i < disco.length; i++) {
			for (int j = 0; j < disco[i].getCanciones().length; j++) {
				if (disco[i].getCanciones()[j].getTitulo().equalsIgnoreCase(name)) {
					nameDisc = disco[i].getTitulo();
				}
			}
		}
		return nameDisc;

	}

	// exercise 9

	public static String[] showDiscxLetter(Disco[] disc, String letter) {
		int count = 0;
		for (int i = 0; i < disc.length; i++) {
			if (disc[i].getTitulo().startsWith(letter)) {
				count++;
			}
		}
		String[] songs = new String[count];
		count = 0;
		for (int i = 0; i < disc.length; i++) {
			if (disc[i].getTitulo().startsWith(letter)) {
				songs[count] = disc[i].getTitulo();
				count++;
			}
		}
		return songs;
	}
	// exercise 10

	public static Disco[] durationDisc(Disco[] disc) {
		double maxDuration = 0;
		Disco[] maxDurationDisc = new Disco[1];
		for (int i = 0; i < disc.length; i++) {
			for (int j = 0; j < disc[i].getCanciones().length; j++) {
				if (disc[i].getCanciones()[j].getDuracion() > maxDuration) {
					maxDuration = disc[i].getCanciones()[j].getDuracion();
					maxDurationDisc[0] = disc[i];
				}
			}
		}
		return maxDurationDisc;
	}

	// exercise 11

	public static int numTimesSong(Disco[] disc, String song) {
		int count = 0;

		for (int i = 0; i < disc.length; i++) {
			for (int j = 0; j < disc[i].getCanciones().length; j++) {
				if (disc[i].getCanciones()[j].getTitulo().equalsIgnoreCase(song)) {
					count++;
				}
			}
		}
		return count;
	}
		// exercise 12

		public static void showSongsDiscxLetterAE(Disco[] disc) {
			for (int i = 0; i < disc.length; i++) {
				if (disc[i].getTitulo().startsWith("E") || disc[i].getTitulo().startsWith("A")) {
					for (int j = 0; j < disc[i].getCanciones().length; j++) {
						System.out.println((j + 1) + disc[i].getCanciones()[j].getDuracion());
					}
				}
			}
		}
	
		// exercise 13
	
		public static void cleanSongsDisc(Disco[] disc, String name) {
			for (int i = 0; i < disc.length; i++) {
				if (disc[i].getTitulo().equalsIgnoreCase(name)) {
					disc[i].setCanciones(null);
				}
			}
	
		}
	
		// exercise 15
	
		public static void ShowRecopilatorio(DiscoRecopilatorio[] disc) {
			for (int i = 0; i < disc.length; i++) {
				System.out.print("Título " + (i + 1) + " : " + disc[i].getTitulo() + " - ");
			}
		}
	
		// exercise 16
	
		public static void recoMoreDurationSong(DiscoRecopilatorio[] reco) {
	
			double duration = 0;
			double acu = 0;
			int index = 0;
	
			for (int i = 0; i < reco.length; i++) {
				for (int j = 0; j < reco[i].getDisco().length; j++) {
					duration = 0;
					for (int q = 0; q < reco[i].getDisco()[j].getCanciones().length; q++) {
						acu += reco[i].getDisco()[j].getCanciones()[q].getDuracion();
	
					}
	
					if (duration < acu) {
						duration = acu;
						index = i;
					}
				}
			}
			// System.out.println(index);
			reco[index].show();
		}
	
		// exercise 17
	
		public static void recolowerDurationSong(DiscoRecopilatorio[] reco) {
	
			double duration = 10000;
			double acu = 0;
			int index = 0;
	
			for (int i = 0; i < reco.length; i++) {
				for (int j = 0; j < reco[i].getDisco().length; j++) {
					duration = 0;
					for (int q = 0; q < reco[i].getDisco()[j].getCanciones().length; q++) {
						acu += reco[i].getDisco()[j].getCanciones()[q].getDuracion();
	
					}
	
					if (duration > acu) {
						duration = acu;
						index = i;
					}
				}
			}
			// System.out.println(index);
			reco[index].show();
		}
	
		// exercise 18
	
		public static void tittleRecoMoreDuration(DiscoRecopilatorio[] reco) {
			double acu = 0;
			double duration;
			int index = 0;
			int index2=0;
			DiscoRecopilatorio[] listDisco = new DiscoRecopilatorio[2];
			for (int i = 0; i < reco.length; i++) {
				for (int j = 0; j < reco[i].getDisco().length; j++) {
					duration = 0;
					for (int q = 0; q < reco[i].getDisco()[j].getCanciones().length; q++) {
							acu += reco[i].getDisco()[j].getCanciones()[q].getDuracion();
						
					}
	
					if(duration<acu) {
						duration = acu;
						index = i;
					}
				}
			}
			//System.out.println(index);
			for (int i = 0; i < reco.length; i++) {
				for (int j = 0; j < reco[i].getDisco().length; j++) {
					duration = 0;
					for (int q = 0; q < reco[i].getDisco()[j].getCanciones().length; q++) {
							acu += reco[i].getDisco()[j].getCanciones()[q].getDuracion();
						
					}
	
					if(duration<acu && i!=index) {
						duration = acu;
						index2 = i;
					}
				}	
		}
			reco[index].show();
			reco[index2].show();
		}
		
		//exercise 19
		
		public static void tittleRecoLowerDuration(DiscoRecopilatorio[] reco) {
			double acu = 0;
			double duration=1000000000;
			int index = 0;
			int index2=0;
			DiscoRecopilatorio[] listDisco = new DiscoRecopilatorio[2];
			for (int i = 0; i < reco.length; i++) {
				for (int j = 0; j < reco[i].getDisco().length; j++) {
					acu = 0;
					for (int q = 0; q < reco[i].getDisco()[j].getCanciones().length; q++) {
							acu += reco[i].getDisco()[j].getCanciones()[q].getDuracion();
						
					}
	
					if(duration>acu) {
						duration = acu;
						index = i;
					}
				}
			}
			//System.out.println(index);
			duration=0;
			for (int i = 0; i < reco.length; i++) {
				for (int j = 0; j < reco[i].getDisco().length; j++) {
					acu = 0;
					for (int q = 0; q < reco[i].getDisco()[j].getCanciones().length; q++) {
							acu += reco[i].getDisco()[j].getCanciones()[q].getDuracion();
						
					}
	
					if(duration>acu && i!=index) {
						duration = acu;
						index2 = i;
					}
				}	
		}
			reco[index].show();
			reco[index2].show();
		}
		
		//exercise20
		public static void discxProductor (DiscoRecopilatorio[] rec, String nom) {
			boolean confirm=false;
			for(int i=0;i<rec.length;i++) {
				for(int j=0;j<rec[i].getDisco().length;j++) {
					if(rec[i].getDisco()[j].getProductor().equalsIgnoreCase(nom)) {
						confirm=true;
					}
				}
				if(confirm==true) {
					rec[i].show();
				}
			}
		}
	
	
	public static void discRecpano(DiscoRecopilatorio[] rec, int año) {
		boolean confirm=false;
		for(int i=0;i<rec.length;i++) {
			for(int j=0;j<rec[i].getDisco().length;j++) {
				if(rec[i].getDisco()[j].getanopublicacion()<año) {
					confirm=true;
				}
			}
			if(confirm==true) {
				rec[i].show();
			}
		}
	}

}

package aplicacion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import actions.Interaction;
import concreteprops.Caja;
import concreteprops.Door;
import concreteprops.Lock;
import model.Player;
import model.SceneGame;
import model.World;

public class Aplicacion {
	static World world;

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Integer opcion = -1;
		world = World.getInstance();

		SceneGame escena1 = new SceneGame("Escena1");
		escena1.setDescription(
				"\nTe encuentras en una habitación con dos puertas (una al norte y una al este, cerrada con llave).\n");
		Door puerta1 = new Door("Puerta1");
		Door puerta2 = new Door("Puerta2");
		Lock lock1 = new Lock("Lock1");
		escena1.addProp(puerta1);
		escena1.addProp(puerta2);
		escena1.addProp(lock1);
		world.addScene(escena1);
		world.addEntity(puerta1);
		world.addEntity(puerta2);
		world.addEntity(lock1);

		SceneGame escena2 = new SceneGame("Escena2");
		escena2.setDescription(
				"\nEsta habitación sólo tiene una salida al sur. En el centro de la habitación hay una mesa con una caja.\n");
		Door puerta3 = new Door("Puerta3");
		Caja caja1 = new Caja("Caja1");
		escena2.addProp(caja1);
		escena2.addProp(puerta3);
		world.addScene(escena2);
		world.addEntity(puerta3);
		world.addEntity(caja1);

		SceneGame escena3 = new SceneGame("Escena3");
		escena3.setDescription("\nHa terminado el juego. Pulse 5 para salir.\n");
		world.addScene(escena3);

		Player player = world.getPlayer();
		player.setCurrentScene(escena1);

		do {
			SceneGame escenaActual = player.getCurrentScene();

			System.out.println(escenaActual.getDescription());

			Set<Interaction> accionesEscena = new HashSet<Interaction>();
			accionesEscena = escenaActual.getAvailableActions();
			int j = 0;
			for (Interaction i : accionesEscena) {
				System.out.println(j + ". " + i.getDescription());
				j++;
			}
			System.out.println("5. Salir");

			opcion = teclado.nextInt();
			Object[] acciones = accionesEscena.toArray();
			switch (opcion) {
			case 0:
				System.out.println(((Interaction) acciones[0]).getDescription());
				((Interaction) acciones[0]).doAction();
				break;
			case 1:
				System.out.println(((Interaction) acciones[1]).getDescription());
				((Interaction) acciones[1]).doAction();
				break;
			case 2:
				System.out.println(((Interaction) acciones[2]).getDescription());
				((Interaction) acciones[2]).doAction();
				break;
			case 5:
				break;
			}
			accionesEscena.clear();
		} while (opcion != 5);

	}

}

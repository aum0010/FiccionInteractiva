package concreteprops;

import java.util.HashSet;
import java.util.Set;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import concreteactions.SwitchSceneAction;
import model.Prop;
import model.World;

public class Door extends Prop implements InteractiveEntityMessage{

	private boolean open;

	public Door(String id) {
		super(id);
		open = false;
		if (id.equals("Puerta1") || id.equals("Puerta3")) {
			open = true;
		}
	}

	public boolean isOpen() {
		return open;
	}
	
	public void open(){
		open = true;
	}

	@Override
	public String getDescription() {
		String description = null;
		if (id.equals("Puerta1")) {
			description = "Puerta norte";
		}
		return description;
	}

	@Override
	public Set<Interaction> getAvailableActions() {
		Set<Interaction> acciones = new HashSet<Interaction>();
		SwitchSceneAction cambiarEscena1a2 = new SwitchSceneAction("Escena2");
		SwitchSceneAction cambiarEscena2a1 = new SwitchSceneAction("Escena1");
		SwitchSceneAction cambiarEscena1a3 = new SwitchSceneAction("Escena3");
		if (isOpen()) {
			if (id.equals("Puerta1")) {
				acciones.add(cambiarEscena1a2);
			}
			if (id.equals("Puerta2")) {
				acciones.add(cambiarEscena1a3);
			}
			if (id.equals("Puerta3")) {
				acciones.add(cambiarEscena2a1);
			}

		}
		return acciones;
	}

	@Override
	public void handleEntityMessage(InteractiveEntityMessage entity){
		open();
		System.out.println("\nLa puerta este está ahora abierta.\n");
		InteractiveEntityMessage message=null;
		World.getInstance().sendMessageToEntity("Lock1", message);
	}


}

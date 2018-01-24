package concreteactions;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import actions.SceneMessage;
import model.World;

public class Open implements Interaction {

	

	@Override
	public String getDescription() {
		return "Usar la llave con la puerta este.";
	}

	@Override
	public void doAction() {
		InteractiveEntityMessage message = null;
		World.getInstance().sendMessageToEntity("Puerta2",message);		
		SceneMessage message2 = null;
		World.getInstance().sendMessageToScene("Escena1",message2);	

	}

}

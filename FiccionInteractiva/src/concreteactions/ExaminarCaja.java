package concreteactions;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import actions.SceneMessage;
import model.World;

public class ExaminarCaja implements Interaction {

	@Override
	public String getDescription() {

		return "Examinar caja";
	}

	@Override
	public void doAction() {
		System.out.println("\nDentro de la caja se encuentra una llave\n");
		World.getInstance().getScenes().get("Escena2").removeProp("Caja1");
		InteractiveEntityMessage message = null;
		SceneMessage message2 = null;
		World.getInstance().sendMessageToEntity("Lock1", message);
		World.getInstance().sendMessageToScene("Escena2", message2);
	}

}

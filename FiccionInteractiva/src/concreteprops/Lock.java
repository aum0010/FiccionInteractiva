package concreteprops;

import java.util.HashSet;
import java.util.Set;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import concreteactions.Open;
import model.Prop;

public class Lock extends Prop implements Interaction, InteractiveEntityMessage {

	private boolean hasKey;

	public Lock(String id) {
		super(id);
		hasKey = false;

	}

	@Override
	public String getDescription() {
		return "A generic door lock with a socket for a key";
	}

	@Override
	public Set<Interaction> getAvailableActions() {
		Set<Interaction> acciones = new HashSet<Interaction>();
		Open open = new Open();
		if (hasKey == true) {
			acciones.add(open);
		}
		return acciones;

	}

	@Override
	public void doAction() {
		if (hasKey == false) {
			hasKey = true;
		}else{
			hasKey=false;
		}
		
	}

	@Override
	public void handleEntityMessage(InteractiveEntityMessage message) {
		doAction();
	}

}

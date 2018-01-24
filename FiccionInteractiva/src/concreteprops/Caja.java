package concreteprops;

import java.util.HashSet;
import java.util.Set;

import actions.Interaction;
import concreteactions.ExaminarCaja;
import model.Prop;

public class Caja extends Prop{

	public Caja(String id) {
		super(id);
		
	}

	@Override
	public String getDescription() {
		
		return "Caja";
	}

	@Override
	public Set<Interaction> getAvailableActions() {
		Set<Interaction> acciones = new HashSet<Interaction>();
		ExaminarCaja examinarCaja = new ExaminarCaja();
		acciones.add(examinarCaja);
		return acciones;
	}

}

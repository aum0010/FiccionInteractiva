package model;

import java.util.*;

import actions.Interaction;
import actions.InteractiveEntityMessage;
import actions.SceneMessage;
import concreteactions.DescribirEscena;

public class SceneGame extends InteractiveEntity {

	private String description;
	private Set<Interaction> acciones;
	private HashMap<String, Prop> props;

	/**
	 * @param id
	 */
	public SceneGame(String id) {
		super(id);
		props = new HashMap<String, Prop>();
		acciones = new HashSet<Interaction>();
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public Set<Interaction> getAvailableActions() {
		DescribirEscena describirEscena = new DescribirEscena(description);
		acciones.add(describirEscena);
		for (String p : props.keySet()) {
			for (Interaction i : getProp(p).getAvailableActions()) {
				acciones.add(i);
			}
		}

		return acciones;
	}

	/**
	 * @param prop
	 */
	public void addProp(Prop prop) {
		props.put(prop.getId(), prop);
	}

	/**
	 * @param propId
	 */
	public void removeProp(String propId) {
		props.remove(propId);
	}

	/**
	 * @param propId
	 * @return
	 */
	public Prop getProp(String propId) {
		return props.get(propId);
	}

	/**
	 * @param message
	 */
	public void handleEntityMessage(InteractiveEntityMessage message) {

	}

	/**
	 * @param message
	 */
	public void handleSceneMessage(SceneMessage message) {
		if(id.equals("Escena2")){
			setDescription("\nEsta habitación sólo tiene una salida al sur.\n");
		}
		if(id.equals("Escena1")){
			setDescription("\nTe encuentras en una habitación con dos puertas (una al norte y una al este).\n");
		}

	}

}
package model;

import java.util.HashMap;

import actions.InteractiveEntityMessage;
import actions.SceneMessage;

/**
 * 
 */
public class World {

	Player player;
	private HashMap<String, InteractiveEntity> listaEntidades;
	private HashMap<String, SceneGame> escenas;

	private static World world = null;

	/**
	 * Default constructor
	 */
	private World() {
		player = new Player();
		listaEntidades = new HashMap<String, InteractiveEntity>();
		escenas = new HashMap<String, SceneGame>();
	}

	public static World getInstance() {
		if (world == null)
			world = new World();
		return world;
	}

	/**
	 * @return
	 */
	public Player getPlayer() {

		return player;
	}

	/**
	 * @param scene
	 */
	public void addScene(SceneGame scene) {
		escenas.put(scene.getId(), scene);
	}

	/**
	 * @param id
	 */
	public void removeScene(String id) {
		escenas.remove(id);
	}

	public HashMap<String, SceneGame> getScenes() {
		return escenas;
	}

	/**
	 * @param id
	 * @param message
	 */
	public void sendMessageToScene(String id, SceneMessage message) {
		escenas.get(id).handleSceneMessage(message);
	}

	/**
	 * @param entity
	 */
	public void addEntity(InteractiveEntity entity) {
		listaEntidades.put(entity.getId(), entity);
	}

	/**
	 * @param id
	 */
	public void removeEntity(String id) {
		listaEntidades.remove(id);
	}

	/**
	 * @param id
	 * @param message
	 */
	public void sendMessageToEntity(String id, InteractiveEntityMessage message) {
		listaEntidades.get(id).handleEntityMessage(message);
	}

}
package model;


import java.util.*;

import actions.Interaction;

/**
 * 
 */
public class Player extends InteractiveEntity {
	
	private SceneGame currentScene;
	private Set<Interaction> acciones;

    /**
     * Default constructor
     */
    public Player() {
    	super(PLAYER_ID);
    }

    /**
     * 
     */
    public static String PLAYER_ID = "Player";


    /**
     * @return
     */
    public String getDescription() {
        
        return "This is the player";
    }

    /**
     * @return
     */
    public Set<Interaction> getAvailableActions() {
        
        return acciones;
    }

    /**
     * @param scene
     */
    public void setCurrentScene(SceneGame scene) {
        this.currentScene=scene;
    }

    /**
     * @return
     */
    public SceneGame getCurrentScene() {
        return currentScene;
    }


}
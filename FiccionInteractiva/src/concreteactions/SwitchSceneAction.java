package concreteactions;


import actions.Interaction;
import actions.SceneMessage;
import model.SceneGame;
import model.World;

public class SwitchSceneAction implements Interaction, SceneMessage {
	
	private String targetSceneId;
	
	
	public SwitchSceneAction(String sceneId){
		this.targetSceneId=sceneId;
	}

	@Override
	public String getDescription() {
		String description=null;
		if(World.getInstance().getPlayer().getCurrentScene().getId().equals("Escena1") && targetSceneId.equals("Escena2")){
			description="Ir al norte";
		}
		if(World.getInstance().getPlayer().getCurrentScene().getId().equals("Escena2") && targetSceneId.equals("Escena1")){
			description="Ir al sur";
		}
		if(World.getInstance().getPlayer().getCurrentScene().getId().equals("Escena1") && targetSceneId.equals("Escena3")){
			description="Ir al este";
		}
		return description;
	}

	@Override
	public void doAction() {
		World.getInstance().getPlayer().setCurrentScene(World.getInstance().getScenes().get(targetSceneId));
	}

	@Override
	public void handleSceneMessage(SceneGame scene) {
		this.targetSceneId=scene.getId();	
	}

}

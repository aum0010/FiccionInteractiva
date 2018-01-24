package concreteactions;

import actions.Interaction;

public class DescribirEscena implements Interaction {

	private String description;

	public DescribirEscena(String description) {
		this.description=description;		
	}

	@Override
	public String getDescription() {
		return "Describir la escena";
	}

	@Override
	public void doAction() {
		System.out.println(description);
	}

}

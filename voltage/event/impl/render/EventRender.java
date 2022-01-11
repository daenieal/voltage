package voltage.event.impl.render;

import voltage.event.Event;

public class EventRender extends Event {
	
	private float partialTicks;
	
	public EventRender(float partialTicks) {
		this.partialTicks = partialTicks;
		
	}

	public float getPartialTicks() {
		return partialTicks;
	}

	public void setPartialTicks(float partialTicks) {
		this.partialTicks = partialTicks;
	}

}

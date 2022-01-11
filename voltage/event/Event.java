package voltage.event;

import voltage.event.impl.EventDirection;
import voltage.event.impl.EventType;

public class Event<T> {
	
	private boolean isCancelled;
	public EventType type;
	public EventDirection direction;

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public EventDirection getDirection() {
		return direction;
	}

	public void setDirection(EventDirection direction) {
		this.direction = direction;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	
	public void call() {
		EventManager.onEvent(this);
	}
	
	public boolean isPre() {
		if(type == null)
			return false;
		
		return type == EventType.PRE;
	}
	
	public boolean isPost() {
		if(type == null)
			return false;
		
		return type == EventType.POST;
	}
	
	public boolean isIncoming() {
		if(direction == null)
			return false;
		
		return direction == EventDirection.INCOMING;
	}
	
	public boolean isOutgoing() {
		if(direction == null)
			return false;
		
		return direction == EventDirection.OUTGOING;
	}
}

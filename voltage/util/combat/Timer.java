package voltage.util.combat;

import voltage.ui.font.FontUtil;

public class Timer {
	
	public long lastMS = System.currentTimeMillis();
	public long lastNano = 0L;
	
	public void reset() {
		lastMS = System.currentTimeMillis();
	}
	
	public int convertToMS(int d) {
		return 1000 / d;
	}
	
	public boolean hasTimeEllapsed(long time, boolean reset) {
		if(System.currentTimeMillis() - lastMS > time) {
			if(reset)
				reset();
			
			return true;
		}
		
		return false;
	}
	
	public long getCurrentMS() {
		return System.nanoTime() / 1000000L;
	}

	public boolean hasReached(long milliseconds) {
		return getCurrentMS() - lastNano >= milliseconds;
	}
	
	public boolean hasTimeReached(long delay) {
		return System.currentTimeMillis() - lastNano >= delay;
	}
	
	public void resetNano() {
		lastNano = getCurrentMS();
	}
	
	public void setLastMS() {
		lastNano = System.currentTimeMillis();
	}
	
	public void setLastMS(long lastNano) {
		this.lastNano = lastNano;
	}
	
	public double easeIn(int x) {
		return x < 0.5 ? 4 * x * x * x : 1 - Math.pow(-2 * x + 2, 3) / 2;
	}
}

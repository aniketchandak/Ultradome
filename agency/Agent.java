package agency;

abstract public class Agent extends Thread {
	private static int nextID = 500;
	protected int idNum;
	protected Agent partner;
	protected Facilitator facilitator;
	protected boolean dead;
	public Agent() {
		super();
		dead = false;
		partner = null;
		idNum = nextID++;

	}

	public void run() {
		while (!isDead() && !facilitator.halt()) {
			update();
			yield();
		}
	}

	abstract public boolean done();

	public abstract void update();

	public Agent getPartner() {
		return partner;
	}

	public void setPartner(Agent partner) {
		this.partner = partner;
	}

	public Facilitator getFacilitator() {
		return facilitator;
	}

	public void setFacilitator(Facilitator facilitator) {
		this.facilitator = facilitator;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public int getIdNum() {
		return idNum;
	}

}

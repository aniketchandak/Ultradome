package agency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Facilitator {
	protected List<Agent> agents = new ArrayList<Agent>();
	private Random generator = new Random(System.currentTimeMillis());
	protected int clock = 0;
	private boolean verbose = true;
	private boolean multiThreaded = false;

	public boolean isVerbose() {
		return verbose;
	}

	public void add(Agent a) {
		a.setFacilitator(this);
		agents.add(a);
	}

	public void console(String s) {
		if (verbose)
			System.out.println(s);
	}

	public Agent get(int arg0) {
		return agents.get(arg0);
	}

	public boolean remove(Object arg0) {
		return agents.remove(arg0);
	}

	public int size() {
		return agents.size();
	}

	/*
	 * Find a random,living,available(Does not have partner) agent b!=a if not get
	 * to next next next if its a end start with same. If i end up on same point
	 * giveup // Gladiator wont fight if he do not get partner ??? a.partner = b and
	 * b.partner=a
	 */
	synchronized public void setPartner(Agent a) {
		int randomId = getRandom(this.size());

		int startId = randomId;
		do {
			Agent temp = agents.get(startId);
			if (!temp.isDead() && temp.getIdNum() != a.getIdNum() && temp.getPartner() == null) {
				a.setPartner(temp);
				temp.setPartner(a);
				break;

			} else {
				if (startId != this.size() - 1) {
					startId++;
				} else {
					startId = 0;
				}
			}

		} while (startId != randomId);
	}

	synchronized public int getRandom(int bound) {

		return this.generator.nextInt(bound);

	}

	/*
	 * update each living agent agents.size() <2 or user can override behaviour of
	 * halt
	 */

	public int livingCount() {
		int count = 0;
		for (Agent agent : agents) {
			if (!agent.isDead()) {
				count++;
			}
		}
		return count;
	}

	// This method return agent if only one is alive. Use: To print winner in UD
	public Agent lastAgent() {
		if (this.livingCount() == 1) {
			for (Agent agent : agents) {
				if (!agent.isDead()) {
					return agent;
				}
			}
		}
		return null;
	}

	public boolean halt() {
		if (this.livingCount() < 2) {
			return true;
		}
		return false;
	}

	/*
	 * Stat while not halt start iteration call update of agents when halt is true
	 * loop wi;; stop end simulation
	 */
	public void start() {

		if (multiThreaded) {
			startSimulation();
			clock = 0;
			for (int i = 0; i < agents.size(); i++) {
				this.get(i).start();

			}
			for (int i = 0; i < agents.size(); i++) {
				try {
					this.get(i).join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			endSimulation();
		} else {
			startSimulation();
			clock = 0;
			while (!halt()) {
				startIteration();
				for (Agent agent : agents) {

					if (!agent.isDead()) {
						if (verbose) {
							this.console("Updating " + agent.getIdNum());

						}
						agent.update();
					}

				}
				endIteration();
				clock++;
			}
			endSimulation();
		}

	}

	public void endSimulation() {
		// TODO Auto-generated method stub

	}

	public void endIteration() {
		// TODO Auto-generated method stub

	}

	public void startIteration() {
		// TODO Auto-generated method stub

	}

	public void startSimulation() {
		// TODO Auto-generated method stub

	}

}

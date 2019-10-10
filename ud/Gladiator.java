package ud;

import agency.Agent;

public class Gladiator extends Agent {
	private int health; // See if constuctor can take care of this
	private String name = "DefaultName";
	private Shield shield;
	private Weapon weapon;

	public Gladiator() {
		// TODO Auto-generated constructor stub

		// Initially galdiator has a basic shield and Sword as a weapon
		this.shield = new BasicShield();
		setWeapon(new Sword());
		this.setHealth(100);

	}

	public Gladiator(String name) {
		// TODO Auto-generated constructor stub
		this();
		this.setGladName(name);

	}

	public Shield getShield() {
		return shield;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		// Set owner of the weapon
		weapon.setOwner(this);
		this.weapon = weapon;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getGladName() {
		return name;
	}

	public void setGladName(String name) {
		this.name = name;
	}

	public void attack() {
		facilitator.setPartner(this);
		if (this.getPartner() != null) {
			Gladiator opponent = (Gladiator) this.getPartner();

			facilitator.console(this.name + " is attacking " + opponent.getGladName() + " with weapon "
					+ this.getWeapon().description);
			opponent.defend(this.weapon.makeStrike());

			// Is opponent dead after attack?? // Should we add this to update code and
			// gladiator should set himself dead when health is 0. But what if till then
			// someone pairs with dead gladiator
			if (opponent.getHealth() <= 0) {
				facilitator.console(opponent.getGladName() + " is Dead");
				opponent.setDead(true);
			}
			// attack is over so lets free partners
			opponent.setPartner(null);
			this.setPartner(null);

		}
	}

	public void defend(Strike s) {
		shield.reduceStrike(s);
		this.setHealth(this.getHealth() - s.getDamage());
	}

	public void strengthenShield(ShieldSkin ss) {
		// To the new shield attach all the previous layers of shield by setting the
		// previous layer as a peer to new shield ;

		ss.setPeer(this.shield);
		// set this new skin as a shield
		this.shield = ss;
		facilitator.console("My shield is changed to: " + this.shield.getClass().getName());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		UltraDome ud = (UltraDome) facilitator;
		int luck = facilitator.getRandom(100); // Check is it necessory to use facilitaors random generator or Can have
												// its own
		if (luck >= 0 && luck < 10) {
			facilitator.console(this.getGladName() + " got lucky and is Drinking Medicine");
			facilitator.console(this.getGladName() + " Health: " + this.getHealth());
			int tempMedicine = ud.getAvailableMedicine();
			facilitator.console("Before drinking dome had " + tempMedicine + " medicine");

			// If medicine is not enough or just enough for gladiator, increase health and
			// clear available medicine
			if ((this.getHealth() + tempMedicine) <= 100) {
				this.setHealth(this.getHealth() + tempMedicine);
				ud.setAvailableMedicine(0);
				// this.setFacilitator(ud); // Is it necessory to do this or it reflects changes
				// to actual object
			}

			// If medicine is more than enough than restore health to 100 and reduce
			// available medicine
			else {
				int gladHealth = this.getHealth();
				int diffHealth = 100 - gladHealth;
				ud.setAvailableMedicine(ud.getAvailableMedicine() - diffHealth);
				this.setHealth(100);
			}
			facilitator.console("After drinking dome has " + ud.getAvailableMedicine() + " medicine");
			;
			facilitator.console("After drinking " + this.getGladName() + " has health" + this.getHealth());
		} else if (luck >= 10 && luck < 20) {
			facilitator.console(this.getGladName() + " got lucky to chose weapon");
			if (ud.noOfWeapons() != 0) {
				int pickWeapon = facilitator.getRandom(ud.noOfWeapons());
				facilitator.console(this.getGladName() + " picked weapon " + ud.getWeapon(pickWeapon).getDescription());
				// If there are any weapon pick one and remove from ud
				this.setWeapon(ud.getWeapon(pickWeapon));
				ud.removeWeapon(pickWeapon);
			} else {
				facilitator.console("OOOPS!!!! No weapons available");
			}

		} else if (luck >= 20 && luck < 30) {
			if (ud.noOfSkin() != 0) {
				int pickSkin = facilitator.getRandom(ud.noOfSkin());
				facilitator.console(this.getGladName() + " picked skin " + ud.getSkin(pickSkin).getClass().getName());
				this.strengthenShield(ud.getSkin(pickSkin));
				ud.removeSkin(pickSkin);
			}

		} else {

			this.attack();
		}
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}

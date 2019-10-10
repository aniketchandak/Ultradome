package ud;

public abstract class Weapon {
	protected String description;
	protected int maxDamage;
	protected Gladiator owner;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public Gladiator getOwner() {
		return owner;
	}

	public void setOwner(Gladiator owner) {
		this.owner = owner;
	}

	abstract Strike makeStrike();
}

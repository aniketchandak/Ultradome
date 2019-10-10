package ud;

public class Sword extends Weapon {
	public Sword() {
		// TODO Auto-generated constructor stub
		this.description = "Sword";
		this.maxDamage = 35;
	}

	@Override
	Strike makeStrike() {
		// TODO Auto-generated method stub

		int strikeDam = Math.min(this.owner.getHealth(), this.maxDamage);
		// Generate random strike less than owner health and max damage
		int power = this.owner.getFacilitator().getRandom(strikeDam);
		this.getOwner().getFacilitator()
				.console(this.getDescription() + " weapon is generated strike of " + power + " power");
		return new Iron(power);
	}

}

package ud;

public class Poison extends Weapon {

	public Poison() {
		// TODO Auto-generated constructor stub
		this.description = "Poison";
		this.maxDamage = 60;
	}

	@Override
	Strike makeStrike() {
		// TODO Auto-generated method stub
		int strikeDam = Math.min(this.owner.getHealth(), this.maxDamage);
		// Generate random strike less than owner health and max damage
		int power = this.owner.getFacilitator().getRandom(strikeDam);
		this.getOwner().getFacilitator()
				.console(this.getDescription() + " weapon is generated strike of " + power + " power");
		return new Chemical(power);
	}

}

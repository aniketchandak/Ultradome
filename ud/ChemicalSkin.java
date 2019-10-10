package ud;

public class ChemicalSkin extends ShieldSkin {

	public ChemicalSkin(Shield p) {
		super(p);
		this.reductionFactor = 0.3f;
		// TODO Auto-generated constructor stub
	}

	public ChemicalSkin() {
		// TODO Auto-generated constructor stub
		this.reductionFactor = 0.3f;
	}

	public Strike reduceStrike(Strike s) {
		// TODO Auto-generated method stub
		System.out.println("Attack came to Chemical Skin with strike:" + s.getDamage());
		if (s instanceof Chemical) {
			System.out.println("Attack reduced by Chemical Skin to:" + Math.round(s.getDamage() * reductionFactor));
			s.setDamage(Math.round(s.getDamage() * reductionFactor));
		}
		return super.reduceStrike(s);
	}

}

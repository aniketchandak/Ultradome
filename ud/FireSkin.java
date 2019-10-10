package ud;

public class FireSkin extends ShieldSkin {

	public FireSkin(Shield p) {
		super(p);
		this.reductionFactor = 0.5f;
		// TODO Auto-generated constructor stub
	}

	public FireSkin() {
		// TODO Auto-generated constructor stub
		this.reductionFactor = 0.5f;
	}

	public Strike reduceStrike(Strike s) {
		// TODO Auto-generated method stub
		System.out.println("Attack came to Fire Skin with strike:" + s.getDamage());
		if (s instanceof Fire) {
			System.out.println("Attack reduced by Fire Skin to:" + Math.round(s.getDamage() * reductionFactor));
			s.setDamage(Math.round(s.getDamage() * reductionFactor));
		}
		return super.reduceStrike(s);
	}

}

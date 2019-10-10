package ud;

public class IronSkin extends ShieldSkin {

	public IronSkin(Shield p) {
		super(p);
		reductionFactor = 0.65f;
		// TODO Auto-generated constructor stub
	}

	public IronSkin() {
		// TODO Auto-generated constructor stub
		reductionFactor = 0.65f;
	}

	public Strike reduceStrike(Strike s) {
		// TODO Auto-generated method stub
		System.out.println("Attack came to Iron Skin with strike:" + s.getDamage());
		if (s instanceof Iron) {
			System.out.println("Attack reduced by Iron Skin to:" + Math.round(s.getDamage() * reductionFactor));
			s.setDamage(Math.round(s.getDamage() * reductionFactor));
		}
		return super.reduceStrike(s);
	}

}

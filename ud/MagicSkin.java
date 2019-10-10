package ud;

public class MagicSkin extends ShieldSkin {

	public MagicSkin(Shield p) {
		super(p);
		reductionFactor = 0.45f;
		// TODO Auto-generated constructor stub
	}

	public MagicSkin() {
		// TODO Auto-generated constructor stub
		reductionFactor = 0.45f;
	}

	@Override
	public Strike reduceStrike(Strike s) {
		// TODO Auto-generated method stub
		System.out.println("Attack came to Magic Skin with strike:" + s.getDamage());
		if (s instanceof Magic) {
			System.out.println("Attack reduced by Magic Skin to:" + Math.round(s.getDamage() * reductionFactor));
			s.setDamage(Math.round(s.getDamage() * reductionFactor));
		}
		return super.reduceStrike(s);
	}

}

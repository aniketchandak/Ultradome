package ud;

public class BasicShield implements Shield {

	private float reductionFactor = 0.90f;

	@Override
	public Strike reduceStrike(Strike s) {
		// TODO Auto-generated method stub
		System.out.println("Attack came to Basic Shield with strike:" + s.getDamage());
		System.out.println("Attack reduced by Basic Skin to:" + Math.round(s.getDamage() * reductionFactor));
		s.setDamage(Math.round(s.getDamage() * reductionFactor));
		return s;
	}

}

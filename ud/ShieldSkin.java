package ud;

public class ShieldSkin implements Shield {
	protected Shield peer = null;
	protected float reductionFactor;

	public ShieldSkin() {

	}

	public ShieldSkin(Shield p) {
		// TODO Auto-generated constructor stub
		this.peer = p;
	}

	@Override
	public Strike reduceStrike(Strike s) {
		// TODO Auto-generated method stub
		return peer.reduceStrike(s);
	}

	public void setPeer(Shield shield) {
		// TODO Auto-generated method stub
		this.peer = shield;

	}

}

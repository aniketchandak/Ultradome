package ud;

import java.util.ArrayList;
import java.util.List;

import agency.Facilitator;

public class UltraDome extends Facilitator {
	private int availableMedicine;
	private List<Weapon> weapons = new ArrayList<Weapon>();
	private List<ShieldSkin> skins = new ArrayList<ShieldSkin>();

	public boolean addSkin(ShieldSkin e) {
		return skins.add(e);
	}

	synchronized public ShieldSkin getSkin(int index) {
		return skins.get(index);
	}

	synchronized public ShieldSkin removeSkin(int index) {
		return skins.remove(index);
	}

	public int noOfSkin() {
		return skins.size();
	}

	public int noOfWeapons() {
		return weapons.size();
	}

	public boolean addWeapon(Weapon e) {
		return weapons.add(e);
	}

	public UltraDome() {
		super();
		this.availableMedicine = 500;
		Weapon w1 = new Poison();
		Weapon w2 = new Wand();
		Weapon w3 = new Sword();
		Weapon w4 = new FlameThrower();
		addWeapon(w1);
		addWeapon(w2);
		addWeapon(w3);
		addWeapon(w4);

		ShieldSkin s1 = new IronSkin();
		ShieldSkin s2 = new MagicSkin();
		ShieldSkin s3 = new FireSkin();
		ShieldSkin s4 = new ChemicalSkin();
		addSkin(s1);
		addSkin(s2);
		addSkin(s3);
		addSkin(s4);

	}

	@Override
	public void startSimulation() {
		// TODO Auto-generated method stub
		super.startSimulation();
		System.out.println("Let the war begin");
	}

	@Override
	public void endSimulation() {
		// TODO Auto-generated method stub
		super.endSimulation();

		System.out.println("Game is over");
		System.out.println("......And the winner is---------");
		System.out.println(((Gladiator) this.lastAgent()).getGladName());

	}

	synchronized public int getAvailableMedicine() {
		return availableMedicine;
	}

	synchronized public void setAvailableMedicine(int availableMedicine) {
		this.availableMedicine = availableMedicine;
	}

	synchronized public Weapon getWeapon(int index) {
		return weapons.get(index);
	}

	synchronized public Weapon removeWeapon(int index) {
		return weapons.remove(index);
	}

	public static void main(String[] args) {
		UltraDome ud = new UltraDome();
		Gladiator ironman = new Gladiator("Iron Man");
		Gladiator superman = new Gladiator("Super Man");
		Gladiator batman = new Gladiator("Bat Man");
		ud.add(ironman);
		ud.add(superman);
		ud.add(batman);

		ud.start();

	}

}

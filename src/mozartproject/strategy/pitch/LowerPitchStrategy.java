package mozartproject.strategy.pitch;

public class LowerPitchStrategy implements PitchStrategy{
	
	/**
	 * 
	 */
	@Override
	public int modifyPitch(int note) {
		note =-2;
		return note;
	}

}

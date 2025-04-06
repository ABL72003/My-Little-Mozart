package mozartproject.factory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	
	/**
	 * concrete method of MidiEventFactoryAbstract that just creates a factory and returns it.
	 * Specifically a StandardMidiEventFactory.
	 * This isn't coupled with the interface so it practices good Abstract Factory technique.
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}

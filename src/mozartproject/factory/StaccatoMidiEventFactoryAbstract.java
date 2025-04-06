package mozartproject.factory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	
	/**
	 * concrete method of MidiEventFactoryAbstract that just creates a factory and returns it.
	 * Specifically a StaccatoMidiEventFactory.
	 * This isn't coupled with the interface so it practices good Abstract Factory technique.
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}

package mozartproject;


import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import java.util.List;

import mozartproject.data.MidiEventData;
import mozartproject.factory.MidiEventFactory;
import mozartproject.factory.MidiEventFactoryAbstract;
import mozartproject.factory.StandardMidiEventFactoryAbstract;
import mozartproject.strategy.instrument.ElectricBassGuitarStrategy;
import mozartproject.strategy.instrument.InstrumentStrategy;
import mozartproject.strategy.instrument.TrumpetStrategy;
import mozartproject.strategy.pitch.HigherPitchStrategy;
import mozartproject.strategy.pitch.PitchStrategy;
import mozartproject.parser.MidiCsvParser;

public class Main {

	public static void main(String[] args) {
		try {
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("song/mystery_song.csv");
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            // MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
            // MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();

            MidiEventFactory factory = factoryAbstract.createFactory();

            // Choose an instrument strategy (e.g., Trumpet, Bass Guitar, Piano)
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);
            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);

            // Choose a pitch strategy (e.g., HigherPitch, LowerPitch)
            PitchStrategy pitchStrategy = new HigherPitchStrategy();

            for (MidiEventData event : midiEvents) {
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
                // call this as much as you want if you want to get a higher pitch
                modifiedNote = pitchStrategy.modifyPitch(modifiedNote);

                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(event.getStartEndTick(),
                                                    modifiedNote,
                                                    event.getVelocity(),
                                                    event.getChannel()));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(),
                                                    modifiedNote,
                                                    event.getChannel()));
                }
            }

            // Playing the sequence
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            while (sequencer.isRunning() || sequencer.isOpen()) {
                Thread.sleep(100);
            }

            Thread.sleep(5000);
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}



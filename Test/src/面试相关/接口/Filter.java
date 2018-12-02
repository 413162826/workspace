package 面试相关.接口;

public class Filter {
	public String name() {
		return getClass().getSimpleName();
	}
	public Waveform process(Waveform input) {return input;}
}

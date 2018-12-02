package 面试相关.接口;

public class HighPass extends Filter{
	double cutoff;
	public HighPass(double cutoff) {this.cutoff = cutoff;}
	public Waveform process(Waveform input) {return input;}
}


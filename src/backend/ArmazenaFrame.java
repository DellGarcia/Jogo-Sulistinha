package backend;

import java.util.ArrayList;
import data.CRUDAnimacao;
import model.Frame;

public class ArmazenaFrame {
	
	private ArrayList<Frame> frames;
	
	public ArmazenaFrame(String nome) {
	
		CRUDAnimacao crud = new CRUDAnimacao();
		frames = new ArrayList<Frame>();
		
		ArrayList<String[]> linha = crud.retornaFrames(nome);
		
		for(int i = 0; i < linha.size(); i++) {
			frames.add(new Frame(linha.get(i)));
		}
		
	}
	
	public ArrayList<Frame> getFrames() {
		return this.frames;
	}
}

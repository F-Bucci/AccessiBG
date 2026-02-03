package it.unibg.accessibilita.base.ui.component;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import struttura.Piano;

public class SelettorePianoTest {
	
	@Test
	void selettore_NonVuoto(){
	List<Piano> piani = new ArrayList<>();
	piani.add(new Piano(1, "prova", "prova", "prova"));
	SelettorePiano sp = new SelettorePiano(piani);
	assertNotNull(sp);
	}
}

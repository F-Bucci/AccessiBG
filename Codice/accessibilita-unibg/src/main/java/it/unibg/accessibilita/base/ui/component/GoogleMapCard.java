package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class GoogleMapCard extends Div {

/*
@param urlMappa
*/
	public GoogleMapCard(String pathMaps) {
		
		setWidthFull();
		setHeight("450px");
		
		addClassNames(
				LumoUtility.BorderRadius.LARGE,
				LumoUtility.BoxShadow.SMALL,
				LumoUtility.Overflow.HIDDEN
				);
		IFrame iframe = new IFrame(pathMaps);
		iframe.setSizeFull();
		iframe.getStyle().set("border", "none");
		
		add(iframe);
	}
}

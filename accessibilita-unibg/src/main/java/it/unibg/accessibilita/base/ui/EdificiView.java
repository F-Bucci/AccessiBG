package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;

//@Route("")
@PageTitle("Sede di Dalmine")
@Menu(order=1)
public class EdificiView extends Composite<VerticalLayout>{
	
	private Card createCard(String testo) {
		
		Card card = new Card();
		card.setWidth("200 px");
		card.setHeight("300 px");
		
		Icon iconTemp = LumoIcon.PHOTO.create();
		
		card.setMedia(iconTemp);
		card.add(testo);
		
		return card;
	};
	
	public EdificiView(){
		
		HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        
        
	}
	
}

package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import it.unibg.accessibilita.base.ui.component.ThemeToggleButton;
import it.unibg.accessibilita.base.ui.component.ViewToolbar;
@Layout
public final class MainLayout extends AppLayout implements RouterLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
 
    }

    private void createHeader() {
        
        ViewToolbar header = new ViewToolbar("AccessiBg");
        addToNavbar(header);
    }
    
    private void createDrawer() {
    	
    	H2 titolo = new H2("Impostazioni utente");
    	titolo.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Padding.MEDIUM);
    	
    	H3 sottotitolo1 = new H3("Cambia Tema:");
    	sottotitolo1.addClassNames(LumoUtility.FontSize.MEDIUM, LumoUtility.Padding.SMALL);
    	VerticalLayout  nav = new VerticalLayout();
    	nav.setPadding(false);
    	
    	ThemeToggleButton toggleBtn = new ThemeToggleButton();
    	toggleBtn.addClassNames(LumoUtility.Margin.MEDIUM);
    	
    	VerticalLayout drawerContent = new VerticalLayout();
    	drawerContent.setSizeFull();
    	drawerContent.setPadding(false);
    	drawerContent.setSpacing(false);
    	
    	drawerContent.add(titolo, sottotitolo1, toggleBtn, nav);
    	drawerContent.expand(nav);
    	drawerContent.addClassNames(LumoUtility.TextAlignment.CENTER);
    	addToDrawer(drawerContent);
    }
}

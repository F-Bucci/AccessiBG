package it.unibg.accessibilita.base.ui.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

import it.unibg.accessibilita.base.ui.component.AppButton;
import it.unibg.accessibilita.base.ui.component.ThemeToggleButton;
import it.unibg.accessibilita.base.ui.component.ToggleAccessibilita;
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
    	
    	//MENU LATERALE
        //BOTTONE HOME
        AppButton homeBtn = new AppButton("Home", VaadinIcon.HOME.create(), e -> {
            UI.getCurrent().navigate(HomeView.class); 
        });
        homeBtn.setWidthFull(); 
        homeBtn.addClassNames(LumoUtility.JustifyContent.START); 
        
        VerticalLayout navSection = new VerticalLayout(homeBtn);
        navSection.setPadding(false);
        navSection.setSpacing(false);
        //TEMA
    	H3 aspettoTitle = new H3("ASPETTO:");
    	aspettoTitle.addClassNames(LumoUtility.FontSize.XSMALL, LumoUtility.TextColor.SECONDARY, LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.Margin.Top.MEDIUM);

        ThemeToggleButton toggleBtn = new ThemeToggleButton();
        toggleBtn.setWidthFull(); 
        toggleBtn.addClassNames(LumoUtility.JustifyContent.START); 
        VerticalLayout aspettoSection = new VerticalLayout(aspettoTitle, toggleBtn);
        aspettoSection.setPadding(false);
        aspettoSection.setSpacing(false);
       
        //IMPOSTAZIONI PREFERENZE
        H3 preferenzeTitle = new H3("Preferenze di navigazione");
        preferenzeTitle.addClassNames(LumoUtility.FontSize.XSMALL, LumoUtility.TextColor.SECONDARY, LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.Margin.Top.MEDIUM);
        ToggleAccessibilita accessBtn = new ToggleAccessibilita();
        accessBtn.getStyle().set("padding-left", "16px");
        
        VerticalLayout preferenzeSection = new VerticalLayout(preferenzeTitle, accessBtn);
        preferenzeSection.setPadding(false);
        preferenzeSection.setSpacing(false);
        
    	VerticalLayout drawerContent = new VerticalLayout();
    	drawerContent.setSizeFull();
    	drawerContent.setPadding(false);
    	
    	drawerContent.add(navSection);
        drawerContent.add(preferenzeSection);
    	//PORTA IL TOGGLE IN BASSO
    	Div spacer = new Div();
        drawerContent.add(spacer);
        drawerContent.expand(spacer);
        
        drawerContent.add(aspettoSection);
    	addToDrawer(drawerContent);
    }
}

package it.unibg.accessibilita.base.ui;

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
    	
        H3 menuTitle = new H3("MENU");
        menuTitle.addClassNames(LumoUtility.FontSize.MEDIUM, LumoUtility.Padding.Horizontal.MEDIUM);

        AppButton homeBtn = new AppButton("Home", VaadinIcon.HOME.create(), e -> {
            UI.getCurrent().navigate(HomeView.class); 
        });
        homeBtn.setWidthFull(); 
        homeBtn.addClassNames(LumoUtility.JustifyContent.START); 
        
        VerticalLayout navSection = new VerticalLayout(menuTitle, homeBtn);
        navSection.setPadding(false);
        navSection.setSpacing(false);
        
    	H3 sottotitolo = new H3("ASPETTO:");
        sottotitolo.addClassNames(LumoUtility.FontSize.MEDIUM, LumoUtility.Padding.Horizontal.MEDIUM);

        ThemeToggleButton toggleBtn = new ThemeToggleButton();
        toggleBtn.setWidthFull(); 
        toggleBtn.addClassNames(LumoUtility.JustifyContent.START); 
        
        VerticalLayout settingsSection = new VerticalLayout(sottotitolo, toggleBtn);
        settingsSection.setPadding(false);
        settingsSection.setSpacing(false);
        
    	VerticalLayout drawerContent = new VerticalLayout();
    	drawerContent.setSizeFull();
    	drawerContent.setPadding(false);
    	
    	drawerContent.add(navSection);
    	Div spacer = new Div();
        drawerContent.add(spacer);
        drawerContent.expand(spacer);
        drawerContent.add(settingsSection);
    	addToDrawer(drawerContent);
    }
}

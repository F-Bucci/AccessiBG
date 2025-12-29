package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.server.menu.MenuEntry;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.component.icon.VaadinIcon;

import static com.vaadin.flow.theme.lumo.LumoUtility.*;

@Layout
public final class MainLayout extends AppLayout {

    MainLayout() {
        setPrimarySection(Section.DRAWER);
        addToDrawer(createHeader());
        new Scroller(createSideNav());
    }

    private Div createHeader() {
    	
    	Button toggleThemeBtn = new Button(VaadinIcon.MOON_O.create());
    	
    	toggleThemeBtn.addThemeVariants(com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY);
    	toggleThemeBtn.addClassName(Margin.Left.AUTO);
    	
    	toggleThemeBtn.addClickListener(click ->{
    	try {
    		ThemeList themelist = UI.getCurrent().getElement().getThemeList();
    		
    		Button sourceButton = (Button) click.getSource();
    		
    	if(themelist.contains(Lumo.DARK)) {
    		themelist.remove(Lumo.DARK);
    		sourceButton.setIcon(VaadinIcon.MOON_O.create());
    	} else {
    		themelist.add(Lumo.DARK);
    		sourceButton.setIcon(VaadinIcon.SUN_O.create());
    	}
    		
    	} catch (Exception e) {
    		System.out.println("----- ERRORE--------");
    		e.printStackTrace();
    	}
    	
    	});
    	
    	
    	
        // TODO Replace with real application logo and name
        var appLogo = VaadinIcon.CUBES.create();
        appLogo.addClassNames(TextColor.PRIMARY, IconSize.LARGE);

        var appName = new Span("Accessibilita Unibg");
        appName.addClassNames(FontWeight.SEMIBOLD, FontSize.LARGE);

        var header = new Div(appLogo, appName, toggleThemeBtn);
        header.addClassNames(Display.FLEX, Padding.MEDIUM, Gap.MEDIUM, AlignItems.CENTER);
        return header;
        
        
    }

    private SideNav createSideNav() {
        var nav = new SideNav();
        nav.addClassNames(Margin.Horizontal.MEDIUM);
        MenuConfiguration.getMenuEntries().forEach(entry -> nav.addItem(createSideNavItem(entry)));
        return nav;
    }

    private SideNavItem createSideNavItem(MenuEntry menuEntry) {
        if (menuEntry.icon() != null) {
            return new SideNavItem(menuEntry.title(), menuEntry.path(), new Icon(menuEntry.icon()));
        } else {
            return new SideNavItem(menuEntry.title(), menuEntry.path());
        }
    }
}

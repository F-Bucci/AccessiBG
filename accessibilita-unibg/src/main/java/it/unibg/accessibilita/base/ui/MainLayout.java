package it.unibg.accessibilita.base.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, new DrawerToggle());
        addToDrawer(createHeader(),new Scroller(createSideNav()));
 
    }

    private Div createHeader() {
    	
        var appLogo = VaadinIcon.CUBES.create();
        appLogo.addClassNames(TextColor.PRIMARY, IconSize.LARGE);

        var appName = new Span("Accessibilita Unibg");
        appName.addClassNames(FontWeight.SEMIBOLD, FontSize.LARGE);
        
        Button themeButton = createThemeToggleButton();
        
        Div titleContainer = new Div(appName, themeButton);
        titleContainer.addClassNames(Display.FLEX, FlexDirection.COLUMN);
        
        Div header = new Div();
        header.add(appLogo, appName, themeButton);
        
        header.addClassNames(Display.FLEX, Padding.MEDIUM, Gap.MEDIUM, AlignItems.CENTER);
        
        return header;
        
    }
    
    private Button createThemeToggleButton() {
    	
    	Icon icon = VaadinIcon.MOON_O.create();
    	Button toggleBtn = new Button("Tema Scuro", icon);
    	toggleBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SMALL);
    	toggleBtn.getStyle().set("padding-left", "0");
    	toggleBtn.getElement().setAttribute("aria-label", "Cambia Tema");
    	toggleBtn.addClickListener(click ->{
    		ThemeList themelist = UI.getCurrent().getElement().getThemeList();
    		
    	if(themelist.contains(Lumo.DARK)) {
    		themelist.remove(Lumo.DARK);
    		toggleBtn.setIcon(VaadinIcon.MOON_O.create());
    		toggleBtn.setText("Tema Scuro");
    	} else {
    		themelist.add(Lumo.DARK);
    		toggleBtn.setIcon(VaadinIcon.SUN_O.create());
    		toggleBtn.setText("Tema Chiaro");

    	}
    	
    });
    	
    return toggleBtn;	
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

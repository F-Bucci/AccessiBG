package it.unibg.accessibilita.base.ui.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public final class ViewToolbar extends Composite<Header> {

    public ViewToolbar(@Nullable String viewTitle, Component... components) {
        addClassNames(Display.FLEX, FlexDirection.ROW, AlignItems.CENTER, 
                Gap.MEDIUM, Padding.End.MEDIUM, Width.FULL);

        var drawerToggle = new DrawerToggle();
        drawerToggle.addClassNames(Margin.NONE);
        drawerToggle.setAriaLabel("Menu Principale");
        getContent().add(drawerToggle);
      
        var title = new H1(viewTitle);
        title.addClassNames(FontSize.XLARGE, Margin.NONE, FontWeight.LIGHT);
        getContent().add(title);

        Div spazio = new Div();
        spazio.addClassNames(Flex.GROW);
        getContent().add(spazio);
        
        if (components.length > 0) {
            var actions = new Div(components);
            actions.addClassNames(Display.FLEX, FlexDirection.COLUMN, JustifyContent.BETWEEN, Flex.GROW, Gap.SMALL,
                    FlexDirection.Breakpoint.Medium.ROW);
            getContent().add(actions);
        }
    }

    public static Component group(Component... components) {
        var group = new Div(components);
        group.addClassNames(Display.FLEX, FlexDirection.COLUMN, AlignItems.STRETCH, Gap.SMALL,
                FlexDirection.Breakpoint.Medium.ROW, AlignItems.Breakpoint.Medium.CENTER);
        return group;
    }
}

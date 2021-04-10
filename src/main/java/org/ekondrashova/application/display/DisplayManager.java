package org.ekondrashova.application.display;

import java.util.ArrayList;
import java.util.List;

public class DisplayManager {
    private final List<Display> displays = new ArrayList<>();

    public void addDisplay(Display display) {
        displays.add(display);
    }

    public void showAll() {
        displays.forEach(Display::show);
    }
}

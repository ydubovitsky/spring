package space.dubovitsky.spring.spel.component.impl;

import space.dubovitsky.spring.spel.component.Window;

public class WoodenWindow implements Window {

    @Override
    public void openWindow() {
        System.out.println("Hello, this is a WoodenWindow");
    }
}

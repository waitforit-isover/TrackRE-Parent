package com.sevenre.trackre.parent;

import com.sevenre.trackre.parent.utils.FontsOverride;

public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/fontawesome-webfont.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/fontawesome-webfont.ttf");
    }
}
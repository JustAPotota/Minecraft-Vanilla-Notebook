package com.june.notebook;

import com.june.notebook.screens.menuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import static com.june.notebook.Notebook.pageLocation;
import static com.june.notebook.screens.menuScreen.bookmarkedpage;
import static com.june.notebook.screens.menuScreen.page;
import static com.june.notebook.Util.removePage.remove;

public class Gui {
    public static class sidebar {
        public static TexturedButtonWidget addSidebarButton(int pos, Identifier BUTTON_TEXTURE, Screen BOOK_MENU, String buttonID, int x, int y, ButtonWidget.PressAction pressAction) {
            return new TexturedButtonWidget(BOOK_MENU.width/2 +90, 18+(12*pos), 8, 8, 0, 0, y, BUTTON_TEXTURE, x, y*2, pressAction, Text.translatable("jwg.button."+buttonID));
        }

    }
    public static class button {
        public static class gotobookmark {
            public static void onPress() {
                bookmarkedpage = menuScreen.page;
                writeBookmark();
            }
            private static void writeBookmark() {
                try {
                    FileWriter fileOverwriter = new FileWriter("config/vanilla-notebook/bookmark.cfg");
                    fileOverwriter.write("# This file stores the bookmark data; DO NOT EDIT THIS FILE as it can cause issues, bugs and crashing!\n"+bookmarkedpage);
                    fileOverwriter.close();
                } catch (IOException e) { e.printStackTrace(); }
            }
        }
        public static class delete {
            public static void onPress(int page) { remove(page); }


        }
        public static class bookmark {
            public static void onPress() {
                if (bookmarkedpage <= Objects.requireNonNull(new File(pageLocation + "/").list()).length) {
                    page = bookmarkedpage;
                }
            }
        }
        public static class importButton {
            public static void onPress(String loc) { Util.ports.imports(loc, "Notebook/book.export"); }
        }
        public static class exportButton {
            public static void onPress(String loc) { Util.ports.exports(loc); }
        }
    }
}
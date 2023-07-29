package inditorias.destiny.registries;


import inditorias.destiny.DestinyMod;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;


public class DestinyKeybinds {
    private static KeyBinding superKeybind;
    private static KeyBinding ability1Keybind;
    private static KeyBinding ability2Keybind;
    private static KeyBinding ability3Keybind;

    public static void registerKeybinds(){
        superKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
           "key.super",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "category."+ DestinyMod.MOD_ID
        ));
        ability1Keybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.ability.1",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "category."+ DestinyMod.MOD_ID
        ));
        ability2Keybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.ability.2",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                "category."+ DestinyMod.MOD_ID
        ));
        ability3Keybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.ability.3",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_V,
                "category."+ DestinyMod.MOD_ID
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (superKeybind.wasPressed()) {
//                client.player.sendMessage(Text.literal("Super Activated!!!"), false);
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (ability1Keybind.wasPressed()) {
//                client.player.sendMessage(Text.literal("Ability 1 Activated!!!"), false);
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (ability2Keybind.wasPressed()) {
//                client.player.sendMessage(Text.literal("Ability 2 Activated!!!"), false);
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (ability3Keybind.wasPressed()) {
//                client.player.sendMessage(Text.literal("Ability 3 Activated!!!"), false);
            }
        });

    }


}

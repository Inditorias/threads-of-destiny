package inditorias.destiny.registries;

import inditorias.destiny.DestinyMod;
import inditorias.destiny.enchantments.EnchantScorch;
import inditorias.destiny.enchantments.EnchantUnravel;
import inditorias.destiny.enchantments.EnchantVolatile;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DestinyEnchantments {
    public static Enchantment ENCHANTMENT_SCORCH = new EnchantScorch(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND);
    public static Enchantment ENCHANTMENT_UNRAVEL = new EnchantUnravel(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND);
    public static Enchantment ENCHANTMENT_VOLATILE = new EnchantVolatile(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND);
    public static void registerEnchantments(){
        Registry.register(Registries.ENCHANTMENT, new Identifier(DestinyMod.MOD_ID, "scorch_enchant"), ENCHANTMENT_SCORCH);
        Registry.register(Registries.ENCHANTMENT, new Identifier(DestinyMod.MOD_ID, "unravel_enchant"), ENCHANTMENT_UNRAVEL);
        Registry.register(Registries.ENCHANTMENT, new Identifier(DestinyMod.MOD_ID, "volatile_enchant"), ENCHANTMENT_VOLATILE);
    }
}

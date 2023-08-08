package inditorias.destiny.enchantments;

import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class EnchantScorch extends Enchantment {
    public EnchantScorch(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return super.getMinPower(21);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingTarget){
            StatusEffectInstance scorch = livingTarget.getStatusEffect(DestinyEffects.SOLAR_SCORCH);
            int amplifier = 1+(level-1)*5;
            if(scorch != null){
                amplifier += scorch.getAmplifier();
                livingTarget.removeStatusEffect(DestinyEffects.SOLAR_SCORCH);
            }
            livingTarget.addStatusEffect(new StatusEffectInstance(DestinyEffects.SOLAR_SCORCH, 5, amplifier), user);
        }
        super.onTargetDamaged(user, target, level);
    }
}

package inditorias.destiny.enchantments;

import inditorias.destiny.config.DestinyConfig;
import inditorias.destiny.registries.DestinyEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class EnchantUnravel  extends Enchantment {
    public EnchantUnravel (Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return super.getMinPower(21);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingTarget) {
            if (livingTarget.getStatusEffect(DestinyEffects.STRAND_UNRAVEL) == null) {

                livingTarget.addStatusEffect(new StatusEffectInstance(DestinyEffects.STRAND_UNRAVEL, (int) (20 * DestinyConfig.getUnravelDuration()), 1), user);
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}

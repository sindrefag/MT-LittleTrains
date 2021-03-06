package net.multiteam.mt_t_trains.items;

import net.hdt.huskylib2.items.ItemMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.multiteam.mt_t_trains.MTTTrains;

import javax.annotation.Nullable;
import java.util.List;

import static net.multiteam.mt_t_trains.Reference.MOD_ID;

public class ItemController extends ItemMod {

    public ItemController() {
        super("controller", MOD_ID);
        this.setCreativeTab(MTTTrains.MAIN_CREATIVE_TAB);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().hasKey("linked_control_box")) {
                tooltip.add(TextFormatting.GOLD.toString() + TextFormatting.BOLD.toString() + "Linked");
                tooltip.add(stack.getTagCompound().getString("linked_control_box"));
                return;
            }
        }
        tooltip.add(TextFormatting.RED.toString() + TextFormatting.BOLD.toString() + "Unlinked");
        tooltip.add("Right click a control box with this controller to link them together");
    }

}
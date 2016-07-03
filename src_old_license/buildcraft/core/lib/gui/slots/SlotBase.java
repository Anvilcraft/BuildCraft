/** Copyright (c) 2011-2015, SpaceToad and the BuildCraft Team http://www.mod-buildcraft.com
 * <p/>
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License 1.0, or MMPL. Please check the contents
 * of the license located in http://www.mod-buildcraft.com/MMPL-1.0.txt */
package buildcraft.core.lib.gui.slots;

import net.minecraft.item.ItemStack;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import buildcraft.core.lib.gui.tooltips.IToolTipProvider;
import buildcraft.core.lib.gui.tooltips.ToolTip;

public class SlotBase extends SlotItemHandler implements IToolTipProvider {
    public final int handlerIndex;
    private ToolTip toolTips;

    public SlotBase(IItemHandler itemHandler, int slotIndex, int posX, int posY) {
        super(itemHandler, slotIndex, posX, posY);
        this.handlerIndex = slotIndex;
    }

    public boolean canShift() {
        return true;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return true;
    }

    /** @return the toolTips */
    @Override
    public ToolTip getToolTip() {
        return toolTips;
    }

    /** @param toolTips the tooltips to set */
    public void setToolTips(ToolTip toolTips) {
        this.toolTips = toolTips;
    }

    @Override
    public boolean isToolTipVisible() {
        return getStack() == null;
    }

    @Override
    public boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX >= xDisplayPosition && mouseX <= xDisplayPosition + 16 && mouseY >= yDisplayPosition && mouseY <= yDisplayPosition + 16;
    }

    /** @param stack
     * @param simulate
     * @return The left over. */
    public ItemStack insert(ItemStack stack, boolean simulate) {
        return getItemHandler().insertItem(handlerIndex, stack, simulate);
    }
}

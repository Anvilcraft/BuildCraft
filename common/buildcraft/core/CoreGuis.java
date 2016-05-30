package buildcraft.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public enum CoreGuis {
    LIST;

    public void openGUI(EntityPlayer player) {
        player.openGui(BCCore.INSTANCE, ordinal(), player.getEntityWorld(), 0, 0, 0);
    }

    public void openGUI(EntityPlayer player, BlockPos pos) {
        player.openGui(BCCore.INSTANCE, ordinal(), player.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ());
    }
}

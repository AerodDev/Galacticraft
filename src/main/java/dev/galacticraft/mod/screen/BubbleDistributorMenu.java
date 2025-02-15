/*
 * Copyright (c) 2019-2023 Team Galacticraft
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.galacticraft.mod.screen;

import dev.galacticraft.machinelib.api.screen.MachineMenu;
import dev.galacticraft.mod.content.block.entity.OxygenBubbleDistributorBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
public class BubbleDistributorMenu extends MachineMenu<OxygenBubbleDistributorBlockEntity> {
    public BubbleDistributorMenu(int syncId, Player player, OxygenBubbleDistributorBlockEntity machine) {
        super(syncId, player, machine, GCMenuTypes.BUBBLE_DISTRIBUTOR_HANDLER);

        this.addPlayerInventorySlots(8, 84);
    }

    public BubbleDistributorMenu(int syncId, Inventory inv, FriendlyByteBuf buf) {
        this(syncId, inv.player, (OxygenBubbleDistributorBlockEntity) inv.player.level.getBlockEntity(buf.readBlockPos()));
    }
}

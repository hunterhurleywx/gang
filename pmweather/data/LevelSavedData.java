/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.level.saveddata.SavedData
 *  net.minecraft.world.level.saveddata.SavedData$Factory
 */
package dev.protomanly.pmweather.data;

import dev.protomanly.pmweather.interfaces.IWorldData;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

public class LevelSavedData
extends SavedData {
    private CompoundTag compoundTag;
    private IWorldData dataHandler;

    public static SavedData.Factory<LevelSavedData> factory() {
        return new SavedData.Factory(LevelSavedData::new, LevelSavedData::load, null);
    }

    public LevelSavedData() {
        this.compoundTag = new CompoundTag();
    }

    public LevelSavedData(CompoundTag compoundTag) {
        this.compoundTag = compoundTag;
    }

    public void setDataHandler(IWorldData dataHandler) {
        this.dataHandler = dataHandler;
    }

    public static LevelSavedData load(CompoundTag compoundTag, HolderLookup.Provider registries) {
        return new LevelSavedData(compoundTag);
    }

    public CompoundTag save(CompoundTag compoundTag, HolderLookup.Provider provider) {
        this.dataHandler.save(compoundTag);
        return compoundTag;
    }

    public CompoundTag getData() {
        return this.compoundTag;
    }

    public boolean isDirty() {
        return true;
    }
}


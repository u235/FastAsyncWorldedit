package com.boydti.fawe.wrappers;

import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldVector;
import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.util.Location;

public class LocationMaskedPlayerWrapper extends PlayerWrapper {
    private Vector position;

    public LocationMaskedPlayerWrapper(Player parent, Vector position) {
        super(parent);
        this.position = position;
    }

    @Override
    public WorldVector getBlockIn() {
        WorldVector pos = getPosition();
        return WorldVector.toBlockPoint(pos.getWorld(), pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public WorldVector getBlockOn() {
        WorldVector pos = getPosition();
        return WorldVector.toBlockPoint(pos.getWorld(), pos.getX(), pos.getY() - 1, pos.getZ());
    }

    @Override
    public WorldVector getPosition() {
        return new WorldVector((LocalWorld) getWorld(), position);
    }

    @Override
    public Location getLocation() {
        return new Location(getWorld(), position);
    }

    @Override
    public void setPosition(Vector pos, float pitch, float yaw) {
        this.position = pos;
    }
}

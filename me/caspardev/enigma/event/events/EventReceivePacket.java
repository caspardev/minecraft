package me.caspardev.enigma.event.events;

import me.caspardev.enigma.event.Event;
import net.minecraft.network.Packet;

public class EventReceivePacket extends Event {
    private Packet packet;

    public EventReceivePacket(Packet packet) {
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }
    public void setPacket(Packet packet) {
        this.packet = packet;
    }
}

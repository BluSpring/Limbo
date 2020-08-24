package nl.hpfxd.limbo.network.packet.packets.play;

import io.netty.buffer.ByteBuf;
import nl.hpfxd.limbo.network.packet.Packet;
import nl.hpfxd.limbo.network.protocol.PacketUtils;

public class PacketJoinGame extends Packet {
    private final int entityId;
    private final int gamemode;
    private final byte dimension;
    private final int difficulty;
    private final int maxPlayers;
    private final String levelType;
    private final boolean reducedDebugInfo;

    public PacketJoinGame(int entityId, int gamemode, byte dimension, int difficulty, int maxPlayers, String levelType, boolean reducedDebugInfo) {
        super(0x01);
        this.entityId = entityId;
        this.gamemode = gamemode;
        this.dimension = dimension;
        this.difficulty = difficulty;
        this.maxPlayers = maxPlayers;
        this.levelType = levelType;
        this.reducedDebugInfo = reducedDebugInfo;
    }
    @Override
    public void write(ByteBuf buf) {
        buf.writeInt(this.entityId);
        buf.writeByte(this.gamemode);
        buf.writeByte(this.dimension);
        buf.writeByte(this.difficulty);
        buf.writeByte(this.maxPlayers);
        PacketUtils.writeString(buf, this.levelType);
        buf.writeBoolean(this.reducedDebugInfo);
    }
}

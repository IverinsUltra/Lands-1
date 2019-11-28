package me.angeschossen.lands.api.objects.player;

import me.angeschossen.lands.api.enums.role.RoleSetting;
import me.angeschossen.lands.api.objects.land.Land;
import me.angeschossen.lands.api.objects.war.War;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.UUID;

public interface LandPlayer {

    /**
     * Is the player participating in a war?
     * @return true, if player is in war.
     */
    @NotNull
    boolean isInWar();

    /**
     * Check if the player is participating in the war.
     * @param war War
     * @return true, if they're participating in the war.
     */
    boolean isInWar(@NotNull War war);

    /**
     * Get current selection.
     *
     * @return Selection
     */
    @Nullable
    Selection getSelection();

    /**
     * Get max claims per land.
     *
     * @return Max claims
     */
    @NotNull
    int getMaxClaimsPerLand();

    /**
     * Get support claims per land. Permission: lands.chunks.support.NUMBER
     *
     * @return Max support claims
     */
    @NotNull
    int getSupportClaimsPerLand();

    /**
     * Get player
     *
     * @return Will return null if player is offline.
     */
    @Nullable
    Player getPlayer();

    /**
     * Get invite of land
     *
     * @param landName Name of land
     * @return Invite
     */
    Invite getInvite(@NotNull String landName);

    /**
     * Get UID of player
     *
     * @return UUID
     */
    @NotNull
    UUID getUID();

    /**
     * Get land where the player is member in
     *
     * @param landName Name or displayname of land
     * @return Land or null, if not member
     */
    @Nullable
    Land getLand(@NotNull String landName);

    /**
     * Set edit land
     * /Lands edit
     *
     * @param land Land to select
     */
    void setEditLand(@Nullable Land land);

    /**
     * Get collection of lands the player is in
     *
     * @return Collection of lands
     */
    @NotNull
    Set<Land> getLands();

    /**
     * Get collection of lands the player is in of world
     *
     * @param worldName Name of world
     * @return Collection of lands
     */
    @NotNull
    Set<Land> getLands(@NotNull String worldName);


    /**
     * Get number of lands (own lands and where the player is trusted)
     * @return Will return 0, if player has no lands.
     */
    @NotNull
    int getSize();

    /**
     * Get an land the player owns in an world
     *
     * @param worldName Name wof world
     * @return Land or null, if no match found
     */
    @Nullable
    Land getOwningLand(@NotNull String worldName);

    /**
     * Get an owning land
     *
     * @return Land or null, if player doesn't own a land
     */
    @Nullable
    Land getOwningLand();

    /**
     * Get the land wich the player set
     * through /Lands edit or random one or null if
     * he has no lands
     *
     * @return Land or null, if no match found
     */
    Land getEditLand();

    /**
     * Get an land where the player can do an specific action
     *
     * @param landsAction Action
     * @return Land or null, if no match found
     */
    Land getAccessActionLand(@NotNull RoleSetting landsAction);

    /**
     * Get an land where the player can do an specific action in an specific world
     *
     * @param landsAction Action
     * @return Land or null, if no match found
     */
    Land getAccessActionLand(@NotNull RoleSetting landsAction, @NotNull String worldName);

    /**
     * Check if player invited from land
     *
     * @param landName Name of land
     * @return Will return false if no invite from land found.
     */
    @NotNull
    boolean hasInvite(@NotNull String landName);

    /**
     * Check if player has owning land
     *
     * @return Will return false if players doesn't own land.
     */
    @NotNull
    boolean hasOwningLand();

    /**
     * Get names of lands.
     *
     * @return Array
     */
    @NotNull
    String[] getLandNames();

    /**
     * Check is player in land
     *
     * @param iD ID of land
     * @return Boolean
     */
    @NotNull
    boolean isInLand(@NotNull int iD);
}
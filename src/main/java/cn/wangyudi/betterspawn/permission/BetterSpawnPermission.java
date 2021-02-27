package cn.wangyudi.betterspawn.permission;

/**
 * @author AbstractPrinter
 */

public enum BetterSpawnPermission {
    // 权限
    RELOAD("BetterSpawn.Reload"),
    ADD_POINT("BetterSpawn.AddPoint"),
    DEL_POINT("BetterSpawn.DelPoint");

    private final String permission;
    BetterSpawnPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

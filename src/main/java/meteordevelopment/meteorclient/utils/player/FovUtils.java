package meteordevelopment.meteorclient.utilis;

import meteordevelopment.meteorclient.utils.player.PlayerUtils;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import static meteordevelopment.meteorclient.MeteorClient.mc;

public class FovUtils {
    public static boolean inFov(Entity entity, double fov) {
        if (fov >= 360) return true;
        float[] angle = PlayerUtils.calculateAngle(entity.getBoundingBox().getCenter());
        double xDist = MathHelper.angleBetween(angle[0], mc.player.getYaw());
        double yDist = MathHelper.angleBetween(angle[1], mc.player.getPitch());
        double angleDistance = Math.hypot(xDist, yDist);
        return angleDistance <= fov;
    }
}

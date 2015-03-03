package tconstruct.plugins.imc;

import cpw.mods.fml.common.event.*;
import mantle.pulsar.pulse.*;
import net.minecraftforge.fluids.Fluid;
import tconstruct.TConstruct;
import tconstruct.util.config.PHConstruct;

import static tconstruct.smeltery.TinkerSmeltery.*;

@Pulse(id = "Tinkers Mystcraft Compatibility", forced = true, modsRequired = "Mystcraft", pulsesRequired = "Tinkers' Smeltery")
public class TinkerMystcraft
{
    @Handler
    public void init (FMLInitializationEvent event)
    {
        final Fluid[] fluids = new Fluid[] {
                // precious tinker fluids
                moltenGoldFluid,
                moltenSteelFluid,
                moltenEmeraldFluid,
                moltenArditeFluid,
                moltenCobaltFluid,
                // all alloys
                pigIronFluid,
                moltenBronzeFluid,
                moltenAlumiteFluid,
                moltenAlubrassFluid,
                moltenManyullynFluid,
                // precious TE fluids
                moltenEnderFluid,
                moltenSilverFluid,
                moltenInvarFluid,
                moltenElectrumFluid,
                moltenShinyFluid
        };

        TConstruct.logger.info("Mystcraft detected. Blacklisting Mystcraft fluid symbols.");
        for(Fluid fluid : fluids)
        {
            if(PHConstruct.blacklistMyst == true || fluid == null)
                continue;
            FMLInterModComms.sendMessage("Mystcraft", "blacklistfluid", fluid.getName());
        }
    }
}

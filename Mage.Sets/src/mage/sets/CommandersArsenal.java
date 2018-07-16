
package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 *
 * @author fireshoes
 */
public final class CommandersArsenal extends ExpansionSet {

    private static final CommandersArsenal instance = new CommandersArsenal();

    public static CommandersArsenal getInstance() {
        return instance;
    }

    private CommandersArsenal() {
        super("Commander's Arsenal", "CM1", ExpansionSet.buildDate(2012, 11, 2), SetType.SUPPLEMENTAL);
        this.blockName = "Command Zone";
        cards.add(new SetCardInfo("Chaos Warp", 1, Rarity.SPECIAL, mage.cards.c.ChaosWarp.class));
        cards.add(new SetCardInfo("Command Tower", 2, Rarity.COMMON, mage.cards.c.CommandTower.class));
        cards.add(new SetCardInfo("Decree of Pain", 3, Rarity.SPECIAL, mage.cards.d.DecreeOfPain.class));
        cards.add(new SetCardInfo("Desertion", 4, Rarity.SPECIAL, mage.cards.d.Desertion.class));
        cards.add(new SetCardInfo("Diaochan, Artful Beauty", 5, Rarity.SPECIAL, mage.cards.d.DiaochanArtfulBeauty.class));
        cards.add(new SetCardInfo("Dragonlair Spider", 6, Rarity.SPECIAL, mage.cards.d.DragonlairSpider.class));
        cards.add(new SetCardInfo("Duplicant", 7, Rarity.SPECIAL, mage.cards.d.Duplicant.class));
        cards.add(new SetCardInfo("Edric, Spymaster of Trest", 8, Rarity.SPECIAL, mage.cards.e.EdricSpymasterOfTrest.class));
        cards.add(new SetCardInfo("Kaalia of the Vast", 9, Rarity.SPECIAL, mage.cards.k.KaaliaOfTheVast.class));
        cards.add(new SetCardInfo("Loyal Retainers", 10, Rarity.SPECIAL, mage.cards.l.LoyalRetainers.class));
        cards.add(new SetCardInfo("Maelstrom Wanderer", 11, Rarity.SPECIAL, mage.cards.m.MaelstromWanderer.class));
        cards.add(new SetCardInfo("Mind's Eye", 13, Rarity.SPECIAL, mage.cards.m.MindsEye.class));
        cards.add(new SetCardInfo("Mirari's Wake", 14, Rarity.SPECIAL, mage.cards.m.MirarisWake.class));
        cards.add(new SetCardInfo("Rhystic Study", 15, Rarity.COMMON, mage.cards.r.RhysticStudy.class));
        cards.add(new SetCardInfo("Scroll Rack", 16, Rarity.SPECIAL, mage.cards.s.ScrollRack.class));
        cards.add(new SetCardInfo("Sylvan Library", 17, Rarity.SPECIAL, mage.cards.s.SylvanLibrary.class));
        cards.add(new SetCardInfo("The Mimeoplasm", 12, Rarity.SPECIAL, mage.cards.t.TheMimeoplasm.class));
        cards.add(new SetCardInfo("Vela the Night-Clad", 18, Rarity.SPECIAL, mage.cards.v.VelaTheNightClad.class));
    }

}

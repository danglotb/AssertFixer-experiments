/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 *
 * @author fireshoes
 */
public class ConspiracyTakeTheCrown extends ExpansionSet {

    private static final ConspiracyTakeTheCrown instance = new ConspiracyTakeTheCrown();

    public static ConspiracyTakeTheCrown getInstance() {
        return instance;
    }

    private ConspiracyTakeTheCrown() {
        super("Conspiracy: Take the Crown", "CN2", ExpansionSet.buildDate(2016, 8, 26), SetType.SUPPLEMENTAL);
        this.blockName = "Conspiracy";
        this.hasBasicLands = false;
        this.hasBoosters = true;
        this.numBoosterLands = 0;
        this.numBoosterCommon = 11;
        this.numBoosterUncommon = 3;
        this.numBoosterRare = 1;
        this.ratioBoosterMythic = 8;
        cards.add(new SetCardInfo("Absorb Vis", 126, Rarity.COMMON, mage.cards.a.AbsorbVis.class));
        cards.add(new SetCardInfo("Adriana, Captain of the Guard", 73, Rarity.RARE, mage.cards.a.AdrianaCaptainOfTheGuard.class));
        cards.add(new SetCardInfo("Affa Guard Hound", 81, Rarity.UNCOMMON, mage.cards.a.AffaGuardHound.class));
        cards.add(new SetCardInfo("Akroan Hoplite", 197, Rarity.UNCOMMON, mage.cards.a.AkroanHoplite.class));
        cards.add(new SetCardInfo("Altar's Reap", 127, Rarity.COMMON, mage.cards.a.AltarsReap.class));
        cards.add(new SetCardInfo("Ascended Lawmage", 198, Rarity.UNCOMMON, mage.cards.a.AscendedLawmage.class));
        cards.add(new SetCardInfo("Avatar of Woe", 128, Rarity.MYTHIC, mage.cards.a.AvatarOfWoe.class));
        cards.add(new SetCardInfo("Beast Within", 174, Rarity.UNCOMMON, mage.cards.b.BeastWithin.class));
        cards.add(new SetCardInfo("Berserk", 175, Rarity.MYTHIC, mage.cards.b.Berserk.class));
        cards.add(new SetCardInfo("Besmirch", 49, Rarity.UNCOMMON, mage.cards.b.Besmirch.class));
        cards.add(new SetCardInfo("Birds of Paradise", 176, Rarity.RARE, mage.cards.b.BirdsOfParadise.class));
        cards.add(new SetCardInfo("Blood-Toll Harpy", 129, Rarity.COMMON, mage.cards.b.BloodTollHarpy.class));
        cards.add(new SetCardInfo("Bonds of Quicksilver", 102, Rarity.COMMON, mage.cards.b.BondsOfQuicksilver.class));
        cards.add(new SetCardInfo("Borderland Explorer", 61, Rarity.COMMON, mage.cards.b.BorderlandExplorer.class));
        cards.add(new SetCardInfo("Bronze Sable", 208, Rarity.COMMON, mage.cards.b.BronzeSable.class));
        cards.add(new SetCardInfo("Brushstrider", 177, Rarity.UNCOMMON, mage.cards.b.Brushstrider.class));
        cards.add(new SetCardInfo("Burgeoning", 178, Rarity.RARE, mage.cards.b.Burgeoning.class));
        cards.add(new SetCardInfo("Burn Away", 151, Rarity.UNCOMMON, mage.cards.b.BurnAway.class));
        cards.add(new SetCardInfo("Burning Wish", 152, Rarity.RARE, mage.cards.b.BurningWish.class));
        cards.add(new SetCardInfo("Caller of Gales", 103, Rarity.COMMON, mage.cards.c.CallerOfGales.class));
        cards.add(new SetCardInfo("Canal Courier", 28, Rarity.COMMON, mage.cards.c.CanalCourier.class));
        cards.add(new SetCardInfo("Capital Punishment", 40, Rarity.RARE, mage.cards.c.CapitalPunishment.class));
        cards.add(new SetCardInfo("Carnage Gladiator", 199, Rarity.UNCOMMON, mage.cards.c.CarnageGladiator.class));
        cards.add(new SetCardInfo("Charmbreaker Devils", 153, Rarity.RARE, mage.cards.c.CharmbreakerDevils.class));
        cards.add(new SetCardInfo("Child of Night", 130, Rarity.COMMON, mage.cards.c.ChildOfNight.class));
        cards.add(new SetCardInfo("Cloaked Siren", 104, Rarity.COMMON, mage.cards.c.CloakedSiren.class));
        cards.add(new SetCardInfo("Coiling Oracle", 200, Rarity.UNCOMMON, mage.cards.c.CoilingOracle.class));
        cards.add(new SetCardInfo("Coordinated Assault", 154, Rarity.UNCOMMON, mage.cards.c.CoordinatedAssault.class));
        cards.add(new SetCardInfo("Copperhorn Scout", 179, Rarity.COMMON, mage.cards.c.CopperhornScout.class));
        cards.add(new SetCardInfo("Covenant of Minds", 105, Rarity.RARE, mage.cards.c.CovenantOfMinds.class));
        cards.add(new SetCardInfo("Coveted Peacock", 29, Rarity.UNCOMMON, mage.cards.c.CovetedPeacock.class));
        cards.add(new SetCardInfo("Crown-Hunter Hireling", 50, Rarity.COMMON, mage.cards.c.CrownHunterHireling.class));
        cards.add(new SetCardInfo("Custodi Lich", 41, Rarity.RARE, mage.cards.c.CustodiLich.class));
        cards.add(new SetCardInfo("Custodi Soulcaller", 15, Rarity.UNCOMMON, mage.cards.c.CustodiSoulcaller.class));
        cards.add(new SetCardInfo("Daretti, Ingenious Iconoclast", 74, Rarity.MYTHIC, mage.cards.d.DarettiIngeniousIconoclast.class));
        cards.add(new SetCardInfo("Deadly Designs", 42, Rarity.UNCOMMON, mage.cards.d.DeadlyDesigns.class));
        cards.add(new SetCardInfo("Death Wind", 131, Rarity.COMMON, mage.cards.d.DeathWind.class));
        cards.add(new SetCardInfo("Deceiver Exarch", 106, Rarity.UNCOMMON, mage.cards.d.DeceiverExarch.class));
        cards.add(new SetCardInfo("Deputized Protester", 51, Rarity.COMMON, mage.cards.d.DeputizedProtester.class));
        cards.add(new SetCardInfo("Desertion", 107, Rarity.RARE, mage.cards.d.Desertion.class));
        cards.add(new SetCardInfo("Diabolic Tutor", 132, Rarity.UNCOMMON, mage.cards.d.DiabolicTutor.class));
        cards.add(new SetCardInfo("Disenchant", 82, Rarity.COMMON, mage.cards.d.Disenchant.class));
        cards.add(new SetCardInfo("Dismiss", 108, Rarity.UNCOMMON, mage.cards.d.Dismiss.class));
        cards.add(new SetCardInfo("Divination", 109, Rarity.COMMON, mage.cards.d.Divination.class));
        cards.add(new SetCardInfo("Domesticated Hydra", 63, Rarity.UNCOMMON, mage.cards.d.DomesticatedHydra.class));
        cards.add(new SetCardInfo("Doomed Traveler", 83, Rarity.COMMON, mage.cards.d.DoomedTraveler.class));
        cards.add(new SetCardInfo("Dragonlair Spider", 201, Rarity.RARE, mage.cards.d.DragonlairSpider.class));
        cards.add(new SetCardInfo("Dread Statuary", 217, Rarity.UNCOMMON, mage.cards.d.DreadStatuary.class));
        cards.add(new SetCardInfo("Driver of the Dead", 133, Rarity.COMMON, mage.cards.d.DriverOfTheDead.class));
        cards.add(new SetCardInfo("Duskmantle Seer", 202, Rarity.RARE, mage.cards.d.DuskmantleSeer.class));
        cards.add(new SetCardInfo("Ember Beast", 155, Rarity.COMMON, mage.cards.e.EmberBeast.class));
        cards.add(new SetCardInfo("Entourage of Trest", 64, Rarity.COMMON, mage.cards.e.EntourageOfTrest.class));
        cards.add(new SetCardInfo("Evolving Wilds", 218, Rarity.COMMON, mage.cards.e.EvolvingWilds.class));
        cards.add(new SetCardInfo("Exotic Orchard", 219, Rarity.RARE, mage.cards.e.ExoticOrchard.class));
        cards.add(new SetCardInfo("Explosive Vegetation", 180, Rarity.UNCOMMON, mage.cards.e.ExplosiveVegetation.class));
        cards.add(new SetCardInfo("Expropriate", 30, Rarity.MYTHIC, mage.cards.e.Expropriate.class));
        cards.add(new SetCardInfo("Fade into Antiquity", 181, Rarity.COMMON, mage.cards.f.FadeIntoAntiquity.class));
        cards.add(new SetCardInfo("Faith's Reward", 84, Rarity.RARE, mage.cards.f.FaithsReward.class));
        cards.add(new SetCardInfo("Fang of the Pack", 65, Rarity.UNCOMMON, mage.cards.f.FangOfThePack.class));
        cards.add(new SetCardInfo("Farbog Boneflinger", 134, Rarity.UNCOMMON, mage.cards.f.FarbogBoneflinger.class));
        cards.add(new SetCardInfo("Festergloom", 135, Rarity.COMMON, mage.cards.f.Festergloom.class));
        cards.add(new SetCardInfo("Fiery Fall", 156, Rarity.COMMON, mage.cards.f.FieryFall.class));
        cards.add(new SetCardInfo("Flame Slash", 157, Rarity.COMMON, mage.cards.f.FlameSlash.class));
        cards.add(new SetCardInfo("Fleeting Distraction", 110, Rarity.COMMON, mage.cards.f.FleetingDistraction.class));
        cards.add(new SetCardInfo("Fleshbag Marauder", 136, Rarity.UNCOMMON, mage.cards.f.FleshbagMarauder.class));
        cards.add(new SetCardInfo("Followed Footsteps", 111, Rarity.RARE, mage.cards.f.FollowedFootsteps.class));
        cards.add(new SetCardInfo("Forgotten Ancient", 182, Rarity.RARE, mage.cards.f.ForgottenAncient.class));
        cards.add(new SetCardInfo("Gang of Devils", 158, Rarity.UNCOMMON, mage.cards.g.GangOfDevils.class));
        cards.add(new SetCardInfo("Garrulous Sycophant", 43, Rarity.COMMON, mage.cards.g.GarrulousSycophant.class));
        cards.add(new SetCardInfo("Ghostly Possession", 85, Rarity.COMMON, mage.cards.g.GhostlyPossession.class));
        cards.add(new SetCardInfo("Ghostly Prison", 86, Rarity.UNCOMMON, mage.cards.g.GhostlyPrison.class));
        cards.add(new SetCardInfo("Gleam of Resistance", 87, Rarity.COMMON, mage.cards.g.GleamOfResistance.class));
        cards.add(new SetCardInfo("Goblin Balloon Brigade", 159, Rarity.COMMON, mage.cards.g.GoblinBalloonBrigade.class));
        cards.add(new SetCardInfo("Goblin Racketeer", 53, Rarity.COMMON, mage.cards.g.GoblinRacketeer.class));
        cards.add(new SetCardInfo("Goblin Tunneler", 160, Rarity.COMMON, mage.cards.g.GoblinTunneler.class));
        cards.add(new SetCardInfo("Gods Willing", 88, Rarity.COMMON, mage.cards.g.GodsWilling.class));
        cards.add(new SetCardInfo("Gratuitous Violence", 161, Rarity.RARE, mage.cards.g.GratuitousViolence.class));
        cards.add(new SetCardInfo("Grenzo's Ruffians", 55, Rarity.UNCOMMON, mage.cards.g.GrenzosRuffians.class));
        cards.add(new SetCardInfo("Grenzo, Havoc Raiser", 54, Rarity.RARE, mage.cards.g.GrenzoHavocRaiser.class));
        cards.add(new SetCardInfo("Gruul War Chant", 203, Rarity.UNCOMMON, mage.cards.g.GruulWarChant.class));
        cards.add(new SetCardInfo("Guardian of the Gateless", 89, Rarity.UNCOMMON, mage.cards.g.GuardianOfTheGateless.class));
        cards.add(new SetCardInfo("Guttersnipe", 162, Rarity.UNCOMMON, mage.cards.g.Guttersnipe.class));
        cards.add(new SetCardInfo("Guul Draz Specter", 137, Rarity.RARE, mage.cards.g.GuulDrazSpecter.class));
        cards.add(new SetCardInfo("Hail of Arrows", 90, Rarity.UNCOMMON, mage.cards.h.HailOfArrows.class));
        cards.add(new SetCardInfo("Hallowed Burial", 91, Rarity.RARE, mage.cards.h.HallowedBurial.class));
        cards.add(new SetCardInfo("Hamletback Goliath", 163, Rarity.RARE, mage.cards.h.HamletbackGoliath.class));
        cards.add(new SetCardInfo("Harvester of Souls", 138, Rarity.RARE, mage.cards.h.HarvesterOfSouls.class));
        cards.add(new SetCardInfo("Havengul Vampire", 164, Rarity.UNCOMMON, mage.cards.h.HavengulVampire.class));
        cards.add(new SetCardInfo("Hedron Matrix", 209, Rarity.RARE, mage.cards.h.HedronMatrix.class));
        cards.add(new SetCardInfo("Hexplate Golem", 210, Rarity.COMMON, mage.cards.h.HexplateGolem.class));
        cards.add(new SetCardInfo("Hollowhenge Spirit", 92, Rarity.UNCOMMON, mage.cards.h.HollowhengeSpirit.class));
        cards.add(new SetCardInfo("Horn of Greed", 211, Rarity.RARE, mage.cards.h.HornOfGreed.class));
        cards.add(new SetCardInfo("Hundred-Handed One", 93, Rarity.RARE, mage.cards.h.HundredHandedOne.class));
        cards.add(new SetCardInfo("Hurly-Burly", 165, Rarity.COMMON, mage.cards.h.HurlyBurly.class));
        cards.add(new SetCardInfo("Ill-Tempered Cyclops", 166, Rarity.COMMON, mage.cards.i.IllTemperedCyclops.class));
        cards.add(new SetCardInfo("Infest", 139, Rarity.UNCOMMON, mage.cards.i.Infest.class));
        cards.add(new SetCardInfo("Inquisition of Kozilek", 140, Rarity.RARE, mage.cards.i.InquisitionOfKozilek.class));
        cards.add(new SetCardInfo("Into the Void", 112, Rarity.UNCOMMON, mage.cards.i.IntoTheVoid.class));
        cards.add(new SetCardInfo("Irresistible Prey", 183, Rarity.UNCOMMON, mage.cards.i.IrresistiblePrey.class));
        cards.add(new SetCardInfo("Jeering Homunculus", 33, Rarity.COMMON, mage.cards.j.JeeringHomunculus.class));
        cards.add(new SetCardInfo("Juniper Order Ranger", 204, Rarity.UNCOMMON, mage.cards.j.JuniperOrderRanger.class));
        cards.add(new SetCardInfo("Kami of the Crescent Moon", 113, Rarity.RARE, mage.cards.k.KamiOfTheCrescentMoon.class));
        cards.add(new SetCardInfo("Kaya, Ghost Assassin", 75, Rarity.MYTHIC, mage.cards.k.KayaGhostAssassin.class));
        cards.add(new SetCardInfo("Keeper of Keys", 34, Rarity.RARE, mage.cards.k.KeeperOfKeys.class));
        cards.add(new SetCardInfo("Keepsake Gorgon", 141, Rarity.UNCOMMON, mage.cards.k.KeepsakeGorgon.class));
        cards.add(new SetCardInfo("Kill Shot", 94, Rarity.COMMON, mage.cards.k.KillShot.class));
        cards.add(new SetCardInfo("Kiln Fiend", 167, Rarity.COMMON, mage.cards.k.KilnFiend.class));
        cards.add(new SetCardInfo("Kitesail", 212, Rarity.COMMON, mage.cards.k.Kitesail.class));
        cards.add(new SetCardInfo("Knights of the Black Rose", 76, Rarity.UNCOMMON, mage.cards.k.KnightsOfTheBlackRose.class));
        cards.add(new SetCardInfo("Lace with Moonglove", 184, Rarity.COMMON, mage.cards.l.LaceWithMoonglove.class));
        cards.add(new SetCardInfo("Lay of the Land", 185, Rarity.COMMON, mage.cards.l.LayOfTheLand.class));
        cards.add(new SetCardInfo("Leovold, Emissary of Trest", 77, Rarity.MYTHIC, mage.cards.l.LeovoldEmissaryOfTrest.class));
        cards.add(new SetCardInfo("Lieutenants of the Guard", 16, Rarity.COMMON, mage.cards.l.LieutenantsOfTheGuard.class));
        cards.add(new SetCardInfo("Manaplasm", 186, Rarity.UNCOMMON, mage.cards.m.Manaplasm.class));
        cards.add(new SetCardInfo("Marchesa's Decree", 44, Rarity.UNCOMMON, mage.cards.m.MarchesasDecree.class));
        cards.add(new SetCardInfo("Mausoleum Turnkey", 142, Rarity.UNCOMMON, mage.cards.m.MausoleumTurnkey.class));
        cards.add(new SetCardInfo("Menagerie Liberator", 67, Rarity.COMMON, mage.cards.m.MenagerieLiberator.class));
        cards.add(new SetCardInfo("Merfolk Looter", 114, Rarity.UNCOMMON, mage.cards.m.MerfolkLooter.class));
        cards.add(new SetCardInfo("Merfolk Skyscout", 115, Rarity.UNCOMMON, mage.cards.m.MerfolkSkyscout.class));
        cards.add(new SetCardInfo("Messenger Jays", 35, Rarity.COMMON, mage.cards.m.MessengerJays.class));
        cards.add(new SetCardInfo("Mnemonic Wall", 116, Rarity.COMMON, mage.cards.m.MnemonicWall.class));
        cards.add(new SetCardInfo("Murder", 143, Rarity.COMMON, mage.cards.m.Murder.class));
        cards.add(new SetCardInfo("Negate", 117, Rarity.COMMON, mage.cards.n.Negate.class));
        cards.add(new SetCardInfo("Nessian Asp", 187, Rarity.COMMON, mage.cards.n.NessianAsp.class));
        cards.add(new SetCardInfo("Netcaster Spider", 188, Rarity.COMMON, mage.cards.n.NetcasterSpider.class));
        cards.add(new SetCardInfo("Ogre Sentry", 168, Rarity.COMMON, mage.cards.o.OgreSentry.class));
        cards.add(new SetCardInfo("Omenspeaker", 118, Rarity.COMMON, mage.cards.o.Omenspeaker.class));
        cards.add(new SetCardInfo("Opaline Unicorn", 213, Rarity.COMMON, mage.cards.o.OpalineUnicorn.class));
        cards.add(new SetCardInfo("Orchard Elemental", 68, Rarity.COMMON, mage.cards.o.OrchardElemental.class));
        cards.add(new SetCardInfo("Overrun", 189, Rarity.UNCOMMON, mage.cards.o.Overrun.class));
        cards.add(new SetCardInfo("Palace Jailer", 18, Rarity.UNCOMMON, mage.cards.p.PalaceJailer.class));
        cards.add(new SetCardInfo("Palace Sentinels", 19, Rarity.COMMON, mage.cards.p.PalaceSentinels.class));
        cards.add(new SetCardInfo("Pariah", 95, Rarity.RARE, mage.cards.p.Pariah.class));
        cards.add(new SetCardInfo("Pharika's Mender", 205, Rarity.UNCOMMON, mage.cards.p.PharikasMender.class));
        cards.add(new SetCardInfo("Phyrexian Arena", 144, Rarity.RARE, mage.cards.p.PhyrexianArena.class));
        cards.add(new SetCardInfo("Platinum Angel", 214, Rarity.MYTHIC, mage.cards.p.PlatinumAngel.class));
        cards.add(new SetCardInfo("Plummet", 190, Rarity.COMMON, mage.cards.p.Plummet.class));
        cards.add(new SetCardInfo("Prey Upon", 191, Rarity.COMMON, mage.cards.p.PreyUpon.class));
        cards.add(new SetCardInfo("Protector of the Crown", 21, Rarity.RARE, mage.cards.p.ProtectorOfTheCrown.class));
        cards.add(new SetCardInfo("Psychosis Crawler", 215, Rarity.RARE, mage.cards.p.PsychosisCrawler.class));
        cards.add(new SetCardInfo("Public Execution", 145, Rarity.UNCOMMON, mage.cards.p.PublicExecution.class));
        cards.add(new SetCardInfo("Queen Marchesa", 78, Rarity.MYTHIC, mage.cards.q.QueenMarchesa.class));
        cards.add(new SetCardInfo("Raise Dead", 146, Rarity.COMMON, mage.cards.r.RaiseDead.class));
        cards.add(new SetCardInfo("Raise the Alarm", 96, Rarity.COMMON, mage.cards.r.RaiseTheAlarm.class));
        cards.add(new SetCardInfo("Ravenous Leucrocota", 192, Rarity.COMMON, mage.cards.r.RavenousLeucrocota.class));
        cards.add(new SetCardInfo("Recruiter of the Guard", 22, Rarity.RARE, mage.cards.r.RecruiterOfTheGuard.class));
        cards.add(new SetCardInfo("Regal Behemoth", 69, Rarity.RARE, mage.cards.r.RegalBehemoth.class));
        cards.add(new SetCardInfo("Repulse", 119, Rarity.COMMON, mage.cards.r.Repulse.class));
        cards.add(new SetCardInfo("Reviving Dose", 97, Rarity.COMMON, mage.cards.r.RevivingDose.class));
        cards.add(new SetCardInfo("Rogue's Passage", 220, Rarity.UNCOMMON, mage.cards.r.RoguesPassage.class));
        cards.add(new SetCardInfo("Runed Servitor", 216, Rarity.UNCOMMON, mage.cards.r.RunedServitor.class));
        cards.add(new SetCardInfo("Sanctum Prelate", 23, Rarity.MYTHIC, mage.cards.s.SanctumPrelate.class));
        cards.add(new SetCardInfo("Sangromancer", 147, Rarity.RARE, mage.cards.s.Sangromancer.class));
        cards.add(new SetCardInfo("Selvala's Stampede", 71, Rarity.RARE, mage.cards.s.SelvalasStampede.class));
        cards.add(new SetCardInfo("Selvala, Heart of the Wilds", 70, Rarity.MYTHIC, mage.cards.s.SelvalaHeartOfTheWilds.class));
        cards.add(new SetCardInfo("Serum Visions", 120, Rarity.UNCOMMON, mage.cards.s.SerumVisions.class));
        cards.add(new SetCardInfo("Shambling Goblin", 148, Rarity.COMMON, mage.cards.s.ShamblingGoblin.class));
        cards.add(new SetCardInfo("Shimmering Grotto", 221, Rarity.COMMON, mage.cards.s.ShimmeringGrotto.class));
        cards.add(new SetCardInfo("Shipwreck Singer", 206, Rarity.UNCOMMON, mage.cards.s.ShipwreckSinger.class));
        cards.add(new SetCardInfo("Show and Tell", 121, Rarity.MYTHIC, mage.cards.s.ShowAndTell.class));
        cards.add(new SetCardInfo("Sinuous Vermin", 46, Rarity.COMMON, mage.cards.s.SinuousVermin.class));
        cards.add(new SetCardInfo("Skittering Crustacean", 36, Rarity.COMMON, mage.cards.s.SkitteringCrustacean.class));
        cards.add(new SetCardInfo("Skyline Despot", 57, Rarity.RARE, mage.cards.s.SkylineDespot.class));
        cards.add(new SetCardInfo("Spectral Grasp", 24, Rarity.UNCOMMON, mage.cards.s.SpectralGrasp.class));
        cards.add(new SetCardInfo("Sphinx of Magosi", 122, Rarity.RARE, mage.cards.s.SphinxOfMagosi.class));
        cards.add(new SetCardInfo("Spirit of the Hearth", 98, Rarity.RARE, mage.cards.s.SpiritOfTheHearth.class));
        cards.add(new SetCardInfo("Splitting Slime", 72, Rarity.RARE, mage.cards.s.SplittingSlime.class));
        cards.add(new SetCardInfo("Stoneshock Giant", 169, Rarity.UNCOMMON, mage.cards.s.StoneshockGiant.class));
        cards.add(new SetCardInfo("Stormchaser Chimera", 207, Rarity.UNCOMMON, mage.cards.s.StormchaserChimera.class));
        cards.add(new SetCardInfo("Strength in Numbers", 193, Rarity.COMMON, mage.cards.s.StrengthInNumbers.class));
        cards.add(new SetCardInfo("Stromkirk Patrol", 149, Rarity.COMMON, mage.cards.s.StromkirkPatrol.class));
        cards.add(new SetCardInfo("Stunt Double", 38, Rarity.RARE, mage.cards.s.StuntDouble.class));
        cards.add(new SetCardInfo("Subterranean Tremors", 58, Rarity.MYTHIC, mage.cards.s.SubterraneanTremors.class));
        cards.add(new SetCardInfo("Sulfurous Blast", 170, Rarity.UNCOMMON, mage.cards.s.SulfurousBlast.class));
        cards.add(new SetCardInfo("Sylvan Bounty", 194, Rarity.COMMON, mage.cards.s.SylvanBounty.class));
        cards.add(new SetCardInfo("Thorn of the Black Rose", 48, Rarity.COMMON, mage.cards.t.ThornOfTheBlackRose.class));
        cards.add(new SetCardInfo("Throne Warden", 25, Rarity.COMMON, mage.cards.t.ThroneWarden.class));
        cards.add(new SetCardInfo("Throne of the High City", 80, Rarity.RARE, mage.cards.t.ThroneOfTheHighCity.class));
        cards.add(new SetCardInfo("Tormenting Voice", 171, Rarity.COMMON, mage.cards.t.TormentingVoice.class));
        cards.add(new SetCardInfo("Traumatic Visions", 123, Rarity.COMMON, mage.cards.t.TraumaticVisions.class));
        cards.add(new SetCardInfo("Trumpet Blast", 172, Rarity.COMMON, mage.cards.t.TrumpetBlast.class));
        cards.add(new SetCardInfo("Twin Bolt", 173, Rarity.COMMON, mage.cards.t.TwinBolt.class));
        cards.add(new SetCardInfo("Unnerve", 150, Rarity.COMMON, mage.cards.u.Unnerve.class));
        cards.add(new SetCardInfo("Vaporkin", 124, Rarity.COMMON, mage.cards.v.Vaporkin.class));
        cards.add(new SetCardInfo("Vertigo Spawn", 125, Rarity.UNCOMMON, mage.cards.v.VertigoSpawn.class));
        cards.add(new SetCardInfo("Voyaging Satyr", 195, Rarity.COMMON, mage.cards.v.VoyagingSatyr.class));
        cards.add(new SetCardInfo("Wild Griffin", 99, Rarity.COMMON, mage.cards.w.WildGriffin.class));
        cards.add(new SetCardInfo("Wild Pair", 196, Rarity.RARE, mage.cards.w.WildPair.class));
        cards.add(new SetCardInfo("Windborne Charge", 100, Rarity.UNCOMMON, mage.cards.w.WindborneCharge.class));
        cards.add(new SetCardInfo("Wings of the Guard", 26, Rarity.COMMON, mage.cards.w.WingsOfTheGuard.class));
        cards.add(new SetCardInfo("Zealous Strike", 101, Rarity.COMMON, mage.cards.z.ZealousStrike.class));
    }

}

/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.cards.s;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.AttachEffect;
import mage.abilities.effects.common.continuous.GainAbilityAttachedEffect;
import mage.abilities.keyword.EnchantAbility;
import mage.abilities.keyword.HasteAbility;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.cards.Cards;
import mage.cards.CardsImpl;
import mage.constants.AttachmentType;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.SubType;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.common.FilterControlledCreaturePermanent;
import mage.filter.predicate.permanent.PermanentIdPredicate;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.Target;
import mage.target.TargetPermanent;
import mage.target.common.TargetControlledCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author Saga
 */
public class ShiftingShadow extends CardImpl {

    public ShiftingShadow(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "{2}{R}");
        this.subtype.add(SubType.AURA);

        // Enchant creature
        TargetPermanent auraTarget = new TargetCreaturePermanent();
        this.getSpellAbility().addTarget(auraTarget);
        this.getSpellAbility().addEffect(new AttachEffect(Outcome.AddAbility));
        this.addAbility(new EnchantAbility(auraTarget.getTargetName()));

        // Enchanted creature has haste and “At the beginning of your upkeep, destroy this creature. Reveal cards from the top of your library until you reveal a creature card.
        // Put that card onto the battlefield and attach Shifting Shadow to it, then put all other cards revealed this way on the bottom of your library in a random order.”
        Ability ability = new SimpleStaticAbility(Zone.BATTLEFIELD, new GainAbilityAttachedEffect(HasteAbility.getInstance(), AttachmentType.AURA));
        Effect effect = new GainAbilityAttachedEffect(new BeginningOfUpkeepTriggeredAbility(
                new ShiftingShadowEffect(this.getId()), TargetController.YOU, false), AttachmentType.AURA);
        effect.setText("and \"At the beginning of your upkeep, destroy this creature. Reveal cards from the top of your library until you reveal a creature card. "
                + "Put that card onto the battlefield and attach {this} to it, then put all other cards revealed this way on the bottom of your library in a random order.\"");
        ability.addEffect(effect);
        this.addAbility(ability);
    }

    public ShiftingShadow(final ShiftingShadow card) {
        super(card);
    }

    @Override
    public ShiftingShadow copy() {
        return new ShiftingShadow(this);
    }
}

class ShiftingShadowEffect extends OneShotEffect {

    private UUID auraId;

    public ShiftingShadowEffect(UUID auraId) {
        super(Outcome.PutCreatureInPlay);
        this.staticText = "destroy this creature. Reveal cards from the top of your library until you reveal a creature card. "
                + "Put that card onto the battlefield and attach Shifting Shadow to it, then put all other cards revealed this way on the bottom of your library in a random order";
        this.auraId = auraId;
    }

    public ShiftingShadowEffect(final ShiftingShadowEffect effect, UUID auraId) {
        super(effect);
        this.auraId = auraId;
    }

    @Override
    public ShiftingShadowEffect copy() {
        return new ShiftingShadowEffect(this, auraId);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        Permanent enchanted = game.getPermanentOrLKIBattlefield(source.getSourceId());
        if (controller != null && enchanted != null) {
            Permanent aura = null;
            int index = 0;
            while (aura == null && index < enchanted.getAttachments().size()) {
                UUID attached = enchanted.getAttachments().get(index);
                if (attached.equals(auraId)) {
                    aura = game.getPermanentOrLKIBattlefield(attached);
                } else {
                    index += 1;
                }
            }
            if (aura != null) {
                enchanted.destroy(source.getSourceId(), game, false);
                Cards revealed = new CardsImpl();
                Cards otherCards = new CardsImpl();
                for (Card card : controller.getLibrary().getCards(game)) {
                    revealed.add(card);
                    if (card != null && card.isCreature()) {
                        controller.moveCards(card, Zone.BATTLEFIELD, source, game);
                        Permanent newEnchanted = game.getPermanent(card.getId());
                        FilterControlledCreaturePermanent filter = new FilterControlledCreaturePermanent();
                        filter.add(new PermanentIdPredicate(card.getId()));
                        Target target = new TargetControlledCreaturePermanent(filter);
                        if (newEnchanted != null) {
                            target.addTarget(newEnchanted.getId(), source, game);
                            aura.getSpellAbility().getTargets().clear();
                            aura.getSpellAbility().getTargets().add(target);
                            newEnchanted.addAttachment(aura.getId(), game);
                        }
                        break;
                    } else {
                        otherCards.add(card);
                    }
                }
                controller.revealCards(enchanted.getIdName(), revealed, game);
                controller.putCardsOnBottomOfLibrary(otherCards, game, source, false);
                return true;
            }
        }
        return false;
    }
}

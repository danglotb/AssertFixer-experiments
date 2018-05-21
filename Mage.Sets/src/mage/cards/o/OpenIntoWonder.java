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
package mage.cards.o;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.SpellAbility;
import mage.abilities.common.DealsCombatDamageToAPlayerTriggeredAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.effects.common.combat.CantBeBlockedTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.filter.StaticFilters;
import mage.game.Game;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author LevelX2
 */
public class OpenIntoWonder extends CardImpl {

    public OpenIntoWonder(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{X}{U}{U}");

        // X target creatures can't be blocked this turn. Until end of turn, those creatures gain "Whenever this creature deals combat damage to a player, draw a card."
        Effect effect = new CantBeBlockedTargetEffect(Duration.EndOfTurn);
        effect.setText("X target creatures can't be blocked this turn");
        this.getSpellAbility().addEffect(effect);
        this.getSpellAbility().addTarget(new TargetCreaturePermanent(0, 1, StaticFilters.FILTER_PERMANENT_CREATURE, false));
        Ability abilityToGain = new DealsCombatDamageToAPlayerTriggeredAbility(new DrawCardSourceControllerEffect(1), false);
        this.getSpellAbility().addEffect(new GainAbilityTargetEffect(abilityToGain, Duration.EndOfTurn,
                "Until end of turn, those creatures gain \"Whenever this creature deals combat damage to a player, draw a card.\""));
    }

    public OpenIntoWonder(final OpenIntoWonder card) {
        super(card);
    }

    @Override
    public void adjustTargets(Ability ability, Game game) {
        if (ability instanceof SpellAbility) {
            ability.getTargets().clear();
            int numberOfTargets = ability.getManaCostsToPay().getX();
            numberOfTargets = Math.min(game.getBattlefield().count(StaticFilters.FILTER_PERMANENT_CREATURE, ability.getSourceId(), ability.getControllerId(), game), numberOfTargets);
            ability.addTarget(new TargetCreaturePermanent(numberOfTargets));
        }
    }

    @Override
    public OpenIntoWonder copy() {
        return new OpenIntoWonder(this);
    }
}

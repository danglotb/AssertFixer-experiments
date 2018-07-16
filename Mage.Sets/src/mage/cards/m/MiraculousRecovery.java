
package mage.cards.m;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.ReturnFromGraveyardToBattlefieldTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.counters.CounterType;
import mage.filter.common.FilterCreatureCard;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.target.Target;
import mage.target.common.TargetCardInYourGraveyard;

/**
 *
 * @author LevelX2
 */
public final class MiraculousRecovery extends CardImpl {

    public MiraculousRecovery(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.INSTANT},"{4}{W}");


        // Return target creature card from your graveyard to the battlefield. Put a +1/+1 counter on it.
        this.getSpellAbility().addEffect(new ReturnFromGraveyardToBattlefieldTargetEffect());
        Target target = new TargetCardInYourGraveyard(new FilterCreatureCard());
        this.getSpellAbility().addTarget(target);
        this.getSpellAbility().addEffect(new MiraculousRecoveryEffect());
    }

    public MiraculousRecovery(final MiraculousRecovery card) {
        super(card);
    }

    @Override
    public MiraculousRecovery copy() {
        return new MiraculousRecovery(this);
    }
}

class MiraculousRecoveryEffect extends OneShotEffect {

    public MiraculousRecoveryEffect() {
        super(Outcome.BoostCreature);
        this.staticText = "Put a +1/+1 counter on it";
    }

    public MiraculousRecoveryEffect(final MiraculousRecoveryEffect effect) {
        super(effect);
    }

    @Override
    public MiraculousRecoveryEffect copy() {
        return new MiraculousRecoveryEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        // targetPointer can't be used because target moved from graveyard to battlefield
        Permanent permanent = game.getPermanent(source.getFirstTarget());
        if (permanent != null) {
                permanent.addCounters(CounterType.P1P1.createInstance(), source, game);
        }
        return false;
    }
}

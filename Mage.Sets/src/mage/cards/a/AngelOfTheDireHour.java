
package mage.cards.a;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.EntersBattlefieldTriggeredAbility;
import mage.abilities.condition.common.CastFromHandSourceCondition;
import mage.abilities.decorator.ConditionalInterveningIfTriggeredAbility;
import mage.abilities.effects.common.ExileAllEffect;
import mage.abilities.keyword.FlashAbility;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.common.FilterAttackingCreature;
import mage.watchers.common.CastFromHandWatcher;

/**
 *
 * @author LevelX2
 */
public final class AngelOfTheDireHour extends CardImpl {

    public AngelOfTheDireHour(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{5}{W}{W}");
        this.subtype.add(SubType.ANGEL);

        this.power = new MageInt(5);
        this.toughness = new MageInt(4);

        // Flash
        this.addAbility(FlashAbility.getInstance());
        // Flying
        this.addAbility(FlyingAbility.getInstance());
        // When Angel of the Dire Hour enters the battlefield, if you cast it from your hand, exile all attacking creatures.
        this.addAbility(new ConditionalInterveningIfTriggeredAbility(
                new EntersBattlefieldTriggeredAbility(new ExileAllEffect(new FilterAttackingCreature("attacking creatures")), false),
                CastFromHandSourceCondition.instance,
                "When {this} enters the battlefield, if you cast it from your hand, exile all attacking creatures."),
                new CastFromHandWatcher());
    }

    public AngelOfTheDireHour(final AngelOfTheDireHour card) {
        super(card);
    }

    @Override
    public AngelOfTheDireHour copy() {
        return new AngelOfTheDireHour(this);
    }
}

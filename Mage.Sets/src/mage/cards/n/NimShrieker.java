
package mage.cards.n;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.dynamicvalue.common.PermanentsOnBattlefieldCount;
import mage.abilities.dynamicvalue.common.StaticValue;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Duration;
import mage.constants.Zone;
import mage.filter.common.FilterControlledPermanent;
import mage.filter.predicate.mageobject.CardTypePredicate;

/**
 * @author Loki
 */
public final class NimShrieker extends CardImpl {

    private static final FilterControlledPermanent filter = new FilterControlledPermanent("artifact you control");

    static {
        filter.add(new CardTypePredicate(CardType.ARTIFACT));
    }

    public NimShrieker(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{3}{B}");
        this.subtype.add(SubType.ZOMBIE);

        this.power = new MageInt(0);
        this.toughness = new MageInt(1);
        this.addAbility(FlyingAbility.getInstance());
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new BoostSourceEffect(new PermanentsOnBattlefieldCount(filter), new StaticValue(0), Duration.WhileOnBattlefield)));
    }

    public NimShrieker(final NimShrieker card) {
        super(card);
    }

    @Override
    public NimShrieker copy() {
        return new NimShrieker(this);
    }
}


package mage.cards.v;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.UntapTargetEffect;
import mage.abilities.keyword.GraftAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.counters.CounterType;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.permanent.CounterPredicate;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author JotaPeRL
 */
public final class VigeanGraftmage extends CardImpl {
    
    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("a creature with a +1/+1 counter on it");
    static {
        filter.add(new CounterPredicate(CounterType.P1P1));
    }    

    public VigeanGraftmage(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{U}");
        this.subtype.add(SubType.VEDALKEN);
        this.subtype.add(SubType.WIZARD);
        this.subtype.add(SubType.MUTANT);
        this.power = new MageInt(0);
        this.toughness = new MageInt(0);

        // Graft 2
        this.addAbility(new GraftAbility(this, 2));
        
        // {1}{U}: Untap target creature with a +1/+1 counter on it.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new UntapTargetEffect(), new ManaCostsImpl("{1}{U}"));
        ability.addTarget(new TargetCreaturePermanent(filter));
        this.addAbility(ability);        
    }

    public VigeanGraftmage(final VigeanGraftmage card) {
        super(card);
    }

    @Override
    public VigeanGraftmage copy() {
        return new VigeanGraftmage(this);
    }
}

package nl.stil4m.mollie.domain.customerpayments;

import nl.stil4m.mollie.domain.CreatePayment;
import nl.stil4m.mollie.domain.CustomerPayment;

public class RecurringPayment extends CustomerPayment {

    public RecurringPayment(CreatePayment createPayment) {
        super(createPayment, "recurring");
    }
}

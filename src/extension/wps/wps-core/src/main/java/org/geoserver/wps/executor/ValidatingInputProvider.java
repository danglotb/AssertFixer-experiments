/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.wps.executor;

import java.util.Collection;

import org.geoserver.wps.validator.ValidationException;
import org.opengis.util.ProgressListener;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Applies a collection of {@link Validator} on the object generated by the delegate input provider
 * 
 * @author Andrea Aime - GeoSolutions
 */
public class ValidatingInputProvider implements InputProvider {

    InputProvider delegate;

    Collection<Validator> validators;

    /**
     * Adds validation around the input provider as needed
     * 
     * @param delegate
     * @param validators
     *
     */
    public static InputProvider wrap(InputProvider delegate, Collection<Validator> validators) {
        if (validators == null || validators.isEmpty()) {
            return delegate;
        }
        return new ValidatingInputProvider(delegate, validators);
    }

    private ValidatingInputProvider(InputProvider delegate, Collection<Validator> validators) {
        this.delegate = delegate;
        this.validators = validators;
    }

    public Object getValue(ProgressListener subListener) throws Exception {
        Object value = delegate.getValue(subListener);
        Errors errors = new BeanPropertyBindingResult(value, getInputId());
        for (Validator v : validators) {
            if (v.supports(value.getClass())) {
                v.validate(value, errors);
            }
        }

        if (errors.hasErrors()) {
            throw new ValidationException(errors, getInputId());
        }

        return value;
    }

    public String getInputId() {
        return delegate.getInputId();
    }

    public boolean resolved() {
        return delegate.resolved();
    }

    public int longStepCount() {
        return delegate.longStepCount();
    }

}

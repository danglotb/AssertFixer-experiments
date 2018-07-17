/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.fluentcore.dag;

import com.microsoft.azure.management.resources.fluentcore.model.HasInner;
import com.microsoft.azure.management.resources.fluentcore.model.Indexable;
import rx.Observable;
import rx.functions.Func1;

/**
 * Simplified functional interface equivalent to abstract class {@link IndexableTaskItem}.
 */
public interface FunctionalTaskItem
        extends Func1<FunctionalTaskItem.Context, Observable<Indexable>> {
    /**
     * Type representing context of an {@link FunctionalTaskItem}.
     */
    final class Context implements HasInner<TaskGroup.InvocationContext>, Indexable {
        private final IndexableTaskItem wrapperTaskItem;
        private TaskGroup.InvocationContext innerContext;

        /**
         * Creates Context.
         *
         * @param taskItem the IndexableTaskItem that wraps this task item.
         */
        Context(IndexableTaskItem taskItem) {
            this.wrapperTaskItem = taskItem;
        }

        /**
         * Set the inner context.
         *
         * @param innerContext the inner context
         */
        void setInnerContext(TaskGroup.InvocationContext innerContext) {
            this.innerContext = innerContext;
        }

        /**
         * Get result of one of the task that belongs to this task's task group.
         *
         * @param key the task key
         * @param <T> the actual type of the task result
         * @return the task result, null will be returned if task has not produced a result yet
         */
        @SuppressWarnings("unchecked")
        public <T extends Indexable> T taskResult(String key) {
            Indexable result = this.wrapperTaskItem.taskGroup().taskResult(key);
            if (result == null) {
                return null;
            } else {
                T castedResult = (T) result;
                return castedResult;
            }
        }

        /**
         * @return an Observable upon subscription emits {@link VoidIndexable} with key same as
         * the key of this TaskItem.
         */
        public Observable<Indexable> voidObservable() {
            Indexable voidIndexable = new VoidIndexable(this.wrapperTaskItem.key());
            return Observable.just(voidIndexable);
        }

        @Override
        public TaskGroup.InvocationContext inner() {
            return this.innerContext;
        }

        @Override
        public String key() {
            return this.wrapperTaskItem.key();
        }
    }
}

/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.multimap.set;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagIterableMultimap;
import org.eclipse.collections.api.set.MutableSetIterable;
import org.eclipse.collections.api.tuple.Pair;

/**
 * @since 6.0
 */
public interface MutableSetIterableMultimap<K, V>
        extends SetMultimap<K, V>, MutableMultimap<K, V>
{
    /**
     * Puts the key / value combination into the MutableSetIterableMultimap and returns the MutableSetIterableMultimap (this).
     * @since 11.1
     */
    @Override
    default MutableSetIterableMultimap<K, V> withKeyValue(K key, V value)
    {
        this.put(key, value);
        return this;
    }

    @Override
    MutableSetIterable<V> replaceValues(K key, Iterable<? extends V> values);

    @Override
    MutableSetIterable<V> removeAll(Object key);

    @Override
    MutableSetIterableMultimap<K, V> newEmpty();

    @Override
    MutableSetIterable<V> get(K key);

    @Override
    MutableSetIterable<V> getIfAbsentPutAll(K key, Iterable<? extends V> values);

    @Override
    MutableSetIterableMultimap<V, K> flip();

    @Override
    MutableSetIterableMultimap<K, V> selectKeysValues(Predicate2<? super K, ? super V> predicate);

    @Override
    MutableSetIterableMultimap<K, V> rejectKeysValues(Predicate2<? super K, ? super V> predicate);

    @Override
    MutableSetIterableMultimap<K, V> selectKeysMultiValues(Predicate2<? super K, ? super RichIterable<V>> predicate);

    @Override
    MutableSetIterableMultimap<K, V> rejectKeysMultiValues(Predicate2<? super K, ? super RichIterable<V>> predicate);

    @Override
    <K2, V2> MutableBagIterableMultimap<K2, V2> collectKeysValues(Function2<? super K, ? super V, Pair<K2, V2>> function);

    @Override
    <K2, V2> MutableBagIterableMultimap<K2, V2> collectKeyMultiValues(Function<? super K, ? extends K2> keyFunction, Function<? super V, ? extends V2> valueFunction);

    @Override
    <V2> MutableMultimap<K, V2> collectValues(Function<? super V, ? extends V2> function);

    @Override
    MutableSetIterableMultimap<K, V> asSynchronized();
}

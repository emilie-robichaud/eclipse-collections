/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.multimap.list;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.bag.MutableBagMultimap;
import org.eclipse.collections.api.tuple.Pair;

/**
 * @since 1.0
 */
public interface MutableListMultimap<K, V>
        extends ListMultimap<K, V>, MutableMultimap<K, V>
{
    /**
     * Puts the key / value combination into the MutableListMultimap and returns the MutableListMultimap (this).
     * @since 11.1
     */
    @Override
    default MutableListMultimap<K, V> withKeyValue(K key, V value)
    {
        this.put(key, value);
        return this;
    }

    /**
     * @since 11.0
     */
    void forEachKeyMutableList(Procedure2<? super K, ? super MutableList<V>> procedure);

    @Override
    MutableList<V> replaceValues(K key, Iterable<? extends V> values);

    @Override
    MutableList<V> removeAll(Object key);

    @Override
    MutableListMultimap<K, V> newEmpty();

    @Override
    MutableList<V> get(K key);

    @Override
    MutableList<V> getIfAbsentPutAll(K key, Iterable<? extends V> values);

    @Override
    MutableBagMultimap<V, K> flip();

    @Override
    MutableListMultimap<K, V> selectKeysValues(Predicate2<? super K, ? super V> predicate);

    @Override
    MutableListMultimap<K, V> rejectKeysValues(Predicate2<? super K, ? super V> predicate);

    @Override
    MutableListMultimap<K, V> selectKeysMultiValues(Predicate2<? super K, ? super RichIterable<V>> predicate);

    @Override
    MutableListMultimap<K, V> rejectKeysMultiValues(Predicate2<? super K, ? super RichIterable<V>> predicate);

    @Override
    <K2, V2> MutableBagMultimap<K2, V2> collectKeysValues(Function2<? super K, ? super V, Pair<K2, V2>> function);

    @Override
    <K2, V2> MutableBagMultimap<K2, V2> collectKeyMultiValues(Function<? super K, ? extends K2> keyFunction, Function<? super V, ? extends V2> valueFunction);

    @Override
    <V2> MutableListMultimap<K, V2> collectValues(Function<? super V, ? extends V2> function);

    @Override
    MutableListMultimap<K, V> asSynchronized();
}

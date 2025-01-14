/*
 * Copyright (c) Shadow client, Saturn5VFive and contributors 2022. All rights reserved.
 */

package coffee.client.feature.items;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class Option<T> {
    @NonNull
    @Getter
    final String name;

    @Getter
    final T standardValueNullIfNothing;

    @NonNull
    @Getter
    final Class<T> type;

    final AtomicReference<T> value = new AtomicReference<>();

    public AtomicReference<T> getValueRef() {
        return value;
    }

    public T getValue() {
        return getValueRef().get();
    }

    public void setValue(T value) {
        getValueRef().set(value);
    }

    @SuppressWarnings("unchecked")
    public void accept(Object o) {
        getValueRef().set((T) o);
    }
}

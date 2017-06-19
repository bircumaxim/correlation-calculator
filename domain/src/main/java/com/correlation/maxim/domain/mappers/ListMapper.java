package com.correlation.maxim.domain.mappers;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 6/18/17.
 */

public class ListMapper {

    private ListMapper() {
    }

    @Nullable
    public static <T, R> List<R> map(List<T> list, Mapper<T, R> mapFunction) {
        if(list == null)
            return null;
        ArrayList<R> result = new ArrayList<>();
        if (list != null) {
            for (T item :
                    list) {
                result.add(mapFunction.map(item));
            }
        }
        return result;
    }
}
package com.zakharov.nicolay.androidlvl3homework1.mvp;

import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 14.06.2018.
 */

public class Model {
    private static Model sModel;
    private Map<Integer, Integer> mMap;

    private Model() {
        mMap = new HashMap<>();
    }

    public void putButtonIdInModel(View view) {
        mMap.put(view.getId(), 0);
    }

    public static Model get() {
        if (sModel == null) {
            sModel = new Model();
        }
        return sModel;
    }

    public int getElementValueAtIndex(int _index) {
        return mMap.get(_index);
    }

    public void setElementValueAtIndex(int _index, int value) {
        if (!mMap.containsKey(_index)) {
            Log.e("setElementValueAtIndex ", "не найден эллемент в Model");
            return;
        }
        mMap.put(_index, value);
    }
}

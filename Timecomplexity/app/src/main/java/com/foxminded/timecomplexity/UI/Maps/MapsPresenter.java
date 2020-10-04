package com.foxminded.timecomplexity.UI.Maps;

import com.foxminded.timecomplexity.Interfaces.MapsContractPresenter;
import com.foxminded.timecomplexity.Interfaces.MapsContractView;
import com.foxminded.timecomplexity.database.MapsModel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsPresenter implements MapsContractPresenter {
    private MapsContractView view;
    private final MapsModel model;
    private Map<Integer, Integer> hashMap;
    private Map<Integer, Integer> treeMap;

    public MapsPresenter(MapsModel model) {
        this.model = model;
    }

    public void atachView(MapsContractView view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public void createMap() {
        hashMap = new HashMap<Integer, Integer>();
        treeMap = new TreeMap<Integer, Integer>();
        int size = view.getSize();
        view.showProgressBar();

        model.fillMaps(hashMap, size, new MapsModel.FillCallback() {
            @Override
            public void onEnd() {
                createThread(hashMap);
            }
        });
        model.fillMaps(treeMap, size, new MapsModel.FillCallback() {
            @Override
            public void onEnd() {
                createThread(treeMap);
            }
        });
    }

    private void createThread(Map map) {
        model.loadAddNew(map, new MapsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (map instanceof HashMap) {
                    view.fillBoxMaps(2, result);
                } else if (map instanceof TreeMap) {
                    view.fillBoxMaps(1, result);
                }
            }
        });
        model.SearchByKey(map, new MapsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (map instanceof HashMap) {
                    view.fillBoxMaps(4, result);
                } else if (map instanceof TreeMap) {
                    view.fillBoxMaps(3, result);
                }
            }
        });
        model.Remove(map, new MapsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (map instanceof HashMap) {
                    view.fillBoxMaps(6, result);
                } else if (map instanceof TreeMap) {
                    view.fillBoxMaps(5, result);
                }
            }
        });
    }
}

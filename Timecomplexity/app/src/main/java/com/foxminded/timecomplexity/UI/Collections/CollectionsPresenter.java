package com.foxminded.timecomplexity.UI.Collections;

import com.foxminded.timecomplexity.Interfaces.CollectionsContractPresenter;
import com.foxminded.timecomplexity.Interfaces.CollectionsContractView;
import com.foxminded.timecomplexity.database.CollectionsModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsPresenter implements CollectionsContractPresenter {

    private CollectionsContractView view;
    private CollectionsModel model;
    private List<Integer> arrayList;
    private List<Integer> linkedList;
    private List<Integer> copyOnWriteArrayList;

    public CollectionsPresenter(CollectionsModel model) {
        this.model = model;
    }

    public void atachView(CollectionsContractView view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public void createCollections() {
        arrayList = new ArrayList<Integer>();
        linkedList = new LinkedList<Integer>();
        copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
        int size = view.getSize();
        view.showProgressBar();

        model.fillCollections(arrayList, size, new CollectionsModel.FillCallback() {
            @Override
            public void onEnd() {
                createThread(arrayList);
            }
        });
        model.fillCollections(linkedList, size, new CollectionsModel.FillCallback() {
            @Override
            public void onEnd() {
                createThread(linkedList);
            }
        });
        model.fillCollections(copyOnWriteArrayList, size, new CollectionsModel.FillCallback() {
            @Override
            public void onEnd() {
                createThread(copyOnWriteArrayList);
            }
        });
    }

    private void createThread(List list) {
        model.loadAddToBegin(list, new CollectionsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (list instanceof ArrayList) {
                    view.fillBoxCollections(1, result);
                } else if (list instanceof LinkedList) {
                    view.fillBoxCollections(2, result);
                } else if (list instanceof CopyOnWriteArrayList) {
                    view.fillBoxCollections(3, result);
                }
            }
        });
        model.loadAddToMiddle(list, new CollectionsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (list instanceof ArrayList) {
                    view.fillBoxCollections(4, result);
                } else if (list instanceof LinkedList) {
                    view.fillBoxCollections(5, result);
                } else if (list instanceof CopyOnWriteArrayList) {
                    view.fillBoxCollections(6, result);
                }
            }
        });
        model.loadAddToEnd(list, new CollectionsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (list instanceof ArrayList) {
                    view.fillBoxCollections(7, result);
                } else if (list instanceof LinkedList) {
                    view.fillBoxCollections(8, result);
                } else if (list instanceof CopyOnWriteArrayList) {
                    view.fillBoxCollections(9, result);
                }
            }
        });
        model.loadSearchByValue(list, new CollectionsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (list instanceof ArrayList) {
                    view.fillBoxCollections(10, result);
                } else if (list instanceof LinkedList) {
                    view.fillBoxCollections(11, result);
                } else if (list instanceof CopyOnWriteArrayList) {
                    view.fillBoxCollections(12, result);
                }
            }
        });
        model.loadRemoveFromBegin(list, new CollectionsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (list instanceof ArrayList) {
                    view.fillBoxCollections(13, result);
                } else if (list instanceof LinkedList) {
                    view.fillBoxCollections(14, result);
                } else if (list instanceof CopyOnWriteArrayList) {
                    view.fillBoxCollections(15, result);
                }
            }
        });
        model.loadRemoveFromMiddle(list, new CollectionsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (list instanceof ArrayList) {
                    view.fillBoxCollections(16, result);
                } else if (list instanceof LinkedList) {
                    view.fillBoxCollections(17, result);
                } else if (list instanceof CopyOnWriteArrayList) {
                    view.fillBoxCollections(18, result);
                }
            }
        });
        model.loadRemoveFromEnd(list, new CollectionsModel.CompleteCallback() {
            @Override
            public void onComplete(String result) {
                if (list instanceof ArrayList) {
                    view.fillBoxCollections(19, result);
                } else if (list instanceof LinkedList) {
                    view.fillBoxCollections(20, result);
                } else if (list instanceof CopyOnWriteArrayList) {
                    view.fillBoxCollections(21, result);
                }
            }
        });
    }
}

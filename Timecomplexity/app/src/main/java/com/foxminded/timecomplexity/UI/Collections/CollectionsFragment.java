package com.foxminded.timecomplexity.UI.Collections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.foxminded.timecomplexity.Interfaces.CollectionsContractPresenter;
import com.foxminded.timecomplexity.R;
import com.foxminded.timecomplexity.database.CollectionsModel;
import com.foxminded.timecomplexity.Interfaces.CollectionsContractView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CollectionsFragment extends Fragment implements CollectionsContractView {

    Unbinder unbinder;

    @BindView(R.id.enterSize2)
    EditText enterSize;
    @BindView(R.id.makeCalculate2)
    Button makeCalculate;

    @BindView(R.id.arrayListAddBegin)
    TextView arrayListAddBegin;
    @BindView(R.id.linkedListAddBegin)
    TextView linkedListAddBegin;
    @BindView(R.id.copyOnWriteArrayListAddBegin)
    TextView copyOnWriteArrayListAddBegin;
    @BindView(R.id.arrayListAddMiddle)
    TextView arrayListAddMiddle;
    @BindView(R.id.linkedListAddMiddle)
    TextView linkedListAddMiddle;
    @BindView(R.id.copyOnWriteArrayListAddMiddle)
    TextView copyOnWriteArrayListAddMiddle;
    @BindView(R.id.arrayListAddEnd)
    TextView arrayListAddEnd;
    @BindView(R.id.linkedListAddEnd)
    TextView linkedListAddEnd;
    @BindView(R.id.copyOnWriteArrayListAddEnd)
    TextView copyOnWriteArrayListAddEnd;
    @BindView(R.id.arrayListSearchValue)
    TextView arrayListSearchValue;
    @BindView(R.id.linkedListSearchValue)
    TextView linkedListSearchValue;
    @BindView(R.id.copyOnWriteArrayListSearchValue)
    TextView copyOnWriteArrayListSearchValue;
    @BindView(R.id.arrayListRemoveBegin)
    TextView arrayListRemoveBegin;
    @BindView(R.id.linkedListRemoveBegin)
    TextView linkedListRemoveBegin;
    @BindView(R.id.copyOnWriteArrayListRemoveBegin)
    TextView copyOnWriteArrayListRemoveBegin;
    @BindView(R.id.arrayListRemoveMiddle)
    TextView arrayListRemoveMiddle;
    @BindView(R.id.linkedListRemoveMiddle)
    TextView linkedListRemoveMiddle;
    @BindView(R.id.copyOnWriteArrayListRemoveMiddle)
    TextView copyOnWriteArrayListRemoveMiddle;
    @BindView(R.id.arrayListRemoveEnd)
    TextView arrayListRemoveEnd;
    @BindView(R.id.linkedListRemoveEnd)
    TextView linkedListRemoveEnd;
    @BindView(R.id.copyOnWriteArrayListRemoveEnd)
    TextView copyOnWriteArrayListRemoveEnd;

    @BindView(R.id.progressBarArrayListAddBegin)
    ProgressBar progressBarArrayListAddBegin;
    @BindView(R.id.progressBarLinkedListAddBegin)
    ProgressBar progressBarLinkedListAddBegin;
    @BindView(R.id.progressBarCopyOnWriteArrayListAddBegin)
    ProgressBar progressBarCopyOnWriteArrayListAddBegin;
    @BindView(R.id.progressBarArrayListAddMiddle)
    ProgressBar progressBarArrayListAddMiddle;
    @BindView(R.id.progressBarLinkedListAddMiddle)
    ProgressBar progressBarLinkedListAddMiddle;
    @BindView(R.id.progressBarCopyOnWriteArrayListAddMiddle)
    ProgressBar progressBarCopyOnWriteArrayListAddMiddle;
    @BindView(R.id.progressBarArrayListAddEnd)
    ProgressBar progressBarArrayListAddEnd;
    @BindView(R.id.progressBarLinkedListAddEnd)
    ProgressBar progressBarLinkedListAddEnd;
    @BindView(R.id.progressBarCopyOnWriteArrayListAddEnd)
    ProgressBar progressBarCopyOnWriteArrayListAddEnd;
    @BindView(R.id.progressBarArrayListSearchValue)
    ProgressBar progressBarArrayListSearchValue;
    @BindView(R.id.progressBarLinkedListSearchValue)
    ProgressBar progressBarLinkedListSearchValue;
    @BindView(R.id.progressBarCopyOnWriteArrayListSearchValue)
    ProgressBar progressBarCopyOnWriteArrayListSearchValue;
    @BindView(R.id.progressBarArrayListRemoveBegin)
    ProgressBar progressBarArrayListRemoveBegin;
    @BindView(R.id.progressBarLinkedListRemoveBegin)
    ProgressBar progressBarLinkedListRemoveBegin;
    @BindView(R.id.progressBarCopyOnWriteArrayListRemoveBegin)
    ProgressBar progressBarCopyOnWriteArrayListRemoveBegin;
    @BindView(R.id.progressBarArrayListRemoveMiddle)
    ProgressBar progressBarArrayListRemoveMiddle;
    @BindView(R.id.progressBarLinkedListRemoveMiddle)
    ProgressBar progressBarLinkedListRemoveMiddle;
    @BindView(R.id.progressBarCopyOnWriteArrayListRemoveMiddle)
    ProgressBar progressBarCopyOnWriteArrayListRemoveMiddle;
    @BindView(R.id.progressBarArrayListRemoveEnd)
    ProgressBar progressBarArrayListRemoveEnd;
    @BindView(R.id.progressBarLinkedListRemoveEnd)
    ProgressBar progressBarLinkedListRemoveEnd;
    @BindView(R.id.progressBarCopyOnWriteArrayListRemoveEnd)
    ProgressBar progressBarCopyOnWriteArrayListRemoveEnd;
    private CollectionsContractPresenter presenter;
    private int size;

    @Override
    public void onCreate(Bundle savedInstanceStaqte) {
        super.onCreate(savedInstanceStaqte);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflatetr, ViewGroup container, Bundle savedInstanceState) {
        View view = inflatetr.inflate(R.layout.fragment_collections, container, false);
        unbinder = ButterKnife.bind(this, view);

        initialization();
        return view;
    }

    private void initialization() {
        makeCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = Integer.parseInt(enterSize.getText().toString());
                presenter.createCollections();
            }
        });
        CollectionsModel collectionsModel = new CollectionsModel();
        presenter = new CollectionsPresenter(collectionsModel);
        presenter.atachView(this);
    }

    public void showProgressBar() {
        arrayListAddBegin.setVisibility(View.GONE);
        progressBarArrayListAddBegin.setVisibility(View.VISIBLE);
        linkedListAddBegin.setVisibility(View.GONE);
        progressBarLinkedListAddBegin.setVisibility(View.VISIBLE);
        copyOnWriteArrayListAddBegin.setVisibility(View.GONE);
        progressBarCopyOnWriteArrayListAddBegin.setVisibility(View.VISIBLE);
        arrayListAddMiddle.setVisibility(View.GONE);
        progressBarArrayListAddMiddle.setVisibility(View.VISIBLE);
        linkedListAddMiddle.setVisibility(View.GONE);
        progressBarLinkedListAddMiddle.setVisibility(View.VISIBLE);
        copyOnWriteArrayListAddMiddle.setVisibility(View.GONE);
        progressBarCopyOnWriteArrayListAddMiddle.setVisibility(View.VISIBLE);
        arrayListAddEnd.setVisibility(View.GONE);
        progressBarArrayListAddEnd.setVisibility(View.VISIBLE);
        linkedListAddEnd.setVisibility(View.GONE);
        progressBarLinkedListAddEnd.setVisibility(View.VISIBLE);
        copyOnWriteArrayListAddEnd.setVisibility(View.GONE);
        progressBarCopyOnWriteArrayListAddEnd.setVisibility(View.VISIBLE);
        arrayListSearchValue.setVisibility(View.GONE);
        progressBarArrayListSearchValue.setVisibility(View.VISIBLE);
        linkedListSearchValue.setVisibility(View.GONE);
        progressBarLinkedListSearchValue.setVisibility(View.VISIBLE);
        copyOnWriteArrayListSearchValue.setVisibility(View.GONE);
        progressBarCopyOnWriteArrayListSearchValue.setVisibility(View.VISIBLE);
        arrayListRemoveBegin.setVisibility(View.GONE);
        progressBarArrayListRemoveBegin.setVisibility(View.VISIBLE);
        linkedListRemoveBegin.setVisibility(View.GONE);
        progressBarLinkedListRemoveBegin.setVisibility(View.VISIBLE);
        copyOnWriteArrayListRemoveBegin.setVisibility(View.GONE);
        progressBarCopyOnWriteArrayListRemoveBegin.setVisibility(View.VISIBLE);
        arrayListRemoveMiddle.setVisibility(View.GONE);
        progressBarArrayListRemoveMiddle.setVisibility(View.VISIBLE);
        linkedListRemoveMiddle.setVisibility(View.GONE);
        progressBarLinkedListRemoveMiddle.setVisibility(View.VISIBLE);
        copyOnWriteArrayListRemoveMiddle.setVisibility(View.GONE);
        progressBarCopyOnWriteArrayListRemoveMiddle.setVisibility(View.VISIBLE);
        arrayListRemoveEnd.setVisibility(View.GONE);
        progressBarArrayListRemoveEnd.setVisibility(View.VISIBLE);
        linkedListRemoveEnd.setVisibility(View.GONE);
        progressBarLinkedListRemoveEnd.setVisibility(View.VISIBLE);
        copyOnWriteArrayListRemoveEnd.setVisibility(View.GONE);
        progressBarCopyOnWriteArrayListRemoveEnd.setVisibility(View.VISIBLE);
    }

    public void fillBoxCollections(int boxNumber, String result) {
        switch (boxNumber) {
            case 1:
                arrayListAddBegin.setText(result);
                arrayListAddBegin.setVisibility(View.VISIBLE);
                progressBarArrayListAddBegin.setVisibility(View.GONE);
                break;
            case 2:
                linkedListAddBegin.setText(result);
                linkedListAddBegin.setVisibility(View.VISIBLE);
                progressBarLinkedListAddBegin.setVisibility(View.GONE);
                break;
            case 3:
                copyOnWriteArrayListAddBegin.setText(result);
                copyOnWriteArrayListAddBegin.setVisibility(View.VISIBLE);
                progressBarCopyOnWriteArrayListAddBegin.setVisibility(View.GONE);
                break;
            case 4:
                arrayListAddMiddle.setText(result);
                arrayListAddMiddle.setVisibility(View.VISIBLE);
                progressBarArrayListAddMiddle.setVisibility(View.GONE);
                break;
            case 5:
                linkedListAddMiddle.setText(result);
                linkedListAddMiddle.setVisibility(View.VISIBLE);
                progressBarLinkedListAddMiddle.setVisibility(View.GONE);
                break;
            case 6:
                copyOnWriteArrayListAddMiddle.setText(result);
                copyOnWriteArrayListAddMiddle.setVisibility(View.VISIBLE);
                progressBarCopyOnWriteArrayListAddMiddle.setVisibility(View.GONE);
                break;
            case 7:
                arrayListAddEnd.setText(result);
                arrayListAddEnd.setVisibility(View.VISIBLE);
                progressBarArrayListAddEnd.setVisibility(View.GONE);
                break;
            case 8:
                linkedListAddEnd.setText(result);
                linkedListAddEnd.setVisibility(View.VISIBLE);
                progressBarLinkedListAddEnd.setVisibility(View.GONE);
                break;
            case 9:
                copyOnWriteArrayListAddEnd.setText(result);
                copyOnWriteArrayListAddEnd.setVisibility(View.VISIBLE);
                progressBarCopyOnWriteArrayListAddEnd.setVisibility(View.GONE);
                break;
            case 10:
                arrayListSearchValue.setText(result);
                arrayListSearchValue.setVisibility(View.VISIBLE);
                progressBarArrayListSearchValue.setVisibility(View.GONE);
                break;
            case 11:
                linkedListSearchValue.setText(result);
                linkedListSearchValue.setVisibility(View.VISIBLE);
                progressBarLinkedListSearchValue.setVisibility(View.GONE);
                break;
            case 12:
                copyOnWriteArrayListSearchValue.setText(result);
                copyOnWriteArrayListSearchValue.setVisibility(View.VISIBLE);
                progressBarCopyOnWriteArrayListSearchValue.setVisibility(View.GONE);
                break;
            case 13:
                arrayListRemoveBegin.setText(result);
                arrayListRemoveBegin.setVisibility(View.VISIBLE);
                progressBarArrayListRemoveBegin.setVisibility(View.GONE);
                break;
            case 14:
                linkedListRemoveBegin.setText(result);
                linkedListRemoveBegin.setVisibility(View.VISIBLE);
                progressBarLinkedListRemoveBegin.setVisibility(View.GONE);
                break;
            case 15:
                copyOnWriteArrayListRemoveBegin.setText(result);
                copyOnWriteArrayListRemoveBegin.setVisibility(View.VISIBLE);
                progressBarCopyOnWriteArrayListRemoveBegin.setVisibility(View.GONE);
                break;
            case 16:
                arrayListRemoveMiddle.setText(result);
                arrayListRemoveMiddle.setVisibility(View.VISIBLE);
                progressBarArrayListRemoveMiddle.setVisibility(View.GONE);
                break;
            case 17:
                linkedListRemoveMiddle.setText(result);
                linkedListRemoveMiddle.setVisibility(View.VISIBLE);
                progressBarLinkedListRemoveMiddle.setVisibility(View.GONE);
                break;
            case 18:
                copyOnWriteArrayListRemoveMiddle.setText(result);
                copyOnWriteArrayListRemoveMiddle.setVisibility(View.VISIBLE);
                progressBarCopyOnWriteArrayListRemoveMiddle.setVisibility(View.GONE);
                break;
            case 19:
                arrayListRemoveEnd.setText(result);
                arrayListRemoveEnd.setVisibility(View.VISIBLE);
                progressBarArrayListRemoveEnd.setVisibility(View.GONE);
                break;
            case 20:
                linkedListRemoveEnd.setText(result);
                linkedListRemoveEnd.setVisibility(View.VISIBLE);
                progressBarLinkedListRemoveEnd.setVisibility(View.GONE);
                break;
            case 21:
                copyOnWriteArrayListRemoveEnd.setText(result);
                copyOnWriteArrayListRemoveEnd.setVisibility(View.VISIBLE);
                progressBarCopyOnWriteArrayListRemoveEnd.setVisibility(View.GONE);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}

package com.foxminded.timecomplexity.UI.Maps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.foxminded.timecomplexity.Interfaces.MapsContractPresenter;
import com.foxminded.timecomplexity.Interfaces.MapsContractView;
import com.foxminded.timecomplexity.R;
import com.foxminded.timecomplexity.database.MapsModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MapsFragment extends Fragment implements MapsContractView {

    Unbinder unbinder;

    @BindView(R.id.enterSize1)
    EditText enterSize;
    @BindView(R.id.makeCalculate1)
    Button makeCalculate;

    @BindView(R.id.mapThreeMapAdd)
    TextView mapThreeMapAdd;
    @BindView(R.id.mapHashMapAdd)
    TextView mapHashMapAdd;
    @BindView(R.id.mapThreeMapSearch)
    TextView mapThreeMapSearch;
    @BindView(R.id.mapHashMapSearch)
    TextView mapHashMapSearch;
    @BindView(R.id.mapThreeMapRemove)
    TextView mapThreeMapRemove;
    @BindView(R.id.mapHashMapRemove)
    TextView mapHashMapRemove;

    @BindView(R.id.progressBarMapThreeMapAdd)
    ProgressBar progressBarMapThreeMapAdd;
    @BindView(R.id.progressBarMapHashMapAdd)
    ProgressBar progressBarMapHashMapAdd;
    @BindView(R.id.progressBarMapThreeMapSearch)
    ProgressBar progressBarMapThreeMapSearch;
    @BindView(R.id.progressBarMapHashMapSearch)
    ProgressBar progressBarMapHashMapSearch;
    @BindView(R.id.progressBarMapThreeMapRemove)
    ProgressBar progressBarMapThreeMapRemove;
    @BindView(R.id.progressBarMapHashMapRemove)
    ProgressBar progressBarMapHashMapRemove;

    private MapsContractPresenter presenter;
    private int size;

    @Override
    public void onCreate(Bundle savedInstanceStaqte) {
        super.onCreate(savedInstanceStaqte);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflatetr, ViewGroup container, Bundle savedInstanceState) {
        View view = inflatetr.inflate(R.layout.fragment_maps, container, false);
        unbinder = ButterKnife.bind(this, view);

        initialization();
        return view;
    }

    private void initialization() {
        makeCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = Integer.parseInt(enterSize.getText().toString());
                presenter.createMap();
            }
        });
        MapsModel mapsModel = new MapsModel();
        presenter = new MapsPresenter(mapsModel);
        presenter.atachView(this);
    }
    public void showProgressBar() {
        mapThreeMapAdd.setVisibility(View.GONE);
        progressBarMapThreeMapAdd.setVisibility(View.VISIBLE);
        mapHashMapAdd.setVisibility(View.GONE);
        progressBarMapHashMapAdd.setVisibility(View.VISIBLE);
        mapThreeMapSearch.setVisibility(View.GONE);
        progressBarMapThreeMapSearch.setVisibility(View.VISIBLE);
        mapHashMapSearch.setVisibility(View.GONE);
        progressBarMapHashMapSearch.setVisibility(View.VISIBLE);
        mapThreeMapRemove.setVisibility(View.GONE);
        progressBarMapThreeMapRemove.setVisibility(View.VISIBLE);
        mapHashMapRemove.setVisibility(View.GONE);
        progressBarMapHashMapRemove.setVisibility(View.VISIBLE);
    }

    public void fillBoxMaps (int boxNumber, String result) {
        switch (boxNumber) {
            case 1:
                mapThreeMapAdd.setText(result);
                mapThreeMapAdd.setVisibility(View.VISIBLE);
                progressBarMapThreeMapAdd.setVisibility(View.GONE);
                break;
            case 2:
                mapHashMapAdd.setText(result);
                mapHashMapAdd.setVisibility(View.VISIBLE);
                progressBarMapHashMapAdd.setVisibility(View.GONE);
                break;
            case 3:
                mapThreeMapSearch.setText(result);
                mapThreeMapSearch.setVisibility(View.VISIBLE);
                progressBarMapThreeMapSearch.setVisibility(View.GONE);
                break;
            case 4:
                mapHashMapSearch.setText(result);
                mapHashMapSearch.setVisibility(View.VISIBLE);
                progressBarMapHashMapSearch.setVisibility(View.GONE);
                break;
            case 5:
                mapThreeMapRemove.setText(result);
                mapThreeMapRemove.setVisibility(View.VISIBLE);
                progressBarMapThreeMapRemove.setVisibility(View.GONE);
                break;
            case 6:
                mapHashMapRemove.setText(result);
                mapHashMapRemove.setVisibility(View.VISIBLE);
                progressBarMapHashMapRemove.setVisibility(View.GONE);
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

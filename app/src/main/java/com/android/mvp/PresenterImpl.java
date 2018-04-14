package com.android.mvp;

import com.android.mvp.contract.MainContract;

/**
 * Created by Aleesha Kanwal on 21/12/2017.
 */

public class PresenterImpl implements MainContract.Presenter, MainContract.GetQuoteInteractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetQuoteInteractor getQuoteInteractor;

    public PresenterImpl(MainContract.MainView mainView, MainContract.GetQuoteInteractor getQuoteInteractor) {
        this.mainView = mainView;
        this.getQuoteInteractor = getQuoteInteractor;
    }

    @Override
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }

        getQuoteInteractor.getNextQuote(this); //presenter requesting model
    }

    @Override
    public void onDestroy() {
        mainView = null;
    } //presenter updating view

    @Override
    public void onFinished(String string) { //presenter getting data from model
        if (mainView != null) {
            mainView.setQuote(string);
            mainView.hideProgress();
        }
    }
}

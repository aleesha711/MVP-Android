package com.android.mvp.contract;

/**
 * Created by Aleesha Kanwal on 21/12/2017.
 */

public interface MainContract {

    interface MainView {
        void showProgress();
                                                          //view
        void hideProgress();

        void setQuote(String string);
    }

    interface GetQuoteInteractor {
        interface OnFinishedListener {                        //model
            void onFinished(String string);
        }

        void getNextQuote(OnFinishedListener onFinishedListener);
    }

    interface Presenter {
        void onButtonClick();
                                                      //presenter
        void onDestroy();
    }
}

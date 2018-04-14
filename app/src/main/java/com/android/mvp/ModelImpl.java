package com.android.mvp;

import android.os.Handler;

import com.android.mvp.contract.MainContract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Aleesha Kanwal on 21/12/2017.
 */

public class ModelImpl implements MainContract.GetQuoteInteractor {


    private List<String> arrayList = Arrays.asList(
            "Be yourself. everyone else is already taken.",
            "A room without books is like a body without a soul.",
            "You only live once, but if you do it right, once is enough.",
            "Be the change that you wish to see in the world.",
            "If you tell the truth, you don't have to remember anything."
    );

    @Override
    public void getNextQuote(final MainContract.GetQuoteInteractor.OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(getRandomString()); //model updating presenter here
            }
        }, 1200);
    }

    private String getRandomString() {

        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }
}

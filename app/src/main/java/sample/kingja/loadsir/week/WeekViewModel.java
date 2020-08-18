package sample.kingja.loadsir.week;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 作者:created by storm
 */

public class WeekViewModel extends ViewModel {

    public MutableLiveData<WeekShowItemView> changeWeekItemBackground=new MutableLiveData<>(null);

    @Override
    protected void onCleared() {
        super.onCleared();
        changeWeekItemBackground=null;
    }
}

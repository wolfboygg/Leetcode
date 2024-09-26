package design.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> mList = new ArrayList<>();

    public void addObserver(Observer o) {
        if (!mList.contains(o)) {
            mList.add(o);
        }
    }

    public void removeObserver(Observer o) {
        if (mList.contains(o)) {
            mList.remove(o);
        }
    }

    public void updateInfo() {
        for (int i = 0; i < mList.size(); i++) {
            mList.get(i).update();
        }
    }
}

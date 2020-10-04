package com.foxminded.timecomplexity.database;

import android.os.AsyncTask;

import java.util.Map;

public class MapsModel {

    private int mapSize;

    public void fillMaps(Map<Integer, Integer> map, int size, MapsModel.FillCallback callback) {
        FillMapsTask fillMapsTask = new FillMapsTask(callback);
        mapSize = size;
        fillMapsTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, map);
    }

    public void loadAddNew(Map<Integer, Integer> map, MapsModel.CompleteCallback callback) {
        AddNewTask addNewTask = new AddNewTask(callback);
        addNewTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, map);
    }

    public void SearchByKey(Map<Integer, Integer> map, MapsModel.CompleteCallback callback) {
        SearchByKeyTask searchByKeyTask = new SearchByKeyTask(callback);
        searchByKeyTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, map);
    }

    public void Remove(Map<Integer, Integer> map, MapsModel.CompleteCallback callback) {
        RemoveTask removeTask = new RemoveTask(callback);
        removeTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, map);
    }

    public interface FillCallback {
        void onEnd();
    }

    public interface CompleteCallback {
        void onComplete(String result);
    }

    class FillMapsTask extends AsyncTask<Map, Void, Void> {

        private final FillCallback callback;

        FillMapsTask(FillCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(Map... params) {
            Map map = params[0];
            for (int i = 0; i <= mapSize - 1; i++) {
                map.put(i + 1, i);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void check) {
            if (callback != null) {
                callback.onEnd();
            }
        }
    }

    class AddNewTask extends AsyncTask<Map<Integer, Integer>, Void, String> {

        private final MapsModel.CompleteCallback callback;

        AddNewTask(MapsModel.CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(Map<Integer, Integer>... params) {
            Map<Integer, Integer> map = params[0];
            String result;
            long start = System.nanoTime();
            map.put(map.size()+1,map.size()+1);
            long stop = System.nanoTime() - start;
            result = Long.toString (stop);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if (callback != null) {
                callback.onComplete(result);
            }
        }
    }

    class SearchByKeyTask extends AsyncTask<Map<Integer, Integer>, Void, String> {

        private final MapsModel.CompleteCallback callback;

        SearchByKeyTask(MapsModel.CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(Map<Integer, Integer>... params) {
            Map<Integer, Integer> map = params[0];
            String result;
            long start = System.nanoTime();
            map.get((map.size())/5);
            long stop = System.nanoTime() - start;
            result = Long.toString (stop);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if (callback != null) {
                callback.onComplete(result);
            }
        }
    }

    class RemoveTask extends AsyncTask<Map<Integer, Integer>, Void, String> {

        private final MapsModel.CompleteCallback callback;

        RemoveTask(MapsModel.CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(Map<Integer, Integer>... params) {
            Map<Integer, Integer> map = params[0];
            String result;
            long start = System.nanoTime();
            map.remove(map.size()/3);
            long stop = System.nanoTime() - start;
            result = Long.toString (stop);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if (callback != null) {
                callback.onComplete(result);
            }
        }
    }

}

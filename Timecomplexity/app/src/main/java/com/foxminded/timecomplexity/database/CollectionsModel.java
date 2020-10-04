package com.foxminded.timecomplexity.database;

import android.os.AsyncTask;

import java.util.List;

public class CollectionsModel {

    private int arraySize;

    public void fillCollections(List<Integer> list, int size, FillCallback callback) {
        FillCollectionsTask fillCollectionsTask = new FillCollectionsTask(callback);
        arraySize = size;
        fillCollectionsTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, list);
    }


    public void loadAddToBegin(List<Integer> list, CompleteCallback callback) {
        AddToBeginTask addToBeginTask = new AddToBeginTask(callback);
        addToBeginTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list);
    }

    public void loadAddToMiddle(List<Integer> list, CompleteCallback callback) {
        AddToMiddleTask addToMiddleTask = new AddToMiddleTask(callback);
        addToMiddleTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list);
    }

    public void loadAddToEnd(List<Integer> list, CompleteCallback callback) {
        AddToEndTask addToEndTask = new AddToEndTask(callback);
        addToEndTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list);
    }

    public void loadSearchByValue(List<Integer> list, CompleteCallback callback) {
        SearchByValueTask searchByValueTask = new SearchByValueTask(callback);
        searchByValueTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list);
    }

    public void loadRemoveFromBegin(List<Integer> list, CompleteCallback callback) {
        RemoveFromBeginTask removeFromBeginTask = new RemoveFromBeginTask(callback);
        removeFromBeginTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list);
    }

    public void loadRemoveFromMiddle(List<Integer> list, CompleteCallback callback) {
        RemoveFromMiddleTask removeFromMiddleTask = new RemoveFromMiddleTask(callback);
        removeFromMiddleTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list);
    }

    public void loadRemoveFromEnd(List<Integer> list, CompleteCallback callback) {
        RemoveFromEndTask removeFromEndTask = new RemoveFromEndTask(callback);
        removeFromEndTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list);
    }

    public interface  FillCallback {
        void onEnd();
    }

    public interface CompleteCallback {
        void onComplete(String result);
    }

    class FillCollectionsTask extends AsyncTask<List<Integer>, Void, Void> {

        private final FillCallback callback;

        FillCollectionsTask(FillCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(List<Integer>... params) {
            List list = params[0];
            for (int i = 0; i <= arraySize - 1; i++) {
                list.add(i);}
            return null;
        }

        @Override
        protected void onPostExecute(Void check) {
            if (callback != null) {
                callback.onEnd();
            }
        }
    }

    class AddToBeginTask extends AsyncTask<List<Integer>, Void, String> {

        private final CompleteCallback callback;

        AddToBeginTask(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(List<Integer>... params) {
            List list = params[0];
            String result;
            long start = System.nanoTime();
            list.add(0,1);
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

    class AddToMiddleTask extends AsyncTask<List<Integer>, Void, String> {

        private final CompleteCallback callback;

        AddToMiddleTask(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(List<Integer>... params) {
            List list = params[0];
            String result;
            long start = System.nanoTime();
            list.add((list.size()-1)/2,1);
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

    class AddToEndTask extends AsyncTask<List<Integer>, Void, String> {

        private final CompleteCallback callback;

        AddToEndTask(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(List<Integer>... params) {
            List list = params[0];
            String result;
            long start = System.nanoTime();
            list.add(1);
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

    class SearchByValueTask extends AsyncTask<List<Integer>, Void, String> {

        private final CompleteCallback callback;

        SearchByValueTask(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(List<Integer>... params) {
            List list = params[0];
            String result;
            long start = System.nanoTime();
            list.indexOf(list.size()-(list.size()/3));
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

    class RemoveFromBeginTask extends AsyncTask<List<Integer>, Void, String> {

        private final CompleteCallback callback;

        RemoveFromBeginTask(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(List<Integer>... params) {
            List list = params[0];
            String result;
            long start = System.nanoTime();
            list.remove(0);
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

    class RemoveFromMiddleTask extends AsyncTask<List<Integer>, Void, String> {

        private final CompleteCallback callback;

        RemoveFromMiddleTask(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(List<Integer>... params) {
            List list = params[0];
            String result;
            long start = System.nanoTime();
            list.remove((list.size()-1)/2);
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

    class RemoveFromEndTask extends AsyncTask<List<Integer>, Void, String> {

        private final CompleteCallback callback;

        RemoveFromEndTask(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(List<Integer>... params) {
            List list = params[0];
            String result;
            long start = System.nanoTime();
            list.remove(list.size()-1);
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

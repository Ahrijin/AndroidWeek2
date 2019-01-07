package jinyuanyuan.bw.com.androidprojects.presenter;

import java.util.Map;

import jinyuanyuan.bw.com.androidprojects.callback.MyCallBack;
import jinyuanyuan.bw.com.androidprojects.model.ModelImpls;
import jinyuanyuan.bw.com.androidprojects.view.IView;

public class PresenterImpls implements IPresenter {
    private ModelImpls modelImpls;
    private IView iView;

    public PresenterImpls(IView iView) {
        this.iView = iView;
        modelImpls = new ModelImpls();
    }


    public void destory() {
        if (modelImpls != null) {
            modelImpls = null;
        }
        if (iView != null) {
            iView = null;
        }
    }

    @Override
    public void postRequest(String url, Map<String, String> map, Class clazz) {
        modelImpls.postRequest(url, map, clazz, new MyCallBack() {
            @Override
            public void Success(Object success) {
                iView.setSuccess(success);
            }

            @Override
            public void Errors(Object error) {
                iView.setError(error);
            }
        });
    }

    @Override
    public void postRequesst(String url,  int userid,String sessionId, Map<String, Integer> map, Class clazz) {
        modelImpls.postRequesst(url, userid,sessionId, map, clazz, new MyCallBack() {
            @Override
            public void Success(Object success) {
                iView.setSuccess(success);
            }

            @Override
            public void Errors(Object error) {
                iView.setError(error);
            }
        });
    }

    @Override
    public void getRequest(String url, Map<String, String> map, Class claas) {
        modelImpls.getRequest(url, map, claas, new MyCallBack() {
            @Override
            public void Success(Object success) {
                iView.setSuccess(success);
            }

            @Override
            public void Errors(Object error) {
                iView.setError(error);
            }
        });
    }

    @Override
    public void delRequest(String url, int userid, String sessionId, Map<String, Integer> map, Class classes) {
        modelImpls.deleteRequest(url, userid, sessionId, map, classes, new MyCallBack() {
            @Override
            public void Success(Object success) {
                iView.setSuccess(success);
            }

            @Override
            public void Errors(Object error) {
                iView.setError(error);
            }
        });
    }


}
